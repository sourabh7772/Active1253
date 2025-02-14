package Object_Repository01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Validation_Page {
	
	public Validation_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Validation_CampPage(WebDriver driver,String Campname)
	{
		  String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
          
          
          
          
          if (actdata.contains(Campname)) 
           {
				System.out.println("Camp name is created");
			}
           else 
           {
                System.out.println("Camp name is not created");
			}
           
	}
	
	public void Validation_Orgpage(WebDriver driver,String Orgname)
	{
		  String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
          
          if (actdata.contains(Orgname))
          {
				System.out.println("Organization name is created");
			  }
          else 
          {
           System.out.println("Organization name is not created");
			}
          
	}
	
	public void Validation_ProductPage(WebDriver driver,String Productname)
	{
		 String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
         
         if (actdata.contains(Productname))
         {
					System.out.println("Productname is created");
		    }
         else 
         {
          System.out.println("Productname is not created");
			}
	}

}
