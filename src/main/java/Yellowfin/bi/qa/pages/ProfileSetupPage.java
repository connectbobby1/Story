package Yellowfin.bi.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Yellowfin.bi.qa.base.TestBase;

public class ProfileSetupPage extends TestBase {
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Actions actions = new Actions(driver);
	
	
	@FindBy(xpath="//input[@id='currentText']")
	WebElement CurrentPass;
	
	@FindBy(xpath="//input[@id='newText']")
	WebElement NewPass;
	
	@FindBy(xpath="//input[@id='new2Text']")
	WebElement New2Pass;
	
	@FindBy(xpath="//div[contains(text(),'Save Personal Settings')]")
	WebElement Save;
	
		
	//Initializing the Page Objects:
	public ProfileSetupPage(){
		PageFactory.initElements(driver, this);
	}
		
	public void EnterPass() {
		wait.until(ExpectedConditions.elementToBeClickable(CurrentPass));
		actions.click(CurrentPass).sendKeys("test").build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(NewPass));
		actions.click(NewPass).sendKeys("test").build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(New2Pass));
		actions.click(New2Pass).sendKeys("test").build().perform();
		
	}
	
	public void SavePersonalSettings() {
		Save.click();
		
	}
	
	
	

}
