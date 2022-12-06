package components;

//1.2.1 Creation of the account class

public abstract class Accounts {
	private String label;
	private Double balance;
	private int accountNumber;
	Client client;

	protected Accounts(String Label, Object Client) {
		this.label = Label;
		this.client = (components.Client) Client;
		this.accountNumber++;

	}

	protected String getLabel() {
		return label;
	}

	protected void setLabel(String label) {
		this.label = label;
	}

	protected Double getBalance() {
		return balance;
	}

	protected void setBalance(Double balance) {
		this.balance = balance;
	}

	protected int getAccountNumber() {
		return accountNumber;
	}

}
