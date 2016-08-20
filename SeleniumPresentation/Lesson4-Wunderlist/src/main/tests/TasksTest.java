import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import java.util.UUID;

public class TasksTest extends TestBase{
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void login(){
        driver.manage().deleteAllCookies();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.open();
        loginPage.login(user);
    }

    @Test(dataProvider = "randomTaskName")
    public void createNewTask(String taskName){
        homePage.addNewTask(taskName);

        assertTrue(homePage.isTaskPresent(taskName));
    }


    @DataProvider(name = "randomTaskName")
    public Object[][] generateRandomTaskName() {
        return new Object[][] {{"Buy some milk"}, {"Call Molly"}, {"Write code snippets"}, {UUID.randomUUID().toString()}};
    }

}
