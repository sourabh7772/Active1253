package Generic_utility;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility01 {
	
	public void WindowMaximize(WebDriver driver)
	{
		     driver.manage().window().maximize();        
	}
	
	public void Pagetoload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void MouseMovetoElement(WebDriver driver, WebElement ele)
	{
		          Actions act = new Actions(driver);
		          act.moveToElement(ele).perform();
	}
	
	public void WindowSwitching(WebDriver driver,String partialtext)
	{
		                 Set<String> allwins = driver.getWindowHandles();
		                 Iterator<String> it = allwins.iterator();
		                 while (it.hasNext()) {
							String win = it.next();
							
							driver.switchTo().window(win);
							@Nullable
							String title = driver.getTitle();
							if (title.contains(partialtext))
							{
								break;
							}
							
						}
	}
	
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void DismissAccept(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

}
