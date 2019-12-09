package Yellowfin.bi.qa.pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Yellowfin.bi.qa.base.TestBase;

public class StoryPage extends TestBase {

	long d = 2000;
	Robot robot;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Actions actions = new Actions(driver);
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	static String workingDir = System.getProperty("user.dir");

	// Page Factory - OR:
	@FindBy(id = "storyHeaderImageContainer")
	WebElement AddImagetoHeader;

	@FindBy(xpath = "//div[text()='Ski Team Blue']")
	WebElement Image;

	@FindBy(xpath = "//textarea[@class='storyTitleInput']")
	WebElement TitleTextBox;

	@FindBy(xpath = "//span[@class='tooltip-icon dante-icon-plus']")
	WebElement CloseMenu;

	@FindBy(xpath = "//button[@title='Add a Report']//child::span[@class='tooltip-icon dante-report']")
	WebElement AddaReport;

	@FindBy(xpath = "//button[@title='Add an image']//child::span[@class='tooltip-icon dante-icon-image']")
	WebElement AddanImage;

	@FindBy(xpath = "//div[@class='imageContainer']")
	WebElement InsertImage;

	@FindBy(xpath = "//span[text()='Add']")
	WebElement AddButton;

	@FindBy(xpath = "//button[@title='Add a video']//child::span[@class='tooltip-icon dante-icon-video']")
	WebElement AddaVideo;

	@FindBy(xpath = "//button[@title='Add a divider']//child::span[@class='tooltip-icon dante-divider']")
	WebElement AddaDivider;

	@FindBy(xpath = "//div[@class='section-inner layoutSingleColumn']//child::p[contains(@class, 'graf graf--p graf--first graf--last')]")
	WebElement TextBox;

	@FindBy(xpath = "//div[contains(@class,'section-inner')]//child::p")
	WebElement EnterVideoLink;

	@FindBy(xpath = "//img[@src='images/close_large_white.png']")
	WebElement ClickOnClose;

	@FindBy(xpath = "//i[@data-action='bold']")
	WebElement ClickOnBold;

	@FindBy(xpath = "//div[@class='section-inner layoutSingleColumn']//child::p[contains(@class, 'graf graf--p is-selected')]")
	WebElement Bold;

	@FindBy(xpath = "//span[@class='tooltip-icon dante-report']")
	WebElement AddReport;

	@FindBy(xpath = "//div[@class='reportSelectionThumbnailItemContainer']")
	WebElement SelectReports;

	@FindBy(xpath = "//div[@class='displayText storyTitle']")
	WebElement StoryTitleTextBox;

	@FindBy(xpath = "//div[text()='Insert into Story']")
	WebElement InsertIntoStory;

	@FindBy(xpath = "//div[@class='moreButton']")
	WebElement More;

	@FindBy(xpath = "//div[@class='btn-container btn-flat btn-yellow-primary btn-standard publishButtonContainer']")
	WebElement Publish;

	@FindBy(xpath = "//ul[@class='yfDropMenu']")
	WebElement SelectCollaborators;

	@FindBy(xpath = "//select[@style='width: 200px; opacity: 0;']")
	WebElement Select1;

	@FindBy(xpath = "(//select[@style='width: 200px; opacity: 0;'])[2]")
	WebElement Select2;

	@FindBy(xpath = "//div[text()='Save']")
	WebElement Save;

	@FindBy(xpath = "//div[text()='Request Approval']")
	WebElement ReqApprv;

	@FindBy(xpath = "//td[@class='radioListDescription' and text()='Private']")
	WebElement Private;

	@FindBy(xpath = "//div[@class='yfDropMenuTitle' and text()='Collaborators']")
	WebElement Collaborators;

	@FindBy(xpath = "//div[@class='yfDropMenuTitle' and text()='Browse Stories']")
	WebElement BrowseStories;

	@FindBy(xpath = "//div[text()='Delete Version']")
	WebElement DeleteStory;

	@FindBy(xpath = "//div[text()='Add Collaborators']")
	WebElement ClickOnAddCollaborators;

