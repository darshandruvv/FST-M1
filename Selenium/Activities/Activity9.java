package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {

    public static void main(String[] args) {

        WebDriver browser = new FirefoxDriver();
        Actions keyboard = new Actions(browser);

        openApplication(browser);

        typeMessage(browser, keyboard);

        shutdown(browser);
    }

    private static void openApplication(WebDriver browser) {
        browser.get("https://training-support.net/webelements/keyboard-events");
        System.out.println("Current Page: " + browser.getTitle());
    }

    private static void typeMessage(WebDriver browser, Actions keyboard) {

        String message = "This is coming from Selenium";

        keyboard.sendKeys(message)
                .sendKeys(Keys.ENTER)
                .perform();

        displayResult(browser);
    }

    private static void displayResult(WebDriver browser) {
        String output = browser.findElement(By.cssSelector("h1.mt-3")).getText();
        System.out.println("Screen Message: " + output);
    }

    private static void shutdown(WebDriver browser) {
        browser.quit();
        System.out.println("Test execution completed.");
    }
}
