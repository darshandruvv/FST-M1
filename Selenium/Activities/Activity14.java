package Activities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {

	public static void main(String[] args) {

		WebDriver browser = new FirefoxDriver();

		openSite(browser);

		reviewTableStructure(browser);

		verifySortingImpact(browser);

		closeSession(browser);
	}

	private static void openSite(WebDriver browser) {
		browser.get("https://training-support.net/webelements/tables");
		System.out.println("Loaded Page: " + browser.getTitle());
	}

	private static void reviewTableStructure(WebDriver browser) {

		int totalColumns = browser.findElements(By.xpath("//table[contains(@class,'table-auto')]//thead//th")).size();

		int totalRows = browser.findElements(By.xpath("//table[contains(@class,'table-auto')]//tbody//tr")).size();

		System.out.println("Detected Columns: " + totalColumns);
		System.out.println("Detected Rows: " + totalRows);
	}

	private static void verifySortingImpact(WebDriver browser) {

		String bookBefore = getBookNameAtRow(browser, 5);
		System.out.println("Book before sorting: " + bookBefore);

		sortByPrice(browser);

		String bookAfter = getBookNameAtRow(browser, 5);
		System.out.println("Book after sorting: " + bookAfter);
	}

	private static String getBookNameAtRow(WebDriver browser, int rowNumber) {

		WebElement bookCell = browser
				.findElement(By.xpath("//table[contains(@class,'table-auto')]//tbody//tr[" + rowNumber + "]//td[2]"));

		return bookCell.getText();
	}

	private static void sortByPrice(WebDriver browser) {

		WebElement priceHeader = browser.findElement(By.xpath("//table[contains(@class,'table-auto')]//thead//th[5]"));

		priceHeader.click();
	}

	private static void closeSession(WebDriver browser) {
		browser.quit();
		System.out.println("Browser closed successfully.");
	}
}
