package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver driver;
    protected Logger logger;

    private Integer timeOut = 30000;

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

    public void simpleWait(long time) {
        long end = System.currentTimeMillis() + time;
        while (System.currentTimeMillis() < end) {
            // Do nothing here, just wait
        }
    }


    public void rightClick(WebElement element) {
        Actions oAction = new Actions(driver);
        oAction.moveToElement(element);
        oAction.contextClick(element).build().perform();
    }

    public void waitTillElementBecomesVisible(WebElement element) {
        long end = System.currentTimeMillis() + timeOut;
        Boolean elementDisplayed = false;
        while (System.currentTimeMillis() < end) {
            simpleWait(1000);
            if (!elementDisplayed) {
                try {
                    elementDisplayed = element.isDisplayed();
                    simpleWait(1000);
                } catch (Exception e) {
                    elementDisplayed = false;
                    simpleWait(1000);
                }
            } else {
                break;
            }
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


    public boolean isElementDisplayed(WebElement element) {
        Boolean visible = false;

        try {
            if (element.isDisplayed()) {
                visible = true;
            }
        } catch (NoSuchElementException e) {
            logger.warn(element + " is not displayed.");
        }

        return visible;
    }


    /**
     * Defines if element is present on the page.
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