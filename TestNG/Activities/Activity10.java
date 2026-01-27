package Activities;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity10 {

    private WebDriver browser;
    private WebDriverWait wait;

    @BeforeClass
    public void launchSite() {
        browser = new FirefoxDriver();
        wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.navigate().to("https://training-support.net/webelements/simple-form");
    }

    public static List<List<String>> loadExcelData(String path) {
        List<List<String>> sheetData = new ArrayList<>();

        try (FileInputStream input = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(input)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                List<String> rowValues = new ArrayList<>();
                for (Cell cell : row) {
                    rowValues.add(cell.getStringCellValue());
                }
                sheetData.add(rowValues);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sheetData;
    }

    @DataProvider(name = "Events")
    public static Object[][] provideTestData() {
        String excelPath = "C:\\Users\\004PGZ744\\Desktop\\TestData.xlsx";
        List<List<String>> excelData = loadExcelData(excelPath);

        return new Object[][]{
                {excelData.get(1)},
                {excelData.get(2)},
                {excelData.get(3)},
                {excelData.get(4)}
        };
    }

    @Test(dataProvider = "Events")
    public void submitEventForm(List<String> inputData) {

        WebElement nameField = browser.findElement(By.id("full-name"));
        nameField.sendKeys(inputData.get(0));

        browser.findElement(By.id("email")).sendKeys(inputData.get(1));

        browser.findElement(By.name("event-date"))
                .sendKeys(inputData.get(2).replace("\"", ""));

        browser.findElement(By.id("additional-details"))
                .sendKeys(inputData.get(3));

        browser.findElement(By.xpath("//button[text()='Submit']")).click();

        String confirmation = browser.findElement(By.id("action-confirmation")).getText();
        assertEquals(confirmation, "Your event has been scheduled!");

        browser.navigate().refresh();
    }

    @AfterClass
    public void closeSite() {
        if (browser != null) {
            browser.quit();
        }
    }
}
