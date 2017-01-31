package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactTests extends TestBase {

    @Test
    public void testContactEditForm(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress())) ;
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }


    @Test
    public void tesContactDetailsForm(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        app.goTo().homePage();
        app.contact().initContactDetailsById(contact.getId());

        String detailsContent = app.contact().detailsContent();

        assertThat(mergeContactInfoDetailsForm(detailsContent), equalTo(mergeContactInfoFromEditForm(contactInfoFromEditForm)));

    }

    public String mergeContactInfoFromEditForm (ContactData contact) {
        return Arrays.asList(contact.getFirstname(),contact.getLastname(),contact.getAddress(),contact.getHomePhone()
                ,contact.getMobilePhone(), contact.getWorkPhone(), contact.getEmail(), contact.getEmail2()
                ,contact.getEmail3())
                .stream().filter(s -> !s.equals(""))
                .collect(Collectors.joining(" "));
    }

    public static String mergeContactInfoDetailsForm(String detailsContent) {
        return detailsContent.replaceAll("\n", " ").replaceAll("  ", " ");
    }


    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactTests::cleaned)
                .collect(Collectors.joining("\n"));
        }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
