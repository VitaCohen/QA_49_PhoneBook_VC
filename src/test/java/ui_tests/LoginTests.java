package ui_tests;

import dto.User;
import dto.UserLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.RetryAnalyzer;
import utils.TestNGListener;

import java.lang.reflect.Method;
import java.util.Random;

@Listeners(TestNGListener.class)
public class LoginTests extends ApplicationManager {

    @Test (groups = {"smoke", "user"}) //(retryAnalyzer = RetryAnalyzer.class)
    public void loginPositiveTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("a@mail.ru", "Password123!");
        Assert.assertTrue(new ContactsPage(getDriver()).isTextContactsPtresent("CONTACTS"));
        // Assert.assertTrue(loginPage.isSignOutDisplayed());

    }

    @Test
    public void loginPositivetTest_userLombok(Method method) {
        UserLombok userLombok = UserLombok.builder()
                .username("a@mail.ru")
                .password("Password123!")
                .build();
        logger.info("Start testing " + method.getName() + "with data " + userLombok);
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWithUserLombok(userLombok);
        Assert.assertTrue(loginPage.isSignOutDisplayed());

    }

    @Test(groups = "negative")
    public void loginNegativeTest_wrongPassword() {
        User user = new User("a@mail.ru", "password123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWithUser(user);
        Assert.assertEquals(loginPage.closeAlertReturnText(),
                "Wrong email or password");

    }

    @Test
    public void loginNegativeTest_wrongEmail() {
        UserLombok userLombok = UserLombok.builder()
                .username("wrong email")
                .password("Password123!")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWithUserLombok(userLombok);

    }

    //Homework_6
    @Test
    public void registrationPositiveTest_userLombok() {
        UserLombok userLombok = UserLombok.builder()
                .username("afs123@mail.ru")
                .password("Password123!")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typrRegistrationFormWithUserLombok(userLombok);
        Assert.assertTrue(loginPage.isSignOutDisplayed());

    }

    //Homework_6
    @Test
    public void registrationNegativeTestULombok_wrongEmail() {
        UserLombok userLombok = UserLombok.builder()
                .username("afs12@@mail.ru")
                .password("Password123!")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typrRegistrationFormWithUserLombok(userLombok);

    }

    //Homework_6
    @Test
    public void registrationNegativeTestULombok_wrongPassword() {
        UserLombok userLombok = UserLombok.builder()
                .username("afs123@@mail.ru")
                .password("password123!")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typrRegistrationFormWithUserLombok(userLombok);


    }


}
