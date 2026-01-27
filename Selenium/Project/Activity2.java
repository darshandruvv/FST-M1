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

public class Activity2 {
	
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
		
		
		
		
		public void hrmImageTest() 
		{
			
			WebElement imp =driver.findElement(By.xpath("//div[@id='divLogo']//img"));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String  imgurl =imp.getAttribute("src");
			System.out.println(imgurl);
			
			Assert.assertTrue(imp.isDisplayed(),"Header is not displayed");
		}
		
		
			
		
	    @AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
		
	}



