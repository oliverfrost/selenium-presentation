package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class TestBase {
    public static WebDriver driver;


    @BeforeClass
    public void startUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeTest() {
        driver.manage().deleteAllCookies();
    }


    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./Screenshots/" + testResult.getName() + "-" + System.currentTimeMillis() + ".png"));
        }
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
