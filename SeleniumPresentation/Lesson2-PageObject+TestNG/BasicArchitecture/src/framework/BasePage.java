package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

		public void type(By locator, String text) {
		if(text != null) {
			WebElement element = driver.findElement(locator);
			element.clear();
			element.sendKeys(text);
		}		
	}
}
