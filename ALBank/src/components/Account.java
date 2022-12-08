package components;

//1.2.1 Creation of the account class

public abstract class Account {
	private String label;
	private Double balance;
	private int accountNumber;
	String client;

	protected Account(String Label, String client) {
		this.label = Label;
		this.client = client;
		this.accountNumber++;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

}
