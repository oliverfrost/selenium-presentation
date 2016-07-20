import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTestWithRunner {

	@Test
	public void verifyLoginWithCorrectCredentials() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("kholodniy.cpd@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Partyword1");
		driver.findElement(By.id("u_0_o")).click();

		Assert.assertTrue(driver.findElement(By.id("contentCol")).isDisplayed(), "[ERROR] Feed not found.");
		driver.quit();
	}

	@Test
	public void verifyLoginWithIncorrectCredentials() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("kholodniy.cpd@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("RandomPassword");
		driver.findElement(By.id("u_0_o")).click();

		Assert.assertFalse(driver.findElement(By.id("contentCol")).isDisplayed(), "[ERROR] Feed not found.");
		driver.quit();
	}
}
