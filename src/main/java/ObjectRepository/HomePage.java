package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebdriverUtility;

public class HomePage extends WebdriverUtility{

	//home 
	
	
		@FindBy(xpath = "//a[.='Campaigns']")
		private WebElement camlnk;
		
		@FindBy(xpath="//span[.='Create Campaign']")
		private WebElement campBtn;

		public WebElement getCamlnk() {
			return camlnk;
		}

		public WebElement getCampBtn() {
			return campBtn;
		}

		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void hmPage() throws InterruptedException {
			
			camlnk.click();
			campBtn.click();
			Thread.sleep(6000);
			//waitForInvisibility(WebDriver driver, By.xpath("//div[contains(@class,'Toastify__toast')]"), 10);
		}
		
		
}
