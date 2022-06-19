package pomScripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class BaseTests {
    WebDriver driver;
    DefaultPage defaultPage;
    LoginModal loginModal;
    HomePage homePage;
    UsersPage usersPage;
    UserPostModal userPostModal;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        defaultPage = new DefaultPage(driver);
        loginModal = new LoginModal(driver);
        homePage = new HomePage(driver);
        usersPage=new UsersPage(driver);
        userPostModal=new UserPostModal(driver);


    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }

    @BeforeMethod
    public void loginTest() {
        driver.get("http://training.skillo-bg.com");
        defaultPage.clickLoginButton();
        loginModal.enterUsername("nikidm-testing-user");
        loginModal.enterPassword("nikidm-testing-user");
        loginModal.clickSingIn();
        Assert.assertTrue(homePage.isLogoutButtonDisplayed());
        Assert.assertTrue(homePage.isNewPostButtonDisplayed());

    }

    @Test
    public void getUserPosts() {
        //loginTest();
        driver.get("http://training.skillo-bg.com/posts/all");
        homePage.clickProfileButton();
        usersPage.getAllUsersPosts();
        Assert.assertTrue(usersPage.usernameDisplayed());
        Assert.assertNotNull(usersPage.getUsersPostsCount());
        //Validate that users posts are displayed - cannot correctly get.is displayed for all items from the list
    }

    @Test //How to make the Enter click - ?
    public void commentPost(){
        driver.get("http://training.skillo-bg.com/users/2399");
        usersPage.getAllUsersPosts();
        usersPage.selectUserPost();
        userPostModal.commentPost();

    }

    @Test //assertion failure
    public void likePost() throws InterruptedException {
        driver.get("http://training.skillo-bg.com/users/2399");
        usersPage.getAllUsersPosts();
        usersPage.selectUserPost();
        userPostModal.likePost();
        Assert.assertTrue(userPostModal.likesVerification1());
        //Assert.assertTrue(userPostModal.likesVerification());
        //userPostModal.likePost();
        Thread.sleep(5000);

    }

    @Test
    public void followUser(){
        homePage.clickFollowUser();
        Assert.assertTrue(homePage.followedUserVerification());
    }

//    @Test
//    public void addNewPost(){
//        driver.get("http://training.skillo-bg.com/users/2399");
//        homePage.clickNewPostButton();
//
//    }
}
