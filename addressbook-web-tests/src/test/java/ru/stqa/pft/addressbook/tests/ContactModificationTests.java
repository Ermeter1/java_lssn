package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0){
            //при создании контакта указывается группа [none], дабы не делать проверку на наличие указываемой группы
            app.contact().create(new ContactData()
                    .withFirstname("Bilbo").withLastname("Baggins").withAddress("Shire")
                    .withMobile("8(800)8008080").withEmail("bilbo@mail.ru").withGroup("[none]"), true);
        }
    }

    @Test
    public void testContactModification(){
        Set<ContactData> before = app.contact().all();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifyContact.getId()).withFirstname("B").withLastname("B").withAddress("B")
                .withMobile("B").withEmail("B");

        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifyContact);
        before.add(contact);
        Assert.assertEquals(before, after);


    }


}
