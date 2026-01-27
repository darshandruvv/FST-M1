package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {

	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();
		WebDriverWait sync = new WebDriverWait(browser, Duration.ofSeconds(10));

		openPage(browser);

		handleCheckbox(browser, sync);

		endTest(browser);
	}

	private static void openPage(WebDriver browser) {
		browser.get("https://www.training-support.net/webelements/dynamic-controls");
		System.out.println("Loaded Page: " + browser.getTitle());
	}

	private static void handleCheckbox(WebDriver browser, WebDriverWait sync) {

		WebElement checkBoxElement = browser.findElement(By.id("checkbox"));
		System.out.println("Initially visible: " + checkBoxElement.isDisplayed());

		toggleCheckbox(browser);
		sync.until(ExpectedConditions.invisibilityOf(checkBoxElement));
		System.out.println("Visible after hiding: " + checkBoxElement.isDisplayed());

		toggleCheckbox(browser);
		sync.until(ExpectedConditions.elementToBeClickable(checkBoxElement)).click();
		System.out.println("Selected after enabling: " + checkBoxElement.isSelected());
	}

	private static void toggleCheckbox(WebDriver browser) {
		browser.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
	}

	private static void endTest(WebDriver browser) {
		browser.quit();
		System.out.println("Execution finished.");
	}
}
