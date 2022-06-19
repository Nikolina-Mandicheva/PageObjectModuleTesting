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

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class RegisterSkilloUser {
    WebDriver driver;
    DefaultPage defaultPage;
    RegisterPage registerPage;
    HomePage homePage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        defaultPage= new DefaultPage(driver);
        registerPage=new RegisterPage(driver);
        homePage=new HomePage(driver);

    }

    @Test
    public void registerUser() throws InterruptedException {
        driver.get("http://training.skillo-bg.com/users/login");
        defaultPage.clickRegisterLink();
        registerPage.registerUser("Nikki","email","nikidm-testing-user");
       // Assert.assertEquals(driver.getCurrentUrl(),"http://training.skillo-bg.com/posts/all");
        Assert.assertTrue(homePage.isLogoutButtonDisplayed());





    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }

}
