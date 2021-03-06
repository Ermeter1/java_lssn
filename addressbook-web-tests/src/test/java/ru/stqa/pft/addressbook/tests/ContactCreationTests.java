package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Imen").withLastname("Familiev").withAddress("Adres")
                .withMobilePhone("8(900)1112233").withEmail("Imen@mail.ru").withGroup("test1");
        //ContactData contact = new ContactData("Bilbo", "Baggins", "Shire","8(800)8008080","bilbo@mail.ru", "test1");
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
