package testCases;

import org.testng.annotations.Test;

import pages.Login;
import utility.Constant;
import utility.TestSetUp;
import utility.Utils;

public class TC001_Hoge_Registration extends TestSetUp{
	@Test
	public void verifyErrorMessageInRegistration() {
		reportStep("Verification of Error messages in Registration started","INFO");
		new Login(driver, logger).
		clickSignUp().
		clickSignUp().
		verifyBlankUserNameErrorMessage().
		enterUserName(Constant.WHITE_SPACE_USERNAME).
		clickSignUp().
		verifyWhitespaceUserNameErrorMessage().
		enterUserName(Constant.USERNAME).
		enterPassword(Constant.LESS_THAN_EIGHT_CHAR).
		clickSignUp().
		verifyErrorMessageForLessThanEightCharPassword().
		enterPassword(Constant.MORE_THAN_THIRTY_TWO_CHAR).
		clickSignUp().
		verifyErrorMessageForMoreThanThirtyTwoCharPassword().
		enterPassword(Constant.ONLY_ALPHABET_CHAR).
		clickSignUp().
		verifyErrorMessagePasswordNotContainingNumber().
		enterPassword(Constant.ONLY_LOWER_CASE_CHAR).
		clickSignUp().
		verifyErrorMessagePasswordNotContainingUpperCase();
		reportStep("Verification of Error message in Registration finished","PASSED");
	}
	
	@Test
	public void verifyErrorMessageWhenUserNameisEmptyDuringRegistration() {
		new Login(driver, logger).
		clickSignUp().
		clickSignUp().
		verifyBlankUserNameErrorMessage();
	}
	
	@Test
	public void verifyErrorMessageWhenUserNameHasWhiteSpaces() {
		new Login(driver, logger).
		clickSignUp().
		enterUserName(Constant.WHITE_SPACE_USERNAME).
		clickSignUp().
		verifyWhitespaceUserNameErrorMessage();
	}
	
	@Test
	public void verifyErrorMessageWhenPasswordHasLessThanEightChar() {
		new Login(driver, logger).
		clickSignUp().
		enterUserName(Constant.USERNAME).
		enterPassword(Constant.LESS_THAN_EIGHT_CHAR).
		clickSignUp().
		verifyErrorMessageForLessThanEightCharPassword();
	}
	@Test
	public void verifyErrorMessageWhenPasswordHasMoreThanThirtyTwoChar() {
		new Login(driver, logger).
		clickSignUp().
		enterUserName(Constant.USERNAME).
		enterPassword(Constant.MORE_THAN_THIRTY_TWO_CHAR).
		clickSignUp().
		verifyErrorMessageForMoreThanThirtyTwoCharPassword();
	}
	
	@Test
	public void verifyErrorMessageWhenPasswordHasOnlyAlphabets() {
		new Login(driver, logger).
		clickSignUp().
		enterUserName(Constant.USERNAME).
		enterPassword(Constant.ONLY_ALPHABET_CHAR).
		clickSignUp().
		verifyErrorMessagePasswordNotContainingNumber();
	}
	
	@Test
	public void verifyErrorMessageWhenPasswordHasNoUpperCaseChar() {
		new Login(driver, logger).
		clickSignUp().
		enterUserName(Constant.USERNAME).
		enterPassword(Constant.ONLY_LOWER_CASE_CHAR).
		clickSignUp().
		verifyErrorMessagePasswordNotContainingUpperCase();
	}
	
	@Test
	public void verifySuccessfulRegistration() {
		new Login(driver, logger).
		clickSignUp().
		enterUserName(Utils.generateRandomString()).
		enterPassword(Constant.PASSWORD).
		clickSignUpSuccess().
		verifyLogoutButtonIsVisible();
	}
	
}
