package fst_project;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
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
	public void addempqulification() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
		driver.findElement(By.xpath("//ul[@id='sidenav']/li[9]")).click();
		driver.findElement(By.xpath("//input[@id='addWorkExperience']")).click();
		
		WebElement company =driver.findElement(By.xpath("//input[@id='experience_employer']"));
		company.sendKeys("IBM");
		WebElement jobtitle =driver.findElement(By.xpath("//input[@id='experience_jobtitle']"));
		jobtitle.sendKeys("QA Automation");
		WebElement expfromdate =driver.findElement(By.xpath("//input[@id='experience_from_date']"));
		expfromdate.click();
		
		Thread.sleep(15000);
		
		
		Select select = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		select.selectByContainsVisibleText("Oct");
		
		Select select1= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		select1.selectByContainsVisibleText("2021");
		
		driver.findElement(By.xpath("//a[text()='10']")).click();
	
	   Thread.sleep(15000);
		
	   driver.findElement(By.id("experience_to_date")).click();
	   driver.findElement(By.xpath("//a[text()='15']")).click();

	   driver.findElement(By.id("btnWorkExpSave")).click();
		
	   Thread.sleep(15000);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
