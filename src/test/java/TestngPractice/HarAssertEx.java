package TestngPractice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HarAssertEx {
	
	@Test
	public void m1()
	{
		 String expdata = "Qspiders";
		 String actdata = "Qspider";
		 Assert.assertEquals(actdata, expdata);
		 System.out.println("Gud Evening");
		
	}
	
	@Test
	public void m2()
	{
		System.out.println("Hello");
	}

}

