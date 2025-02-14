package CreateCampaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utility.Base_Class;
import Generic_utility.Base_Class01;

import Generic_utility.Excel_Utility;
import Generic_utility.File_utility;
import Generic_utility.Java_Utility;
import Generic_utility.WebDriver_Utility;

public class Create_CampaignTest extends Base_Class01 {

	@Test
	public void Create_CampaignTest() throws Throwable {
		               
		               
		 WebDriver driver = new ChromeDriver();
		
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
          
                               
                                  
		                 
                   FileInputStream file = new FileInputStream("./src/test/resources/PropertiesData.properties.txt");
                            Properties pro = new Properties();
                            pro.load(file);
                            
                            String BROWSER = pro.getProperty("browser");
                            String URL = pro.getProperty("url");
                            String USERNAME = pro.getProperty("username");
                            String PASSWORD = pro.getProperty("password");
                            
                            driver.get(URL);
                            
                            driver.findElement(By.name("user_name")).sendKeys(USERNAME);
                            driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
                            driver.findElement(By.id("submitButton")).click();
                            
                            WebElement txt = driver.findElement(By.xpath("//a[text()=\"More\"]"));
                                  
                               Actions act = new Actions(driver);
                                act.moveToElement(txt).perform();
                      
                                 driver.findElement(By.xpath("//a[text()=\"Campaigns\"]")).click();
                                 driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
                                 
                                 
                                 Random ran = new Random();
                                int rannum = ran.nextInt();
                                 
                                
                                 
                                   FileInputStream fol = new FileInputStream("./src/test/resources/Nike.xlsx");
                                          Workbook book = WorkbookFactory.create(fol);
                                          Sheet sheet = book.getSheet("Campaign");
                                         Row row = sheet.getRow(0);
                                        Cell cell = row.getCell(0);
                                        String Campname = cell.getStringCellValue();
                                 
                                                 
                                 
                                 driver.findElement(By.xpath("//input[@name=\"campaignname\"]")).sendKeys(Campname);
                                 
                                 JavascriptExecutor js = (JavascriptExecutor)driver;
                                 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
                                 
                                 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
                                 
                                 String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
                                
                           
                                
                                
                                if (actdata.contains(Campname)) 
                                 {
									System.out.println("Camp name is created");
								}
                                 else 
                                 {
                                      System.out.println("Camp name is not created");
								}
                                 
                                driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
                                driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();

                              
                            driver.quit();   
                            
                            
                            
	}

}
