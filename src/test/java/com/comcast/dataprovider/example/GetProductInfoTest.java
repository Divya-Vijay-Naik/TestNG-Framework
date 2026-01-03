package com.comcast.dataprovider.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetProductInfoTest {

	@Test
	public void getProduct() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://amazon.in/");
		driver.manage().window().maximize();
		//driver.findElement(By.className("a-button-text")).click();
		List<WebElement> cookieButtons = driver.findElements(By.className("a-button-text"));
		if(!cookieButtons.isEmpty()) {
		    cookieButtons.get(0).click();
		}

		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
		
		//capture product
		//WebElement xpath=driver.findElement(By.xpath("//span[.='Apple iPhone 15 (128 GB) - Green']/ancestor::div[@data-component-type='s-search-result']"));
		WebElement xpath=driver.findElement(By.xpath("//span[.='Apple iPhone 15 (128 GB) - Green']/../../../../div[3]/div[1]/div/div[1]/div[1]/a/span/span[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", xpath);

		String price=xpath.getText();
		System.out.println(price);
		driver.quit();
	}
}
