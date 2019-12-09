package Yellowfin.bi.qa.pages;




import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Yellowfin.bi.qa.base.TestBase;

public class ReportsPage extends TestBase {
	
	long d = 2000;
	Actions actions = new Actions(driver);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	
	WebDriverWait wait = new WebDriverWait(driver, 35);
	
	
	@FindBy(xpath="//div[@class='navigation-menu-toggle toggle-old-page']")
	WebElement ClickOnMenu;
	
	@FindBy(xpath="//div[text()='Browse']")
	WebElement ClickOnBrowse;
	
	@FindBy(xpath="//span[text()= 'Reports']")
	WebElement ClickOnReports;
	
	@FindBy(xpath="//span[@class='default-overlay extraOptionsOverlay']")
	WebElement EnterSearchResults;
	
	@FindBy(xpath="//img[@class='search']")
	WebElement ClickOnSearch;
	
	@FindBy(xpath="//div[@title='Invoice Summary']")
	WebElement SelectInvoiceSummaryReport;
	
	@FindBy(xpath="//div[@title='Performance by Region']")
	WebElement SelectPerformanceByRegionReport;
	
	@FindBy(xpath="//div[@title='Region Profit Summary']")
	WebElement SelectRegionProfitSummary;
	
	@FindBy(xpath="//img[@title='Snapshots']")
	WebElement ClickonSnapshots;	
	
	@FindBy(xpath="//a[text()='Create Snapshot']")
	WebElement ClickOnCreateSnapshot;
	
	@FindBy(xpath="//td[@class='toolbarButton' and @id='addReportToStory']")
	WebElement AddReportToStory;
	
	@FindBy(xpath="//img[@title='Add Report to Story']")
	WebElement ClickonSnapshots1;
		
	@FindBy(xpath="//input[@type='text']//following::div[text()='Name']")
	WebElement EnterSnapshotName;
	
	@FindBy(xpath="//input[@type='text']//following::div[text()='Description']")
	WebElement EnterSnapShotDescription;
	
	@FindBy(xpath="//div[text()='Save to Snapshots']")
	WebElement SaveSnapShots;
	
	@FindBy(xpath="//div[@class='addToStory']//following-sibling::div[@class='reportLeftNavBarPopupItemLabel']")
	WebElement HoveonLabel;
	
    @FindBy(xpath="//div[@class='addToStory']")
    WebElement ClickOnAddtoStory;
    
    @FindBy(xpath="//img[@src='images/add_to_story_hover.png']")
    WebElement topToolBar;

    @FindBy(xpath="//input[@class='newStoryTitle standardTextInput']")
    WebElement EnterTheTitle;
    
    @FindBy(xpath="//div[text()='Create New Story']")
    WebElement CreateNewStory;
    
    @FindBy(tagName ="select")
    WebElement SelectTag;
    
    @FindBy(xpath="//select[@multiple='multiple']")
    WebElement SelectFilter1;
    
    @FindBy(xpath="(//select[@multiple='multiple'])[2]")
    WebElement SelectFilter2;
    
    @FindBy(xpath="//span[text()='Go']")
    WebElement ClickonGo;
    
    @FindBy(xpath="(//div[@class='sideBarIcon'])[2]")
    WebElement ClickOnBookmark;
    
    @FindBy(xpath="//a[text()='Create Bookmark']")
    WebElement ClickOnCreateBookmark;
    
    @FindBy(xpath="//div[text()='Save to Bookmarks']")
    WebElement ClickonSavetoBookmarks;
    
    @FindBy(xpath="//div[@class='editStoryButton']")
	WebElement EditStory;
    
    @FindBy(xpath="//div[contains(text(),'Delete')]")
   	WebElement ClickOnDelete;
    
    @FindBy(xpath="//img[@src='images/Delete.png']")
    WebElement ClickDelete;
    
    @FindBy(xpath="//span[@id='dialogLeftMidText']")
    WebElement ClickOk;
    
    @FindBy(xpath = "//td[@id='addReportToStory']")
    WebElement HoverOntoptoolbar;
    
    @FindBy(xpath = "//div[@class='reportChart']")
    WebElement Report;
    
    @FindBy(xpath = "//span[@class='default-overlay']")
    WebElement SearchDraft;
    
    @FindBy(xpath = "//div[@class='searchBar standardSearchBar']//child::input[@type='text']")
    WebElement SearchBar;
    
    @FindBy(xpath = "//img[@title='Search existing draft stories']")
    WebElement Search;
    
    @FindBy(xpath = "//div[contains(text(),'No Stories to Display')]")
    WebElement Results;

  
    @FindBy(xpath=" //div[@id='logoffBtn']")
    WebElement LogOff;
    
 
    
	
	//Initializing the Page Objects:
		public ReportsPage(){
			PageFactory.initElements(driver, this);
		}
		
		public void AccessMenu()
		{
			ClickOnMenu.click();	
			
		}
		
		
		public void ClickOnBrowse()
		
		{
			ClickOnBrowse.click();
			
		}
		
