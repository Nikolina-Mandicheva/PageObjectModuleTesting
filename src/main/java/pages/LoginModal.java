package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginModal {
    WebDriver driver;

    public LoginModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    By usernameField=By.id("defaultLoginFormUsername");
//    By passwordField=By.id("defaultLoginFormPassword");
//    By signInButton=By.id("sign-in-button");

    @FindBy(id = "defaultLoginFormUsername")
    WebElement usernameField;

    @FindBy(id = "defaultLoginFormPassword")
    WebElement passwordField;
    @FindBy(id = "sign-in-button")
    WebElement signInButton;

    //Methods
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSingIn() {
        signInButton.click();

    }
}
