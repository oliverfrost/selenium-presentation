import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainClass {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://docs.seleniumhq.org/");
		
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		
		driver.quit();		
	}
}