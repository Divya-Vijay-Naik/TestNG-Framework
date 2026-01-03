package GenericUtility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String readDataFromExcel(String name, int row, int col) throws Throwable {
	FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Divya Naik\\eclipse-workspace\\TestNG\\src\\test\\resources\\Components\\Advanced.xlsx");
	Workbook workbook=WorkbookFactory.create(fileInputStream);
	Sheet sh=workbook.getSheet("Sheet1");
	String val = sh.getRow(row).getCell(col).getStringCellValue();
	workbook.close();
	return val;
	
}
}
