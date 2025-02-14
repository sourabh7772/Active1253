package Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Object_Repository01.Home_Page;
import Object_Repository01.VtigerLoginPage01;

public class Base_Class01 {
	public WebDriver driver;
	@BeforeSuite(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void BS()
	{
		System.out.println("DataBase open");
	}
	@BeforeTest(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void BT()
	{
		System.out.println("Parellel execution");
	}
	@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void BC(String BROWSER) throws Throwable
	{
		  File_Utility01 fileu = new File_Utility01();
		 // String BROWSER = fileu.getkeyandvaluepair("browser");
		           
                  
          if (BROWSER.equalsIgnoreCase("chrome")) 
          {
				System.out.println("Chrome has been launched");
				driver=new ChromeDriver();
			}
          else if(BROWSER.equalsIgnoreCase("edge"))
          {
              System.out.println("Edge has been launched");
              driver=new EdgeDriver();
			}	
          else
          {
          	System.out.println("Chrome has been launched");
          	driver=new ChromeDriver();
          }	
        	                
       	    	  
		System.out.println("Launching Browser");
	}
	@BeforeMethod(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void BM() throws Throwable
	{
		  WebDriver_Utility01 web = new WebDriver_Utility01();
		  web.Pagetoload(driver);
		  web.WindowMaximize(driver);
          File_Utility01 futi = new File_Utility01();
         String URL = futi.getkeyandvaluepair("url");
         String BROWSER = futi.getkeyandvaluepair("browser");
         String USERNAME = futi.getkeyandvaluepair("username");
        String PASSWORD = futi.getkeyandvaluepair("password");
        driver.get(URL);
        
        VtigerLoginPage01 login = new VtigerLoginPage01(driver);
        login.LoginTOVtiger(USERNAME, PASSWORD);
        
		System.out.println("Login to App");
	}
	@AfterMethod(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void AM()
	{
	     Home_Page home = new Home_Page(driver);
        
         home.Adminlink();
         home.Signout();

		System.out.println("Logout App");
	}
	@AfterClass(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void AC()
	{
	    driver.quit();   
		System.out.println("Close Browser");
	}
	@AfterTest(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void AT()
	{
		System.out.println("Parellel Execution");
	}
	@AfterSuite(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void AS()
	{
		System.out.println("Close Database");
	}

}
