package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity8 {

    private WebDriver browser;
    private WebDriverWait explicitWait;

    @BeforeClass
    public void launchBrowser() {
        browser = new FirefoxDriver();
        explicitWait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.navigate().to("https://training-support.net/webelements/login-form");
    }

    @DataProvider(name = "Credentials")
    public Object[][] getTestData() {
        return new Object[][]{
                {"admin1", "password1", "Invalid Credentials"},
                {"wrongAdmin", "wrongPassword", "Invalid Credentials"}
        };
    }

    @Test(dataProvider = "Credentials")
    public void verifyInvalidLogin(String user, String pass, String expectedText) {

        WebElement userInput = browser.findElement(By.id("username"));
        WebElement passInput = browser.findElement(By.id("password"));
        WebElement submitBtn = browser.findElement(By.xpath("//button[text()='Submit']"));

        userInput.clear();
        passInput.clear();

        userInput.sendKeys(user);
        passInput.sendKeys(pass);
        submitBtn.click();

        String actualText = browser.findElement(By.id("subheading")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @AfterClass
    public void closeBrowser() {
        if (browser != null) {
            browser.quit();
        }
    }
}
