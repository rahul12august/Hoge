package utility;

import java.text.DecimalFormat;

public class ProjectUtils {
	public static String calculateFees() {
		final DecimalFormat df = new DecimalFormat("0.00");
		int transactionAmount=Integer.parseInt(Constant.TRANSACTION_AMOUNT);
		Double fees=transactionAmount*0.30;
		String feeAmount=df.format(fees).toString();;
		return feeAmount;
	}
}
