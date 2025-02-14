package Object_Repository01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductandvalidate {
	
	       public DeleteProductandvalidate(WebDriver driver)
	       {
	    	   PageFactory.initElements(driver, this);
	       }
	
	      @FindBy(xpath = "//a[text()=\"Products\"]")
	      private WebElement Productlink;
	      
	      @FindBy(xpath = "//input[@class=\"crmbutton small delete\"]")
	      private WebElement DeleteLink;
	      
	      public void clickProductlink()
	      {
	    	  Productlink.click(); 
	      }
	      
	      public void clickondeletelink()
	      {
	    	  DeleteLink.click();
	      }
	      
	      
	      public void Clickprdname(WebDriver driver, String Productname )
	       {
	    	  driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//td//a[text()='"+Productname+"']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
	       }
	      
	      public void Validateproductdeleted(WebDriver driver,String prdName1)
	      {
	    	  List<WebElement> productList = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3][position()>1]"));

              
	             boolean flag=false;
	              
	             for(WebElement product:productList)
	    		 {
	    			String actData = product.getText();
	    			System.out.println(actData);
	    			if(actData.contains((CharSequence) product))
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
	      }

}
