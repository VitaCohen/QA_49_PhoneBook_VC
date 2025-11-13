package ui_tests;

import manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.HeaderMenuItem;

import static pages.BasePage.clickButtonHeader;
import static utils.PropertiesReader.getProperty;

public class DeleteContactTests extends ApplicationManager {

    SoftAssert softAssert = new SoftAssert();
    HomePage homePage;
    LoginPage loginPage;
    ContactsPage contactsPage;
    AddPage addPage;
    int numberOfContacts;

    @BeforeMethod
    public void login() {
        HomePage homePage = new HomePage(getDriver());
        loginPage = BasePage.clickButtonHeader(HeaderMenuItem.LOGIN);
        //loginPage.typeLoginForm("iv@mail.com", "123456Aa!");
        loginPage.typeLoginForm(getProperty("base.properties", "login"),
                getProperty("base.properties", "password"));
        contactsPage = new ContactsPage(getDriver());
        numberOfContacts = contactsPage.getNumberOfContacts();
        addPage = clickButtonHeader(HeaderMenuItem.ADD);


    }
    @Test
    public void deleteFirstContactPositiveTest(){

    }


}
