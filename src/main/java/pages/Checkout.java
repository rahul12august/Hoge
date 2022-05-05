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

import utility.ProjectUtils;
import utility.TestSetUp;
import utility.Utils;

public class Checkout extends TestSetUp{
	public static final Logger log = LogManager.getLogger(Checkout.class);

	public Checkout(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		reportStep("Waiting for the Checkout Page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(lblFeesAmount));
			reportStep("Successfully landed on the Checkout Page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Checkout Page", "FAIL");
		}
	}
	
	@FindBy(xpath="(//span)[4]")
	private WebElement lblFeesAmount;
	
	public Checkout getTotalFeesCharged() {
		try {
			reportStep("Trying to locate Total Fees Charged Amount Label on Checkout Page.", "INFO");
			Utils.getText(lblFeesAmount);
			reportStep("Successfully fetched Total Fees Charged Amount Label on Checkout Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to fetch Total Fees Charged Amount Label on Checkout Page.", "FAIL");
		}
		return this;
	}
	
	public Checkout verifyFeesCharged() {
		try {
			reportStep("Trying to locate Total Fees Charged Amount Label on Checkout Page.", "INFO");
			String expectedFees=ProjectUtils.calculateFees();
			String actualFees=Utils.getText(lblFeesAmount);
			if(expectedFees==actualFees) {
				reportStep("Successfully verified fees charged for the transaction. Expected Fees : "+expectedFees+ " and actual fees = "+ actualFees, "PASS");
			}else {
				reportStep("Fees charged for the transaction is not as expected. Expected Fees : "+expectedFees+ " and actual fees = "+ actualFees + " are not equal.", "PASS");
			}
		} catch (Exception e) {
			reportStep("Unable to fetch Total Fees Charged Amount Label on Checkout Page.", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//button[text()='Withdraw']")
	private WebElement btnWithdraw;
	
	public Dashboard clickWithDrawButton() {
		try {
			reportStep("Trying to locate WithDraw Button on Checkout Page", "INFO");
			Utils.click(btnWithdraw);
			reportStep("Successfully clicked WithDraw Button on Checkout Page", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click WithDraw Button on Checkout Page", "FAIL");
		}
		return new Dashboard(driver,logger);
	}
	
	@FindBy(xpath = "//button[text()='Deposit']")
	private WebElement btnDeposit;
	
	public Dashboard clickDepositButton() {
		try {
			reportStep("Trying to locate Deposit Button on Checkout Page", "INFO");
			Utils.click(btnDeposit);
			reportStep("Successfully clicked Deposit Button on Checkout Page", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click Deposit Button on Checkout Page", "FAIL");
		}
		return new Dashboard(driver,logger);
	}
	
	@FindBy(xpath = "//input")
	private WebElement txtBxAmount;
	public Checkout enterAmount(String amount) {
		try {
			reportStep("Trying to locate amount textbox on Checkout Page", "INFO");
			Utils.sendKeys(txtBxAmount, amount);
			reportStep("Successfully entered \"" +amount+ "\" amount in textbox on Checkout Page", "PASS");
		} catch (Exception e) {
			reportStep("Unable to enter amount in textbox on Checkout Page", "FAIL");
		}
		return this;
	}
	

}
