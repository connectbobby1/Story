package Yellowfin.bi.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Yellowfin.bi.qa.base.TestBase;

public class TimelinePage extends TestBase {
	
	long d = 2000;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Actions actions = new Actions(driver);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	static String workingDir = System.getProperty("user.dir");	
	
	//Page Factory - OR:
	@FindBy(xpath="//div[contains(@id,'timelineContentItemMessageTextSTORYCOMMENTTHREAD')]")
	WebElement ContentItem;
	    
	@FindBy(xpath="//div[text()='Approve']")
	WebElement Approve;
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement Submit;
		
	@FindBy(xpath="//div[text()='Reject']")
	WebElement Reject;
	
	@FindBy(xpath="//div[@class='discussionStreamTaskStatus']")
	WebElement TaskStatus;
	
	@FindBy(xpath="//div[@class='btn-menu-icon-purple btn-menu-icon']")
	WebElement DownArrow;
	
	@FindBy(xpath="//div[@class='activityStreamInputTextArea broadcastInputTextPlaceholder' and text()='Enter your resolution here']")
	WebElement RejectComments;

	//Initializing the Page Objects:
	public TimelinePage(){
		PageFactory.initElements(driver, this);
			}

	 public void ApproveStory()
	  
	  {
		  ContentItem.click();
		  Approve.click();
		  
	  }		
	 
	 public void RejectStory()
	  
	  {
		  ContentItem.click();
		  DownArrow.click();
		  Reject.click();
		  actions.click(RejectComments).sendKeys("Reject Comments").build().perform();
		  Submit.click();
  	  }	
			
	 public void ValidateTaskStatus()
	  
	 {
		 try {
			Thread.sleep(d+4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 String Tstatus = TaskStatus.getText();
		 if (Tstatus.contains("Approved"))
		 {
			 System.out.println("The story has been approved");
			 Assert.assertEquals(Tstatus, "Approved");
		 }
		 
		 else if (Tstatus.contains("In Progress"))
		 {
			 System.out.println("The story has been rejected");
			 Assert.assertEquals(Tstatus, "In Progress");
		 }
				 		 
	 }
	 
	 
	
}