	@FindBy(xpath = " //div[@class='search-text-email']")
	WebElement AddCollaborators;

	@FindBy(xpath = "//div[text()='Invite']")
	WebElement InviteCollaborators;

	@FindBy(xpath = "//img[@src='images/close.png']")
	WebElement CloseInviteCollaboratorsWindow;

	@FindBy(xpath = "//div[@class='activityCommentsToggle activityStreamOpenButton']")
	WebElement activityStream;

	@FindBy(xpath = "//div[@class='timelineAddCommentOptions']")
	WebElement addCommentOption;

	@FindBy(xpath = "//img[@title='Add Comment']")
	WebElement addComment;

	@FindBy(xpath = "//textarea[@class='commentBoxTextarea broadcastInputTextArea']")
	WebElement EnterComment;

	@FindBy(xpath = "//div[@class='inlineSubmitButton']")
	WebElement submitComment;

	@FindBy(xpath = "//div[@class='activityStreamInputTextArea broadcastInputTextPlaceholder']")
	WebElement addComment1;

	@FindBy(xpath = "//textarea[@class='commentBoxTextarea broadcastInputTextArea']")
	WebElement textArea;

	@FindBy(xpath = "//div[@class='simpleToolbarButtonClose']")
	WebElement Cls;

	@FindBy(xpath = "//input[@class='search-people-search-box-inline']")
	WebElement sharePublStory;

	@FindBy(xpath = "//div[text()='Administrators']")
	WebElement SelectAdmin;

	@FindBy(xpath = "//div[text()='Submit']")
	WebElement Submit;

	@FindBy(xpath = "//img[@src='images/story/favourite-white-native.svg']")
	WebElement Favorite;

	@FindBy(xpath = "//div[text()='My Favorites']")
	WebElement MyFavorite;

	@FindBy(xpath = "//div[@class='btn-container btn-flat btn-transparent shareButtonContainer']")
	WebElement Share;

	@FindBy(xpath = "//textarea[@class='broadcastInput broadcastInputFull']")
	WebElement TextArea;

	@FindBy(xpath = "//div[text()='Follow']")
	WebElement Follow;

	@FindBy(xpath = "//div[@class='btn-container btn-flat btn-native_darkGrey-rollover_veryDarkGrey followUserButton']")
	WebElement Following;

	@FindBy(xpath = "//div[text()='User Access']")
	WebElement UserAccess;

	@FindBy(xpath = "//input[@class='search-people-search-box-inline']")
	WebElement UserAccess1;

	@FindBy(xpath = "//div[@class='btn-container btn-flat btn-blue' and text()='Save']")
	WebElement ClickOnSave;

	@FindBy(xpath = "//div[@class='btn-container btn-flat btn-native_white-rollover_veryLightGrey likeButtonInnerContainer']")
	WebElement ClickOnLike;

	@FindBy(xpath = "//td[@class='likeCounter']")
	WebElement LikeCounter;

	@FindBy(xpath = "//div[@class='confirmationButtonText' and contains(text(),'Get Started')]")
	WebElement ConfirmButton;

	@FindBy(xpath = "//div[@class='simpleToolbarButtonClose']")
	WebElement CloseStoryPage;

	@FindBy(xpath = "//div[text()='Edit Story']")
	WebElement EditStory;

	@FindBy(xpath = "//div[@class='search-text']")
	WebElement Select;

	@FindBy(xpath = "//div[@class='confirmationCheckboxLabel' and text()='Got it!']")
	WebElement GotIt;

	@FindBy(xpath = "//div[@class='btn-container btn-flat btn-blue-primary btn-standard' and text() = 'Approval Required']")
	WebElement ClickApprovalRequired;

	@FindBy(xpath = "//div[@class='btn-container btn-flat btn-purple' and text()='Approve']")
	WebElement ClickApprove;

	@FindBy(xpath = "//div[@class='storyIntroductionPopupContainer']")
	WebElement StoryContainer;

	@FindBy(xpath = "//div[text()='Delete']")
	WebElement DeleteVersion;

