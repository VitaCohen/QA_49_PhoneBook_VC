package pages;

import dto.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AddPage extends  BasePage{

    public AddPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                10), this);
    }

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement inputNameContact;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement inputLastNameContact;
    @FindBy(xpath = "//input[@placeholder='Phone']")
    WebElement inputPhoneContact;
    @FindBy(xpath = "//input[@placeholder='email']")
    WebElement inputEmailContact;
    @FindBy(xpath = "//input[@placeholder='Address']")
    WebElement inputAddressContact;
    @FindBy(xpath = "//input[@placeholder='description']")
    WebElement inputDescriptionContact;

    @FindBy(xpath = "//b[text()='Save']")
    WebElement btnSave;


public static void typeNewContactForm(Contact contact){


}

}
