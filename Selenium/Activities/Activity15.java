package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {

	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();
		WebDriverWait synchronizer = new WebDriverWait(browser, Duration.ofSeconds(10));

		openApplication(browser);

		submitEventForm(browser);

		verifySubmission(browser, synchronizer);

		shutdown(browser);
	}

	private static void openApplication(WebDriver browser) {
		browser.get("https://training-support.net/webelements/dynamic-attributes");
		System.out.println("Loaded Page Title: " + browser.getTitle());
	}

	private static void submitEventForm(WebDriver browser) {

		WebElement nameField = browser.findElement(By.xpath("//input[starts-with(@id,'full-name')]"));

		WebElement emailField = browser.findElement(By.xpath("//input[contains(@id,'-email')]"));

		WebElement dateField = browser.findElement(By.xpath("//input[contains(@name,'-event-date-')]"));

		WebElement notesField = browser.findElement(By.xpath("//textarea[contains(@id,'-additional-details-')]"));

		nameField.sendKeys("Raiden Shogun");
		emailField.sendKeys("raiden@electromail.com");
		dateField.sendKeys("2025-06-26");
		notesField.sendKeys("It will be electric!");

		browser.findElement(By.xpath("//button[text()='Submit']")).click();
	}

	private static void verifySubmission(WebDriver browser, WebDriverWait synchronizer) {

		WebElement confirmation = synchronizer
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));

		System.out.println("Form submission status: " + confirmation.getText());
	}

	private static void shutdown(WebDriver browser) {
		browser.quit();
		System.out.println("Browser closed successfully.");
	}
}
