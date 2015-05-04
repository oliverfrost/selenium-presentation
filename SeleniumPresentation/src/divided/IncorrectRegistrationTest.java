package divided;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class IncorrectRegistrationTest extends TestBase{

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
}
