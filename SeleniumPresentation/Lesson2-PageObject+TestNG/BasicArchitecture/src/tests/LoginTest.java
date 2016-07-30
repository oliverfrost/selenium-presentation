package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.UserFeedPage;
import help1.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
	public WebDriver driver;

	@BeforeClass
	public void startUp() {
		driver = new FirefoxDriver();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyLoginWithCorrectCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.open();
		loginPage.login("kholodniy.cpd@gmail.com", "Partyword1");

		Assert.assertTrue((new UserFeedPage(driver)).isFeedDisplayed(), "[ERROR] Feed not found.");
	}

	@Test
	public void verifyLoginWithIncorrectCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.open();
		loginPage.login("kholodniy.cpd@gmail.com", "RandomPassword");

		Assert.assertFalse((new UserFeedPage(driver)).isFeedDisplayed(), "[ERROR] Feed not found.");
	}
}
