package Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility01 {
	
	public String getExcelData(String Sheetname,int rownum,int cellnum) throws Throwable
	{
		              FileInputStream file = new FileInputStream("./src/test/resources/Nike.xlsx");
		              Workbook book = WorkbookFactory.create(file);
		              Sheet sheet = book.getSheet(Sheetname);
		              Row row = sheet.getRow(rownum);
		              Cell cell = row.getCell(cellnum);
		              String exceldata = cell.getStringCellValue();
		              return exceldata;
	}
	
	public String getExceldataUsingFormatter(String Sheetname,int rownum,int cellnum) throws Throwable
	
	{
		 FileInputStream file = new FileInputStream("./src/test/resources/Nike.xlsx");
         Workbook book = WorkbookFactory.create(file);
         Sheet sheet = book.getSheet(Sheetname);
         Row row = sheet.getRow(rownum);
         Cell cell = row.getCell(cellnum);
         DataFormatter datafo = new DataFormatter();
         String exceldata = datafo.formatCellValue(cell);
         System.out.println(exceldata);
        
         return exceldata;
	}

	public Object[][] getDataProviderData(String sheetname) throws Throwable
	{
		 FileInputStream file = new FileInputStream("./src/test/resources/Nike.xlsx");
         Workbook book = WorkbookFactory.create(file);
         Sheet sheet = book.getSheet(sheetname);
         int lastrow = sheet.getLastRowNum()+1;
         int lastcell = sheet.getRow(0).getLastCellNum();
         
         Object[][] objarr=new Object[lastrow][lastcell];
         for (int i = 0; i < lastrow ; i++) 
         {
	     for (int j = 0; j < lastcell; j++)
	     {
	    	 objarr[i][j]=sheet.getRow(i).getCell(j).toString();
		}
		}
         
         
		
		return objarr;
		
	}
}
