package main;

import java.util.ArrayList;
import java.util.List;

//1.1.2 Creation of main class for tests

import components.Client;
import components.CurrentAccount;
import components.SavingsAccount;

public class main {

	// 1.1.1 Creation of the Client class

	public static void main(String[] args) {
		ArrayList<String> listClients = new ArrayList<String>();
		ArrayList<String> listAccounts = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			Client c = new Client("Alexis" + (i + 1), "Lu" + (i + 1));
			ArrayList<String> client = new ArrayList<String>();
			client.add(c.getName());
			client.add(c.getFirstName());
			listClients.add(client.toString());
		}
		// 1.2.3 Creation of the tablea account
		showClientsList(listClients);
		listAccounts = loadAccounts(listClients);
		showAccountsList(listAccounts);
	}

	public static void showClientsList(List<String> listClients) {
		for (String client : listClients) {
			System.out.println(client);
		}
	}

	public static void showAccountsList(List<String> listAccounts) {
		for (int i = 0; i < listAccounts.size(); i++) {
			System.out.println(listAccounts.toArray()[i]);
		}
	}

	public static ArrayList<String> loadAccounts(ArrayList<String> listClients) {
		ArrayList<String> listAccounts = new ArrayList<String>();
		for (int i = 0; i < listClients.size(); i++) {
			CurrentAccount cAcc = new CurrentAccount("CurrentAccount", listClients.get(i));
			SavingsAccount sAcc = new SavingsAccount("SavingsAccount", listClients.get(i));
			ArrayList<String> cAccount = new ArrayList<String>();
			cAccount.add(cAcc.getLabel());
			cAccount.add(cAcc.getBalance().toString());
			cAccount.add(listClients.get(i));
			listAccounts.add(cAccount.toString());
			ArrayList<String> sAccount = new ArrayList<String>();
			sAccount.add(sAcc.getLabel());
			sAccount.add(sAcc.getBalance().toString());
			sAccount.add(listClients.get(i));
			listAccounts.add(sAccount.toString());
		}
		return listAccounts;
	}

}
