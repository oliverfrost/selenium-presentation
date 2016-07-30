import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("kholodniy.cpd@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Partyword1");
		driver.findElement(By.id("u_0_o")).click();
		driver.quit();
	}
}
