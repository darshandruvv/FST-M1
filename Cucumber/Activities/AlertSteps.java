package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertSteps extends BaseClass {
	public static Alert alert;
	
	@Given("User is on the page")
	public void homePage() {
		driver.get("https://training-support.net/webelements/alerts");
	}
	
	@When("User clicks the Simple Alert button")
	public void simpleAlertBtn() {
		driver.findElement(By.id("simple")).click();
	}
	
	@When("User clicks the Confirm Alert button")
	public void confirmAlertBtn() {
		driver.findElement(By.id("confirmation")).click();
	}
	
	@When("User clicks the Prompt Alert button")
	public void promptAlertBtn() {
		driver.findElement(By.id("prompt")).click();
	}
	
	@Then("Alert opens")
	public void alertOpens() {
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	@And("Read the text from it and print it")
	public void readText() {
		alert = driver.switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
	}
	
	@And("Close the alert")
	public void closeAlert() {
		alert.accept();
	}
	
	@And("Close the alert with Cancel")
	public void closeAlertAsCancel() {
		alert.dismiss();
	}
	
	@And("Read the result text")
	public void readMessage() {
		String message = driver.findElement(By.id("result")).getText();
		System.out.println("Result message: " + message);
	}
	
	@And("Write a custom message in it")
	public void writeMessage() {
		alert.sendKeys("You are tying on Alert");
	}
}