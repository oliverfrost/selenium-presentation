package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	/** Clears text field and enters specified text
	 * 
	 * @param locator By locator that looks like By.xxx(yyy)  
	 * @param text String any text
	 */
	public void type(By locator, String text) {
		if (text != null) {
			WebElement element = driver.findElement(locator);
			element.clear();
			element.sendKeys(text);
		}
	}

	
	protected void click(By locator) {
		driver.findElement(locator).click();
	}

	/** Defines if element is present on the page.
	 * 
	 * @param locator By locator that looks like By.xxx(yyy) 
	 * @return true is element exists, false if not
	 */
	public boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
