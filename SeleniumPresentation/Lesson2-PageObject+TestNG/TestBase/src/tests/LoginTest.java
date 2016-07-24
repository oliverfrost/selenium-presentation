package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.LoginPage;
import framework.UserFeedPage;


public class LoginTest extends TestBase{
	
	@Test(enabled=false)
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
