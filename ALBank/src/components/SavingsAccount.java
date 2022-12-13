package components;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SavingsAccount extends Account {

	// 1.2.2 Creation of the CurrentAccount and SavingsAccount

	public SavingsAccount(String label, Client client) {
		super(label, client);
		setLabel(label);
		this.client = client;
		// this.setBalance(Math.random() * 1000 - 1 + 1, null);
	}

}
