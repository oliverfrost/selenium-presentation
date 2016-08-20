package pages;

import entities.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "div.email>input")
    @CacheLookup
    private WebElement loginField;

    @FindBy(css = "div.password>input")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(css = "input[type='submit']")
    @CacheLookup
    private WebElement submitButton;

    @FindBy(css = "div.message[role='alert']")
    private WebElement incorrectEmailMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(User user) {
        login(user.getEmail(), user.getPassword());
    }


    public void login(String login, String password) {
        logger.info("Authorizing as: {} / {}", login, password);
        enterLogin(login);
        enterPassword(password);
        clickSubmitButton();
    }


    public void open() {
        driver.get("https://www.wunderlist.com/login");
    }


    public void enterLogin(String login) {
        type(loginField, login);
    }


    public void enterPassword(String password) {
        type(passwordField, password);
    }


    public void clickSubmitButton() {
        submitButton.click();
    }


    public boolean isIncorrectPasswordMessageDisplayed() {
        return isElementDisplayed(incorrectEmailMessage);
    }
}
