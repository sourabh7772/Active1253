package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_utility.Excel_Utility01;
import Generic_utility.File_Utility01;
import Generic_utility.Java_Utility_01;
import Object_Repository01.Home_Page;
import Object_Repository01.Validation_Page;
import Object_Repository01.VtigerLoginPage01;

public class Create_Organization01Test {
	@Test(groups = "SanityTest")
	public void  Create_Organization01Test() throws Throwable {
		
		                    
		  WebDriver driver = new ChromeDriver();
		  
		                   
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           driver.get("http://localhost:8888/");
           driver.manage().window().maximize();
           
           driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
           driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
           driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
                                                 
           
                  Home_Page home = new Home_Page(driver);
                  
                  home.OrgLink();
           
         //  driver.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
           driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
           
      
          Java_Utility_01 juti = new Java_Utility_01();
          int rannum = juti.getrandomnumber();
          
           Excel_Utility01 exut = new Excel_Utility01();
           String Orgname = exut.getExcelData("Organization", 0, 0)+rannum;
                                      
               System.out.println(Orgname);
          
          driver.findElement(By.name("accountname")).sendKeys(Orgname);
          
          String Phnum = exut.getExceldataUsingFormatter("Organization", 1, 0)+rannum;    
      
          System.out.println(Phnum);
          driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys(Phnum);
          
          String Email = exut.getExcelData("Organization", 2,0)+rannum;
                   /*Row row2 = sheet.getRow(2);
                   Cell cell2 = row2.getCell(0);
                   String Email = cell2.getStringCellValue()+rannum;*/
                   System.out.println(Email);
                   
                   driver.findElement(By.xpath("//input[@id=\"email1\"]")).sendKeys(Email);
                   JavascriptExecutor js = (JavascriptExecutor)driver;
                   js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
                   
                   driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
             
                              Validation_Page vali = new Validation_Page(driver);
                              vali.Validation_Orgpage(driver, Orgname);
               /*    String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
                   
                   if (actdata.contains(Orgname))
                   {
						System.out.println("Organization name is created");
					  }
                   else 
                   {
                    System.out.println("Organization name is not created");
					}*/
                   
                 
                   
                   driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
                   driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
           
           driver.quit();

}
	}


