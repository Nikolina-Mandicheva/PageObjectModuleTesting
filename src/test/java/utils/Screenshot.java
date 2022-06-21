package utils;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 *
 * @author steve
 *
 * to use, add the following to your TestNG tests:
 *
 * @AfterTest
 * public void tearDown(ITestResult result) {
 *   if (!result.isSuccess()) {
 *     Screenshot.capture(driver, "target/surefire-reports", result.getName());
 *   }
 * }
 *
 *
 */

public class Screenshot {
    WebDriver driver;
    //TODO implement capture method



        public static final void capture(WebDriver driver, String path, String fileName) {
            try {
                new File(path).mkdirs();
                try ( FileOutputStream out = new FileOutputStream(path + File.separator + "screenshot-" + fileName + ".png")) {
                    out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                }
            } catch (IOException | WebDriverException e) {
                System.out.println("screenshot failed:" + e.getMessage());
            }
        }

    }

