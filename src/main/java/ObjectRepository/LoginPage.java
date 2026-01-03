package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebdriverUtility;

public class LoginPage extends WebdriverUtility{

	@FindBy(id="username")
	private WebElement usernameTF;
	
	@FindBy(id="inputPassword")
	private WebElement passwordTF;
	
	@FindBy(xpath="//button[.='Sign In']")
	private WebElement loginBtn;

	
//	@FindBy(className = "svg-inline--fa_fa-user")
//	private WebElement profileBtn;
//	
	@FindBy(xpath = "//*[local-name()='svg']")
	private WebElement profileBtn;

	
	@FindBy(xpath = "//div[.='Logout ']")
	private WebElement lgoutBtn;
	
	public WebElement getProfileBtn() {
		return profileBtn;
	}


	public WebElement getLgoutBtn() {
		return lgoutBtn;
	}

	//campaign page
	@FindBy(name = "campaignName")
	private WebElement cmpNameTF;
	
	@FindBy(name = "targetSize")
	private WebElement trgtSizeBtn;
	
	@FindBy(xpath = "//button[.='Create Campaign']")
	private WebElement crtCmpBtn;
	
	//step 4



	public WebElement getCmpNameTF() {
		return cmpNameTF;
	}


	public WebElement getTrgtSizeBtn() {
		return trgtSizeBtn;
	}


	public WebElement getCrtCmpBtn() {
		return crtCmpBtn;
	}


	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//step 3
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
//business logic
	public void loginToNinza(String name, String pass) throws InterruptedException {
		usernameTF.sendKeys(name);
		passwordTF.sendKeys(pass);
		loginBtn.click();
		Thread.sleep(2000);
	}
	
	
	
	public void logout(WebDriver driver) throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    //wait.until(ExpectedConditions.elementToBeClickable(profileBtn));
//	    toImplicitlyWait(driver, 15);
	  //wait for that pop-up to disappear
		Thread.sleep(6000);
		profileBtn.click();
		lgoutBtn.click();
	}
}
