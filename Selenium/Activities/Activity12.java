package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {

	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();
		WebDriverWait synchronizer = new WebDriverWait(browser, Duration.ofSeconds(10));

		openSite(browser);

		captureDynamicWord(browser, synchronizer);

		shutdown(browser);
	}

	private static void openSite(WebDriver browser) {
		browser.get("https://www.training-support.net/webelements/dynamic-content");
		System.out.println("Loaded Page: " + browser.getTitle());
	}

	private static void captureDynamicWord(WebDriver browser, WebDriverWait synchronizer) {

		browser.findElement(By.id("genButton")).click();

		boolean isWordVisible = synchronizer
				.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"));

		if (isWordVisible) {
			String dynamicText = browser.findElement(By.id("word")).getText();
			System.out.println("Captured Text: " + dynamicText);
		} else {
			System.out.println("Expected text did not appear.");
		}
	}

	private static void shutdown(WebDriver browser) {
		browser.quit();
		System.out.println("Test completed and browser closed.");
	}
}
