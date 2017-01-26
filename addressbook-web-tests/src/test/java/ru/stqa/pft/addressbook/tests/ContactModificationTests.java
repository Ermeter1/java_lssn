package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            //при создании контакта указывается группа [none], дабы не делать проверку на наличие указываемой группы
            app.getContactHelper().createContact(new ContactData("Bilbo", "Baggins", "Shire","8(800)8008080","bilbo@mail.ru", "[none]"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        //app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().initContactModification(before.size()-1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "B","B","B","B","B", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId()) ;
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }

}
