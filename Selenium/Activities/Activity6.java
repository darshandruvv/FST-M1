package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity6 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://training-support.net/webelements/dynamic-controls");

        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));

        boolean beforeClick = checkbox.isSelected();
        System.out.println("Checkbox selected before click: " + beforeClick);

        checkbox.click();

        boolean afterClick = checkbox.isSelected();
        System.out.println("Checkbox selected after click: " + afterClick);

        driver.quit();
    }
}
