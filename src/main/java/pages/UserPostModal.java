package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class UserPostModal {
    WebDriver driver;
    WebDriverWait wait;

    public UserPostModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//app-post-modal//input[@placeholder='Comment here']")
    WebElement postModalCommentHereField;

    @FindBy(xpath = "//app-post-modal//i[@class='like far fa-heart fa-2x liked']")
    WebElement likedPostButton;

    @FindBy(xpath = "//app-post-modal//i[@class='like far fa-heart fa-2x']")
    WebElement likePostButton;

    @FindBy(xpath = "//app-post-modal//strong[contains(text(),' likes')]")
    WebElement likeCount;

    @FindBy(xpath = "//form[contains(@class,'comment-form ng-pristine')]")
    WebElement sendComment;

    public void commentPost(){
        postModalCommentHereField.clear();
        postModalCommentHereField.sendKeys("1002");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(postModalCommentHereField,"1002"));
       postModalCommentHereField.sendKeys(Keys.ENTER);
       // sendComment.sendKeys(Keys.ENTER);
    }

    public void likePost(){
    likePostButton.click();

    }

    public boolean likesVerification(){
        return(likedPostButton.isDisplayed());

    }
}
