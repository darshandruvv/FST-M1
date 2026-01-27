package Activities;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Activity1 {

	WebDriver driver = new FirefoxDriver();

	@BeforeClass

	public void open() {

		driver.get("https://training-support.net");

	}

	@AfterClass

	public void close() {

		driver.quit();
	}

	@Test

	public void data() {

		String title = driver.getTitle();
		System.out.println("Title is: " + title);

		Assert.assertEquals(title, "Training Support");

		WebElement element = driver.findElement(By.linkText("About Us"));
		element.click();

		System.out.println("Title of the new page is: " + driver.getTitle());
	}
}