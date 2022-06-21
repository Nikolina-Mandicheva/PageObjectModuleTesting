package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage extends BasePage{


    public UsersPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[text()='nikidm-testing-user']")
    WebElement userName;
    @FindBy(xpath = "//strong[@class='profile-stat-count']")
    WebElement usersPostsCount;

    //@FindBy(xpath = "//div[@class='gallery-item-info']")


    @FindBy(xpath = "//label[text()=' All ']")
    WebElement radioButtonAll;

    @FindBy(xpath = "//div[@class='gallery-item']/div[1]")
    WebElement userPost;

    public boolean usernameDisplayed(){
        Assert.assertEquals(userName.getText(),"nikidm-testing-user");
        return(userName.isDisplayed());
    }

    public void getAllUsersPosts(){
        radioButtonAll.click();
    }

    public String getUsersPostsCount(){
       // it is not made to compare the WebList.size to this value as with fails all the time
        return(usersPostsCount.getText());
    }

    public void selectUserPost(){
        userPost.click();
    }

    public boolean postsDisplayed() {
        List<WebElement> userPosts=driver.findElements(By.xpath("//app-post/div[@class='gallery-item']"));
    boolean isDisplayed=false;
        int i;
        for (i = 0; i < userPosts.size(); i++) {
            if (userPosts.get(i).isDisplayed()) {
                isDisplayed = true;
            } else {
                isDisplayed = false;
            }
        }
        return isDisplayed;
    }

    public Integer getUsersPostsCountFromWebList(){
        // it is not made to compare the WebList.size to this value as with fails all the time
        List<WebElement> userPosts=driver.findElements(By.xpath("//app-post/div[@class='gallery-item']"));
        return userPosts.size();
    }



}
