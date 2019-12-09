package Yellowfin.bi.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Yellowfin.bi.qa.base.TestBase;
import Yellowfin.bi.qa.pages.HomePage;
import Yellowfin.bi.qa.pages.LicensePage;
import Yellowfin.bi.qa.pages.LoginPage;
import Yellowfin.bi.qa.pages.StoryPage;

public class HomePageTest extends TestBase{
	
	
	LoginPage loginPage;
	LicensePage licensePage;
	HomePage homePage;
	StoryPage storyPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		homePage = new HomePage();
		storyPage = new StoryPage();
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(enabled = false)
	public void CreateStory()
	
	{   
	
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		
	}
	
	
	@Parameters({"RName", "StoryTitle"})
	@Test(testName = "CreateStoryFromHomePage", enabled = false, priority = 1 )
	public void Test1(String RName, String StoryTitle)
	
	{
		licensePage.ClickHereToContinue();
		homePage.AccessMenu();
		homePage.ClickOnBrowse();
		homePage.ClickOnReports();
		homePage.EnterSearchResults(RName);
		homePage.ClickOnSearch();
		homePage.SelectTheReport();
		homePage.AddReportToStory();
		homePage.EnterTitle(StoryTitle);
		homePage.CreateNewStory();
		homePage.EditStory();
	}
	
	@Parameters({"RName", "StoryTitle"})
	@Test(testName = "AddReporttoExistingStory", enabled = false, priority = 2)
	public void Test2(String RName, String StoryTitle)
	
	{
		licensePage.ClickHereToContinue();
		homePage.AccessMenu();
		homePage.ClickOnBrowse();
		homePage.ClickOnReports();
		homePage.EnterSearchResults(RName);
		homePage.ClickOnSearch();
		homePage.SelectTheReport();
		homePage.AddReportToStory();
		homePage.ClickOnSearchBox(StoryTitle);
		homePage.AddtoStory();
		homePage.EditStory();
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
