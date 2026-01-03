package GenericUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebdriverUtility {
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void toGoBack(WebDriver driver) {
		driver.navigate().back();
	}

	public void toGoForword(WebDriver driver) {
		driver.navigate().forward();
	}

	public void mouseHoverOnWebelemment(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void toImplicitlyWait(WebDriver driver, int i) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
	}

	public void waitForInvisibility(WebDriver driver, By locator, int timeOut) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void scrollByAmount(WebDriver driver, int x, int y) {
		Actions act1 = new Actions(driver);
		act1.scrollByAmount(x, y).perform();
	}
	
	public void selectByIndex(WebElement ref, int index) {
		Select select=new Select(ref);
		select.selectByIndex(index);
		
	}
}
