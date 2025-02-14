package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_utility.Base_Class01;
import Generic_utility.Excel_Utility01;
import Generic_utility.Java_Utility_01;
import Generic_utility.Scroll_Utility;
import Object_Repository01.Create_Product_Page;
import Object_Repository01.Home_Page;
import Object_Repository01.Validation_Page;
import Object_Repository01.VtigerLoginPage01;

public class Create_Product01Test extends Base_Class01{
@Test(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void Create_Product01Test() throws Throwable {
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.get("http://localhost:8888/");
         driver.manage().window().maximize();
         
         driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
         driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
         driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
         
                                  Home_Page home = new Home_Page(driver);
                                  home.ProductLink();
        // driver.findElement(By.xpath("//a[text()=\"Products\"]")).click();
                                  
                               Create_Product_Page pro = new Create_Product_Page(driver);
                               pro.createProductLink();
       //  driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
                               
                                  Java_Utility_01 juti = new Java_Utility_01();
                               int rannum = juti.getrandomnumber();
         
                      //   Random ran = new Random();
                      //    int rannum = ran.nextInt(1000);
         
            
                            Excel_Utility01 exuti = new Excel_Utility01();
                            String Productname = exuti.getExcelData("Product", 0, 0)+rannum;
     /*  FileInputStream file = new FileInputStream("./src/test/resources/Nike.xlsx");
       Workbook book = WorkbookFactory.create(file);
       Sheet sheet = book.getSheet("Product");
      Row row = sheet.getRow(0);
      Cell cell = row.getCell(0);
      String Productname = cell.getStringCellValue()+rannum;*/
             
                
                      Scroll_Utility sc = new Scroll_Utility();
                      sc.ScrollToUp(driver);
      
              //  JavascriptExecutor js = (JavascriptExecutor)driver;
               // js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
                
                pro.productName(Productname);   
                
               // driver.findElement(By.xpath("//input[@name=\"productname\"]")).sendKeys(Productname);
                
                pro.productSaveButton();
             //   driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
                
          
                Validation_Page valid = new Validation_Page(driver);
                valid.Validation_ProductPage(driver, Productname);
           
                /*  String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
                
                if (actdata.contains(Productname))
                {
						System.out.println("Productname is created");
			    }
                else 
                {
                 System.out.println("Productname is not created");
				}
				*/
                
              
                 home.Adminlink();
                 home.Signout();
               // driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
               // driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
        
      
      
        


	}

}
