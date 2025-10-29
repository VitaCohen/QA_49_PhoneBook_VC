package ui_tests;

import manager.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.HeaderMenuItem;

import static pages.BasePage.*;

public class AddNewContactTests extends ApplicationManager {


    HomePage homePage;
    LoginPage loginPage;
    ContactsPage contactsPage;
    AddPage addPage;


    @BeforeMethod
    public void login() {
        homePage = new HomePage(getDriver());
        loginPage = BasePage.clickButtonHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm("iv@mail.com", "123456Aa!");
        contactsPage = new ContactsPage(getDriver());
        addPage = clickButtonHeader(HeaderMenuItem.ADD);


    }
 //Homework 7(28.10.25) advanced
    @Test
    public void addNewContactPositiveTest() {


    }


}
