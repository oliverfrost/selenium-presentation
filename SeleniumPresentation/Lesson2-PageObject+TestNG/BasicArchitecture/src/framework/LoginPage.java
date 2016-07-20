package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String login, String password) {
		enterLogin(login);
		enterPassword(password);
		clickSubmitButton();
	}
	
	public void open() {
		driver.get("https://www.facebook.com/");
	}

	public void enterLogin(String login) {
		type(By.id("email"), login);
	}

	public void enterPassword(String password) {
		type(By.id("pass"), password);
	}

	public void clickSubmitButton() {
		driver.findElement(By.id("u_0_o")).click();
	}
}
