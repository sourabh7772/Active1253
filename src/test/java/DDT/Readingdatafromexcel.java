package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readingdatafromexcel {

	public static void main(String[] args) throws Throwable {
		                  FileInputStream file = new FileInputStream("./src/test/resources/Nike.xlsx");
		                               Workbook book = WorkbookFactory.create(file);
		                               Sheet sheet = book.getSheet("Sheet1");
		                               Row row = sheet.getRow(1);
		                               Cell cell = row.getCell(0);
		                             //  String exceldata = cell.getStringCellValue();
		                           //  double exceldata = cell.getNumericCellValue();
		                                              DataFormatter format = new DataFormatter();
		                                              String exceldata = format.formatCellValue(cell);
		                               System.out.println(exceldata);
	}

}
