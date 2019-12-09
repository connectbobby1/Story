package Yellowfin.bi.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Yellowfin.bi.qa.base.TestBase;
import Yellowfin.bi.qa.pages.AdminConsolePage;
import Yellowfin.bi.qa.pages.HomePage;
import Yellowfin.bi.qa.pages.LicensePage;
import Yellowfin.bi.qa.pages.LoginPage;
import Yellowfin.bi.qa.pages.ProfileSetupPage;
import Yellowfin.bi.qa.pages.StoryPage;

public class ProfileSetupTest extends TestBase{
	LoginPage loginPage;	
	LicensePage licensePage;
	AdminConsolePage adminConsolePage;
	HomePage homePage;
	ProfileSetupPage ProfileSetup;
	StoryPage storyPage;
	
	
	
	public ProfileSetupTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		ProfileSetup = new ProfileSetupPage();
		homePage = new HomePage();
		adminConsolePage = new AdminConsolePage();
		storyPage = new StoryPage();
	}
	
	
	@Test(priority = 0, enabled = false)
	public void ImportUsers()
	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
        homePage.AccessAdminConsole();
		adminConsolePage.ImportUsers();		
		
	}
	
	@Test(priority=1, enabled = false)
	public void Test1(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		ProfileSetup.EnterPass();
		ProfileSetup.SavePersonalSettings();		
	}
	
	@Test(priority=2, enabled = false)
	public void Test2(){
		loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		ProfileSetup.EnterPass();
		ProfileSetup.SavePersonalSettings();		
	}
	
	@Test(priority=3, enabled = false)
	public void Test3(){
		loginPage.login(prop.getProperty("username2"), prop.getProperty("password2"));
		ProfileSetup.EnterPass();
		ProfileSetup.SavePersonalSettings();		
	}
	
	@Test(priority=4, enabled = false)
	public void Test4(){
		loginPage.login(prop.getProperty("username3"), prop.getProperty("password3"));
		ProfileSetup.EnterPass();
		ProfileSetup.SavePersonalSettings();		
	}
	
	@Parameters({"Title"})
	@Test(priority = 5, enabled = false)
	public void Test5(String Title) throws InterruptedException
	
	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.CheckStoryContainer();
	}
	
	@Parameters({"Title"})
	@Test(priority = 6, enabled = false)
	public void Test6(String Title) throws InterruptedException
	
	{
		licensePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.CheckStoryContainer();
	}
	
	
	@Parameters({"Title"})
	@Test(priority = 7, enabled = false)
	public void Test7(String Title) throws InterruptedException
	
	{
		licensePage = loginPage.login(prop.getProperty("username2"), prop.getProperty("password2"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.CheckStoryContainer();
	}
	
	@Parameters({"Title"})
	@Test(priority = 8, enabled = false)
	public void Test8(String Title) throws InterruptedException
	
	{
		licensePage = loginPage.login(prop.getProperty("username3"), prop.getProperty("password3"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.CheckStoryContainer();
	}
	
		
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	
	

}
