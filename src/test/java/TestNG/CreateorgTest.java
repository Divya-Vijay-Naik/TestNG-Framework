package TestNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateorgTest {

	@BeforeClass
	public void OpenBrowser() {
		System.out.println("open browser");
	}
	

	@BeforeMethod
	public void Login() {
		System.out.println("Login to application");
	}
	
//	@Test(priority = -1)
//	public void CreateOrg() {
//		System.out.println("Org created ");
//	}
//	@Test(priority = 1)
//	public void CreateOrg1() {
//		System.out.println(" created successfully");
//	}
	@Test
	public void CreateOrg() {
		System.out.println("Org created ");
		String str=null;
		System.out.println(str.equals("123"));
	}
	@Test(dependsOnMethods="CreateOrg")
	public void CreateOrg2() {
		System.out.println("Org created successfully");
	}
	@AfterClass()
	public void CloseBrowser() {
		System.out.println("close browser");
	}
	

	@AfterMethod
	public void Logout() {
		System.out.println("Logout from application");
	}
	
	@BeforeSuite
	public void BS() {
		System.out.println("----------Excetution is started---------------");
	}
	
	@AfterSuite
	public void AS() {
		System.out.println("----------Excetution is Completed---------------");
	}
	
	
}
