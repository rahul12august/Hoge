package testCases;

import org.testng.annotations.Test;

import pages.Dashboard;
import pages.Login;
import utility.Constant;
import utility.TestSetUp;
import utility.Utils;

public class TC002_Withdraw_Functionality extends TestSetUp{
	@Test
	public void verifyUserIsAbleToWithDrawMoneySuccessfully(){
		reportStep("Verification of Successful Withdraw started","INFO");
		new Login(driver, logger).
		clickSignUp().
		enterUserName(Utils.generateRandomString()).
		enterPassword(Constant.PASSWORD).
		clickSignUpSuccess().
		clickWithDrawLink().
		enterAmount(Constant.TRANSACTION_AMOUNT).
		verifyFeesCharged().
		clickWithDrawButton().
		verifyBalanceIsUpdatedPostTransaction();
		reportStep("Verification of Successful Withdraw completed","PASS");
	}
}
