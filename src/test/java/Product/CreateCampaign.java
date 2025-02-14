package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {
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
        
        Thread.sleep(2000);
        WebElement txt = driver.findElement(By.xpath("//a[text()=\"More\"]"));
             Actions act = new Actions(driver);
             act.moveToElement(txt).perform();
        driver.findElement(By.xpath("//a[text()=\"Campaigns\"]")).click();
        driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
        

        Random ran = new Random();
        int rannum = ran.nextInt(1000);
        
        FileInputStream fes = new FileInputStream("C:\\Users\\HP\\Desktop\\Nike.xlsx");
		     Workbook book = WorkbookFactory.create(fes);
		     Sheet sheet = book.getSheet("Campaign");
		     
		     Row row = sheet.getRow(0);
		     Cell cell = row.getCell(0);
		     String Campname = cell.getStringCellValue()+rannum;
		     System.out.println(Campname);
       driver.findElement(By.xpath("//input[@name=\"campaignname\"]")).sendKeys(Campname);
       driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
       Thread.sleep(2000);
       
       String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
       if (actData.contains(Campname))
       {
		System.out.println("Campaign is created");
	} 
       else 
       {
         System.out.println("Campaign is not created");
	   }
       
       Thread.sleep(2000);
       
        driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();

	}


	}


