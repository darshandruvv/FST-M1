package Activities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			launchApplication(driver);
			displayPrimaryTabInfo(driver);
			openSecondTab(driver, wait);
			openThirdTab(driver, wait);
		} finally {
			driver.quit();
			System.out.println("All browser windows closed.");
		}
	}

	private static void launchApplication(WebDriver driver) {
		driver.get("https://training-support.net/webelements/tabs");
		System.out.println("Initial Page: " + driver.getTitle());
	}

	private static void displayPrimaryTabInfo(WebDriver driver) {
		System.out.println("Primary Tab ID: " + driver.getWindowHandle());
	}

	private static void openSecondTab(WebDriver driver, WebDriverWait wait) {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open A New Tab']"))).click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		switchToNewestTab(driver);

		printCurrentTabDetails(driver);
	}

	private static void openThirdTab(WebDriver driver, WebDriverWait wait) {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Another One')]")))
				.click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(3));

		switchToNewestTab(driver);

		System.out.println("Final Tab Title: " + driver.getTitle());
	}

	private static void switchToNewestTab(WebDriver driver) {

		Set<String> allTabs = driver.getWindowHandles();

		for (String tab : allTabs) {
			driver.switchTo().window(tab);
		}
	}

	private static void printCurrentTabDetails(WebDriver driver) {

		System.out.println("Active Tab ID: " + driver.getWindowHandle());
		System.out.println("Active Page Title: " + driver.getTitle());

		String message = driver.findElement(By.cssSelector("h2.mt-5")).getText();
		System.out.println("Active Page Message: " + message);
	}
}
