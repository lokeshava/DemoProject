package Demo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "D:\\Executable browser files\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void inputFields() {
		driver.findElement(By.id("name")).sendKeys("Lokesh");
		driver.findElement(By.id("email")).sendKeys("lokeshavareddy111@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9148750050");
		driver.findElement(By.id("textarea")).sendKeys("65/3, nanjappa street, Banhalore, Karnataka");
		driver.findElement(By.id("male")).click();
		driver.findElement(By.id("sunday")).click();
		driver.findElement(By.id("monday")).click();
		WebElement country = driver.findElement(By.id("country"));
		Select dd = new Select(country);
		dd.selectByVisibleText("United States");
		
		WebElement colors = driver.findElement(By.id("colors"));
		Select ddd = new Select(colors);
		ddd.selectByValue("blue");
		ddd.selectByValue("red");
	
		driver.findElement(By.id("datepicker")).sendKeys("11/06/1999");
		
	}
}
