package Activities;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.testng.SkipException;

public class Activity2 {

	WebDriver driver;

	@BeforeClass

	public void open() {

		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice/");

	}

	@Test
	public void test1() {
		System.out.println("Title is: " + driver.getTitle());
	}

	@Test
	public void test2() {

		WebElement blackButton = driver.findElement(By.xpath("//button[text()='black']"));
		Assert.assertTrue(blackButton.isDisplayed());
		Assert.assertEquals(blackButton.getText(), "black");

	}

	@Test(enabled = false)
	public void test3() {

		System.out.println("Test method 3 will be skipped");
	}

	@Test
	public void test4() throws SkipException {

		throw new SkipException("Skipping test 4 method");
	}

	@AfterClass

	public void close() {

		driver.quit();
	}
}
