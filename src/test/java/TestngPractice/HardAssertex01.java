package TestngPractice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertex01 {
	@Test
	public void m1()
	{
		String expdata = "Qspiders";
		String actdata = "Qspiders";
		Assert.assertEquals(actdata, expdata);
		System.out.println("Good evening");
		
	}
	@Test
	public void m2()
	{
		System.out.println("Hello");
	}

}
