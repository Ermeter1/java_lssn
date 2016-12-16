package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion(){
        //app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            //при создании контакта указывается группа [none], дабы не делать проверку на наличие указываемой группы
            app.getContactHelper().createContact(new ContactData("Bilbo", "Baggins", "Shire","8(800)8008080","bilbo@mail.ru", "[none]"), true);
        }
        app.getContactHelper().selectContact();
        //при выполнении теста почему то не удаляется контакт, (тест проходит успешно, но контакт не удален) если дебажить, то контакт удаляется, не понятно.
        app.getContactHelper().deleteSelectedContact();

    }
}
