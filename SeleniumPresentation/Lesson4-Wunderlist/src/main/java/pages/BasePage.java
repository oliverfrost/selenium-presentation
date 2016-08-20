package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver driver;
    protected Logger logger;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        logger = LogManager.getRootLogger();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.clear();
            element.sendKeys(text);
        }
    }


//    public boolean isElementDisplayed(WebElement element) {
//        try {
//            new FluentWait<WebDriver>(driver).withTimeout(5, TimeUnit.SECONDS)
//                    .pollingEvery(1, TimeUnit.SECONDS)
//                    .ignoring(NoSuchElementException.class)
//                    .until(ExpectedConditions.visibilityOf(element));
//            if (element.isDisplayed())
//                return true;
//            else
//                return false;
//
//        } catch (Exception e) {
//            return false;
//        }
//    }


    public boolean isElementDisplayed(WebElement element){
        Boolean visible = false;

        try{
            if(element.isDisplayed()){
                visible = true;
            }
        } catch (NoSuchElementException e){
            logger.warn(element + " is not displayed.");
        }

        return visible;
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