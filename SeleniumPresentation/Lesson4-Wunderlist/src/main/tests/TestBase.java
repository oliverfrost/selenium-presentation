import entities.User;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    protected Properties properties;
    protected User user = new User();

    @BeforeSuite
    public void startUp() {
        loadProperties();
        initializeUser();
        initializeDriver();
    }


    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./Screenshots/" + testResult.getName() + "-" + System.currentTimeMillis() + ".png"));
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("configs/local.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeDriver() {
        String browser = properties.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                EdgeDriverManager.getInstance().setup();
                driver = new EdgeDriver();
            default:
                throw new Error(browser + " Browser is not available!");
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    private void initializeUser(){
        user.setEmail(properties.getProperty("userEmail"));
        user.setPassword(properties.getProperty("userPassword"));
        user.setName(properties.getProperty("userName"));
    }
}