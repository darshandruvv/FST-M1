package Activities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.BaseClassFinder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1 extends BaseClassFinder {
	
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@Given("user is on the TS homepage")
	public void openTSHomepage() throws Throwable {
		// Open the browser
		driver.get("https://training-support.net");
		assertEquals(driver.getTitle(), "Training Support");
	}

	@When("the user clicks on the About Us link")
	public void clickButton() throws Throwable {
		driver.findElement(By.linkText("About Us")).click();
	}

	@Then("they are redirected to another page")
	public void aboutUsPage() throws Throwable {
		wait.until(ExpectedConditions.titleIs("About Training Support"));
		String pageHeading = driver.findElement(By.cssSelector("h1.text-center")).getText();

		System.out.println("New page title is: " + pageHeading);
		assertEquals(pageHeading, "About Us");
	}
}