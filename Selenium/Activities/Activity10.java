package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {

	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();
		Actions mouseController = new Actions(browser);

		loadApplication(browser);

		executeDragOperations(browser, mouseController);

		terminateSession(browser);
	}

	private static void loadApplication(WebDriver browser) {
		browser.get("https://training-support.net/webelements/drag-drop");
		System.out.println("Application Loaded: " + browser.getTitle());
	}

	private static void executeDragOperations(WebDriver browser, Actions mouseController) {

		WebElement ballElement = browser.findElement(By.id("ball"));
		WebElement firstZone = browser.findElement(By.id("dropzone1"));
		WebElement secondZone = browser.findElement(By.id("dropzone2"));

		dragUsingSteps(mouseController, ballElement, firstZone);
		verifyDrop(firstZone, "Dropzone 1");

		dragUsingDirectMethod(mouseController, ballElement, secondZone);
		verifyDrop(secondZone, "Dropzone 2");
	}

	private static void dragUsingSteps(Actions mouseController, WebElement source, WebElement target) {

		mouseController.clickAndHold(source).moveToElement(target).pause(2000).release().perform();
	}

	private static void dragUsingDirectMethod(Actions mouseController, WebElement source, WebElement target) {

		mouseController.dragAndDrop(source, target).pause(2000).perform();
	}

	private static void verifyDrop(WebElement zone, String zoneName) {

		String status = zone.findElement(By.className("dropzone-text")).getText();

		if ("Dropped!".equals(status)) {
			System.out.println("Ball successfully dropped in " + zoneName);
		} else {
			System.out.println("Ball NOT dropped in " + zoneName);
		}
	}

	private static void terminateSession(WebDriver browser) {
		browser.quit();
		System.out.println("Browser session closed.");
	}
}
