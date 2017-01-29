package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Imen").withLastname("Familiev").withAddress("Adres")
                .withMobile("8(900)1112233").withEmail("Imen@mail.ru").withGroup("test1");
        //ContactData contact = new ContactData("Bilbo", "Baggins", "Shire","8(800)8008080","bilbo@mail.ru", "test1");
        app.contact().create(contact, true);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size()+1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
