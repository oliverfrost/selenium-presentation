import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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

        assertTrue(homePage.isTaskPresent(taskName), "[ERROR] Task not present: " + taskName);
    }

    @Test(dependsOnMethods = {"createNewTask"}, groups = {"smoke", "positive, regression"})
    public void markTaskAsCompleted() {
        String taskName = "Call Molly";
        homePage.markTaskAsCompleted(taskName);

        assertFalse(homePage.isTaskPresent(taskName), "[ERROR] Task shound not be present: " + taskName);
    }

    @Test(dependsOnMethods = {"createNewTask"}, groups = {"smoke", "positive, regression"})
    public void removeTask() {
        String taskName = "Buy some milk";
        homePage.removeTask(taskName);

        assertFalse(homePage.isTaskPresent(taskName), "[ERROR] Task shound not be present: " + taskName);
    }

    @Test
    public void softAssertExample() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false, "[ERROR] Noo-o-o-o-o!");
        softAssert.assertEquals(1, 2, "[ERROR] But how?");
        softAssert.assertAll();
    }




    @DataProvider(name = "randomTaskName")
    public Object[][] generateRandomTaskName() {
        return new Object[][]{{"Buy some milk"}, {"Call Molly"}, {"Write code snippets"}, {UUID.randomUUID().toString()}};
    }

}
