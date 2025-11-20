package ui_tests;

import manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.HeaderMenuItem;

import static pages.BasePage.clickButtonHeader;
import static pages.BasePage.pause;
import static utils.PropertiesReader.getProperty;

public class DeleteContactTests extends ApplicationManager {

    SoftAssert softAssert = new SoftAssert();
    HomePage homePage;
    LoginPage loginPage;
    ContactsPage contactsPage;
    AddPage addPage;
    int numberOfContacts;


    @BeforeMethod (alwaysRun = true)
    public void login() {
        homePage = new HomePage(getDriver());
        loginPage = clickButtonHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm(getProperty("base.properties", "login"),
                getProperty("base.properties", "password"));
        contactsPage = new ContactsPage(getDriver());
        numberOfContacts = contactsPage.getNumberOfContacts();
    }

    @Test(groups = {"smoke", "contact"})
    public void deleteFirstContactPositiveTest() {
        contactsPage.deleteFirstContact();
        pause(3);
        int numberOfContactsAfterDelete = contactsPage.getNumberOfContacts();
        Assert.assertEquals(numberOfContactsAfterDelete, numberOfContacts - 1);
    }


}