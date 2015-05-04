package modified;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


public class ModifiedTest {
  private WebDriver driver;
  private String baseUrl;
    

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.facebook.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

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
    assertTrue(isElementPresent(By.id("u_0_i")));
  }
  
  @Test
  public void incorretRegistrationText() {
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath(".//*[@id='pageFooter']//a[text()='Sign Up']")).click();
	  driver.findElement(By.xpath(".//*[@id='u_0_0']")).sendKeys("Peter");
	  driver.findElement(By.xpath(".//*[@id='u_0_1']")).sendKeys("Parker");
	  driver.findElement(By.xpath(".//*[@id='u_0_2']")).sendKeys("kholodniy.cpd@gmail.com");
	  driver.findElement(By.xpath(".//*[@id='u_0_4']")).sendKeys("kholodniy.cpd@gmail.com");
	  driver.findElement(By.xpath(".//*[@id='u_0_5']")).sendKeys("password");
	 	  
	  Select month = new Select(driver.findElement(By.xpath(".//*[@id='month']")));
	  month.selectByVisibleText("Apr");
	  
	  Select day = new Select(driver.findElement(By.xpath(".//*[@id='day']")));
	  day.selectByVisibleText("1");
	  
	  Select year = new Select(driver.findElement(By.xpath(".//*[@id='year']")));
	  year.selectByVisibleText("2012");
  
	  driver.findElement(By.xpath(".//*[@id='u_0_7']")).click();
	  driver.findElement(By.xpath(".//*[@id='u_0_9']")).click(); // submit button
	  	  
	  assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/r.php");
  }
  
  
  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
