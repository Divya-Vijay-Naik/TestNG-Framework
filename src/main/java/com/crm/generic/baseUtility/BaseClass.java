package com.crm.generic.baseUtility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebdriverUtility;
import ObjectRepository.LoginPage;

public class BaseClass {
	public static WebDriver sdriver;
	public FileUtility fileUtility = new FileUtility();
	public ExcelUtility excelUtility = new ExcelUtility();
	public WebdriverUtility utility=new WebdriverUtility();
	public JavaUtility javaUtility=new JavaUtility();

	public WebDriver driver = null;

	@BeforeSuite(groups = {"smoke", "regression"})
	public void BS() {
		System.out.println("----------connect to DB, report config---------------");
	}

	@BeforeClass(groups = {"smoke", "regression"})
	public void OpenBrowser() throws Throwable {
		System.out.println("open browser");
		String Val = fileUtility.toReadDataFromProp("browser");
		if (Val.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
//			driver=new ChromeDriver();

		} else if (Val.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		sdriver=driver;
	}

	@BeforeMethod(groups = {"smoke", "regression"})
	public void Login() throws Throwable {
		System.out.println("Login to application");
		utility.toMaximize(driver);
		String URL = fileUtility.toReadDataFromProp("url");
		driver.get(URL);
		String Name = fileUtility.toReadDataFromProp("username");
		String Pass = fileUtility.toReadDataFromProp("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToNinza(Name, Pass);

	}

	@AfterMethod(groups = {"smoke", "regression"})
	public void Logout() throws InterruptedException {
		System.out.println("Logout from application");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logout(driver);
	}

	@AfterClass(groups = {"smoke", "regression"})
	public void CloseBrowser() {
		System.out.println("close browser");
		driver.quit();
	}

	@AfterSuite(groups = {"smoke", "regression"})
	public void AS() {
		System.out.println("----------close DB, report backup---------------");
	}
}
