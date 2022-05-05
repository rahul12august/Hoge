package testCases;

import org.testng.annotations.Test;

import pages.Login;
import utility.Constant;
import utility.TestSetUp;
import utility.Utils;

public class TC003_Deposit_Functionality extends TestSetUp{
	@Test
	public void verifyUserIsAbleToDepositMoneySuccessfully(){
		reportStep("Verification of Successful Deposit started","INFO");
		new Login(driver, logger).
		clickSignUp().
		enterUserName(Utils.generateRandomString()).
		enterPassword(Constant.PASSWORD).
		clickSignUpSuccess().
		clickDepositLink().
		enterAmount(Constant.TRANSACTION_AMOUNT).
		verifyFeesCharged().
		clickDepositButton().
		verifyBalanceIsUpdatedPostTransaction();
		reportStep("Verification of Successful Deposit completed","PASS");
	}
}
