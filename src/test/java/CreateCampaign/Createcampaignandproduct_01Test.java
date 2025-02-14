package CreateCampaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_utility.Base_Class01;


public class Createcampaignandproduct_01Test extends Base_Class01 {

	@Test(groups = "SmokeTest")
	public void Createcampaignandproduct_01Test() throws Throwable {
		                      
		                       
		
	FileInputStream file = new FileInputStream("./src/test/resources/PropertiesData.properties.txt");
        Properties pro = new Properties();
        pro.load(file);
        
        String URL = pro.getProperty("url");
        String BROWSER = pro.getProperty("browser");
        String USERNAME = pro.getProperty("username");
        String PASSWORD = pro.getProperty("password");
       
     
       WebDriver driver=new ChromeDriver();
     
       driver.get(URL);
       driver.findElement(By.name("user_name")).sendKeys(USERNAME);
       driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
       driver.findElement(By.id("submitButton")).click();
       
       driver.findElement(By.linkText("Products")).click();
       driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
       

      Random ran = new Random();
       int rannum = ran.nextInt(1000);
       
             
      FileInputStream fes = new FileInputStream("C:\\Users\\HP\\Desktop\\Nike.xlsx");
		     Workbook book = WorkbookFactory.create(fes);
		     Sheet sheet = book.getSheet("Product");
		     
		     Row row = sheet.getRow(0);
		     Cell cell = row.getCell(0);
		     String PrdNAME = cell.getStringCellValue()+rannum;
               
                        
		     System.out.println(PrdNAME);
      driver.findElement(By.name("productname")).sendKeys(PrdNAME);
      driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
      WebElement txt = driver.findElement(By.xpath("//a[text()=\"More\"]"));
                           
     Actions act = new Actions(driver);
     act.moveToElement(txt).perform();
      
      driver.findElement(By.xpath("//a[text()=\"Campaigns\"]")).click();
      driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
        
	
 FileInputStream fes1 = new FileInputStream("C:\\Users\\HP\\Desktop\\Nike.xlsx");
   Workbook book1 = WorkbookFactory.create(fes1);
   Sheet sheet1 = book.getSheet("Campaign");
   
   Row row1 = sheet.getRow(0);
   Cell cell1 = row.getCell(0);
   String Campname = cell.getStringCellValue()+rannum;
              
   System.out.println(Campname);
 driver.findElement(By.xpath("//input[@name=\"campaignname\"]")).sendKeys(Campname);
 driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
 
             
                          
          Set<String> allwins = driver.getWindowHandles();
          
          Iterator<String> it = allwins.iterator();
          while (it.hasNext())
          {
			String win1 = it.next();
			
			driver.switchTo().window(win1);
			@Nullable
			String title = driver.getTitle();
			if (title.contains("Products&action"))
			{
				break;
			}
			
				
		  }
 
         
         
          driver.findElement(By.name("search_text")).sendKeys(PrdNAME);
          driver.findElement(By.name("search")).click();
          
          //Dynamic xpath
                           
          driver.findElement(By.xpath("//a[text()='" + PrdNAME + "']")).click();
          
           Set<String> allwin1 = driver.getWindowHandles();
           Iterator<String> it1 = allwin1.iterator();
           while (it1.hasNext())
           {
			String win2 = it1.next();
			driver.switchTo().window(win2);
			@Nullable
			String title1 = driver.getTitle();
			if (title1.contains("Campaigns&action"))
			{
				break;
			}
			
		}
           driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			  
			  Thread.sleep(2000);
		       
		        driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		        driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
           

     
	}
	}
