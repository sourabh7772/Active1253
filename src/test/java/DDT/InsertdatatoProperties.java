package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InsertdatatoProperties {
//Automation Engineer
	public static void main(String[] args) throws Throwable {
	                    Properties pro1 = new Properties();
	                    pro1.setProperty("browser", "chrome");
	                    pro1.setProperty("url", "https\\://www.saucedemo.com/v1/");
	                    pro1.setProperty("username", "standard_user");
	                    pro1.setProperty("password", "secret_sauce");
	                    
	                    
	                    FileInputStream file = new FileInputStream("./src/test/resources/browser chrome.properties.txt");
                        Properties pro = new Properties();
                        pro.load(file);
                        
                        String BROWSER = pro.getProperty("browser");
                        String URL= pro.getProperty("url");
                        String USERNAME = pro.getProperty("username");
                        String PASSWORD = pro.getProperty("password");
                        
                        WebDriver driver; 
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
                        	
                        driver.get(URL);
                        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys(USERNAME);
                        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(PASSWORD);
                        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
                        

	}

}
