package Activities;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.openqa.selenium.By;

public class Activity3 {
	
WebDriver driver; 
	
	@BeforeClass
	
	public void open() {
		
	 driver = new FirefoxDriver();	
	 driver.get("https://training-support.net/webelements/login-form");
	     
	}
	
	@Test
	
	public void test() {
		
		WebElement element1 = driver.findElement(By.id("username"));
		   
		   element1.sendKeys("admin");
		   
		   WebElement element2 = driver.findElement(By.id("password"));
		   
		   element2.sendKeys("password");
		   
		   WebElement element3 = driver.findElement(By.xpath("//button[text()='Submit']"));
		   
		   element3.click();
		   
		   String message = driver.findElement(By.xpath("//h1[contains(text(), 'Success')]")).getText();
		   System.out.println(message);
		   
		   Assert.assertEquals(message, "Login Success!");
	}
	
    @AfterClass
	
	public void close() {
		
		driver.quit();
	}
}
