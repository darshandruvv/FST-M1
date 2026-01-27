package Activities;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

public class Activity5 {

	WebDriver driver;

	@BeforeClass

	public void open() {

		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");

	}

	@Test(groups = { "HeaderTests" })

	public void Header1() {

		String message = driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText();
		System.out.println(message);
		Assert.assertEquals(message, "Heading #3");
	}

	@Test(groups = { "HeaderTests" })
	public void Header2() {
		Color header5Color = Color
				.fromString(driver.findElement(By.cssSelector("h5.text-purple-600")).getCssValue("color"));
		Assert.assertEquals(header5Color.asHex(), "#9333ea");
	}

	@Test(groups = { "ButtonTests" })
	public void Button1() {
		String button = driver.findElement(By.xpath("//button[text()='Emerald']")).getText();
		Assert.assertEquals(button, "Emerald");
	}

	@Test(groups = { "ButtonTests" })
	public void Button2() {
		Color button2Color = Color
				.fromString(driver.findElement(By.xpath("//button[contains(@class, 'purple')]")).getCssValue("color"));
		Assert.assertEquals(button2Color.asHex(), "#581c87");
	}

	@AfterClass

	public void close() {

		driver.close();
	}
}