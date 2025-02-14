package Object_Repository01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Organization_Page {
	
	public Create_Organization_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
	private WebElement Orglookupimg;
	
	@FindBy(name="accountname")
	private WebElement Orgname;
	
	@FindBy(xpath = "//input[@id=\"phone\"]")
	private WebElement Phhum;
	
	@FindBy(xpath = "//input[@id=\"email1\"]")
	private WebElement Email;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement orgsavebutton;

	
	

	
	public WebElement getOrglookupimg() {
		return Orglookupimg;
	}

	public WebElement getOrgname() {
		return Orgname;
	}

	public WebElement getPhhum() {
		return Phhum;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getOrgsavebutton() {
		return orgsavebutton;
	}
	
	public void Orglookupimg()
	{
		Orglookupimg.click();
	}
	
	public void enterOrgname(String orgname)
	{
		Orgname.sendKeys(orgname);
	}
	
	public void enterPhhum(String Phonenum)
	{
		Phhum.sendKeys(Phonenum);
	}
	
	public void enterEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void orgsavebutton()
	{
		orgsavebutton.click();
	}
	
	
	
}
