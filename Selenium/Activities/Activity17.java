package Activities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();

		openSite(browser);

		processMultiSelect(browser);

		closeSession(browser);
	}

	private static void openSite(WebDriver browser) {
		browser.get("https://training-support.net/webelements/selects");
		System.out.println("Loaded Page Title: " + browser.getTitle());
	}

	private static void processMultiSelect(WebDriver browser) {

		WebElement multiSelectBox = browser.findElement(By.cssSelector("select.h-80"));
		Select selector = new Select(multiSelectBox);

		selectInitialOptions(selector);

		printCurrentSelections(selector, "After initial selection");

		removeOneSelection(selector);

		printCurrentSelections(selector, "After removing one option");
	}

	private static void selectInitialOptions(Select selector) {

		selector.selectByVisibleText("HTML");

		for (int index = 3; index <= 5; index++) {
			selector.selectByIndex(index);
		}

		selector.selectByValue("nodejs");
	}

	private static void removeOneSelection(Select selector) {
		selector.deselectByIndex(4);
	}

	private static void printCurrentSelections(Select selector, String stage) {

		List<WebElement> chosenItems = selector.getAllSelectedOptions();

		System.out.println(stage + ":");

		for (WebElement item : chosenItems) {
			System.out.println(" - " + item.getText());
		}
	}

	private static void closeSession(WebDriver browser) {
		browser.quit();
		System.out.println("Browser closed successfully.");
	}
}
