package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import Generic_utility.Excel_Utility01;
import Generic_utility.File_Utility01;

import Generic_utility.Java_Utility_01;
import Generic_utility.Scroll_Utility;
import Object_Repository01.DeleteProductandvalidate;
import Object_Repository01.Home_Page;
import Object_Repository01.Validation_Page;

public class CreateproductanddeleteproductTest {
	@Test(groups = "SmokeTest")
	public void CreateproductanddeleteproductTest() throws Throwable {
		                      Java_Utility_01 javau = new Java_Utility_01();
		                      File_Utility01 fiuti = new File_Utility01();
		                      Excel_Utility01 exuti = new Excel_Utility01();
		                    Scroll_Utility sc = new Scroll_Utility();
		                  
		   WebDriver driver=new ChromeDriver();
		      
	        
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	       String URL = fiuti.getkeyandvaluepair("url");
	       String BROWSER = fiuti.getkeyandvaluepair("browser");
	       String USERNAME = fiuti.getkeyandvaluepair("username");
	       String PASSWORD = fiuti.getkeyandvaluepair("password");
	/* FileInputStream file = new FileInputStream("./src/test/resources/PropertiesData.properties.txt");
         Properties pro = new Properties();
         pro.load(file);
         
         String URL = pro.getProperty("url");
         String BROWSER = pro.getProperty("browser");
         String USERNAME = pro.getProperty("username");
         String PASSWORD = pro.getProperty("password");*/
                    
     
        driver.get(URL);
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
                
        
        driver.findElement(By.xpath("//a[text()=\"Products\"]")).click();
        driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
        
                      //   Random ran = new Random();
                       //int rannum = ran.nextInt(1000);
        int rannum = javau.getrandomnumber();
       String Productname = exuti.getExcelData("Product", 0, 0)+rannum;
     /* FileInputStream file1 = new FileInputStream("./src/test/resources/Nike.xlsx");
      Workbook book = WorkbookFactory.create(file1);
      Sheet sheet = book.getSheet("Product");
     Row row = sheet.getRow(0);
     Cell cell = row.getCell(0);
     String Productname = cell.getStringCellValue()+rannum;*/
                       
                       System.out.println(Productname);
     
                      sc.ScrollToUp(driver);
                           
             //  JavascriptExecutor js = (JavascriptExecutor)driver;
             //  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
               
               driver.findElement(By.xpath("//input[@name=\"productname\"]")).sendKeys(Productname);
               
               driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
               
               
                            Validation_Page vali = new Validation_Page(driver);
                            vali.Validation_ProductPage(driver, Productname);
               
            /*   String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
               
               if (actdata.contains(Productname))
               {
					System.out.println("Productname is created");
				  }
               else 
               {
                System.out.println("Productname is not created");
				}
				*/
                            
                            DeleteProductandvalidate delprd = new DeleteProductandvalidate(driver);
                            delprd.clickProductlink();
                            delprd.Clickprdname(driver, Productname);
             //  driver.findElement(By.xpath("//a[text()=\"Products\"]")).click();
                            delprd.clickondeletelink();
             //  driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//td//a[text()='"+Productname+"']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
               
            //  driver.findElement(By.xpath("//input[@class=\"crmbutton small delete\"]")).click();
              
              driver.switchTo().alert().accept();
              delprd.Validateproductdeleted(driver, Productname);
         /*   List<WebElement> productList = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3][position()>1]"));

               
             boolean flag=false;
              
             for(WebElement prdName1:productList)
    		 {
    			String actData = prdName1.getText();
    			System.out.println(actData);
    			if(actData.contains((CharSequence) prdName1))
    			{
    				flag=true;
    				break;
    			}
    		 }
    		 System.out.println(flag);
    		if(flag)
    		{
    			System.out.println("product data is deleted");
    		}else {
    			System.out.println("product data is not deleted");
    		}
             */
              Home_Page home = new Home_Page(driver);
              home.Adminlink();
              home.Signout();
	}
	

}