	@FindBy(xpath = "//div[@class='broadcastInputTextPlaceholder' and text()='Give this Story a description.']")
	WebElement StoryDescription;

	@FindBy(xpath = "//input[@class='search-people-search-box-inline']")
	WebElement ClickonSearch;

	@FindBy(xpath = "//div[@class='search-results']")
	WebElement SelectRecipient;

	@FindBy(xpath = "//div[@class='storyIntroductionPopupContainer']")
	WebElement StoryPopUp;

	@FindBy(xpath = "//img[@src='images/close_large_white.png']")
	WebElement Close;

	@FindBy(xpath = "//div[text()='Publish']")
	WebElement Save1;

	@FindBy(xpath = "(//div[text()='Publish'])[2]")
	WebElement Save2;

	@FindBy(xpath = "//div[@class='yfDropMenuTitle' and text()='Preview']")
	WebElement Preview;

	@FindBy(xpath = "//div[@class='previewText']")
	WebElement ValidatePreview;

	@FindBy(xpath = "//div[@class='reportChart']")
	WebElement HoverOverChart;

	@FindBy(xpath = "//span[@title='Display table']")
	WebElement DisplayTable;

	@FindBy(xpath = "//span[@title='Maximize']")
	WebElement MaximizeReport;

	@FindBy(xpath = "(//span[@title='Original size'])[1]")
	WebElement OrignalSize;

	@FindBy(xpath = "//span[@title='Wide']")
	WebElement Wide;

	@FindBy(xpath = "//span[@title='Display chart']")
	WebElement DisplayTitle;

	@FindBy(xpath = "//img[@class='graf-image']")
	WebElement HoveOnImage;

	@FindBy(xpath = "//div[@title='Region Profit Summary']//preceding-sibling::div[@class='thumbnailImageContainer']")
	WebElement AddRegionProfitSummaryReport;

	@FindBy(xpath = "//div[@class='chartSelectionItem']")
	WebElement SelectChart;

	@FindBy(xpath = "//div[@id='logoffBtn']")
	WebElement LogOut;

	@FindBy(xpath = "//div[@class='dashButton']")
	WebElement LgOut;

	@FindBy(xpath = "//div[@class='storyIntroductionPopupContainer']")
	WebElement storyIntroductionPopupContainer;

	// Initializing the Page Objects:
	public StoryPage() {
		PageFactory.initElements(driver, this);
	}

	public void ClickFollow() {
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Follow']")));
		Follow.click();

	}

	public void ValidatePreviewPage() {
		String Preview = ValidatePreview.getText();
		assertEquals(Preview, "Preview");
	}

