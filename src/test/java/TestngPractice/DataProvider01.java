package TestngPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataProvider01 {
	@Test(dataProvider="dataProviderData")
	public void BookTickets(String src,String dest,int NumOfppl)
	{
		System.out.println("Book Tickets from"+src+"To"+dest+""+NumOfppl);
	}
	
	@DataProvider
	 public Object[][]dataProviderData()
	 
	 {
		  Object[][] bojArr = new Object[2][3];
		  bojArr[0][0]="Banglore";
		  bojArr[0][1]="Goa";
		  bojArr[0][2]=3;
		  // [0]--> Row [1] -->Column = Index starts from 0
		  //0=1 to pehle row ka 1st column
		  //0 ka 2nd column
		  bojArr[1][0]="Hata";
		  bojArr[1][1]="Bhopal";
		  bojArr[1][2]=4;
		  
		  
		  
		return bojArr;}

}
