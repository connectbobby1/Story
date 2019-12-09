package Yellowfin.bi.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Yellowfin.bi.qa.base.TestBase;

public class HomePage extends TestBase {
	long d = 2000;
	Actions actions = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 35);
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	// Page Factory - OR:
	@FindBy(xpath = "//img[@class='create-content-plus']")
	WebElement CreateContent;

	@FindBy(xpath = "//div[text()='Story']")
	WebElement ClickOnStory;

	@FindBy(xpath = "//span[text()= 'Reports']")
	WebElement ClickOnReports;

	@FindBy(xpath = "//div[text()='Browse']")
	WebElement ClickOnBrowse;

	@FindBy(xpath = "//div[@class='menu-cell']//child::span[text()='Stories']")
	WebElement ClickOnStories;

	@FindBy(xpath = "//div[@class='navigation-menu-toggle toggle-old-page']")
	WebElement ClickOnMenu;

	@FindBy(xpath = "//td[@id='addReportToStory']//child::img[@title='Add Report to Story']")
	WebElement ClickOnAddReportToStory;

	@FindBy(xpath = "//span[@class='default-overlay extraOptionsOverlay']")
	WebElement EnterSearchResults;

	@FindBy(xpath = "//img[@class='search']")
	WebElement ClickOnSearch;

	@FindBy(xpath = "//div[@title='Invoice Summary']")
	WebElement SelectReport;

	@FindBy(xpath = "//div[text()='Create New Story']")
	WebElement CreateNewStory;

	@FindBy(xpath = "//div[@class='editStoryButton']")
	WebElement EditStory;

	@FindBy(xpath = "//div[text()='Enter title']")
	WebElement EnterTitle;

	@FindBy(xpath = "//span[text()='Search existing stories']")
	WebElement ClickOnSearchBox;

	@FindBy(xpath = "//div[@class='searchImgContainer']")
	WebElement ClickSearch;

	@FindBy(xpath = "//div[text()='Add to this Story']")
	WebElement AddthistoStory;

	@FindBy(xpath = "//div[@class='storyDetails']")
	WebElement HoverMouseonExistingStory;

	@FindBy(xpath = "//div[@class='menu-toggle-inner-container']")
	WebElement Menu;

	@FindBy(xpath = "//span[text()='System Administrator']")
	WebElement SystemAdmin;

	@FindBy(xpath = "//span[text()='Timeline']")
	WebElement TimeLine;

	@FindBy(xpath = "//div[text()='Administration']")
	WebElement Admin;

	@FindBy(xpath = "//span[text()='Admin Console']")
	WebElement AdminConsole;

	@FindBy(xpath = "//div[@class='navigation-menu-section']")
	List<WebElement> menuCon;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void AccessStories()

	{
		try {
			Thread.sleep(d);
			wait.until(ExpectedConditions.elementToBeClickable(Menu));
			Menu.click();
			Thread.sleep(d);
			ClickOnBrowse.click();
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnStories));
			ClickOnStories.click();
			Thread.sleep(d);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void AccessMenu() {
		ClickOnMenu.click();

	}

	public void ClickOnBrowse()

	{
		ClickOnBrowse.click();

	}

	public void ClickOnReports() {
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnReports));
		ClickOnReports.click();

	}

	public void AddReportToStory()

	{

		try {

			actions.click(ClickOnAddReportToStory).build().perform();
		}

		catch (Exception e) {
			e.getMessage();
		}

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

	public void SelectTheReport() {
		actions.doubleClick(SelectReport).build().perform();

	}

	public void CreateNewStory()

	{
		CreateNewStory.click();

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

	public void EnterTitle(String StoryTitle) {
		wait.until(ExpectedConditions.elementToBeClickable(EnterTitle));
		actions.click(EnterTitle).sendKeys(StoryTitle).build().perform();
	}

	public void ClickOnSearchBox(String StoryTitle) {
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchBox));
		actions.click(ClickOnSearchBox).sendKeys(StoryTitle).build().perform();

	}

	public void AddtoStory() {
		wait.until(ExpectedConditions.elementToBeClickable(ClickSearch));
		ClickSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(HoverMouseonExistingStory));
		actions.moveToElement(HoverMouseonExistingStory).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(AddthistoStory));
		actions.click(AddthistoStory).build().perform();
	}

	/*
	 * public void AccessAdminConsole()
	 * 
	 * { Menu.click(); Admin.click();
	 * wait.until(ExpectedConditions.elementToBeClickable(AdminConsole));
	 * AdminConsole.click();
	 * 
	 * }
	 */

	public StoryPage CreateStory() {

		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='create-content-plus']")));
		CreateContent.click();
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		ClickOnStory.click();
		return new StoryPage();
	}

	/*
	 * public ReportsPage AccessReportPage() { AccessMenu(); ClickOnBrowse();
	 * ClickOnReports(); return new ReportsPage();
	 * 
	 * }
	 */

	public AdminConsolePage AccessAdminConsole() {
		wait.until(ExpectedConditions.elementToBeClickable(Menu));
		Menu.click();
		wait.until(ExpectedConditions.elementToBeClickable(Admin));
		Admin.click();
		wait.until(ExpectedConditions.elementToBeClickable(AdminConsole));
		AdminConsole.click();
		return new AdminConsolePage();
	}

	public void AccessTimelines() {
		Menu.click();
		wait.until(ExpectedConditions.elementToBeClickable(SystemAdmin));
		SystemAdmin.click();
		wait.until(ExpectedConditions.elementToBeClickable(TimeLine));
		TimeLine.click();
	}

}
