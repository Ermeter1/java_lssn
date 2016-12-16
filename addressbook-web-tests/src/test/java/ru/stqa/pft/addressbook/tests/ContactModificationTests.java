package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            //при создании контакта указывается группа [none], дабы не делать проверку на наличие указываемой группы
            app.getContactHelper().createContact(new ContactData("Bilbo", "Baggins", "Shire","8(800)8008080","bilbo@mail.ru", "[none]"), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("B","B","B","B","B", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }

}
