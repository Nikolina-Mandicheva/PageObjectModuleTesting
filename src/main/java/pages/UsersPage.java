package pages;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage {
    WebDriver driver;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[text()='nikidm-testing-user']")
    WebElement userName;
    @FindBy(xpath = "//strong[@class='profile-stat-count']")
    WebElement usersPostsCount;

    @FindBy(xpath = "//div[@class='gallery-item-info']")
    List<WebElement> userPosts;

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
       return(usersPostsCount.getText());
    }

    public void selectUserPost(){
        userPost.click();
    }

//    public boolean postsDisplayed(){
//        int i;
//       for (i=0; i< userPosts.size()-1;i++){
//
//
//       if (userPosts.get(i).isDisplayed()){
//           return true;
//       }
//       else return false;
//
//    }

}
