package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        
        driver = new FirefoxDriver();
      
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get("https://training-support.net/webelements/login-form");
    }

    @DataProvider(name = "Credentials")
    public static Object[][] creds() {
        return new Object[][] { 
            { "admin1", "password1", "Invalid Credentials" },
            { "wrongAdmin", "wrongPassword", "Invalid Credentials" }
        };
    }

    @Test(dataProvider = "Credentials")
    public void loginTest(String username, String password, String expectedMessage) {
        
		WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));

        usernameField.clear();
        passwordField.clear();
       
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        String loginMessage = driver.findElement(By.id("subheading")).getText();
        Assert.assertEquals(loginMessage, expectedMessage);
    }

    @AfterClass
    public void tearDown() {
        
        driver.quit();
    }
}