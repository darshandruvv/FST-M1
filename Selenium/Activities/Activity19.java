package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {

	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();

		launchPage(browser);

		handleConfirmationPopup(browser);

		shutdown(browser);
	}

	private static void launchPage(WebDriver browser) {
		browser.get("https://training-support.net/webelements/alerts");
		System.out.println("Page Loaded: " + browser.getTitle());
	}

	private static void handleConfirmationPopup(WebDriver browser) {

		browser.findElement(By.id("confirmation")).click();

		Alert confirmationBox = browser.switchTo().alert();

		String confirmationMessage = confirmationBox.getText();
		System.out.println("Confirmation message: " + confirmationMessage);

		confirmationBox.accept(); // Use dismiss() if cancel is required

		String response = browser.findElement(By.id("result")).getText();
		System.out.println("Application response: " + response);
	}

	private static void shutdown(WebDriver browser) {
		browser.quit();
		System.out.println("Browser session closed.");
	}
}
