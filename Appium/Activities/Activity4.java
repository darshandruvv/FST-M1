package activities;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	
	 AndroidDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setup() throws Exception {

	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        options.setAppPackage("com.google.android.contacts");
	        options.setAppActivity("com.android.contacts.activities.PeopleActivity");

	        URL serverURL = new URI("http://localhost:4723").toURL();
	        driver = new AndroidDriver(serverURL, options);

	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }

	 
	    @Test
	    public void contactsTest() {
	 
	        WebElement addButton = wait.until(ExpectedConditions.presenceOfElementLocated(
	                AppiumBy.xpath("//android.widget.ImageButton")
	        ));
	        addButton.click();
	 
	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.xpath("//android.widget.EditText[contains(@text,'First')]")
	        ));
	 
	        driver.findElement(
	                AppiumBy.xpath("//android.widget.EditText[contains(@text,'First')]")
	        ).sendKeys("Aaditya");
	 
	        driver.findElement(
	                AppiumBy.xpath("//android.widget.EditText[contains(@text,'Last')]")
	        ).sendKeys("Varma");
	 
	        driver.findElement(
	                AppiumBy.xpath("//android.widget.EditText[contains(@text,'Phone')]")
	        ).sendKeys("999148292");
	 
	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.xpath("//android.widget.Button[@text='Save'] | //android.widget.ImageButton[@content-desc='Save']")
	        )).click();
	 
	        WebElement contactTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                AppiumBy.id("large_title")
	        ));

	        Assert.assertEquals(contactTitle.getText(), "Aaditya Varma");
	    }


	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }


}
