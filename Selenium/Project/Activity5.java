package fst_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() 
	{
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://alchemy.hguy.co/orangehrm");
	}
     
	@Test
	
	public void editUserInformation() 
	{
		WebElement username =driver.findElement(By.xpath("//input[@id='txtUsername']"));
		username.sendKeys("orange");
		WebElement password =driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.sendKeys("orangepassword123");
		WebElement loginButton =driver.findElement(By.xpath("//input[@id='btnLogin']"));
		loginButton.click();
		
		driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement edit = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.xpath("//input[@value='Edit']")
		        )
		);
		edit.click();
		
		//driver.findElement(By.xpath("//input[@value='Edit']")).click();
		
		WebElement firstname =driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
		firstname.sendKeys("Kavya");
		
		WebElement lastname =driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
		lastname.sendKeys("N N");
		
		WebElement gender =driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		gender.click();		
		
		WebElement dropdwon =driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
		
		Select select = new Select(dropdwon);		
		
		select.selectByVisibleText("Indian");
		
		String selected= select.getFirstSelectedOption().getText();
		
		System.out.println(selected);
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
