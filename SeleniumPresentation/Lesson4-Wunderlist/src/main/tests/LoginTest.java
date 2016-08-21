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
    public void goToLoginPage() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        driver.manage().deleteAllCookies();
        loginPage.open();
    }


    @Test(groups = {"smoke", "positive, regression"})
    public void loginWithCorrectCredentialsTest() {
        loginPage.login(USER);
        assertTrue(homePage.isOpened());
    }

    @Test(groups = {"negative, regression"})
    public void loginWithIncorrectPasswordTest() {
        loginPage.login(USER.getEmail(), "Incorrect Password");
        assertTrue(loginPage.isIncorrectPasswordMessageDisplayed());
    }

    @Test(groups = {"negative, regression"})
    public void loginWithIncorrectEmailTest() {
        loginPage.login("Incorrect Email", USER.getPassword());
        assertFalse(loginPage.isIncorrectPasswordMessageDisplayed());
    }
}
