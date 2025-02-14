package Object_Repository01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Product_Page {
	
	public Create_Product_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createProductLink;
	
	@FindBy(xpath = "//input[@name=\"productname\"]")
	private WebElement productName;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement productSaveButton;

	public WebElement getCreateProductLink() {
		return createProductLink;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductSaveButton() {
		return productSaveButton;
	}
	
	public void createProductLink()
	{
		createProductLink.click();
	}

	public void productName(String prdname)
	{
		productName.sendKeys(prdname);
	}
	
	public void productSaveButton()
	{
		productSaveButton.click();
	}
	
}
