package Yellowfin.bi.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Yellowfin.bi.qa.base.TestBase;
import Yellowfin.bi.qa.pages.LicensePage;
import Yellowfin.bi.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	LicensePage licensePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginTest() {
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
