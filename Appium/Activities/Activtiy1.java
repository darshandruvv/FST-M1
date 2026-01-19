package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activtiy1 {
	
	AppiumDriver driver;
	WebDriverWait wait;
   
	//set the capabilities 
	@BeforeMethod
	public void setup() throws MalformedURLException, URISyntaxException 
	{
		UiAutomator2Options cap = new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("UiAutomator2");
		cap.setApp("src/test/resources/Calculator.apk");
		
		//set up the appium server
		URL serverurl = new URI("http://localhost:4723").toURL();
		
		//Intializie the Android driver 
		
		driver = new AndroidDriver(serverurl,cap);		
	}
   @Test
  public void method() {
	   
	   driver.findElement(AppiumBy.accessibilityId("9")).click();
	   driver.findElement(AppiumBy.accessibilityId("multiply")).click();
	   driver.findElement(AppiumBy.id("digit_5")).click();
	   driver.findElement(AppiumBy.accessibilityId("equals")).click();
	   WebElement result=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]"));
	   
	   System.out.println(result.getText());
	   
	   Assert.assertEquals(result,"45");
			
		}
   
   
    @AfterMethod
	public void tearDown() {
			driver.quit();	
		}	

}
