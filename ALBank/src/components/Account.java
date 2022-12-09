package components;

//1.2.1 Creation of the account class

public abstract class Account {
	protected String label;
	protected Double balance;
	protected static int index;
	protected int accountNumber;
	protected Client client;

	protected Account(String label, Client client) {
		this.label = label;
		this.client = client;
		index++;
		this.accountNumber = index;
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

	public Client getClient() {
		return client;
	}

}
