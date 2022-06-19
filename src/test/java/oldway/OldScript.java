package oldway;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OldScript {
    ChromeDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Implicit - waits designated time before throwing an error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Explicit wait - waiting for a designated action to happen before to throw an error "element not found"
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //actions = new Actions(driver);

    }

    @Test
    public void openSignInForm() {
        driver.get("http://training.skillo-bg.com/users/login");

        //test
        WebElement loginButton = driver.findElement(By.id("nav-link-login"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        WebElement usernameField = driver.findElement(By.id("defaultLoginFormUsername"));
        usernameField.sendKeys("nikidm-testing-user");
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys("nikidm-testing-user");
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        signInButton.click();
        WebElement newPostButton = driver.findElement(By.id("nav-link-new-post"));
        Assert.assertTrue(newPostButton.isDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
