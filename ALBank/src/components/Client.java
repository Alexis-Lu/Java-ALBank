package components;

// 1.1.1 Creation of the client class

public class Client {

	private String name;
	private String firstname;
	private int clientnumber;

	public Client(String Name, String FirstName) {
		this.name = Name;
		this.firstname = FirstName;
		this.clientnumber++;
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

	// public void createClient()
}
