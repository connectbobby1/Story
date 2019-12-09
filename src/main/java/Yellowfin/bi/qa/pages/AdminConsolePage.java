package Yellowfin.bi.qa.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Yellowfin.bi.qa.base.TestBase;

public class AdminConsolePage extends TestBase{
	long d = 2000;
	Actions actions = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	
	//Page Factory - OR:
	@FindBy(xpath="//div[contains(text(),'Users') and @id='user-section-title']")
	WebElement Users;
	
	@FindBy(xpath="//span[@class='submitMidHighlightText' and text()='Add']")
	WebElement Add;
	
	@FindBy(xpath="//input[@title='First Name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@title='Last Name']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@title='Email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@title='User Id']")
	WebElement UserId;
	
	@FindBy(xpath="//div[text()='Password']")
	WebElement Passwd;
	
	@FindBy(xpath="//div[text()='Confirm password']")
	WebElement ConfirmPwd;
	
	@FindBy(xpath="//span[text()='Create User']")
	WebElement CreateUser;
	
	@FindBy(xpath="//div[contains(text(),'Content Folders')]")
	WebElement ContentFolders;
	
	@FindBy(xpath="//a[text()='Athletes']")
	WebElement Atheletes;
	
	@FindBy(xpath="//div[text()='User Access' and @class='panelTab']")
	WebElement UserAccess;
	
	@FindBy(id="toggle")
	WebElement ExpertApproval;
	
	@FindBy(xpath="//input[@type='text']//following-sibling::div[text()='Search']")
	WebElement PersonTextbox;
	
	@FindBy(xpath="//div[text()='Administrators']")
	WebElement SelectAdministrators;
	
	@FindBy(xpath="//div[text()='Submit']")
	WebElement Submit;
	
	@FindBy(xpath="//span[text()='User Import']")
	WebElement UserImport;
	
	@FindBy(xpath="//input[@class='i4medbox']")
	WebElement ChooseFile;
	
	@FindBy(xpath="//span[@id='uploadButtonText']")
	WebElement Upload;
	
	@FindBy(linkText="Close")
	WebElement Close;
	
	//Initializing the Page Objects:
	public AdminConsolePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void CreateUser(String FName, String LName, String email, String userID, String passwd, String confpass)
	
	{
		Users.click();
		wait.until(ExpectedConditions.elementToBeClickable(Add)); 
		Add.click();
		FirstName.sendKeys(FName);
		LastName.sendKeys(LName);
		Email.sendKeys(email);
		UserId.sendKeys(userID);
		actions.click(Passwd).sendKeys(passwd).build().perform();
		actions.click(ConfirmPwd).sendKeys(confpass).build().perform();
		CreateUser.click();		
	}
	
	public void AppToFolders()
	
	{
		try {
		ContentFolders.click();
		wait.until(ExpectedConditions.elementToBeClickable(Atheletes));
		Atheletes.click();
		actions.click(UserAccess).build().perform();
		ExpertApproval.click();
		actions.click(PersonTextbox).build().perform();
		SelectAdministrators.click();
		Submit.click();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ImportUsers()
	{
		try {
		Users.click();
		wait.until(ExpectedConditions.elementToBeClickable(UserImport));
		UserImport.click();
		wait.until(ExpectedConditions.elementToBeClickable(ChooseFile));
		ChooseFile.click();
		StringSelection ss = new StringSelection("userimport.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		Close.click();
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
