import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTestingDemo1 {
	
	
	@Test
	public void DataDriven() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		
		
		// 1. Definisemo file u kome su podaci
		FileInputStream file = new FileInputStream("c:\\Users\\HP\\Desktop\\TestData.xlsx");
		
		// 2. Definisemo workbook
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		// 3. Definisemo sheet koji koristimo 
		XSSFSheet sheet = workbook.getSheet("sheet1");
		
		// 4. Definisemo broj redova
		int rowCount = sheet.getLastRowNum();
		
		// 5. Definisemo broj cell-ova
		int colCount = sheet.getRow(0).getLastCellNum();
		
		// 6. Iscitamo redove i cell-ove tj columns
		for(int i=0; i<rowCount; i++) {
			XSSFRow currentRow = sheet.getRow(i);
			
			for(int j=0; j<colCount; j++) {
				String cellValue = currentRow.getCell(j).toString();
				System.out.print(cellValue +"     ");
			}
			System.out.println();
			workbook.close();
		}
		
		
		
	} 
	
}
