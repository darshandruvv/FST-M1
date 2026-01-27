package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity5 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/dynamic-controls");

        System.out.println("Page Title: " + driver.getTitle());

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        System.out.println("Checkbox visible before click: " + checkbox.isDisplayed());

        WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(), 'Toggle Checkbox')]"));
        removeButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));

        boolean isCheckboxVisible;
        try {
            isCheckboxVisible = driver.findElement(By.id("checkbox")).isDisplayed();
        } catch (Exception e) {
            isCheckboxVisible = false;
        }

        System.out.println("Checkbox visible after click: " + isCheckboxVisible);

        driver.quit();
    }
}
