package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import utility.TestSetUp;
import utility.Utils;

public class Login extends TestSetUp{
	public static final Logger log = LogManager.getLogger(Login.class);	

	//Constructor for WP_AccountSettingsPage
	public Login(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		reportStep("Waiting for the Login Page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(btnSignUp));
			reportStep("Successfully landed on the Login Page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Login Page", "FAIL");
		} 
	}
	
	@FindBy(xpath="//button[text()='SIGNUP']")
	private WebElement btnSignUp;
	
	public SignUp clickSignUp() {
		try {
			reportStep("Trying to locate Sign Up Button", "INFO");
			Utils.click(btnSignUp);
			reportStep("Successfully clicked Sign Up Button", "PASS");
		}catch(Exception e) {
			reportStep("Unable to click Sign Up Button", "FAIL");
		}
		return new SignUp(driver, logger);
	}
	
	@FindBy(xpath="//button[text()='LOGIN']")
	private WebElement btnLogin;
	
	public Dashboard clickLogin() {
		try {
			reportStep("Trying to locate Login Button", "INFO");
			Utils.click(btnLogin);
			reportStep("Successfully clicked Login Button", "PASS");
		}catch(Exception e) {
			reportStep("Unable to click Login Button", "FAIL");
		}
		return new Dashboard(driver, logger);
	}
	
	@FindBy(xpath = "(//div[text()='Username:']//following-sibling::input)[1]")
	private WebElement txtBxUserName;

	public Login enterUserName(String text) {
		try {
			reportStep("Trying to locate User Name text Box", "INFO");
			Utils.sendKeys(txtBxUserName, text);
			reportStep("Successfully entered " + text + " in User Name text Box", "PASS");
		} catch (Exception e) {
			reportStep("Unable to enter text in User Name text Box", "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//input[@type='password']")
	private WebElement txtBxPassword;

	public Login enterPassword(String password) {
		try {
			reportStep("Trying to locate User Name text Box", "INFO");
			Utils.sendKeys(txtBxPassword, password);
			reportStep("Successfully entered " + password + " in Password text Box", "PASS");
		} catch (Exception e) {
			reportStep("Unable to enter text in Password text Box", "FAIL");
		}
		return this;
	}

}
