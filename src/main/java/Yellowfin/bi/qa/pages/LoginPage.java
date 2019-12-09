package Yellowfin.bi.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Yellowfin.bi.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR:
		@FindBy(name="email")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(id="logonButton")
		WebElement loginButton;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		public LicensePage login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginButton.click();
			return new LicensePage();
		}
		
	}
