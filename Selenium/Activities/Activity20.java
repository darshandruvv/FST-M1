package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {

    public static void main(String[] args) {

        WebDriver browser = new FirefoxDriver();

        openPage(browser);

        processPromptAlert(browser);

        closeSession(browser);
    }

    private static void openPage(WebDriver browser) {
        browser.get("https://training-support.net/webelements/alerts");
        System.out.println("Loaded Page: " + browser.getTitle());
    }

    private static void processPromptAlert(WebDriver browser) {

        browser.findElement(By.id("prompt")).click();

        Alert promptBox = browser.switchTo().alert();

        System.out.println("Prompt says: " + promptBox.getText());

        promptBox.sendKeys("Awesome!");

        promptBox.accept();

        String output = browser.findElement(By.id("result")).getText();
        System.out.println("Application output: " + output);
    }

    private static void closeSession(WebDriver browser) {
        browser.quit();
        System.out.println("Browser session closed.");
    }
}
