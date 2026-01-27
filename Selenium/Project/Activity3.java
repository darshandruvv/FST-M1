package fst_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {

	
	 WebDriver driver;
		
		
		@BeforeMethod
		public void setUp() 
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	      //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	      //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        driver.get("http://alchemy.hguy.co/orangehrm");
		}
		
		
		
		public void loginTest() 
		{
			WebElement username =driver.findElement(By.xpath("//input[@id='txtUsername']"));
			username.sendKeys("orange");
			WebElement password =driver.findElement(By.xpath("//input[@id='txtPassword']"));
			password.sendKeys("orangepassword123");
			WebElement loginButton =driver.findElement(By.xpath("//input[@id='btnLogin']"));
			loginButton.click();
			
			String homepage=driver.getTitle();
			System.out.println(homepage);
			
		  WebElement homescreen =driver.findElement(By.xpath("//a[@id='menu_dashboard_index']"));
		  Assert.assertTrue(homescreen.isDisplayed(),"not displayed ");
		  
		}
			
		
	    @AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
}


