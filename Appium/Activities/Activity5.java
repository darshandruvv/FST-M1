package activities;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
public class Activity5 {
	
	AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");

        URL serverURL = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void sendSmsToSelf() {

        String myNumber = "7619140488";  
        String messageText = "Hello";
 
        WebElement newMsgBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.ImageButton | //android.widget.Button")));
        newMsgBtn.click();
 
        WebElement toField = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[contains(@text,'To')] | //android.widget.MultiAutoCompleteTextView")));
        toField.sendKeys(myNumber);
 
        driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(
                io.appium.java_client.android.nativekey.AndroidKey.ENTER));
 
        WebElement messageField = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")));
        messageField.sendKeys(messageText);
 
        WebElement sendBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.google.android.apps.messaging:id/send_message_button_icon")));
        sendBtn.click();
 
        WebElement sentMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='Hello from Appium']")));

        Assert.assertEquals(sentMsg.getText(), messageText, "Message was not sent successfully!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
