package Generic_utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scroll_Utility {
	/**
	 * This method is used to Scrollup the page.
	 * @param driver
	 */
	
	public static void ScrollToUp(WebDriver driver)
	{
		  JavascriptExecutor js = (JavascriptExecutor)driver;
          js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void ScrollToDown(WebDriver driver)
	{
		  JavascriptExecutor js = (JavascriptExecutor)driver;
          js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

}
