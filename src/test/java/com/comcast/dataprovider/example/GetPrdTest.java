package com.comcast.dataprovider.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetPrdTest {

	    @Test
	    public void getProduct() {
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        driver.get("https://amazon.in/");
	        driver.manage().window().maximize();

	        driver.findElement(By.className("a-button-text")).click();

	        String productName = "Iphone"; 
	        // Search product
	        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName, Keys.ENTER);

	        // Dynamic XPath to locate the first matching product container
	        WebElement productContainer = driver.findElement(By.xpath(
	            "//span[contains(text(),'" + productName + "')]/ancestor::div[@data-component-type='s-search-result']"
	        ));

	        // Scroll into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productContainer);

	        // Get price specifically
	        WebElement priceElement = productContainer.findElement(By.xpath(".//span[@class='a-price-whole']"));
	        String price = priceElement.getText();

	        System.out.println("Price: ₹" + price);

	        driver.quit();
	    }
	
}
