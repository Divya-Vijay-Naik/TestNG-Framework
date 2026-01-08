package com.crm.comcast.CreateProductTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.crm.Listners.RetryAnalyzer;
import com.crm.generic.baseUtility.BaseClass;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebdriverUtility;
import ObjectRepository.HomePage;
import ObjectRepository.ProductPage;

public class CreateProductPage extends BaseClass {
	

	//@Test(retryAnalyzer = RetryAnalyzer.class)
	@Test
	public void addPrd() throws Throwable {
		//System.out.println("Org created");
		String quantity = excelUtility.readDataFromExcel("Sheet1", 4, 0);
		String prdName = excelUtility.readDataFromExcel("Sheet1", 4, 2);
		String price = excelUtility.readDataFromExcel("Sheet1", 4, 3);
		WebdriverUtility utility = new WebdriverUtility();
		JavaUtility javaUtility=new JavaUtility();
		String RD = javaUtility.RandomData();
		prdName=prdName+RD;
		//login to app
		HomePage homePage=new HomePage(driver);
		homePage.hmPage();
		
		ProductPage page=new ProductPage(driver);
		page.PrdPage(utility, quantity, prdName, price);
		
		//verify
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for toast to appear
		WebElement toastmsg = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']"))
		);

		// Get text using textContent
		String msg = toastmsg.getAttribute("textContent").trim();
		System.out.println( );
		System.out.println("Toast message: " + msg);
		System.out.println( );

		// Verification
		if (msg.contains(prdName)) {
		    System.out.println("Product " + prdName +" is Verified and created");
		} else {
		    System.out.println("Product not verified");
		}
		System.out.println( );
		
	}
	
	@Test
	public void createOrg1() {
		System.out.println("Org created successfully");
	}
}
