package Object_Repository01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Campaign_Page {
	
	public Create_Campaign_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
  @FindBy(xpath = "//img[@alt=\"Create Campaign...\"]")
  private WebElement Lookupimg;
  
  @FindBy(xpath = "//input[@name=\"campaignname\"]")
  private WebElement CamapignName;
  
  @FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
  private WebElement SaveButton;

public WebElement getLookupimg() {
	return Lookupimg;
}

public WebElement getCamapignName() {
	return CamapignName;
}

public WebElement getSaveButton() {
	return SaveButton;
}
  
public void  Lookupimg()
{
	Lookupimg.click();
}

public void enterCampname(String name)
{
	CamapignName.sendKeys(name);
}

public void Savebutton()
{
	SaveButton.click();
}
}
