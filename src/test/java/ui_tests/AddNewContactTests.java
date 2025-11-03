package ui_tests;

import dto.Contact;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.ContactFactory;
import utils.HeaderMenuItem;

import static pages.BasePage.*;
import static utils.PropertiesReader.getProperty;

public class AddNewContactTests extends ApplicationManager {

    SoftAssert softAssert = new SoftAssert();
    HomePage homePage;
    LoginPage loginPage;
    ContactsPage contactsPage;
    AddPage addPage;
    int numberOfContacts;


    @BeforeMethod
    public void login() {
        homePage = new HomePage(getDriver());
        loginPage = BasePage.clickButtonHeader(HeaderMenuItem.LOGIN);
        //loginPage.typeLoginForm("iv@mail.com", "123456Aa!");
        loginPage.typeLoginForm(getProperty("base.properties", "login"),
                getProperty("base.properties", "password"));
        contactsPage = new ContactsPage(getDriver());
        numberOfContacts = contactsPage.getNumberOfContacts();
        addPage = clickButtonHeader(HeaderMenuItem.ADD);


    }

    //Homework 7(28.10.25) advanced
    @Test
    public void addNewContactPositiveTest() {
        addPage.typeContactForm(ContactFactory.positiveContact());
        int numberOfContactsAfterAdd = contactsPage.getNumberOfContacts();
        Assert.assertEquals(numberOfContactsAfterAdd, numberOfContacts + 1);

    }

    @Test
    public void addNewContactPositiveTestValidateList() {
        Contact contact = ContactFactory.positiveContact();
        addPage.typeContactForm(contact);
        Assert.assertTrue(contactsPage.isContactPresent(contact));
    }

    @Test
    public void addNewContactPositiveTest_validateElementScroll() {
        Contact contact = ContactFactory.positiveContact();
        addPage.typeContactForm(contact);
        contactsPage.scrollToLastElementList();
        contactsPage.clickLastContact();
        //contactsPage.scrollToLastElementListJS();
        String  text = contactsPage.getContactCardText();
       softAssert.assertTrue(text.contains(contact.getName()));
       softAssert.assertTrue(text.contains(contact.getLastName()));
       softAssert.assertTrue(text.contains(contact.getPhone()));
       softAssert.assertTrue(text.contains("zzzzzzzzzzzzz"), "message contains Phone");
       softAssert.assertTrue(text.contains(contact.getEmail()));
       softAssert.assertTrue(text.contains(contact.getAddress()), "contains adress");
       softAssert.assertAll();
    }


}
