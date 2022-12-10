package components;

import java.util.Date;

public class Transfer extends Flow {

	// 1.3.3 Creation of the Transfert, Credit, Debit classes

	public Transfer(String comment, int identifier, double amount, int targetAccountNumber, boolean effect,
			Date dateOfFlow, int fromAccountNumber) {
		super(comment, identifier, amount, targetAccountNumber, effect, dateOfFlow);
	}

}
