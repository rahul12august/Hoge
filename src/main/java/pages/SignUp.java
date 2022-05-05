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

public class SignUp extends TestSetUp {
	public static final Logger log = LogManager.getLogger(SignUp.class);

	// Constructor for WP_AccountSettingsPage
	public SignUp(WebDriver driver, ExtentTest logger) {

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		reportStep("Waiting for the Sign Up Page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(btnSignUp));
			reportStep("Successfully landed on the Sign Up Page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Sign Up Page", "FAIL");
		}
	}

	@FindBy(xpath = "//button[text()='SIGNUP']")
	private WebElement btnSignUp;

	public SignUp clickSignUp() {
		try {
			reportStep("Trying to locate Sign Up Button", "INFO");
			Utils.click(btnSignUp);
			reportStep("Successfully clicked Sign Up Button", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click Sign Up Button", "FAIL");
		}
		return this;
	}
	
	public Dashboard clickSignUpSuccess() {
		try {
			reportStep("Trying to locate Sign Up Button", "INFO");
			Utils.click(btnSignUp);
			reportStep("Successfully clicked Sign Up Button", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click Sign Up Button", "FAIL");
		}
		return new Dashboard(driver, logger);
	}

	@FindBy(xpath = "//span[text()='User name cannot be blank']")
	private WebElement lblBlankUserName;

	public SignUp verifyBlankUserNameErrorMessage() {
		reportStep("Trying to locate \"User name cannot be blank\" error message", "INFO");
		boolean presence = Utils.verifyElementPresence(lblBlankUserName);
		if (presence) {
			reportStep("Successfully verified presence of error message \"User name cannot be blank\"", "PASS");
		} else {
			reportStep("Unable to verify presence of error message \"User name cannot be blank\"", "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='User name cannot contain whitespaces']")
	private WebElement lblWhitespaceUserName;

	public SignUp verifyWhitespaceUserNameErrorMessage() {
		reportStep("Trying to locate \"User name cannot contain whitespaces\" error message", "INFO");
		boolean presence = Utils.verifyElementPresence(lblWhitespaceUserName);
		if (presence) {
			reportStep("Successfully verified presence of error message \"User name cannot contain whitespaces\"",
					"PASS");
		} else {
			reportStep("Unable to verify presence of error message \"User name cannot contain whitespaces\"", "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "(//div[text()='Username:']//following-sibling::input)[1]")
	private WebElement txtBxUserName;

	public SignUp enterUserName(String text) {
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

	public SignUp enterPassword(String password) {
		try {
			reportStep("Trying to locate User Name text Box", "INFO");
			Utils.sendKeys(txtBxPassword, password);
			reportStep("Successfully entered " + password + " in Password text Box", "PASS");
		} catch (Exception e) {
			reportStep("Unable to enter text in Password text Box", "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='Password cannot be less than 8 characters']")
	private WebElement lblLessThanEightCharErrorMessage;

	public SignUp verifyErrorMessageForLessThanEightCharPassword() {
		reportStep("Trying to locate \"Password cannot be less than 8 characters\" error message", "INFO");
		boolean presence = Utils.verifyElementPresence(lblLessThanEightCharErrorMessage);
		if (presence) {
			reportStep("Successfully verified presence of error message \"Password cannot be less than 8 characters\"",
					"PASS");
		} else {
			reportStep("Unable to verify presence of error message \"Password cannot be less than 8 characters\"",
					"FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='Password cannot be longer than 32 characters']")
	private WebElement lblMoreThanThirtyTwoCharErrorMessage;

	public SignUp verifyErrorMessageForMoreThanThirtyTwoCharPassword() {
		reportStep("Trying to locate \"Password cannot be longer than 32 characters\" error message", "INFO");
		boolean presence = Utils.verifyElementPresence(lblMoreThanThirtyTwoCharErrorMessage);
		if (presence) {
			reportStep(
					"Successfully verified presence of error message \"Password cannot be longer than 32 characters\"",
					"PASS");
		} else {
			reportStep("Unable to verify presence of error message \"Password cannot be longer than 32 characters\"",
					"FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//span[text()='Password must contain numbers']")
	private WebElement lblPasswordMustContainNumberErrorMessage;

	public SignUp verifyErrorMessagePasswordNotContainingNumber() {
		reportStep("Trying to locate \"Password must contain numbers\" error message", "INFO");
		boolean presence = Utils.verifyElementPresence(lblPasswordMustContainNumberErrorMessage);
		if (presence) {
			reportStep(
					"Successfully verified presence of error message \"Password must contain numbers\"",
					"PASS");
		} else {
			reportStep("Unable to verify presence of error message \"Password must contain numbers\"",
					"FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//span[text()='Password must contain uppercase letters']")
	private WebElement lblPasswordMustContainUpperCaseErrorMessage;

	public SignUp verifyErrorMessagePasswordNotContainingUpperCase() {
		reportStep("Trying to locate \"Password must contain numbers\" error message", "INFO");
		boolean presence = Utils.verifyElementPresence(lblPasswordMustContainUpperCaseErrorMessage);
		if (presence) {
			reportStep(
					"Successfully verified presence of error message \"Password must contain numbers\"",
					"PASS");
		} else {
			reportStep("Unable to verify presence of error message \"Password must contain numbers\"",
					"FAIL");
		}
		return this;
	}
}