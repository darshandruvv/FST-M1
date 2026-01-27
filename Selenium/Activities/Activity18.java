package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {

	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();

		openApplication(browser);

		processSimpleAlert(browser);

		closeBrowser(browser);
	}

	private static void openApplication(WebDriver browser) {
		browser.get("https://training-support.net/webelements/alerts");
		System.out.println("Loaded Page: " + browser.getTitle());
	}

	private static void processSimpleAlert(WebDriver browser) {

		browser.findElement(By.id("simple")).click();

		Alert popup = browser.switchTo().alert();

		String popupMessage = popup.getText();
		System.out.println("Alert message received: " + popupMessage);

		popup.accept();

		String resultText = browser.findElement(By.id("result")).getText();
		System.out.println("Page response: " + resultText);
	}

	private static void closeBrowser(WebDriver browser) {
		browser.quit();
		System.out.println("Browser session closed.");
	}
}