	public void CheckStoryContainer() {
		try {
			if (StoryPopUp.isEnabled()) {
				executor.executeScript("document.getElementsByClassName('confirmationCheckboxLabel')[0].click();",
						GotIt);
				executor.executeScript("document.getElementsByClassName('confirmationButtonText')[0].click();",
						ConfirmButton);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void AddImage()

	{
		AddImagetoHeader.click();
		Image.click();
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void EnterTitle(String Text)

	{
		StoryTitleTextBox.click();
		TitleTextBox.clear();
		TitleTextBox.sendKeys(Text);
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void ClickOnTextBox() {

		wait.until(ExpectedConditions.elementToBeClickable(TextBox));
		TextBox.click();
	}

	public void AddVideoLink(String link) {
		TextBox.click();
		TextBox.sendKeys(link);
	}

	public void ClickOnCloseMenu() {

		executor.executeScript("document.getElementsByClassName('tooltip-icon dante-icon-plus')[0].click();",
				CloseMenu);
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void AddAnImage() {

		executor.executeScript("document.getElementsByClassName('tooltip-icon dante-icon-image')[0].click();",
				AddanImage);
	}

	public void InsertAnImage() {

		InsertImage.click();
	}

	public void ClickOnAddButton() {
		try {
			AddButton.click();
		}

		catch (Exception e) {
			e.getMessage();
		}

	}

	public void ClickOnWide() {

		actions.moveToElement(HoveOnImage).build().perform();
		actions.click(Wide).build().perform();
	}

	public void ClickOnAddReport() {
		AddaReport.click();
	}

	public void updateQuery() {

		try {

			String username = "sa";
			String password = "toolkit";
			String updatequery = "delete from [PersonFavourite] where [FavouriteTypeCode] = 'USERCONNECTION'";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://10.10.10.14:1433;databaseName=yellowfinstoryv8bijinandchris", username, password);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(updatequery);
			con.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void AddVideo() {

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 15);
		 * wait.until(ExpectedConditions.elementToBeClickable(AddaVideo));
		 * AddaVideo.click();
		 */

		executor.executeScript("document.getElementsByClassName('tooltip-icon dante-icon-video')[0].click();",
				AddaVideo);

	}

	public void EnterVideoLink(String link) {

		StringSelection stringSelection = new StringSelection(link);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform();

	}

	public void logout() {

		try {
			Thread.sleep(d);

			executor.executeScript("document.getElementsByClassName('simpleToolbarButtonClose')[0].click();",
					CloseStoryPage);
			Thread.sleep(d);
			LogOut.click();
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void CloseStory() {
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnClose));
		ClickOnClose.click();
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void LogOff() {
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoffBtn")));
		LogOut.click();
	}

	public void PressEnter() {
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public void AddDivider() {
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(AddaDivider));
		 * AddaDivider.click();
		 */
		executor.executeScript("document.getElementsByClassName('tooltip-icon dante-divider')[0].click();",
				AddaDivider);

	}

	public void EnterText(String Data) {
		StringSelection stringSelection = new StringSelection(Data);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform();

	}

	public void SelectAllText() {
		wait.until(ExpectedConditions.elementToBeClickable(TextBox));
		actions.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();

	}

	public void ClickonBold() {
		ClickOnBold.click();
	}

	public void AddReport()

	{
		executor.executeScript("document.getElementsByClassName('tooltip-icon dante-report')[0].click();", AddReport);
		wait.until(ExpectedConditions.elementToBeClickable(SelectReports));
		SelectReports.click();
	}

	public void AddRegionProfitSummaryReport() {
		executor.executeScript("document.getElementsByClassName('tooltip-icon dante-report')[0].click();", AddReport);

		wait.until(ExpectedConditions.elementToBeClickable(AddRegionProfitSummaryReport));
		AddRegionProfitSummaryReport.click();
	}

	public void InsertIntoStory()

	{
		wait.until(ExpectedConditions.elementToBeClickable(InsertIntoStory));
		InsertIntoStory.click();
	}

	public void PublishStory(String folder1, String folder2)

	{
		executor.executeScript(
				"document.getElementsByClassName('btn-container btn-flat btn-yellow-primary btn-standard publishButtonContainer')[0].click();",
				Publish);

		new Select(Select1).selectByVisibleText(folder1);
		new Select(Select2).selectByVisibleText(folder2);
		actions.click(StoryDescription).sendKeys("Description").build().perform();
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		executor.executeScript("document.getElementsByClassName('btn-container btn-flat btn-blue')[0].click();", Save1);
		actions.click(ClickonSearch).build().perform();
		executor.executeScript("document.getElementsByClassName('closeLightboxPopup')[0].click();", Close);
	}

	public void PublishStoryApproval(String folder1, String folder2)

	{
		executor.executeScript(
				"document.getElementsByClassName('btn-container btn-flat btn-yellow-primary')[0].click();", Publish);
		new Select(Select1).selectByVisibleText(folder1);
		new Select(Select2).selectByVisibleText(folder2);
		actions.click(StoryDescription).sendKeys("Description").build().perform();
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		actions.click(TextArea).sendKeys("Approval").build().perform();
		ReqApprv.click();

	}

	public void PublishPrivateStory(String folder1, String folder2)

	{
		executor.executeScript(
				"document.getElementsByClassName('btn-container btn-flat btn-yellow-primary')[0].click();", Publish);
		new Select(Select1).selectByVisibleText(folder1);
		new Select(Select2).selectByVisibleText(folder2);
		actions.click(StoryDescription).sendKeys("Description").build().perform();
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		Private.click();
		UserAccess.click();
		actions.click(UserAccess1).build().perform();
		actions.click(Select).build().perform();
		Save2.click();

	}

	public void PublishPrivateStory1(String folder1, String folder2)

	{
		executor.executeScript(
				"document.getElementsByClassName('btn-container btn-flat btn-yellow-primary')[0].click();", Publish);
		new Select(Select1).selectByVisibleText(folder1);
		new Select(Select2).selectByVisibleText(folder2);
		actions.click(StoryDescription).sendKeys("Description").build().perform();
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		Private.click();
		Save2.click();

	}

	public void PublishStoryinSecureFolder(String folder1, String folder2)

	{
		executor.executeScript(
				"document.getElementsByClassName('btn-container btn-flat btn-yellow-primary')[0].click();", Publish);
		new Select(Select1).selectByVisibleText(folder1);
		new Select(Select2).selectByVisibleText(folder2);
		actions.click(StoryDescription).sendKeys("Description").build().perform();
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Save2.click();

	}

	public void AssignCollaborators()

	{
		try {
			Thread.sleep(d);
			executor.executeScript(
					"document.getElementsByClassName('btn-container btn-flat btn-blue-primary btn-standard btn-white-outline')[0].click();",
					More);
			executor.executeScript("document.getElementsByClassName('yfDropMenuTitle')[1].click();", Collaborators);
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnAddCollaborators));
			ClickOnAddCollaborators.click();
			AddCollaborators.click();
			InviteCollaborators.click();
			CloseInviteCollaboratorsWindow.click();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void BrowseStories()

	{
		try {
			Thread.sleep(d);
			executor.executeScript(
					"document.getElementsByClassName('btn-container btn-flat btn-blue-primary btn-standard btn-white-outline')[0].click();",
					More);

			executor.executeScript("document.getElementsByClassName('yfDropMenuTitle')[2].click();", BrowseStories);
			// clickElement("yfDropMenuTitle", "Browse Stories");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickElement(String classNames, String text) {

		String js = "var elements = document.getElementsByClassName('" + classNames + "'); ";
		js += "for (var i = 0; i < elements.length; i++) { ";
		js += "if (elements[i].innerText == " + text + ") { ";
		js += "elements[i].click();";
		js += " } ";
		js += " } ";

		executor.executeScript(js, text);
	}

	public void BrowseStories1()

	{
		try {
			executor.executeScript(
					"document.getElementsByClassName('btn-container btn-flat btn-blue-primary btn-standard btn-white-outline')[0].click();",
					More);
			Thread.sleep(d);
			executor.executeScript("document.getElementsByClassName('yfDropMenuTitle')[1].click();", BrowseStories);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DeleteStory()

	{
		executor.executeScript(
				"document.getElementsByClassName('btn-container btn-flat btn-blue-primary btn-standard btn-white-outline')[0].click();",
				More);
		executor.executeScript("document.getElementsByClassName('yfDropMenuTitle')[3].click();", DeleteStory);
		executor.executeScript(
				"document.getElementsByClassName('btn-container btn-flat btn-blue-primary btn-standard acceptBtnContainer')[0].click();",
				DeleteVersion);

	}

	public void SendMessagestoActivityStream()

	{
		executor.executeScript(
				"document.getElementsByClassName('activityCommentsToggle activityStreamOpenButton')[0].click();",
				activityStream);
		executor.executeScript("document.getElementsByClassName('timelineAddCommentOptions')[0].click();",
				addCommentOption);
		executor.executeScript(
				"document.getElementsByClassName('timelineAddNewComment timelineAddNewOption')[0].click();",
				addComment);
		executor.executeScript(
				"document.getElementsByClassName('activityStreamInputTextArea broadcastInputTextPlaceholder')[0].click();",
				addComment1);
		executor.executeScript(
				"document.getElementsByClassName('nicEdit-main editableDivTextArea')[0].innerHTML = \"Test Comment\";",
				EnterComment);
		executor.executeScript("document.getElementsByClassName('nicEdit-main editableDivTextArea')[0].click();",
				EnterComment);
		executor.executeScript(
				"document.getElementsByClassName('commentBoxTextarea broadcastInputTextArea')[0].value = \"Test Comment\";",
				textArea);
		executor.executeScript("document.getElementsByClassName('inlineSubmitButton')[0].click();", submitComment);
	}

	public void shareStory()

	{
		executor.executeScript("document.getElementsByClassName('btn-container btn-flat btn-transparent')[0].click();",
				Share);
		actions.click(sharePublStory).build().perform();
		actions.click(SelectAdmin).build().perform();
		actions.click(Submit).build().perform();
	}

	public void ClickMyFavorite() {
		MyFavorite.click();
	}

	public void ClosetheStoryPage() {
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("simpleToolbarButtonClose")));
		executor.executeScript("document.getElementsByClassName('simpleToolbarButtonClose')[0].click();",
				CloseStoryPage);
	}

	public void ValidateFollowing() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(700, 500);
		String Var1 = Following.getText();
		assertEquals(Var1, "Following");
	}

	public void LikeStory() {
		ClickOnLike.click();
	}

	public void ValidateLikeCount() {
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String LikeCount = (LikeCounter).getText();
		assertEquals(LikeCount, "1");
		System.out.println(LikeCount);
	}

	public String getString() {
		String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder s = new StringBuilder();
		Random rnd = new Random();
		while (s.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * CHARS.length());
			s.append(CHARS.charAt(index));
		}
		String Str = s.toString();
		return Str;
	}

	public void ValidateStory(String name) {

		try {
			List<WebElement> listItems = driver.findElements(By.className("browseList"));
			for (int i = 0; i < listItems.size(); i++) {
				if (listItems.get(i).getText().contains(name)) {
					System.out.println("System displays the Story");
				} else {
					System.out.println("System does not display the story");
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ConfirmButton() {
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmButton));
		ConfirmButton.click();
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void Preview() {
		executor.executeScript(
				"document.getElementsByClassName('btn-container btn-flat btn-blue-primary btn-standard btn-white-outline')[0].click();",
				More);
		executor.executeScript("document.getElementsByClassName('yfDropMenuTitle')[0].click();", Preview);

	}

	public void GotIt() {
		wait.until(ExpectedConditions.elementToBeClickable(GotIt));
		GotIt.click();
	}

	public void ClickApprovalReq() {
		executor.executeScript(
				"document.getElementsByClassName('btn-container btn-flat btn-blue-primary btn-standard')[0].click();",
				ClickApprovalRequired);
		executor.executeScript("document.getElementsByClassName('btn-container btn-flat btn-purple')[0].click();",
				ClickApprove);
	}

	public void ClickFavourite() {
		executor.executeScript(
				"document.getElementsByClassName('btn-container btn-flat btn-transparent favouriteButtonContainer')[0].click();",
				Favorite);
	}

	public void EditStory() {
		executor.executeScript(
				"document.getElementsByClassName('btn-container btn-flat btn-black-primary btn-standard btn-white-outline')[1].click();",
				EditStory);
	}

	public void DisplayChart() {
		actions.moveToElement(HoverOverChart).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(DisplayTitle));
		DisplayTitle.click();

	}

	public void SelectChart() {
		wait.until(ExpectedConditions.elementToBeClickable(SelectChart));
		actions.click(SelectChart).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(InsertIntoStory));
		InsertIntoStory.click();

	}

	public String captureScreenShot(String vfileName) throws InterruptedException

	{

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(workingDir + "\\Screenshots\\" + vfileName + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		return vfileName;

	}

	public void DisplayTable() {
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		actions.moveToElement(HoverOverChart).build().perform();
		DisplayTable.click();
	}

	public void MaximizeReport() {

		actions.moveToElement(HoverOverChart).build().perform();
		MaximizeReport.click();
	}

	public void OrignalSize() {
		actions.moveToElement(HoverOverChart).build().perform();
		OrignalSize.click();
	}
}
