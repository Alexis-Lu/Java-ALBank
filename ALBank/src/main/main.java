package main;

import java.util.ArrayList;
import java.util.List;

//1.1.2 Creation of main class for tests

import components.Client;

public class main {

	public static void main(String[] args) {
		ArrayList listClients = new ArrayList();
		ArrayList listAccounts = new ArrayList();
		for (int i = 0; i < 3; i++) {
			Client c = new Client("Alexis" + (i + 1), "Lu" + i);
			ArrayList client = new ArrayList();
			client.add(c.getName());
			client.add(c.getFirstName());
			// Accounts a = new Accounts("LaPoste", client, i);
			listClients.add(client);
		}

		showClientsList(listClients);

	}

	public static void showClientsList(List<ArrayList<String>> listClients) {
		for (Object client : listClients) {
			System.out.println(client.toString());
		}
	}

	public static void showAccountsList() {

	}

}
