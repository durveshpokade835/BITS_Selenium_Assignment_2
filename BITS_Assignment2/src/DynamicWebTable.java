import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Bits New Trainning Automation\\Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//Accessing the website
		driver.get("https://datatables.net/");
		
		WebElement dynamicTable = driver.findElement(By.id("example"));
		js.executeScript("arguments[0].scrollIntoView();", dynamicTable);
		
		// Specify the table ID and column name/index
        String tableId = "example";
        int columnIndex = 0; // Column index to interact with
        String columnName = "Name"; // Column name for sorting
        String expectedValue = "Airi Satou"; // Value to validate

//         Extract and validate data from the specified column
        TableUtils.extractAndValidate(driver, tableId, columnIndex, expectedValue);

        // Sort and verify the specified column
        TableUtils.sortAndVerify(driver, tableId, columnName, columnIndex);

        // Close the browser
        driver.quit();
		
		
		
		
		
		
		
		
		
		
	}

}
