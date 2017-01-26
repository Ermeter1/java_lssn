package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            //при создании контакта указывается группа [none], дабы не делать проверку на наличие указываемой группы
            app.getContactHelper().createContact(new ContactData("Bilbo", "Baggins", "Shire","8(800)8008080","bilbo@mail.ru", "[none]"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        //при выполнении теста почему то не удаляется контакт, (тест проходит успешно, но контакт не удален) если дебажить, то контакт удаляется, не понятно.
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(before.size()-1);
        Assert.assertEquals(before, after);

    }
}
