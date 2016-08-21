import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.util.UUID;

public class TasksTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void login() {
        driver.manage().deleteAllCookies();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.open();
        loginPage.login(USER);
    }

    @Test(dataProvider = "randomTaskName", groups = {"smoke", "positive, regression"})
    public void createNewTask(String taskName) {
        homePage.addNewTask(taskName);

        assertTrue(homePage.isTaskPresent(taskName));
    }

    @Test(dependsOnMethods = {"createNewTask"}, groups = {"smoke", "positive, regression"})
    public void markTaskAsCompleted() {
        String taskName = "Call Molly";
        homePage.markTaskAsCompleted(taskName);

        assertFalse(homePage.isTaskPresent(taskName));
    }

    @Test(dependsOnMethods = {"createNewTask"}, groups = {"smoke", "positive, regression"})
    public void removeTask() {
        String taskName = "Buy some milk";
        homePage.removeTask(taskName);

        assertFalse(homePage.isTaskPresent(taskName));
    }


    @DataProvider(name = "randomTaskName")
    public Object[][] generateRandomTaskName() {
        return new Object[][]{{"Buy some milk"}, {"Call Molly"}, {"Write code snippets"}, {UUID.randomUUID().toString()}};
    }

}
