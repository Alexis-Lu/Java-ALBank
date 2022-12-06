package main;

import java.util.ArrayList;
import java.util.List;

//1.1.2 Creation of main class for tests

import components.Clients;

public class main {

	public static void main(String[] args) {
		ArrayList listClients = new ArrayList();
		for (int i = 0; i < 3; i++) {
			Clients c = new Clients("Alexis" + (i + 1), "Lu" + (i + 1), i);
			ArrayList client = new ArrayList();
			client.add(c.getName());
			client.add(c.getFirstName());
			listClients.add(client);
		}

		showClientsList(listClients);
	}

	public static void showClientsList(List<ArrayList<String>> listClients) {
		for (Object client : listClients) {
			System.out.println(client.toString());
		}
	}

}
