package activities;


import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.util.Collections;

public class Activity6 {
	
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException { 
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
 
		URL serverURL = new URI("http://localhost:4723").toURL();
 
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 
		driver.get("https://training-support.net/webelements/sliders");
	}

	@Test
	public void volume75Test() { 
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar"))); 
		Dimension dims = driver.manage().window().getSize(); 
		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .77));
		Point end = new Point((int) (dims.getWidth() * .67), (int) (dims.getHeight() * .77)); 
		doSwipe(driver, start, end, 2000);
 
		String volumeText = driver
			.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
			.getText();
 
	 	assertTrue(volumeText.contains("75%"));
	}

	private void doSwipe(AndroidDriver driver2, Point start, Point end, int i) { 
		
	}

	@Test
	public void volume25Test() { 
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar"))); 
		Dimension dims = driver.manage().window().getSize(); 
		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .77));
		Point end = new Point((int) (dims.getWidth() * .33), (int) (dims.getHeight() * .77)); 
		doSwipe(driver, start, end, 2000);
 
		String volumeText = driver
			.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
			.getText();
 
		assertTrue(volumeText.contains("25%"));
	}

	@AfterClass
	public void tearDown() { 
		driver.quit();
	}
}


