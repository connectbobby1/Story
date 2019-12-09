package Yellowfin.bi.qa.base;


	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Yellowfin.bi.qa.util.TestUtil;

	

	public class TestBase {
		
		public static WebDriver driver;
		public static Properties prop;
		static String workingDir = System.getProperty("user.dir");	
		long d = 3000;
		
		
		
		
		public TestBase(){
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java"
						+ "/Yellowfin/bi/qa/config/config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public static void initialization(){
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "/Users/Drivers/chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "/Users/Drivers/geckodriver.exe");	
				driver = new FirefoxDriver(); 
			}
		
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		
		}
		
			   public String captureScreenShot(String vfileName) throws InterruptedException

			{
				Thread.sleep(d);
				 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
					try {
						FileUtils.copyFile(scrFile, new File(workingDir+ "\\Screenshots\\" + vfileName + ".png"));
							} catch (IOException e) {
								
								e.printStackTrace();
							}
							
					return vfileName;

			}
		
	
	}


