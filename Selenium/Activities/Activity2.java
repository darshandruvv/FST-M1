package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity2 {

    public static void main(String[] args) {

        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://training-support.net/webelements/login-form/");

        String pageTitle = browser.getTitle();
        System.out.println(pageTitle);

        browser.findElement(By.name("username")).sendKeys("admin");
        browser.findElement(By.name("password")).sendKeys("password");

        browser.findElement(By.xpath("//button[text()='Submit']")).click();

        browser.close();
    }
}//button[text()='Submit']
