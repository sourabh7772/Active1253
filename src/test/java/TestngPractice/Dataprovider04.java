package TestngPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utility.Excel_Utility01;
import Generic_utility.Java_Utility_01;

public class Dataprovider04 {
	@Test(dataProvider = "Dataproviderdata")
	public void OrganizationModule(String Orgname,String  Phnum,String Email ) throws Throwable
	{
		  WebDriver driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           driver.get("http://localhost:8888/");
           driver.manage().window().maximize();
           
           driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
           driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
           driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
           driver.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
           driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
           
           driver.findElement(By.name("accountname")).sendKeys(Orgname);
           driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys(Phnum);
           driver.findElement(By.xpath("//input[@id=\"email1\"]")).sendKeys(Email);
         
           
           driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
           Thread.sleep(2000);
           driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
           driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
           driver.quit();
	}
	
	@DataProvider
	public Object[][]Dataproviderdata() throws Throwable
	{
		
		 Excel_Utility01 elib = new Excel_Utility01();
		 Object[][] value = elib.getDataProviderData("DataProvider");
		                  
		return value ;
	}
}

