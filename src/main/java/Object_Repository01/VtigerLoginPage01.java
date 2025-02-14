package Object_Repository01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage01 {
    
    // Corrected constructor
    public VtigerLoginPage01(WebDriver driver) {
        // Initialize elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    // Locators for the username field, password field, and login button
   @FindBy(name="user_name")
   private WebElement UsernameTextField;
   
   @FindBy(name="user_password")
   private WebElement PasswordTextField;
   
   @FindBy(id="submitButton")
   private WebElement LoginButton;

public WebElement getUsernameTextField() {
	return UsernameTextField;
}

public WebElement getPasswordTextField() {
	return PasswordTextField;
}

public WebElement getLoginButton() {
	return LoginButton;
}
   
   //Business Logic
/**
 * This method is used to login Vtiger.
 * @param username
 * @param password
 * @author HP
 */
public void LoginTOVtiger(String username,String password)

   {
	UsernameTextField.sendKeys(username);
	PasswordTextField.sendKeys(password);
	LoginButton.click();
   }
}
