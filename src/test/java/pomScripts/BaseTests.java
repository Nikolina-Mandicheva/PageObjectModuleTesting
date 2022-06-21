package pomScripts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.Screenshot;

import java.time.Duration;

public class BaseTests {
    WebDriver driver;
    DefaultPage defaultPage;
    LoginModal loginModal;
    HomePage homePage;
    UsersPage usersPage;
    UserPostModal userPostModal;
    RegisterPage registerPage;



    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        defaultPage = new DefaultPage(driver);
        loginModal = new LoginModal(driver);
        homePage = new HomePage(driver);
        usersPage=new UsersPage(driver);
        userPostModal=new UserPostModal(driver);
        registerPage = new RegisterPage(driver);


    }

    @AfterTest
    public void tearDown(/*ITestResult result*/) {
        //TODO Screenshot
//        if (!result.isSuccess()) {
//            Screenshot.capture(driver, "screenshots", result.getName());
//        }
        driver.quit();

    }
}
