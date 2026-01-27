package fst_project;
import java.time.Duration;
import java.util.List;

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

public class Activity8 {
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
	public void applyLeave() throws InterruptedException 
	{
		
		WebElement allayleave =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Apply Leave']")));
		//driver.findElement(By.xpath("//span[text()='Apply Leave']")).click();		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", allayleave);
		//allayleave.click();
	    
        
	    Select select = new Select(driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']")));
		select.selectByContainsVisibleText("DayOff");
		
		driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']")).click();		
		
		Select fromMonth = new Select(
		        driver.findElement(By.className("ui-datepicker-month")));
		fromMonth.selectByVisibleText("Jan");

		// Select Year
		Select fromYear = new Select(
		        driver.findElement(By.className("ui-datepicker-year")));
		fromYear.selectByVisibleText("2026");
		
		driver.findElement(By.xpath("//a[text()='19']")).click();
		
		
		
		//WebElement todate=driver.findElement(By.id("applyleave_txtToDate"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
		    "document.getElementById('applyleave_txtToDate').value='2026-01-20';"
		);
		
		Thread.sleep(10000);
		
		// Select Day
		//driver.findElement(By.xpath("//a[text()='12']")).click();
		
		//WebElement applubtn =driver.findElement(By.id("applyBtn"));
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", applubtn);
		
		WebElement applyBtn = wait.until(
			    ExpectedConditions.elementToBeClickable(By.id("applyBtn"))
			);

			// Scroll & click
			((JavascriptExecutor) driver).executeScript(
			    "arguments[0].scrollIntoView(true);", applyBtn
			);
			((JavascriptExecutor) driver).executeScript(
			    "arguments[0].click();", applyBtn
			);
		
		
		
		WebElement myleave=driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myleave);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript(
		    "document.getElementById('calFromDate').value='2026-01-19';"
		);
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript(
		    "document.getElementById('calToDate').value='2026-01-20';"
		);
		
		driver.findElement(By.id("btnSearch")).click();
		
		List<WebElement> rows = driver.findElements(
		        By.xpath("//table[@id='resultTable']/tbody/tr"));
		
		String expectedFrom = "2026-01-26";
		String expectedTo = "2026-01-27";
		boolean found = false;

		for (WebElement row : rows) {

		    String dateText = row.findElement(By.xpath("td[1]")).getText();
		    // Example: "2026-01-26 to 2026-01-27"

		    if (dateText.contains(expectedFrom) && dateText.contains(expectedTo)) {

		        String status = row.findElement(By.xpath("td[6]")).getText();
		        System.out.println("Status found: " + status);

		        Assert.assertTrue(
		                status.contains("Pending"),
		                "Leave status is NOT Pending Approval");

		        found = true;
		        break;
		    }
		}

		Assert.assertTrue(found, "No leave entry found for selected date range");
		
			
		Thread.sleep(15000); 

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
