package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterPage {
WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@formcontrolname='username']")
    WebElement registerUsernameField;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement registerEmailField;
    @FindBy(id = "defaultRegisterFormPassword")
    WebElement registerPasswordField;
    @FindBy(id = "defaultRegisterPhonePassword")
    WebElement registerConfirmPasswordField;
    @FindBy(id="sign-in-button")
    WebElement signInButton;

    public void registerUser(String username, String email, String password){
        registerUsernameField.clear();
        registerEmailField.clear();
        registerPasswordField.clear();
        registerConfirmPasswordField.clear();

        Date date=new Date();
        String a=String.valueOf(date.getTime());
        String lastFourDigits = "";   //substring containing last 4 characters

        if (a.length() > 4)
        {
            lastFourDigits = a.substring(a.length() - 4);
        }
        else
        {
            lastFourDigits = a;
        }

        registerUsernameField.sendKeys(username+lastFourDigits);
        registerEmailField.sendKeys(email+lastFourDigits+"@test.com");
        registerPasswordField.sendKeys(password);
        registerConfirmPasswordField.sendKeys(password);
        signInButton.click();

    }


}
