package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			openApplication(driver);
			performLogin(driver, wait);
			verifyLoginMessage(driver);
		} finally {
			driver.quit();
			System.out.println("Browser session ended.");
		}
	}

	private static void openApplication(WebDriver driver) {
		driver.get("https://training-support.net/webelements/popups");
		System.out.println("Loaded Page: " + driver.getTitle());
	}

	private static void performLogin(WebDriver driver, WebDriverWait wait) {

		driver.findElement(By.id("launcher")).click();

		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

		WebElement passwordField = driver.findElement(By.id("password"));

		usernameField.clear();
		usernameField.sendKeys("admin");

		passwordField.clear();
		passwordField.sendKeys("password");

		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	}

	private static void verifyLoginMessage(WebDriver driver) {

		WebElement statusMessage = driver.findElement(By.cssSelector("h2.text-center"));

		System.out.println("Login Status: " + statusMessage.getText());
	}
}
