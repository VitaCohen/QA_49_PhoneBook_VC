package pages;

import dto.User;
import dto.UserLombok;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(css = "input[name='email']")
    WebElement inputEmail;

    @FindBy(css = "input[name='password']")
    WebElement inputPassword;

    @FindBy(css = "button[name='login']")
    WebElement btnLoginForm;

    //Homework_6
    @FindBy(xpath = "//button[text() = 'Sign Out']")
    WebElement btnSignOutHeader;

    @FindBy(css = "button[name='registration']")
    WebElement btnRegistrationForm;


    public void typeLoginForm(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        btnLoginForm.click();

    }

    public void typeLoginFormWithUser(User user) {
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        btnLoginForm.click();

    }

    //Homework_6
    public void typeLoginFormWithUserLombok(UserLombok userLombok) {
        inputEmail.sendKeys(userLombok.getUsername());
        inputPassword.sendKeys(userLombok.getPassword());
        btnLoginForm.click();

    }

    //Homework_6
    public void typrRegistrationFormWithUserLombok(UserLombok userLombok) {
        inputEmail.sendKeys(userLombok.getUsername());
        inputPassword.sendKeys(userLombok.getPassword());
        btnRegistrationForm.click();
    }

    public boolean isSignOutDisplayed() {
        return isElementDisplayed(btnSignOutHeader);
    }

    public String closeAlertReturnText() {
        Alert alert = new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        return text;

    }

    public void typeRegForm(User user) {
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        btnRegistrationForm.click();

    }
}
