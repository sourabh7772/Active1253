package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Insertdatatotheexcelsheet {

	public static void main(String[] args) throws Throwable {
		                    FileInputStream file = new FileInputStream("./src/test/resources/Nike.xlsx");
		                                      Workbook book = WorkbookFactory.create(file);
		                                      Sheet sheet = book.getSheet("Sheet1");
		                                      Row row = sheet.createRow(2);
		                                      Cell cell = row.createCell(0);
		                                      cell.setCellValue("Sourabh");
		                          FileOutputStream fos = new FileOutputStream("./src/test/resources/Nike.xlsx");
		                          book.write(fos);
		                          book.close();
	}  

}
