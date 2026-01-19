package appiumProject;

import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

public class loginviapopup {
	  AndroidDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setup() throws Exception {
	    	DesiredCapabilities caps = new DesiredCapabilities();
	    	caps.setCapability("platformName", "Android");
	    	caps.setCapability("appium:automationName", "UiAutomator2");
	    	caps.setCapability("appium:deviceName", "Google Pixel 9");
	    	caps.setCapability("browserName", "Chrome");  

	    	 
	    	caps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", true));
	    	
	    	caps.setCapability("appium:chromedriverExecutable", "C:\\chromedriver\\chromedriver.exe");
	    	
	    	ChromeOptions chromeOptions = new ChromeOptions();
	    	chromeOptions.setExperimentalOption("w3c", true); 
	    	caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	    	
	    	 
	    	caps.setCapability("appium:newCommandTimeout", 300);
	    	caps.setCapability("appium:uiautomator2ServerLaunchTimeout", 60000);
	    	caps.setCapability("appium:noReset", true);

	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }


	    // --- LOGIN FORM TEST CASES ---

	    
	    @Test
	    public void testPopupLoginForm() {
	        // 1. Launch the main page
	        driver.get("https://training-support.net/webelements");
	        ensureWebContext();

	        // 2. Find the Popups card and scroll it into view 
	        WebElement popupsCard = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//a[contains(@href, '/webelements/popups')]")));
	        
	        // Scrolling is necessary on a mobile device to make the element clickable
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", popupsCard);
	        popupsCard.click();

	        // 3. Wait for the Popups page to load
	        wait.until(ExpectedConditions.urlContains("popups"));

	        // 4. Find the button to open the Login Form Popup 
	        WebElement openLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("launcher")));
	        openLoginBtn.click();

	        // 5. Interact with the Popup  
	        WebElement modalUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
	        
	        System.out.println("Login popup opened successfully. Username field detected.");
	        
	         
	        // 2. Locate fields
	        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));

	        // 3. Enter Correct Credentials
	        usernameField.clear();
	        usernameField.sendKeys("admin");
	        passwordField.clear();
	        passwordField.sendKeys("password");
	        submitBtn.click();

	        
	        
	        driver.context("NATIVE_APP");

	        // 2. Define the locator
	        By successMessageLocator = By.xpath("//android.widget.TextView[@text='Login Success!']");

	        // 3. Wait for the element to appear
	        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));

	        // 4. Perform the Assertion
	        String actualText = successMessage.getText();
	        Assert.assertEquals(actualText, "Login Success!", "The login success message was not displayed correctly!");


	        System.out.println("Login with valid credentials verified successfully.");
	        
	        
//	         5. Switch back to Webview if you have more web tests to run
	         driver.context("CHROMIUM");
	        
	         
	    }

	   
	  

	        // Helper method to keep code clean
	        private void ensureWebContext() {
	            for (String context : driver.getContextHandles()) {
	                if (context.contains("WEBVIEW") || context.contains("CHROMIUM")) {
	                    driver.context(context);
	                    break;
	                }
	            }
	        }


	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

}
