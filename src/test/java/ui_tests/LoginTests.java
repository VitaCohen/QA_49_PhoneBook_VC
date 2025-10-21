package ui_tests;

import dto.User;
import dto.UserLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.Random;

public class LoginTests extends ApplicationManager {

    @Test
    public void loginPositiveTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("a@mail.ru", "Password123!");
        Assert.assertTrue(loginPage.isSignOutDisplayed());

    }

    @Test
    public void loginPositivetTest_userLombok() {
        UserLombok userLombok = UserLombok.builder()
                .username("a@mail.ru")
                .password("Password123!")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWithUserLombok(userLombok);
        Assert.assertTrue(loginPage.isSignOutDisplayed());

    }

    @Test
    public void loginNegativeTest_wrongPassword() {
        User user = new User("a@mail.ru", "password123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWithUser(user);

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
                .username("afs1@mail.ru")
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
                .username("afs@@mail.ru")
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
                .username("afs12@@mail.ru")
                .password("password123!")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typrRegistrationFormWithUserLombok(userLombok);


    }


}
