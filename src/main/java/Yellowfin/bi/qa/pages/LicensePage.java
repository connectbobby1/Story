package Yellowfin.bi.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Yellowfin.bi.qa.base.TestBase;

public class LicensePage extends TestBase {
	
	@FindBy(xpath="//a[text()='Click Here To Continue']")
	WebElement ClickToContinue;
	
	//Initializing the Page Objects:
			public LicensePage(){
				PageFactory.initElements(driver, this);
			}
	

			
	public HomePage ClickHereToContinue()
	
	{
		ClickToContinue.click();
		return new HomePage();
		
	}
}
