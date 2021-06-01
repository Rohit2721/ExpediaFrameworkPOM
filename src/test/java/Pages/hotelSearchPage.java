package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePack.browserLaunch;

public class hotelSearchPage extends browserLaunch {
		
	@FindBy(css="button[aria-label='Going to']")
	WebElement destinationBtn;
	
	@FindBy(id="location-field-destination")
	WebElement destinationInput;
	
	@FindBy(id="d1-btn")
	WebElement checkInBtn;
	
	@FindBy(id="d2-btn")
	WebElement checkOutBtn;
	
	@FindBy(xpath="//button[@data-stid='apply-date-picker']")
	WebElement applyDate;
	
	@FindBy(xpath="//button[@data-testid='submit-button']")
	WebElement submitBtn;
	
	public hotelSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void hotelSearch() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		destinationBtn.click();
		destinationInput.sendKeys("Hyderabad",Keys.ENTER);
		
		checkInBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[starts-with(@aria-label,'Jun 16')]")));
		driver.findElement(By.xpath("//button[starts-with(@aria-label,'Jun 16')]")).click();
		applyDate.click();
		
		checkOutBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[starts-with(@aria-label,'Jun ')]")));
		driver.findElement(By.xpath("//button[starts-with(@aria-label,'Jun 17')]")).click();
		
		applyDate.click();
		
		submitBtn.click();
		
	}
	
	public String readTitle() {
		return driver.getTitle();
	}
	
}
