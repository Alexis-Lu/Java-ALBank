package components;

// 1.1.1 Creation of the client class

public class Clients {

	private String name;
	private String firstName;
	private int clientNumber;

	public Clients(String Name, String FirstName, int ClientNumber) {
		this.name = Name;
		this.firstName = FirstName;
		this.clientNumber = ClientNumber;
		// System.out.println(this.name);
		// System.out.println(this.firstName);
		// System.out.println(this.clientNumber);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}

	// public void createClient()
}
