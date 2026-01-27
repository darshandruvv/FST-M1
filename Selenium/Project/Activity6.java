package fst_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void setUp() 
	{
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://alchemy.hguy.co/orangehrm");
        
        WebElement username =driver.findElement(By.xpath("//input[@id='txtUsername']"));
		username.sendKeys("orange");
		WebElement password =driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.sendKeys("orangepassword123");
		WebElement loginButton =driver.findElement(By.xpath("//input[@id='btnLogin']"));
		loginButton.click();
	}
	
	
    @Test
    public void  verifyDirectoryMenu() throws InterruptedException 
    {
       //WebElement directory =driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']"));
   
      WebElement directory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_directory_viewDirectory']")));
       
       Assert.assertTrue(directory.isDisplayed(),"not displayed");
       
       
       //Assert.assertTrue(directory.isEnabled(),"not clickable");
       
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", directory);
       
       Thread.sleep(3000);
      
     /*  WebElement directory1 = wait.until(
               ExpectedConditions.elementToBeClickable(
                       By.xpath("//a[@id='menu_directory_viewDirectory']")
               )
       );
       
       directory1.click();*/
       
        WebElement searchdirectory =wait.until(
       		 ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Search Directory']")));
         
         
         System.out.println(searchdirectory.getText());
         
        Assert.assertTrue(searchdirectory.getText().contains("Search Directory"),"not matched"); 
    }
	
    @AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
