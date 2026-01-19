package appiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.TimeoutException;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class VerifyTodoTasks {
	
	AndroidDriver driver;

	WebDriverWait wait;


	    @BeforeClass
	    public void setup() throws MalformedURLException {


	        
	        UiAutomator2Options options = new UiAutomator2Options()
	                .setDeviceName("Android Emulator")
	                .setPlatformName("Android")
	                .setAutomationName("UiAutomator2")
	                .setApp(System.getProperty("user.home") + "/Downloads/ts-todo-list-v1.apk")
	                .setAppPackage("com.app.todolist")
	                .setAppActivity("com.app.todolist.view.SplashActivity");
	 
	        URL appiumServerURL = new URL("http://127.0.0.1:4723");
	        driver = new AndroidDriver(appiumServerURL, options);
	    }
	 


	 
	    private static final By ADD_TASK_BTN = By.id("com.app.todolist:id/fab_new_task");
	    private static final By TITLE_INPUT = By.id("com.app.todolist:id/et_new_task_name") ;
	    private static final By Priority_INPUT = By.id("com.app.todolist:id/tv_new_task_priority") ;
	    private static final By SAVE_BTN = By.id("com.app.todolist:id/bt_new_task_ok");
	    private static final By PRIORITY_FIELD =
	            By.xpath("//android.widget.TextView[@resource-id='com.app.todolist:id/tv_new_task_priority']");
	    private static final By TASK_TITLE_LABEL =
	            By.id("com.app.todolist:id/tv_exlv_task_name");
	     

	    private static final By ALLOW_NOTIFICATION_BTN =
	            By.id("com.android.permissioncontroller:id/permission_allow_button");
	    private static final By SKIP_BTN =
	            By.id("com.app.todolist:id/btn_skip");

	    
	    private static final By FIRST_TASK =
	            By.xpath("(//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_name'])[1]");
	    private static final By Edit_BTN =
	            By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]");
	    
	    private static final By DEADLINE_FIELD =
	            By.id("com.app.todolist:id/tv_todo_list_deadline");

	    private static final By DEADLINE_OK_BTN =   
