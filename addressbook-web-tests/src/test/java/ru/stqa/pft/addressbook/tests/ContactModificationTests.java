package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0){
            //при создании контакта указывается группа [none], дабы не делать проверку на наличие указываемой группы
            app.contact().create(new ContactData()
                    .withFirstname("Bilbo").withLastname("Baggins").withAddress("Shire")
                    .withMobilePhone("8(800)8008080").withEmail("bilbo@mail.ru").withGroup("[none]"), true);
        }
    }

    @Test
    public void testContactModification(){
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("B").withLastname("B").withAddress("B")
                .withMobilePhone("B").withEmail("B");

        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }


}
