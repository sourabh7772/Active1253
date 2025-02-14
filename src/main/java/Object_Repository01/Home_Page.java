package Object_Repository01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()=\"Organizations\"]")
	private WebElement OrgLink;
	
	@FindBy(xpath = "//a[text()=\"Products\"]")
	private WebElement ProductLink;
	
	@FindBy(xpath = "//a[text()=\"More\"]")
	private WebElement Morelink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement Adminlink;
	
	@FindBy(xpath = "//a[text()=\"Sign Out\"]")
     private WebElement Signout;
	
	
	
	@FindBy(xpath= "//input[@title=\"Save [Alt+S]\"]")
    private WebElement SaveButton;
	

	
	@FindBy(xpath = "//a[text()=\"Campaigns\"]")
	private WebElement Campaignlink;



	public WebElement getOrgLink() {
		return OrgLink;
	}



	public WebElement getProductLink() {
		return ProductLink;
	}



	public WebElement getMorelink() {
		return Morelink;
	}



	public WebElement getAdminlink() {
		return Adminlink;
	}



	public WebElement getSignout() {
		return Signout;
	}



	public WebElement getSaveButton() {
		return SaveButton;
	}



	public WebElement getCampaignlink() {
		return Campaignlink;
	}
	
	
	//Business Logic
	
	public void OrgLink()
	{
		OrgLink.click();
	}
	
	public void ProductLink()
	{
		ProductLink.click();
	}
	
	public void Campaignlink()
	{
		Campaignlink.click();
	}
	
	public void Morelink()
	{
		Morelink.click();
	}
	
	public void Adminlink()
	{
		Adminlink.click();
	}
	
	public void Signout()
	{
		Signout.click();
	}
	
	
	
	

}
