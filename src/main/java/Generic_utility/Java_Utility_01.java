package Generic_utility;

import java.util.Random;

public class Java_Utility_01 {
	
	/**
	 * This method is used to avoid duplicates
	 * @author HP
	 */

	public int getrandomnumber()
	{
		      Random ran = new Random();
		      int rannum = ran.nextInt(1000);
		      return rannum;
			
	}
}
