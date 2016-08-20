import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void goToLoginPage(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        driver.manage().deleteAllCookies();
        loginPage.open();
    }


    @Test(groups = {"smoke", "positive"})
    public void loginWithCorrectCredentialsTest(){
        loginPage.login(user);
        assertTrue(homePage.isOpened());
    }

    @Test(groups = {"negative"})
    public void loginWithIncorrectPasswordTest(){
        loginPage.login(user.getEmail(), "Incorrect Password");
        assertTrue(loginPage.isIncorrectPasswordMessageDisplayed());
    }

    @Test(groups = {"negative"})
    public void loginWithIncorrectEmailTest(){
        loginPage.login("Incorrect Email", user.getPassword());
        assertFalse(loginPage.isIncorrectPasswordMessageDisplayed());
    }
}
