package TestngPractice;

import org.testng.annotations.Test;

public class Sampletest1 {
	
	@Test()
	public void createcontact()
	{
		System.out.println("contact created");
	}

	@Test(dependsOnMethods="createcontact")
	public void modifycontact()
	{
		System.out.println("Modify the contsct");
	}

	@Test(dependsOnMethods="createcontact")
	public void deletecontact()
	{
		System.out.println("Delete the contact");
	}

}
