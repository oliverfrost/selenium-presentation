import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTestWithFixtures {
	public WebDriver driver;

	@BeforeMethod()
	public void startUp() {
		driver = new FirefoxDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyLoginWithCorrectCredentials() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("kholodniy.cpd@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Partyword1");
		driver.findElement(By.id("u_0_o")).click();

		Assert.assertTrue(driver.findElement(By.id("contentCol")).isDisplayed(), "[ERROR] Feed not found.");
	}

	@Test
	public void verifyLoginWithIncorrectCredentials() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("kholodniy.cpd@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("RandomPassword");
		driver.findElement(By.id("u_0_o")).click();

		Assert.assertFalse(driver.findElement(By.id("contentCol")).isDisplayed(), "[ERROR] Feed not found.");
	}
}
