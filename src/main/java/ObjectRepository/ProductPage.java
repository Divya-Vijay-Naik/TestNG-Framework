package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebdriverUtility;

public class ProductPage {
	
	@FindBy(xpath  = "(//a[@class=\"nav-link\"])[5]")
	private WebElement prdLnkTF;
	
	@FindBy(xpath = "//span[.='Add Product']")
	private WebElement addPrdBtn;
	
	@FindBy(name = "productName")
	private WebElement prdNameTF;
	
	@FindBy(name="productCategory")
	private WebElement selCatDropDwn;
	
	@FindBy(name = "quantity")
	private WebElement qtyDrpDwn;
	
	@FindBy(name = "price")
	private WebElement price;
	
	public WebElement getAddbtn() {
		return addbtn;
	}

	

	@FindBy(name = "vendorId")
	private WebElement vndrId;
	
	@FindBy(xpath = "//button[.='Add']")
	private WebElement addbtn;
	

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getPrdLnkTF() {
		return prdLnkTF;
	}

	public WebElement getAddPrdBtn() {
		return addPrdBtn;
	}

	public WebElement getPrdNameTF() {
		return prdNameTF;
	}

	public WebElement getSelCatDropDwn() {
		return selCatDropDwn;
	}

	public WebElement getQtyDrpDwn() {
		return qtyDrpDwn;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getVndrId() {
		return vndrId;
	}
	
	public void PrdPage(WebdriverUtility utility, String quantity, String prdName, String amt) {
		prdLnkTF.click();
		addPrdBtn.click();	
		prdNameTF.sendKeys(prdName);
		utility.selectByIndex(selCatDropDwn, 3);
		qtyDrpDwn.clear();
		qtyDrpDwn.sendKeys(quantity);
		price.clear();
		price.sendKeys(amt);
		utility.selectByIndex(vndrId, 5);
		addbtn.click();
		
		
	}
	

}
