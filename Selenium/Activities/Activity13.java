package Activities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {

	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();

		openApplication(browser);

		analyzeTable(browser);

		closeBrowser(browser);
	}

	private static void openApplication(WebDriver browser) {
		browser.get("https://training-support.net/webelements/tables");
		System.out.println("Application Title: " + browser.getTitle());
	}

	private static void analyzeTable(WebDriver browser) {

		int columnCount = getColumnCount(browser);
		int rowCount = getRowCount(browser);

		System.out.println("Total Columns: " + columnCount);
		System.out.println("Total Rows: " + rowCount);

		printSpecificRow(browser, 3);

		printSpecificCell(browser, 2, 2);
	}

	private static int getColumnCount(WebDriver browser) {
		List<WebElement> headers = browser.findElements(By.xpath("//table[contains(@class,'table-auto')]//thead//th"));
		return headers.size();
	}

	private static int getRowCount(WebDriver browser) {
		List<WebElement> tableRows = browser
				.findElements(By.xpath("//table[contains(@class,'table-auto')]//tbody//tr"));
		return tableRows.size();
	}

	private static void printSpecificRow(WebDriver browser, int rowNumber) {

		List<WebElement> rowData = browser
				.findElements(By.xpath("//table[contains(@class,'table-auto')]//tbody//tr[" + rowNumber + "]//td"));

		System.out.println("Values from row " + rowNumber + ":");

		for (WebElement data : rowData) {
			System.out.println(" - " + data.getText());
		}
	}

	private static void printSpecificCell(WebDriver browser, int row, int column) {

		WebElement targetCell = browser.findElement(
				By.xpath("//table[contains(@class,'table-auto')]//tbody//tr[" + row + "]//td[" + column + "]"));

		System.out.println("Value at Row " + row + ", Column " + column + ": " + targetCell.getText());
	}

	private static void closeBrowser(WebDriver browser) {
		browser.quit();
		System.out.println("Browser session ended.");
	}
}
