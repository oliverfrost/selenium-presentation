package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomePage extends BasePage {
    // @FindAll({ @FindBy(id = "one"), @FindBy(id = "two")})

    @FindBy(className = "user-name")
    private WebElement userNameBlock;

    @FindBy(className = "avatar")
    private WebElement avatar;

    @FindBy(className = "list-toggle")
    private WebElement hamburgerIcon;

    @FindBy(className = "sidebarActions")
    private WebElement addNewListBlock;

    @FindBy(className = "addTask-input")
    private WebElement newTaskInput;

    @FindBys(@FindBy(className = "taskItem-body"))
    private List<WebElement> tasks;


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public boolean isOpened() {
        return avatar.isDisplayed() && hamburgerIcon.isDisplayed();
    }


    public void addNewTask(String taskName) {
        logger.info("Adding new task: {}", taskName);
        type(newTaskInput, taskName);
        newTaskInput.sendKeys(Keys.RETURN);
    }


    public boolean isTaskPresent(String taskName) {
        boolean present = false;

        for (WebElement task : tasks) {
            String name = task.getText();
            logger.debug("Task present: {}", name);
            if (name.equals(taskName)) {
                present = true;
                break;
            }
        }
        return present;
    }
}
