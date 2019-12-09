package Yellowfin.bi.qa.pages;

import java.awt.Robot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Yellowfin.bi.qa.base.TestBase;

public class StoriesPage extends TestBase {
	
	long d = 2000;
	Robot robot;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Actions actions = new Actions(driver);

	//Page Factory - OR:
	@FindBy(xpath="//div[@class='contentTitle']")
	WebElement ContentTitle;
	
	@FindBy(xpath="//div[@class='yfDropMenuTitle' and text()='Edit']")
	WebElement Edit;
	

	@FindBy(xpath="//span[@class='submitMidHighlightText' and text()='Ok']")
	WebElement Ok;
	
	@FindBy(xpath="(//div[@class='notificationFlag browseNotification'])[2]")
	WebElement ContentTitle1;
	
	
	
	
		
	
	
	
	//Initializing the Page Objects:
		public StoriesPage(){
			PageFactory.initElements(driver, this);
		}
		
		 public void OpenStory()
		 
		 {
			 actions.doubleClick(ContentTitle).build().perform();
			 			 
		 }
					
		 public void OpenStory1()
		 
		 {
			 actions.doubleClick(ContentTitle1).build().perform();
			 			 
		 }
	
	
}
