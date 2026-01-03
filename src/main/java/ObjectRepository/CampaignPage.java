package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	//campaign page
		@FindBy(name = "campaignName")
		private WebElement cmpNameTF;
		
		@FindBy(name = "targetSize")
		private WebElement trgtSizeBtn;
		
		@FindBy(xpath = "//button[.='Create Campaign']")
		private WebElement crtCmpBtn;

		public WebElement getCmpNameTF() {
			return cmpNameTF;
		}

		public WebElement getTrgtSizeBtn() {
			return trgtSizeBtn;
		}

		public WebElement getCrtCmpBtn() {
			return crtCmpBtn;
		}

		public CampaignPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void CampPage(String cname, String num) {
			cmpNameTF.sendKeys(cname);
			trgtSizeBtn.sendKeys(num);	
			crtCmpBtn.click();
		}
		
		
}
