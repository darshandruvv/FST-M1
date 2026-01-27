package Activities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {

	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();

		launchPage(browser);

		handleDropdown(browser);

		closeBrowser(browser);
	}

	private static void launchPage(WebDriver browser) {
		browser.get("https://training-support.net/webelements/selects");
		System.out.println("Opened Page: " + browser.getTitle());
	}

	private static void handleDropdown(WebDriver browser) {

		WebElement selectElement = browser.findElement(By.cssSelector("select.h-10"));
		Select selector = new Select(selectElement);

		chooseByText(selector, "Two");
		chooseByPosition(selector, 3);
		chooseByValue(selector, "four");

		displayAllOptions(selector);
	}

	private static void chooseByText(Select selector, String text) {
		selector.selectByVisibleText(text);
		System.out.println("Chosen by text: " + selector.getFirstSelectedOption().getText());
	}

	private static void chooseByPosition(Select selector, int index) {
		selector.selectByIndex(index);
		System.out.println("Chosen by index: " + selector.getFirstSelectedOption().getText());
	}

	private static void chooseByValue(Select selector, String value) {
		selector.selectByValue(value);
		System.out.println("Chosen by value: " + selector.getFirstSelectedOption().getText());
	}

	private static void displayAllOptions(Select selector) {

		List<WebElement> availableOptions = selector.getOptions();

		System.out.println("Available dropdown values:");

		for (WebElement item : availableOptions) {
			System.out.println(" - " + item.getText());
		}
	}

	private static void closeBrowser(WebDriver browser) {
		browser.quit();
		System.out.println("Browser session closed.");
	}
}
