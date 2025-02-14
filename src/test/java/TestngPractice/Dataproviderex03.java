package TestngPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utility.Java_Utility_01;

public class Dataproviderex03 {
	
	@Test(dataProvider = "readdata")
	public void OrganizationModuleTEst(String Orgname, String Phnum,String Email ) throws Throwable
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
	public Object[][] readdata()
	{
		     Java_Utility_01 ran = new Java_Utility_01();
		     int rannum = ran.getrandomnumber();
		     
		     Object[][] objArr = new Object[3][3];
		     objArr[0][0]="AAA"+rannum;
		     objArr[0][1]="98765432";
		     objArr[0][2]="abc@gmail.com"+rannum;
		     
		     objArr[1][0]="BBB"+rannum;
		     objArr[1][1]="987654352"+rannum;
		     objArr[1][2]="abc@gmail.com"+rannum;
		     
		     objArr[2][0]="CCC"+rannum;
		     objArr[2][1]="87654325"+rannum;
		     objArr[2][2]="abc@gmail.com"+rannum;
			return objArr;
	}
	
}



