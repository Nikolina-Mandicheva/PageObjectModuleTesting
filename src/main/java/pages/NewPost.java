package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPost {
    WebDriver driver;

    public NewPost(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@class='image-preview']")
    WebElement imageContainer;
    @FindBy(xpath = "//input[@formcontrolname='caption']")
    WebElement postCaptionField;
    @FindBy(xpath = "//input[@id='customSwitch2']")
    WebElement toggleSwitch;
    @FindBy(id = "create-post")
    WebElement submitButton;

    public void makePost(){
        //How to actually upload the pic?
        postCaptionField.clear();
        postCaptionField.sendKeys("IJ - TEST 123 123 234");
        toggleSwitch.click();
    }
}
