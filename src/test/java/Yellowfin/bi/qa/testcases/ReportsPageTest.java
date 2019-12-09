package Yellowfin.bi.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Yellowfin.bi.qa.base.TestBase;
import Yellowfin.bi.qa.pages.HomePage;
import Yellowfin.bi.qa.pages.LicensePage;
import Yellowfin.bi.qa.pages.LoginPage;
import Yellowfin.bi.qa.pages.ReportsPage;

public class ReportsPageTest extends TestBase {
	
	LoginPage loginPage;
	LicensePage licensePage;
	HomePage homePage;
	ReportsPage reportsPage;
	
	public ReportsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		homePage = new HomePage();
		reportsPage = new ReportsPage();
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Parameters({ "RName","SnapShotName", "Desc", "StoryTitle" })
	@Test(testName = "CreateStorywithSnapshot", enabled = true, priority = 1)
	public void Test1(String RName, String SnapShotName, String Desc, String StoryTitle) throws InterruptedException
	
	{
		licensePage.ClickHereToContinue();
		reportsPage.AccessMenu();
		reportsPage.ClickOnBrowse();
		reportsPage.ClickOnReports();
		reportsPage.EnterSearchResults(RName);
		reportsPage.ClickOnSearch();
		reportsPage.SelectInvoiceSummaryReport();
		reportsPage.ClickOnCreateSnapshot(SnapShotName, Desc);
		reportsPage.AddSnapShottoStory();
		reportsPage.CreateStory(StoryTitle);
		reportsPage.EditStory();
		captureScreenShot("ReportsPageTest1");	
		
		
	}
	
	@Parameters({ "RName","BookMarkName", "Desc", "StoryTitle" })
	@Test(testName = "CreateStorywithBookmark", enabled = true, priority = 2)
	public void Test2(String RName, String BookMarkName, String Desc, String StoryTitle) throws InterruptedException
	
	{
		licensePage.ClickHereToContinue();
		reportsPage.AccessMenu();
		reportsPage.ClickOnBrowse();
		reportsPage.ClickOnReports();
		reportsPage.EnterSearchResults(RName);
		reportsPage.ClickOnSearch();
		reportsPage.SelectRegionProfitSummary();
		reportsPage.SelectFilterValues();
		reportsPage.CreateBookmark(BookMarkName, Desc);
		reportsPage.AddBookMarktoStory();
		reportsPage.CreateStory(StoryTitle);
		reportsPage.EditStory();
		captureScreenShot("ReportsPageTest2");		
			
	}
	
	@Parameters({ "RName"})
	@Test(testName = "Verify that system displays validation message for a report that is attached to a snapshot", enabled = true, priority = 3)
	public void Test3(String RName) throws InterruptedException
	
	{
		licensePage.ClickHereToContinue();
		reportsPage.AccessMenu();
		reportsPage.ClickOnBrowse();
		reportsPage.ClickOnReports();
		reportsPage.EnterSearchResults(RName);
		reportsPage.ClickOnSearch();
		reportsPage.DeleteReport();
		captureScreenShot("ReportsPageTest3");
		
	}
	
	@Parameters({ "RName", "SnapShotName", "Desc" })
	@Test(testName = "Verify that top tool bar adds snapshot when there is active Snapshot", enabled = true, priority = 4)
	public void Test4(String RName, String SnapShotName, String Desc) throws InterruptedException
	
	{
		licensePage.ClickHereToContinue();
		reportsPage.AccessMenu();
		reportsPage.ClickOnBrowse();
		reportsPage.ClickOnReports();
		reportsPage.EnterSearchResults(RName);
		reportsPage.ClickOnSearch();
		reportsPage.SelectInvoiceSummaryReport();
		reportsPage.ClickOnCreateSnapshot(SnapShotName, Desc);
		reportsPage.AddToStory();
		captureScreenShot("ReportsPageTest4");
		
	}
	
	
	@Parameters({ "ReportName", "BookMarkName", "Desc" })
	@Test(testName = "Verify that the system deletes a bookmark", enabled = true, priority = 5)
	public void Test6(String ReportName, String BookMarkName, String Desc) throws InterruptedException
	
	{
		licensePage.ClickHereToContinue();
		reportsPage.AccessMenu();
		reportsPage.ClickOnBrowse();
		reportsPage.ClickOnReports();
		reportsPage.EnterSearchResults(ReportName);
		reportsPage.ClickOnSearch();
		reportsPage.SelectRegionProfitSummary();
		reportsPage.SelectFilterValues();
		reportsPage.CreateBookmark(BookMarkName, Desc);
		reportsPage.DeleteBookmark();
		reportsPage.LogOff();
	
	}
	
	@Parameters({ "ReportName", "SnapShotName", "Desc" })
	@Test(testName = "Verify that the system deletes a sanpshot", enabled = true, priority = 6)
	public void Test7(String RName, String SnapShotName, String Desc) throws InterruptedException
	
	{
		licensePage.ClickHereToContinue();
		reportsPage.AccessMenu();
		reportsPage.ClickOnBrowse();
		reportsPage.ClickOnReports();
		reportsPage.EnterSearchResults(RName);
		reportsPage.ClickOnSearch();
		reportsPage.SelectRegionProfitSummary();
		reportsPage.SelectFilterValues();
		reportsPage.ClickOnCreateSnapshot(SnapShotName, Desc);
		reportsPage.DeleteSnapShot();
		//reportsPage.LogOff();
	
	}
	
	@Parameters({ "RName" })
	@Test(testName = "Verify that the user is able to create a story without a title", enabled = true, priority = 7)
	public void Test8(String RName) throws InterruptedException
	
	{
		licensePage.ClickHereToContinue();
		reportsPage.AccessMenu();
		reportsPage.ClickOnBrowse();
		reportsPage.ClickOnReports();
		reportsPage.EnterSearchResults(RName);
		reportsPage.ClickOnSearch();
		reportsPage.SelectInvoiceSummaryReport();
		reportsPage.AddToStory();
		reportsPage.CreateStory1();
		reportsPage.EditStory();
		captureScreenShot("ReportsPageTest7");
			
	}
	
	@Parameters({ "RName","SnapShotName", "Desc", "StoryTitle" })
	@Test(testName = "Verify that Drill down/drill anywhere/ drill through does not work for snapshots", enabled = true, priority = 8)
	public void Test9(String RName, String SnapShotName, String Desc, String StoryTitle) throws InterruptedException
	
	{
		licensePage.ClickHereToContinue();
		reportsPage.AccessMenu();
		reportsPage.ClickOnBrowse();
		reportsPage.ClickOnReports();
		reportsPage.EnterSearchResults(RName);
		reportsPage.ClickOnSearch();
		reportsPage.SelectRegionProfitSummary();
		reportsPage.ClickOnCreateSnapshot(SnapShotName, Desc);
		reportsPage.AddSnapShottoStory();
		reportsPage.CreateStory(StoryTitle);
		reportsPage.EditStory();
		reportsPage.Validate();
		captureScreenShot("ReportsPageTest8");	
		
	}
	
	
	
	@AfterMethod()
	public void exit()
	
	{
		//driver.quit();
	}
	
	
}
