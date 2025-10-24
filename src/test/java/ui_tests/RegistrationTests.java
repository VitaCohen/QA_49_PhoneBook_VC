package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

import static utils.UserFactory.*;

public class RegistrationTests extends ApplicationManager {

    LoginPage loginPage;

    @BeforeMethod
    public void goToRegPage() {
        new HomePage(getDriver()).clickBtnLoginHeader();
        loginPage = new LoginPage(getDriver());

    }


    @Test
    public void registrationPositiveTest() {
        User user = positiveUser();
        loginPage.typeRegForm(user);
        Assert.assertTrue(new ContactsPage(getDriver()).isTextNoContactsPresent("No Contacts here!"));
    }


    @Test
    public void registrationNegativeTest_wrongEmail() {
        User user = positiveUser();
        user.setUsername("Wrong email");
        loginPage.typeRegForm(user);
        Assert.assertTrue(loginPage.closeAlertReturnText().contains(
                "Wrong email or password format"));

    }

    // Homework_7

    @Test
    public void registrationNegativeTest_wrongPassword() {
        User user = positiveUser();
        user.setPassword("Wrong password");
        loginPage.typeRegForm(user);
        Assert.assertTrue(loginPage.closeAlertReturnText().contains(
               "Wrong email or password format"));

    }

}
