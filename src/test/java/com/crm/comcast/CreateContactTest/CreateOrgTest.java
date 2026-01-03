package com.crm.comcast.CreateContactTest;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.crm.Listners.RetryAnalyzer;
import com.crm.generic.baseUtility.BaseClass;

import GenericUtility.JavaUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.HomePage;

public class CreateOrgTest extends BaseClass{
	//WebDriver driver = null;
	
	@Test
	public void CreateCamp() throws Throwable{
		String camp = excelUtility.readDataFromExcel("Sheet1", 1, 0);
		String tar = excelUtility.readDataFromExcel("Sheet1", 1, 1);
		JavaUtility javaUtility=new JavaUtility();
		String RD = javaUtility.RandomData();
		camp=camp+RD;
		
		//login to app
				HomePage homePage=new HomePage(driver);
				homePage.hmPage();
				
				//navigate to campaign
				CampaignPage campaignPage=new CampaignPage(driver);
				campaignPage.CampPage(camp, tar);
				
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
				if (msg.contains(camp)) {
				    System.out.println("Product " + camp +" is Verified and created");
				} else {
				    System.out.println("Product not verified");
				}
				System.out.println( );
	
//	@Test
//	public void CreateContact() {
//		
//		//System.out.println("Product is updated successfully");
//	}
}
}
