package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**The page the user is landed after he has been logged in
 *
 */
//page factory  model implemented
public class HomePage extends BasePage{


    public HomePage(WebDriver driver) {
       super(driver);

    }

    // Locators using PageFactory
    @FindBy(id="nav-link-new-post")
    WebElement newPostButton;
    @FindBy(xpath="//i[contains(@class,'sign-out')]")
    WebElement logoutButton;
    @FindBy(id = "nav-link-profile")
    WebElement profileButton;

    @FindBy(xpath = "//button[text()='Follow']")
    WebElement followButton;
    @FindBy(xpath = "//button[text()='Unfollow']")
    WebElement unfollowButton;

    @FindBy(id = "nav-link-home")
    WebElement homeButton;

    //Interaction methods
    public void clickProfileButton(){
        profileButton.click();
    }

    public void clickNewPostButton (){
        newPostButton.click();
    }

    //Assertion method
    public boolean isNewPostButtonDisplayed(){
        return newPostButton.isDisplayed();
    }

    public boolean isLogoutButtonDisplayed(){

        return logoutButton.isDisplayed();
    }

    public void clickFollowUser(){
        followButton.click();
    }

    public boolean followedUserVerification(){
        return(unfollowButton.isDisplayed());
    }

    public void clickHomeButton(){
        homeButton.click();
    }
    public void clickLogoutButton(){
        logoutButton.click();
    }



}
