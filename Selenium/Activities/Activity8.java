package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        driver.get("https://training-support.net/webelements/mouse-events");

        System.out.println(driver.getTitle());

        WebElement cargoLock = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("cargo-lock"))
        );

        WebElement cargoToml = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("cargo-toml"))
        );

        actions
                .click(cargoLock)
                .moveToElement(cargoToml)
                .click()
                .perform();

        WebElement confirmation1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("result"))
        );
        System.out.println(confirmation1.getText());

        WebElement src = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("src"))
        );

        WebElement target = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("target"))
        );

        actions
                .doubleClick(src)
                .contextClick(target)
                .perform();

        WebElement openOption = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Open']"))
        );
        openOption.click();

        WebElement confirmation2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("result"))
        );
        System.out.println(confirmation2.getText());

        driver.quit();
    }
}

