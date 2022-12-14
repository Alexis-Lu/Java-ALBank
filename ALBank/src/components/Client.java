package components;

// 1.1.1 Creation of the client class

public class Client {

	private String name;
	private String firstname;
	private static int index;
	private int clientnumber;

	public Client(String name, String firstName) {
		this.name = name;
		this.firstname = firstName;
		index++;
		this.clientnumber = index;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public int getClientNumber() {
		return clientnumber;
	}

	public String toString() {
		return this.getName() + " " + this.getFirstName() + " : Client number = " + this.getClientNumber();
	}
}
