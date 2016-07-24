package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
