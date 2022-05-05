package utility;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestSetUp {
	String testName ="";
	String  browser;
	String  deviceName;
	String  version;
	public WebDriver driver=null;
	protected static ExtentReports report=null;
	protected   ExtentTest logger;
	//Initializes  reports
	@BeforeTest(alwaysRun = true)
	public void beforeTest() 
	{
		try {
			// Set HTML reporting file location
			Date objNewDateFolder = new Date();
			SimpleDateFormat dateFormat_Folder = new SimpleDateFormat("yyyy_MM_dd");
			File file = new File(System.getProperty("user.dir") + "/results/" + dateFormat_Folder.format(objNewDateFolder));
			boolean status = file.mkdir();			
			if(status) {
				
				System.out.println("New directory is been created :)  ");
			}
			
			String strDatenow = dateFormat_Folder.format(objNewDateFolder);

			// created result file with time stamp in date folder at results folder
			Date objNewTimeFile = new Date();
			SimpleDateFormat dateFormat_File = new SimpleDateFormat("yyyy_MM_dd @ HH_mm_SS");
			
			report=new ExtentReports(System.getProperty("user.dir") + "/results/" + strDatenow + "/" + dateFormat_File.format(objNewTimeFile) + ".html");
			report.loadConfig(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"extentreport.xml"));

		}catch(Exception e) {
			throw e;
		}
	}
	
		

	@Parameters(value= "browserName")
	@BeforeMethod
	public void openBrowser(Method method, String browserName) throws Exception{
		String osName;//,browserName;
		try{
			testName = method.getName();
			this.logger= report.startTest(testName);
			System.out.println(testName);
			osName=System.getProperty("os.name");
			System.out.println("OS Name is "+osName);
			//browserName="safari";
			if(osName.equals("Linux") && browserName.equals("Chrome")){
						ChromeOptions options= new ChromeOptions();
						options.addArguments("disable-infobars", "--no-sandbox");
						driver = new ChromeDriver(options);
			}		
			else if(osName.startsWith("Windows") && browserName.equals("Chrome")){
						System.setProperty("webdriver.chrome.driver",
								System.getProperty("user.dir")
										+File.separator +"chromedriver.exe");
						ChromeOptions options= new ChromeOptions();
						options.addArguments("disable-infobars", "--no-sandbox");
						driver = new ChromeDriver(options);
			}
			else if(osName.startsWith("Windows") && browserName.equals("Mozilla")){
				System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+File.separator+"geckodriver.exe");	
				 driver = new FirefoxDriver();
			}
			else if(osName.equals("Linux") && browserName.equals("Mozilla")){
				  System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			      driver = new FirefoxDriver();
			}
			else if(osName.equals("Mac OS X") && browserName.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", 
						System.getProperty("user.dir")+File.separator+"chromedriver");
				driver=new ChromeDriver();
			}
			else if(osName.equals("Mac OS X") && browserName.equals("safari")){
				driver=new SafariDriver();
			}
		}catch(Exception e){
			throw e;
		}
		driver.manage().window().maximize();
		driver.get(Constant.BASEURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();		
		//Utils.wait = new WebDriverWait(driver, 2);
	}

	//Quit the browser
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult  result)
	{  
		String base64Screenshot = "";
		if(result.getStatus()==ITestResult.SUCCESS) {

			// Take base64Screenshot screenshot.
			base64Screenshot = "data:image/png;base64,"
					+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			// Extentreports log and screenshot operations for failed tests.
			logger.log(LogStatus.PASS, "Testcase : Passed  ",
					logger.addBase64ScreenShot(base64Screenshot));

		} else if(result.getStatus()==ITestResult.FAILURE) {
			// Take base64Screenshot screenshot.
			base64Screenshot = "data:image/png;base64,"
					+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			// Extentreports log and screenshot operations for failed tests.
			logger.log(LogStatus.FAIL, "Testcase : Failed , Please find the below screenshot ..! ",
					logger.addBase64ScreenShot(base64Screenshot));

		} else if(result.getStatus()==ITestResult.SKIP) {
			// Take base64Screenshot screenshot.
			base64Screenshot = "data:image/png;base64,"
					+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			// Extentreports log and screenshot operations for failed tests.
			logger.log(LogStatus.FAIL, "Testcase : Failed , Please find the below screenshot ..! ",
					logger.addBase64ScreenShot(base64Screenshot));
		}

		driver.quit();
	}

	//closed browser and report object
	@AfterTest(alwaysRun = true)
	public void afterTest() 
	{
		report.flush();
	}

	//LogReport
	public void reportStep(String desc, String status, boolean bSnap)  {

		if(status.trim().equalsIgnoreCase("PASS")) {
			logger.log(LogStatus.PASS, desc);		
		}else if (status.trim().equalsIgnoreCase("FAIL")) {
			logger.log(LogStatus.FAIL, desc);
			throw new RuntimeException();	
		}else if (status.trim().equalsIgnoreCase("SKIP")) {
			logger.log(LogStatus.SKIP, desc);	
		}else if (status.trim().equalsIgnoreCase("INFO")) {
			logger.log(LogStatus.INFO, desc);	
		}else if (status.trim().equalsIgnoreCase("ERROR")) {
			logger.log(LogStatus.FAIL, desc);
		}
	}

	//LogReportHelpermethod
	public void reportStep(String desc, String status) {

		if(status.equalsIgnoreCase("FAIL")) {

			reportStep(desc, status, true);

		} else {
			reportStep(desc, status, false);
		}
	}
}
