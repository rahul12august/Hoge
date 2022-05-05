package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import utility.TestSetUp;
import utility.Utils;

public class Dashboard extends TestSetUp{
	public static final Logger log = LogManager.getLogger(Dashboard.class);
	public Dashboard(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		reportStep("Waiting for the Dashboard Page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(btnLogout));
			reportStep("Successfully landed on the Dashboard Page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Dashboard Page", "FAIL");
		}
	}
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement btnLogout;

	public Login clickLogout() {
		try {
			reportStep("Trying to locate Log out  Button", "INFO");
			Utils.click(btnLogout);
			reportStep("Successfully clicked Log out Button", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click Log out Button", "FAIL");
		}
		return new Login(driver,logger);
	}
	
	public Dashboard verifyLogoutButtonIsVisible() {
		reportStep("Trying to locate Log out Button", "INFO");
		boolean presence = Utils.verifyElementPresence(btnLogout);
		if (presence) {
			reportStep("Successfully verified presence of Log out Button", "PASS");
		} else {
			reportStep("Unable to verify presence of Log out Button", "FAIL");
		}
		
		return this;
	}
	
	@FindBy(xpath = "(//a)[1]")
	private WebElement lnkDeposit;
	public Checkout clickDepositLink() {
		try {
			reportStep("Trying to locate Deposit Link", "INFO");
			Utils.click(lnkDeposit);
			reportStep("Successfully clicked Deposit Link", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click Deposit Link", "FAIL");
		}
		return new Checkout(driver,logger);
	}
	
	@FindBy(xpath = "(//a)[2]")
	private WebElement lnkWithdraw;
	public Checkout clickWithDrawLink() {
		try {
			reportStep("Trying to locate WithDraw Link", "INFO");
			Utils.click(lnkWithdraw);
			reportStep("Successfully clicked WithDraw Link", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click WithDraw Link", "FAIL");
		}
		return new Checkout(driver,logger);
	}
	
	@FindBy(xpath = "//td[text()='Balance']/following-sibling::td")
	private WebElement lblBalanceAmount;
	
	public Dashboard getTotalBalance() {
		try {
			reportStep("Trying to locate Total Balance Amount Label", "INFO");
			Utils.getText(lblBalanceAmount);
			reportStep("Successfully fetched Total Balance Amount Label", "PASS");
		} catch (Exception e) {
			reportStep("Unable to fetch Total Balance Amount Label", "FAIL");
		}
		return this;
	}
	
	public Dashboard verifyBalanceIsUpdatedPostTransaction() {
		try {
			reportStep("Trying to locate Total Balance Amount Label", "INFO");
			String previousBalance=Utils.getText(lblBalanceAmount);
			reportStep("Balance before transaction : " +previousBalance, "INFO");
			boolean bool = Utils.explicitWaitForInvisibility(driver, "//td[text()='Balance']/following-sibling::td[text()='"+previousBalance+"']");
			String updatedBalance=Utils.getText(lblBalanceAmount);
			reportStep("Balance after transaction : " +updatedBalance, "INFO");
			System.out.println(updatedBalance);
			reportStep("Successfully verified that balance is updated.", "PASS");
		} catch (Exception e) {
			reportStep("Balance is not updated post transaction", "FAIL");
		}
		return this;
	}
}
