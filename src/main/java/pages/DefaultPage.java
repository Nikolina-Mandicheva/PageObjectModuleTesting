package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The page that is opened after the Url is hit
 * Defaultpage=> Home page => New Post page
 */

public class DefaultPage extends BasePage{



    public DefaultPage(WebDriver driver) {
        super(driver);

    }

    //locators
    //By loginButton= By.id("nav-link-login");
    @FindBy(id="nav-link-login")
    WebElement loginButton;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerLink;

    //Methods
 public void clickLoginButton(){
     loginButton.click();
 }

 public void clickRegisterLink(){
     registerLink.click();
 }
}
