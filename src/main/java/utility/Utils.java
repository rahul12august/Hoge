package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	public static void click(WebElement btnSignUp) {
		btnSignUp.click();
	}

	public static boolean verifyElementPresence(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public static void sendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public static String getText(WebElement element) {
		String text= element.getText().toString();
		return text;
	}
	
	public static String generateRandomString() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder(10);

		for (int i = 0; i < 10; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());

			sb.append(AlphaNumericString.charAt(index));
		}
		System.out.print(sb.toString());
		return sb.toString();
	}
	
	public static boolean explicitWaitForInvisibility(WebDriver driver,String xpath) {
		boolean b=true;
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(13,1));
			b=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
			return b;
		}catch(Exception e) {
			e.printStackTrace();
			return b;
		}	
	}

}
