package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserFeedPage extends BasePage {

	public UserFeedPage(WebDriver driver) {
		super(driver);
	}

	public boolean isFeedDisplayed() {
		return driver.findElement(By.id("contentCol")).isDisplayed();
	}
}
