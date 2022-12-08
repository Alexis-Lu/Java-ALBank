package components;

public class SavingsAccount extends Account {

	// 1.2.2 Creation of the CurrentAccount and SavingsAccount

	public SavingsAccount(String Label, String client) {
		super(Label, client);
		setLabel(Label);
		this.client = client;
		this.setBalance(0.0);
	}

}
