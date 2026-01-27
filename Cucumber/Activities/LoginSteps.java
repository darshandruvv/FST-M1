package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {

	@Given("the user is on the login page")
	public void loginPage() {
		driver.get("https://training-support.net/webelements/login-form");
	}

	@When("the user enters username and password")
	public void enterCreds() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
	}

	@When("the user enters {string} and {string}")
	public void enterCredsWithInput(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("clicks the submit button")
	public void submitBtn() {
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
	}

	@Then("get the confirmation message and verify it")
	public void verifyHomePageMessage() {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
		String headingMessage = driver.findElement(By.cssSelector("h1.text-center")).getText();
		assertEquals("Login Success!", headingMessage);
	}

	@Then("get the confirmation text and verify message as {string}")
	public void verifyhomePageMessageWithInput(String expectedMessage) {
		String headingMessage;

		if (!expectedMessage.contains("Invalid")) {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
			headingMessage = driver.findElement(By.cssSelector("h2.mt-5")).getText();
		} else {
			headingMessage = driver.findElement(By.id("subheading")).getText();
		}
		assertEquals(expectedMessage, headingMessage);

	}

}