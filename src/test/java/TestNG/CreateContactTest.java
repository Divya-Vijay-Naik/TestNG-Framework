package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTest {
//DataProvider
	
	@Test(dataProvider = "getData")
	public void createContactTest(String fname, String lname) {
		System.out.println("First name --> "+fname+"  Last name --> "+lname);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] obj=new Object[3][2];
		obj[0][0]="Divya";
		obj[0][1]="Naik";
		
		obj[1][0]="Jhon";
		obj[1][1]="smith";
		
		obj[2][0]="steve";
		obj[2][1]="henry";
		return obj;
		
	}
}
