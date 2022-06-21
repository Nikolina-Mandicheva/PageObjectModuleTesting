package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class UserPostModal extends BasePage {
    WebDriverWait wait;

    public UserPostModal(WebDriver driver) {
        super(driver);
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

    @FindBy(xpath = "//div[@role='alertdialog']")
    WebElement likePostSuccessAlert;

    public boolean commentPost(String comment) {
        boolean isCommentDisplayed=false;
        postModalCommentHereField.clear();
        postModalCommentHereField.sendKeys(comment);
        postModalCommentHereField.sendKeys(Keys.ENTER);
        WebElement publishedComment = driver.findElement(By.xpath("//div[@class='comment-list-container']//div[text()='Niki12100 Test']"));
        String commentWebElementText=publishedComment.getText();
        if  (commentWebElementText== comment){
             isCommentDisplayed=true;
        }
        else { isCommentDisplayed=false;}
        return isCommentDisplayed;

    }


    public void likePost() {
        likePostButton.click();


    }

    public boolean likesVerification() { //is present?
        return (likedPostButton.isDisplayed());

    }

    public boolean likesVerification1() {
        wait.until(ExpectedConditions.invisibilityOf(likePostSuccessAlert));
        return (likedPostButton.isDisplayed());

    }
}
