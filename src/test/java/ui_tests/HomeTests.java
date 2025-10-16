package ui_tests;

import manager.ApplicationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTests extends ApplicationManager {

 @Test
    public void firstTest(){
     System.out.println("First Test");
     HomePage homePage = new HomePage(getDriver());

 }




}