		public void ClickOnReports()
		{
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnReports));
			ClickOnReports.click();	
		}
		
		public void EnterSearchResults(String ReportName)
		   
		{
		   wait.until(ExpectedConditions.elementToBeClickable(EnterSearchResults));  
		   actions.doubleClick(EnterSearchResults).sendKeys(ReportName).build().perform();
		}
		
		 public void ClickOnSearch()
		   
		{
		   ClickOnSearch.click(); 
		}
		 
		public void SelectInvoiceSummaryReport()
		{
		   actions.doubleClick(SelectInvoiceSummaryReport).build().perform();
		} 
		 
		
		public void SelectPerformanceByRegionReport()
		{
		   actions.doubleClick(SelectPerformanceByRegionReport).build().perform();
		} 
		public void SelectRegionProfitSummary()
		{
		   actions.doubleClick(SelectRegionProfitSummary).build().perform();
		}
		
		public void ClickonSnapshots()
		{
			wait.until(ExpectedConditions.elementToBeClickable(ClickonSnapshots)); 
			ClickonSnapshots.click();
		}

		public void ClickOnCreateSnapshot(String SnapShotName, String SnapShotDesc)
		{
			
			try {
				Thread.sleep(d);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			ClickonSnapshots.click();
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnCreateSnapshot));  
			ClickOnCreateSnapshot.click();
			actions.click(EnterSnapshotName).sendKeys(SnapShotName).build().perform();
			actions.click(EnterSnapShotDescription).sendKeys(SnapShotDesc).build().perform();
			SaveSnapShots.click();
		}
		
		public void AddSnapShottoStory()
		
		{
			try {
				Thread.sleep(d);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			wait.until(ExpectedConditions.elementToBeClickable(ClickonSnapshots1)); 
			ClickonSnapshots1.click();
			/*wait.until(ExpectedConditions.elementToBeClickable(HoveonLabel)); 
			actions.moveToElement(HoveonLabel).build().perform();
			actions.click(ClickOnAddtoStory).build().perform();*/
			
		}
		
		public void AddBookMarktoStory()
		
		{
			try {
			
			Thread.sleep(d);	
			executor.executeScript("document.getElementsByClassName('sideBarIcon')[1].click();",ClickOnBookmark);
			
			Thread.sleep(d);
			actions.moveToElement(HoveonLabel).build().perform();
			actions.click(ClickOnAddtoStory).build().perform();
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		public void CreateStory(String StoryTitle)
		
		{
			actions.click(EnterTheTitle).sendKeys(StoryTitle).build().perform();
			CreateNewStory.click();
		}
		
		
		public void CreateStory1()
		
		{
			wait.until(ExpectedConditions.elementToBeClickable(CreateNewStory)); 
			CreateNewStory.click();
		}
		public void SelectFilterValues()
		
		{
			try {
			new Select((SelectFilter1)).selectByVisibleText("Asia");
			ClickonGo.click();
			}
			
			catch(Exception e)
			{
				e.getMessage();
			}
		}
		
		public void CreateBookmark(String BookmarkName, String BookmarkDesc)
		
		{
			
			try {
			
			ClickOnBookmark.click();
			//actions.click(ClickOnBookmark).click().build().perform();		
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnCreateBookmark)); 
			actions.click(ClickOnCreateBookmark).click().build().perform();
			actions.click(EnterSnapshotName).sendKeys(BookmarkName).build().perform();
			actions.click(EnterSnapShotDescription).sendKeys(BookmarkDesc).build().perform();
			ClickonSavetoBookmarks.click();
			}
			catch(Exception e)
			{
				e.getMessage();
			}
		
		}
		
		public void EditStory()
		   
		   {
			   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			   actions.click(EditStory).build().perform(); 
			   
		   }
		
		public void AddToStory()
		
		{
		   try {
		
			 Thread.sleep(d);  
			 executor.executeScript("document.getElementsByClassName('toolbarButton')[5].click();",HoverOntoptoolbar);
			/*actions.moveToElement(HoverOntoptoolbar).build().perform();
			actions.click(topToolBar).build().perform();*/
		   }
		   
		   catch(Exception e) {
			   e.getMessage();
		   }
			
			   
		}
		
		public void clickOnBookmark()
		
		{
			
			executor.executeScript("document.getElementsByClassName('sideBarIcon')[1].click();",ClickOnBookmark);
			wait.until(ExpectedConditions.elementToBeClickable(HoveonLabel)); 
			HoveonLabel.click();
			
		}
		
		public void DeleteReport()
		
		{
		  actions.contextClick(SelectRegionProfitSummary).click().build().perform();
		  actions.click(ClickOnDelete).build().perform();
		  
		}
		
		public void DeleteBookmark()
		
		{
			try {
			ClickOnBookmark.click();
			wait.until(ExpectedConditions.elementToBeClickable(HoveonLabel)); 
			actions.moveToElement(HoveonLabel).build().perform();
			ClickDelete.click();
			actions.click(ClickOk).build().perform();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		public void DeleteSnapShot()
		
		{
			try {
				
			Thread.sleep(d);
			ClickonSnapshots.click();
			wait.until(ExpectedConditions.elementToBeClickable(HoveonLabel)); 	
			actions.moveToElement(HoveonLabel).click().build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(ClickDelete)); 	
			actions.click(ClickDelete).build().perform();
			actions.click(ClickOk).build().perform();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			
		}
			public void Validate(){
				
			 Actions action = new Actions(driver);
			 action.moveToElement(Report, 300, 200);
			 try {
				Thread.sleep(2000+d);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			 action.click().build().perform();
		}
        
		
			public void SearchDraftStory(String name) {
			
				try {
				executor.executeScript("document.getElementsByClassName('default-overlay')[0].click();",SearchDraft);
				//executor.executeScript("document.getElementsByClassName('searchBar standardSearchBar')[0].value='"+"name"+"';");
				Thread.sleep(d);
				actions.clickAndHold().sendKeys(SearchBar,name).build().perform();
				actions.click(Search).click().build().perform();
								
				}
				
				catch(Exception e)
				{
					e.getMessage();
				}
				
			}
		
		
			 public void ValidateResults() {
				 
				 String rResults = Results.getText();
				 assertEquals(rResults, "No Stories to Display"); 
				 
				 
			 }
			 
			 
		
		
		public void LogOff()
		
		{
			LogOff.click();
		}
		
}
