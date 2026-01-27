package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;

public class Activity6 {

	WebDriver driver;

	@BeforeClass

	public void open() {

		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");

	}

	@Test
	@Parameters({ "sUsername", "sPassword" })
	public void test(String sUsername, String sPassword) {

		WebElement element1 = driver.findElement(By.id("username"));

		element1.sendKeys(sUsername);

		WebElement element2 = driver.findElement(By.id("password"));

		element2.sendKeys(sPassword);

		WebElement element3 = driver.findElement(By.xpath("//button[text()='Submit']"));

		element3.click();

		String message = driver.findElement(By.xpath("//h1[contains(text(), 'Success')]")).getText();
		System.out.println(message);

	}

	@AfterClass

	public void close() {

		driver.close();
	}
}