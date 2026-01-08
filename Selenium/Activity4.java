package fst_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
	
	WebDriver driver;

	
	String firstname="David";
	String lastname="villa";

	//Activity1 activity;
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
	public void addNewEmployee() throws InterruptedException 
	{
		WebElement username =driver.findElement(By.xpath("//input[@id='txtUsername']"));
		username.sendKeys("orange");
		WebElement password =driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.sendKeys("orangepassword123");
		WebElement loginButton =driver.findElement(By.xpath("//input[@id='btnLogin']"));
		loginButton.click();
		
		//Actions action = new Actions();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		//Thread.sleep(5000);
		
		WebElement empList = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.id("menu_pim_viewEmployeeList")
		        )
		);
		empList.click();
		
		WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAdd")));		
		
		addButton.click();
		
		//driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
		String empId = driver.findElement(By.id("personal_txtEmployeeId"))
                .getAttribute("value");

       System.out.println("Created Employee ID: " + empId);
		
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();		
		
		//WebElement emp = driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']"));
	   //	emp.sendKeys("David villa");
		
		
		//
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement suggestion = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[@class='ac_results']//li")
		        )
		);
		suggestion.click();*/
		
		driver.findElement(By.id("empsearch_id")).clear();
		driver.findElement(By.id("empsearch_id")).sendKeys(empId);

		driver.findElement(By.id("searchBtn")).click();
		
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		
		
		/*WebElement firstNameCell = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//td[@class='left']/a[text()='David']")
		        )
		);*/
		
		//String empName = firstname + " " + lastname;

		//String empXpath = "//a[text()='David']";

		//WebElement result = driver.findElement(By.xpath(empXpath));
		
		//WebElement empresent=driver.findElement(By.xpath("//a[text()='\" + firstname + \" \" + lastname + \"']"));
		
		//Assert.assertTrue(firstNameCell.isDisplayed(), "emp is not added in the list");
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement empRow = wait1.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//a[text()='" + empId + "']")
		        )
		);

		Assert.assertTrue(empRow.isDisplayed(),
		        "Employee not found with ID: " + empId);

		System.out.println("Employee successfully validated with ID: " + empId);
	
		
	}
	
	

      

}




