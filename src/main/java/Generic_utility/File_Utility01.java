package Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility01 {
	
	public String getkeyandvaluepair(String key) throws Throwable
	{
		       FileInputStream file = new FileInputStream("./src/test/resources/PropertiesData.properties.txt");
		       Properties pro = new Properties();
		       pro.load(file);
		       String value = pro.getProperty(key);
		       
		       return value;
	}        
 
}
