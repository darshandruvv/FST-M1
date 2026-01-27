package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {

	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {

		driver = new FirefoxDriver();
		Reporter.log("Starting Test |");
		driver.get("https://training-support.net/webelements/alerts");
		Reporter.log("Page title is " + driver.getTitle() + " |");

	}

	@BeforeMethod

	public void beforeMethod() {
		driver.switchTo().defaultContent();
	}

	@Test(priority = 1)
	public void TestAlert() {

		driver.findElement(By.id("simple")).click();
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		Assert.assertEquals("You've just triggered a simple alert!", alertText);
		simpleAlert.accept();
	}

	@Test(priority = 2)
	public void TestconfirmAlert() {

		driver.findElement(By.id("confirmation")).click();
		Alert confirmAlert = driver.switchTo().alert();
		String alertText = confirmAlert.getText();
		Assert.assertEquals("You've just triggered a confirmation alert!", alertText);
		confirmAlert.accept();
	}

	@Test(priority = 3)
	public void TestpromptAlert() {

		driver.findElement(By.id("prompt")).click();
		Alert promptAlert = driver.switchTo().alert();
		String alertText = promptAlert.getText();
		Assert.assertEquals("I'm a Prompt! Type something into me!", alertText);
		promptAlert.sendKeys("Awesome!");
		promptAlert.accept();

	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}