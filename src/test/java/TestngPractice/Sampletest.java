package TestngPractice;

import org.testng.annotations.Test;

public class Sampletest {

	@Test(invocationCount = 2)
	public void createcontact()
	{
		System.out.println("Contact Created");
	}
	@Test(invocationCount = 3)
	public void Modifycontact()
	{
		System.out.println("Modify Contact");
	}
	@Test(invocationCount = 2)
	public void Deletecontact()
	{
		System.out.println("Delete Contact");
	}
	
	
	
}
