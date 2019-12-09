package Yellowfin.bi.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Yellowfin.bi.qa.base.TestBase;
import Yellowfin.bi.qa.pages.AdminConsolePage;
import Yellowfin.bi.qa.pages.HomePage;
import Yellowfin.bi.qa.pages.LicensePage;
import Yellowfin.bi.qa.pages.LoginPage;
import Yellowfin.bi.qa.pages.StoryPage;

public class AdminConsoleTest extends TestBase {

	LoginPage loginPage;
	LicensePage licensePage;
	HomePage homePage;
	StoryPage storyPage;
	AdminConsolePage adminConsolePage;

	public AdminConsoleTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		storyPage = new StoryPage();
		adminConsolePage = new AdminConsolePage();
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Parameters({ "FName", "LName", "Email", "userID", "passwd", "ConfrmPwsd" })
	@Test(enabled = true)
	public void Test1(String FName, String LName, String Email, String userID, String passwd, String ConfrmPwsd)

	{
		licensePage.ClickHereToContinue();
		homePage.AccessAdminConsole();
		adminConsolePage.CreateUser(FName, LName, Email, userID, passwd, ConfrmPwsd);
	}

	@Test(enabled = true)
	public void Test2()

	{
		licensePage.ClickHereToContinue();
		homePage.AccessAdminConsole();
		adminConsolePage.AppToFolders();
	}

}
