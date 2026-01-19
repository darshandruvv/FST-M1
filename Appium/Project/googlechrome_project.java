package appiumProject;

import java.net.URL;
import java.time.Duration;
import java.util.List;

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
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.time.Duration;

public class googlechrome_project {
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

	    @Test
	    public void testTodoListWeb() {
	        driver.get("https://training-support.net/webelements");

	     // Switch to web context
	        for (String context : driver.getContextHandles()) {
	            if (context.contains("WEBVIEW") || context.contains("CHROMIUM")) {
	                driver.context(context);
	                break;
	            }
	        }
	        
	     // Set up Wait
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	     // Locate the To-Do List card (robust locator for web)
//	       
	        WebElement todoCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        	    By.xpath("//a[contains(@href, '/webelements/todo-list')]")));
	        todoCard.click();

	                
	        // Switch to web context
	        for (String context : driver.getContextHandles()) {
	            if (context.contains("WEBVIEW") || context.contains("CHROMIUM")) {
	                driver.context(context);
	                break;
	            }
	        }

	        // Locate input field, add button, and tasks list
	        By INPUT = By.id("todo-input");
	        By ADD_BTN = By.id("todo-add");
	        By TASKS = By.xpath("//ul/li");   
	        By CHECKBOX = By.xpath(".//input[@type='checkbox']");   

	        // Add tasks
	        String[] newTasks = {
	                "Add tasks to list",
	                "Get number of tasks",
	                "Clear the list"
	        };

	        for (String task : newTasks) {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT)).sendKeys(task);
	            driver.findElement(ADD_BTN).click();
	        }

	          //  fetch the list again to ensure we have the newly added elements
	        List<WebElement> allTasks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	                By.xpath("//ul[contains(@class, 'flex-col')]/li")));
	        
	        System.out.println("Total tasks found: " + allTasks.size());
	        
	        for (int i = 2; i < allTasks.size(); i++) {
	            // Find the checkbox inside the specific <li> and click it
	            WebElement checkbox = allTasks.get(i).findElement(CHECKBOX);
	            checkbox.click();
	            
	            // Optional: Print the text of the task being struck out
	            String taskText = allTasks.get(i).findElement(By.tagName("h3")).getText();
	            System.out.println("Struck out task: " + taskText);
	        }

	        // 5. Assertions
	        Assert.assertEquals(allTasks.size(), 5, "The total count of tasks should be 5.");
	        

	        System.out.println("All tasks added, marked, and verified successfully.");
	    }


	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

}
