package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestNGListener;

import java.lang.reflect.Method;

import static utils.UserFactory.*;

@Listeners(TestNGListener.class)
public class RegistrationTests extends ApplicationManager {

    LoginPage loginPage;

    @BeforeMethod (alwaysRun = true)
    public void goToRegPage() {
        new HomePage(getDriver()).clickBtnLoginHeader();
        loginPage = new LoginPage(getDriver());

    }


    @Test (groups = {"smoke", "user"})
    public void registrationPositiveTest(Method method) {
        User user = positiveUser();
        logger.info("Start testing " + method.getName() + "with data " + user);
        loginPage.typeRegForm(user);
        Assert.assertTrue(new ContactsPage(getDriver()).isTextNoContactsPresent("No Contacts here!"));
    }


    @Test(groups = "negative")
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
