package fst_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {

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
	public void retriveallemployee() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
		driver.findElement(By.xpath("//ul[@id='sidenav']/li[3]")).click();
		
		 List<WebElement> rows = driver.findElements(
	                By.xpath("//table[@id='emgcontact_list']/tbody/tr")
	        );

	        System.out.println("----- Emergency Contacts -----");
	        System.out.println("Total Emergency Contacts: " + rows.size());
	        
	        for (WebElement row : rows) {

	            List<WebElement> cells = row.findElements(By.xpath("./td"));

	            String name = cells.get(1).getText();
	            String relationship = cells.get(2).getText();
	            String homePhone = cells.get(3).getText();
	            String mobile = cells.get(4).getText();
	            String workPhone = cells.get(5).getText();

	            System.out.println("Name        : " + name);
	            System.out.println("Relationship: " + relationship);
	            System.out.println("Home Phone  : " + homePhone);
	            System.out.println("Mobile      : " + mobile);
	            System.out.println("Work Phone  : " + workPhone);
	            System.out.println("--------------------------------");
	        }
	        
	      /*  for (int i = 1; i < rows.size(); i++) { // start from 1 to skip header
	            List<WebElement> columns = rows.get(i).findElements(By.xpath(".//div[@role='cell']"));

	            String name = columns.get(1).getText();
	            String relationship = columns.get(2).getText();
	            String homePhone = columns.get(3).getText();
	            String mobile = columns.get(4).getText();
	            String workPhone = columns.get(5).getText();

	            // f. Print to console
	            System.out.println("Name         : " + name);
	            System.out.println("Relationship : " + relationship);
	            System.out.println("Home Phone   : " + homePhone);
	            System.out.println("Mobile       : " + mobile);
	            System.out.println("Work Phone   : " + workPhone);
	            System.out.println("-----------------------------");
	        }*/
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
