package Yellowfin.bi.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Yellowfin.bi.qa.base.TestBase;
import Yellowfin.bi.qa.pages.AdminConsolePage;
import Yellowfin.bi.qa.pages.HomePage;
import Yellowfin.bi.qa.pages.LicensePage;
import Yellowfin.bi.qa.pages.LoginPage;
import Yellowfin.bi.qa.pages.ReportsPage;
import Yellowfin.bi.qa.pages.StoriesPage;
import Yellowfin.bi.qa.pages.StoryPage;
import Yellowfin.bi.qa.pages.TimelinePage;

public class StoryPageTest extends TestBase {

	LoginPage loginPage;
	LicensePage licensePage;
	HomePage homePage;
	StoryPage storyPage;
	ReportsPage reportsPage;
	AdminConsolePage adminConsolePage;
	TimelinePage timelinePage;
	StoriesPage storiesPage;

	public StoryPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		storyPage = new StoryPage();
		reportsPage = new ReportsPage();
		adminConsolePage = new AdminConsolePage();
		timelinePage = new TimelinePage();
		storiesPage = new StoriesPage();
	}

	@Parameters({ "Title" })
	@Test(testName = "Create a story with title (Banner) image", priority = 2, enabled = true)
	public void Test2(String Title) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.captureScreenShot("StoryWithTitle");
		storyPage.logout();
	}

	@Parameters({ "Title" })
	@Test(testName = "Create a story with an image", priority = 3, enabled = true)
	public void Test3(String Title) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddAnImage();
		storyPage.InsertAnImage();
		storyPage.ClickOnAddButton();
		storyPage.captureScreenShot("StoryWithimage");
		storyPage.logout();

	}

	@Parameters({ "Title", "VideoLink" })
	@Test(testName = "Create a story with Video", priority = 4, enabled = true)
	public void Test4(String Title, String VideoLink) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddVideo();
		storyPage.EnterVideoLink(VideoLink);
		storyPage.PressEnter();
		storyPage.captureScreenShot("StoryWithVideo");
		storyPage.logout();

	}

	@Parameters({ "Title" })
	@Test(testName = "Create a story with Divider", priority = 5, enabled = true)
	public void Test5(String Title) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddDivider();
		storyPage.PressEnter();
		storyPage.captureScreenShot("StoryWithDivider");
		storyPage.logout();
	}

	@Parameters({ "Title", "Data" })
	@Test(testName = "Create a story with text", priority = 6, enabled = true)
	public void Test6(String Title, String Data) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.EnterText(Data);
		storyPage.captureScreenShot("StoryWithContent");
		storyPage.logout();
	}

	@Parameters({ "Title", "Data" })
	@Test(testName = "Create a story with Bold Text", priority = 7, enabled = true)
	public void Test7(String Title, String Data) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.EnterText(Data);
		storyPage.SelectAllText();
		storyPage.ClickonBold();
		storyPage.captureScreenShot("StoryWithBoldText");
		storyPage.logout();
	}

	@Parameters({ "Title" })
	@Test(testName = "Create a story with Reports", priority = 8, enabled = true)
	public void Test8(String Title) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.captureScreenShot("StoryWithReport");
		storyPage.logout();

	}

	@Parameters({ "Title", "Fold1", "Fold2" })
	@Test(testName = "Publish Story", priority = 9, enabled = true)
	public void Test9(String Title, String Fold1, String Fold2) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishStory(Fold1, Fold2);
		storyPage.captureScreenShot("PublishStory");
		storyPage.logout();

	}

	@Parameters({ "Title" })
	@Test(testName = "Assign Collaborators", priority = 10, enabled = true)
	public void Test10(String Title)

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.AssignCollaborators();
		storyPage.logout();

	}

	@Parameters({ "Title" })
	@Test(testName = "Browse Stories", priority = 11, enabled = true)
	public void Test11(String Title)

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.BrowseStories();

	}

	@Parameters({ "Title" })
	@Test(testName = "Verify that the author can Delete a Story", priority = 12, enabled = true)
	public void Test12(String Title)

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.DeleteStory();
		storyPage.LogOff();
	}

	@Parameters({ "Title" })
	@Test(testName = "Verify that the comment can be entered in the activity stream", priority = 13, enabled = true)
	public void Test13(String Title)

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.SendMessagestoActivityStream();
		storyPage.logout();
	}

	@Parameters({ "Title", "Fold1", "Fold2" })
	@Test(testName = "Verify that published stories are displayed in timeline", priority = 14, enabled = true)
	public void Test14(String Title, String Fold1, String Fold2) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishStory(Fold1, Fold2);
		storyPage.ClosetheStoryPage();
		homePage.AccessTimelines();
		reportsPage.captureScreenShot("Published Story in timeline");
		storyPage.LogOff();
	}

	@Parameters({ "Title", "Fold1", "Fold2" })
	@Test(testName = "Verify that the published story can be shared", priority = 15, enabled = true)
	public void Test15(String Title, String Fold1, String Fold2)

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishStory(Fold1, Fold2);
		storyPage.shareStory();

	}

	@Parameters({ "Title", "Fold1", "Fold2" })
	@Test(testName = "Add to favorite", priority = 16, enabled = true)
	public void Test16(String Title, String Fold1, String Fold2) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle("Title");
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishStory(Fold1, Fold2);
		storyPage.ClickFavourite();
		storyPage.BrowseStories1();
		storyPage.ClickMyFavorite();
		reportsPage.captureScreenShot("My Favorite story");
		storyPage.LogOff();
	}

	@Parameters({ "Title", "Fold1", "Fold2" })
	@Test(testName = "Verify that the Admin is able to approve the request", priority = 17, enabled = false)
	public void Test17(String Title, String Fold1, String Fold2)

	{
		licensePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.CheckStoryContainer();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishStoryApproval(Fold1, Fold2);
		storyPage.LogOff();
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.AccessTimelines();
		timelinePage.ApproveStory();
		timelinePage.ValidateTaskStatus();
	}

	@Parameters({ "Title", "Fold1", "Fold2" })
	@Test(testName = "Verify that the Admin is able to reject the request", priority = 18, enabled = true)
	public void Test18(String Title, String Fold1, String Fold2)

	{
		licensePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.CheckStoryContainer();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishStoryApproval(Fold1, Fold2);
		storyPage.LogOff();
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.AccessTimelines();
		timelinePage.RejectStory();
		timelinePage.ValidateTaskStatus();
	}

	@Parameters({ "Title", "Fold1", "Fold2" })
	@Test(testName = "Verify that the user is able to follow the author", priority = 19, enabled = true)
	public void Test19(String Title, String Fold1, String Fold2) throws AWTException

	{
		storyPage.updateQuery();
		licensePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishStoryApproval(Fold1, Fold2);
		storyPage.LogOff();
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.AccessStories();
		storiesPage.OpenStory();
		storyPage.ClickApprovalReq();
		storyPage.ClickFollow();
		storyPage.ValidateFollowing();
	}

	@Parameters({ "Title", "Title1", "Fold1", "Fold2" })
	@Test(testName = "Verify that following tag displays for all the stories", priority = 20, enabled = false)
	public void Test20(String Title, String Title1, String Fold1, String Fold2) throws AWTException

	{
		storyPage.updateQuery();
		licensePage = loginPage.login(prop.getProperty("username2"), prop.getProperty("password2"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.CheckStoryContainer();
		storyPage.AddImage();
		storyPage.EnterTitle(Title);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishStoryApproval(Fold1, Fold2);
		// storyPage.ClosetheStoryPage();
		homePage.CreateStory();
		storyPage.AddImage();
		storyPage.EnterTitle(Title1);
		storyPage.PublishStoryApproval(Fold1, Fold2);
		storyPage.LogOff();
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.AccessStories();
		storiesPage.OpenStory();
		storyPage.ClickApprovalReq();
		storyPage.ClickFollow();
		storyPage.ClosetheStoryPage();
		storiesPage.OpenStory1();
		storyPage.ClickApprovalReq();
		storyPage.ValidateFollowing();
		storyPage.LogOff();

	}

	@Test(testName = "Verify that the story in edit mode is not accessible to other users", priority = 21, enabled = true)
	public void Test21()

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.logout();
		licensePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		licensePage.ClickHereToContinue();
		homePage.AccessStories();
		storyPage.ValidateStory(name);
		storyPage.LogOff();

	}

	@Test(testName = "Verify that the story in edit mode is accessible to story admin", priority = 22, enabled = true)
	public void Test22()

	{
		licensePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.logout();
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.AccessStories();
		storyPage.ValidateStory(name);
		storyPage.LogOff();
	}

	@Parameters({ "Fold1Test22", "Fold2Test22" })
	@Test(testName = "Verify that a private story is accessible to a member who is given access ", priority = 23, enabled = true)
	public void Test23(String Fold1Test22, String Fold2Test22)

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishPrivateStory(Fold1Test22, Fold2Test22);
		storyPage.logout();
		licensePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		licensePage.ClickHereToContinue();
		homePage.AccessStories();
		storyPage.ValidateStory(name);
		storyPage.LogOff();
	}

	@Parameters({ "Fold1Test22", "Fold2Test22" })
	@Test(testName = "Verify that a private story is not accessable to a member who is not given access ", priority = 24, enabled = true)
	public void Test24(String Fold1Test22, String Fold2Test22)

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishPrivateStory1(Fold1Test22, Fold2Test22);
		storyPage.logout();
		licensePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		licensePage.ClickHereToContinue();
		homePage.AccessStories();
		storyPage.ValidateStory(name);
		storyPage.LogOff();
	}

	@Parameters({ "Fold1Test22", "Fold2Test22" })
	@Test(testName = "Verify that a story saved in a private folder is not accessible to other users", priority = 25, enabled = true)
	public void Test25(String Fold1Test22, String Fold2Test22)

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishStoryinSecureFolder(Fold1Test22, Fold2Test22);
		storyPage.logout();
		licensePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		licensePage.ClickHereToContinue();
		homePage.AccessStories();
		storyPage.ValidateStory(name);
		storyPage.LogOff();
	}

	@Parameters({ "Fold1Test25", "Fold2Test25" })
	@Test(testName = "Verify that the user is able to like a story ", priority = 26, enabled = true)
	public void Test26(String Fold1Test25, String Fold2Test25)

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishStory(Fold1Test25, Fold2Test25);
		storyPage.LikeStory();
		storyPage.ValidateLikeCount();
		storyPage.logout();

	}

	@Parameters({ "Fold1Test25", "Fold2Test25" })
	@Test(testName = "Verify that the collaborator is unable to publish a story", priority = 27, enabled = true)
	public void Test27(String Fold1Test25, String Fold2Test25) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.AssignCollaborators();
		storyPage.logout();
		licensePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		licensePage.ClickHereToContinue();
		homePage.AccessStories();
		storiesPage.OpenStory();
		// storyPage.EditStory();
		storyPage.captureScreenShot("Test27");
		storyPage.logout();

	}

	@Parameters({ "Fold1Test25", "Fold2Test25" })
	@Test(testName = "Verify that the user is able to preview a page", priority = 28, enabled = true)
	public void Test28(String Fold1Test25, String Fold2Test25) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.Preview();
		storyPage.ValidatePreviewPage();

	}

	@Parameters({ "Fold1Test25", "Fold2Test25", "RName" })
	@Test(testName = "Verify that system does not display published Story in Choose a Draft Story window", priority = 29, enabled = true)
	public void Test29(String Fold1Test25, String Fold2Test25, String RName) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.PublishStory(Fold1Test25, Fold2Test25);
		storyPage.logout();
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		reportsPage.AccessMenu();
		reportsPage.ClickOnBrowse();
		reportsPage.ClickOnReports();
		reportsPage.EnterSearchResults(RName);
		reportsPage.ClickOnSearch();
		reportsPage.SelectInvoiceSummaryReport();
		reportsPage.AddToStory();
		reportsPage.SearchDraftStory(name);
		reportsPage.captureScreenShot("StoryPageTest29");
		reportsPage.ValidateResults();
	}

	@Parameters({ "Fold1Test25", "Fold2Test25", "RName" })
	@Test(testName = "Verify that system displays the display table for a report", priority = 30, enabled = true)
	public void Test30(String Fold1Test25, String Fold2Test25, String RName) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.DisplayTable();
		reportsPage.captureScreenShot("Test30");
	}

	@Parameters({ "Fold1Test25", "Fold2Test25", "RName" })
	@Test(testName = "Verify that the user is able to maximize a report", priority = 31, enabled = true)
	public void Test31(String Fold1Test25, String Fold2Test25, String RName) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.MaximizeReport();
		reportsPage.captureScreenShot("StoryPageTest31");
	}

	@Parameters({ "Fold1Test25", "Fold2Test25", "RName" })
	@Test(testName = "Verify that the user is able to set the size of the report to original", priority = 32, enabled = true)
	public void Test32(String Fold1Test25, String Fold2Test25, String RName) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddReport();
		storyPage.InsertIntoStory();
		storyPage.OrignalSize();
		reportsPage.captureScreenShot("StoryPageTest32");
	}

	@Parameters({ "Fold1Test25", "Fold2Test25", "RName" })
	@Test(testName = "Verify that the sizing for the images work", priority = 33, enabled = true)
	public void Test33(String Fold1Test25, String Fold2Test25, String RName) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddAnImage();
		storyPage.InsertAnImage();
		storyPage.ClickOnAddButton();
		storyPage.ClickOnWide();
		reportsPage.captureScreenShot("StoryPageTest33");
	}

	@Parameters({ "Fold1Test25", "Fold2Test25", "RName" })
	@Test(testName = "Verify that a report with multiple charts can be selected", priority = 34, enabled = true)
	public void Test34(String Fold1Test25, String Fold2Test25, String RName) throws InterruptedException

	{
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		licensePage.ClickHereToContinue();
		homePage.CreateStory();
		storyPage.AddImage();
		String name = storyPage.getString();
		storyPage.EnterTitle(name);
		storyPage.ClickOnTextBox();
		storyPage.ClickOnCloseMenu();
		storyPage.AddRegionProfitSummaryReport();
		storyPage.InsertIntoStory();
		storyPage.DisplayChart();
		storyPage.SelectChart();
		reportsPage.captureScreenShot("StoryPageTest34");
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
