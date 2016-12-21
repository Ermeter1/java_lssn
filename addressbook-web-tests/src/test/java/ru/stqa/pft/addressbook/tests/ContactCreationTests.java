package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.getNavigationHelper().gotoHomePage();
        //здесь нужна бы проверка на наличие группы test1, либо указывать группу [none]
        app.getContactHelper().createContact(new ContactData("Bilbo", "Baggins", "Shire","8(800)8008080","bilbo@mail.ru", "test1"), true);
    }
}