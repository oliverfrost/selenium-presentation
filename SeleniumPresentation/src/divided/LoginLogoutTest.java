package divided;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginLogoutTest extends TestBase{
	
	  @Test
	  public void loginAndLogoutTest() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("kholodniy.cpd@gmail.com");
	    driver.findElement(By.id("pass")).clear();
	    driver.findElement(By.id("pass")).sendKeys("password111");
	    driver.findElement(By.id("u_0_n")).click();
	    driver.findElement(By.id("userNavigationLabel")).click();
	    driver.findElement(By.cssSelector("input.uiLinkButtonInput")).click();
	    assertTrue(isElementPresent(By.id("email")));
	  }
}
