package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/dynamic-controls");

        System.out.println(driver.getTitle());

        WebElement inputBox = driver.findElement(By.id("textInput"));
        System.out.println(inputBox.isEnabled());

        WebElement enableButton = driver.findElement(By.id("textInputButton"));
        enableButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        System.out.println(inputBox.isEnabled());

        driver.quit();
    }
}
