package Yellowfin.bi.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Yellowfin.bi.qa.base.TestBase;
import Yellowfin.bi.qa.pages.LicensePage;
import Yellowfin.bi.qa.pages.LoginPage;

public class LicensePageTest extends TestBase{
	
	LoginPage loginPage;
	LicensePage licensePage;

	public LicensePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		licensePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void ClickOnHeretoContinue()
	
	{
		licensePage.ClickHereToContinue();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