//	    By.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_new_task_ok\"]") ;
	    		By.id("com.app.todolist:id/bt_deadline_ok");

	    private static final By DEADLINE_LABEL_IN_LIST =
	            By.id("com.app.todolist:id/tv_exlv_task_deadline");

	    private static final By DATE_10 =
	            By.xpath("//android.view.View[@text='10' or @content-desc='10']");

	    
	    private static final By TASK_CHECKBOX =
	            By.id("com.app.todolist:id/cb_task_done");

	    private static final By THIRD_TASK =
	    	    By.xpath("(//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\"])[3]");


	    private static final By PROGRESS_SLIDER =
	            By.id("com.app.todolist:id/sb_new_task_progress");

	    private static final By OPTIONS_BTN =
	            By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");

	    private static final By COMPLETED_TASKS_MENU =
	            By.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/title\" and @text=\"Completed tasks\"]");

	    
	    
	    private void allowNotificationsIfPresent() {
	        try {
	            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement allowBtn = shortWait.until(
	                    ExpectedConditions.presenceOfElementLocated(ALLOW_NOTIFICATION_BTN)
	            );
	            allowBtn.click();
	        } catch (TimeoutException e) {
	         }
	    }

	    
	    private void navigateToMainScreen() {

	    	 try {
	             WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	             WebElement allowBtn = shortWait.until(
	                     ExpectedConditions.presenceOfElementLocated(SKIP_BTN)
	             );
	             allowBtn.click();
	         } catch (TimeoutException e) {
	         }
	    }

	    
	    @Test
	    public void addThreeTasksAndVerify() {

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        allowNotificationsIfPresent();
	        
	        navigateToMainScreen();

	        addTask("Complete Activity 1", "High");
	        addTask("Complete Activity 2", "Medium");
	        addTask("Complete Activity 3", "Low");

	        List<WebElement> tasks = wait.until(
	                ExpectedConditions.presenceOfAllElementsLocatedBy(TASK_TITLE_LABEL)
	        );

	        boolean found1 = false, found2 = false, found3 = false;

	        for (WebElement task : tasks) {
	            String text = task.getText().trim();
	            if (text.equals("Complete Activity 1")) found1 = true;
	           if (text.equals("Complete Activity 2")) found2 = true;
	            if (text.equals("Complete Activity 3")) found3 = true;
	        }

	        Assert.assertTrue(found1, "Task 'Complete Activity 1' was not found");
	        Assert.assertTrue(found2, "Task 'Complete Activity 2' was not found");
	        Assert.assertTrue(found3, "Task 'Complete Activity 3' was not found");
	        

	        System.out.println("All three tasks have been added to the list " );
	        
	        
	        editFirstTaskAndSetDeadline();
	        verifyDeadlineIsSet();
	        
	        
	        markFirstTwoTasksComplete(); 
	        
	        editThirdTaskSetProgress50();

	        openCompletedTasksView(); 
	        
	        verifyOnlyTwoTasksCompleted();
	        
	        
	    }

	    
	    private void addTask(String title, String priority) {
	        wait.until(ExpectedConditions.elementToBeClickable(ADD_TASK_BTN)).click();

	        WebElement titleField = wait.until(ExpectedConditions.presenceOfElementLocated(TITLE_INPUT));
	        titleField.clear();
	        titleField.sendKeys(title);

	        wait.until(ExpectedConditions.elementToBeClickable(PRIORITY_FIELD)).click();

	 
	        By priorityOption = By.xpath("//android.widget.TextView[@text='" + priority + "']");
	        
	 
	         wait.until(ExpectedConditions.elementToBeClickable(priorityOption)).click();

	        wait.until(ExpectedConditions.elementToBeClickable(SAVE_BTN)).click();
	    }

	 

	    private void editFirstTaskAndSetDeadline() {

	        WebElement firstTask = wait.until(ExpectedConditions.presenceOfElementLocated(FIRST_TASK));

	        // Long press to open edit screen
	        new io.appium.java_client.android.AndroidTouchAction(driver)
	        .longPress(io.appium.java_client.touch.offset.ElementOption.element(firstTask))
	        .release()
	        .perform();
	        
	        wait.until(ExpectedConditions.elementToBeClickable(Edit_BTN)).click();

	        // Open deadline picker
	        wait.until(ExpectedConditions.elementToBeClickable(DEADLINE_FIELD)).click();

	        // Select day = 10
	        wait.until(ExpectedConditions.elementToBeClickable(DATE_10)).click();
	        
	        // add date 
	        wait.until(ExpectedConditions.elementToBeClickable(DEADLINE_OK_BTN)).click();

	        // Save edited task
	        wait.until(ExpectedConditions.elementToBeClickable(SAVE_BTN)).click();
	    }

	    
	    
	    
	    private void verifyDeadlineIsSet() {

	        WebElement deadlineLabel = wait.until(
	                ExpectedConditions.presenceOfElementLocated(DEADLINE_LABEL_IN_LIST)
	        );

	        String deadlineText = deadlineLabel.getText().trim();

	        // Assert deadline is not empty
	        Assert.assertFalse(deadlineText.isEmpty(), "Deadline was not set on the task.");

	        // Assert deadline contains expected date parts
	        Assert.assertTrue(
	                deadlineText.contains("10") && (deadlineText.contains("Jan") || deadlineText.contains("01")) && deadlineText.contains("2026"),
	                "Expected deadline to be 10 Jan 2026 but was: " + deadlineText
	        );

	        System.out.println("Deadline successfully set to: " + deadlineText);
	    }


	    
	    private void markFirstTwoTasksComplete() {
	        List<WebElement> checkboxes = wait.until(
	                ExpectedConditions.presenceOfAllElementsLocatedBy(TASK_CHECKBOX)
	        );

	        checkboxes.get(0).click();
	        checkboxes.get(1).click();
	    }

	    
	    private void editThirdTaskSetProgress50() {

	        WebElement thirdTask = wait.until(ExpectedConditions.presenceOfElementLocated(THIRD_TASK));

	        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        new io.appium.java_client.android.AndroidTouchAction(driver)
	                .longPress(io.appium.java_client.touch.offset.ElementOption.element(thirdTask))
	                .release()
	                .perform();

	        wait.until(ExpectedConditions.elementToBeClickable(Edit_BTN)).click();

	        WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(PROGRESS_SLIDER));

	        int startX = slider.getLocation().getX();
	        int width = slider.getSize().getWidth();
	        int y = slider.getLocation().getY() + (slider.getSize().getHeight() / 2);

	        int moveTo = startX + (width / 2);

	        new io.appium.java_client.android.AndroidTouchAction(driver)
	                .press(io.appium.java_client.touch.offset.PointOption.point(startX, y))
	                .moveTo(io.appium.java_client.touch.offset.PointOption.point(moveTo, y))
	                .release()
	                .perform();

	        wait.until(ExpectedConditions.elementToBeClickable(SAVE_BTN)).click();
	    }

	    private void openCompletedTasksView() {
	        wait.until(ExpectedConditions.elementToBeClickable(OPTIONS_BTN)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(COMPLETED_TASKS_MENU)).click();
	    }

	    
	    private void verifyOnlyTwoTasksCompleted() {

	        List<WebElement> completedTasks = wait.until(
	                ExpectedConditions.presenceOfAllElementsLocatedBy(TASK_TITLE_LABEL)
	        );

	        Assert.assertEquals(completedTasks.size(), 2,
	                "Expected exactly 2 completed tasks, but found " + completedTasks.size());

	        System.out.println("Verified: Only 2 completed tasks are shown.");
	    }

		
	    @AfterClass
	    public void tearDown() { 
	        driver.quit();
	    }

}
