package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import components.Account;

//1.1.2 Creation of main class for tests

import components.Client;
import components.CurrentAccount;
import components.SavingsAccount;

public class main {

	public static void main(String[] args) {
		// 1.1.1 Creation of the Client class
		ArrayList<Client> listClients = new ArrayList<Client>();

		listClients = loadClientsList(3);
		showClientsList(listClients);

		// 1.2.3 Creation of the table account

		ArrayList<Account> listAccounts = new ArrayList<Account>();

		listAccounts = loadAccounts(listClients);
		showAccountsList(listAccounts);

		// 1.3.1 Adaptation of the table of accounts
		Map<Integer, Account> accountInfos = new HashMap<>();
		accountInfos = loadHashMap(listAccounts);
		// System.out.println("//////////////////////////////////////");
		showHashMap(accountInfos);
	}

	public static ArrayList<Client> loadClientsList(int nbClient) {
		ArrayList<Client> listClients = new ArrayList<Client>();
		for (int i = 0; i < nbClient; i++) {
			Client c = new Client("Alexis" + (i + 1), "Lu" + (i + 1));
			listClients.add(c);
		}
		return listClients;

	}

	public static void showClientsList(List<Client> listClients) {
		listClients.stream().forEach(s -> System.out.println(s.getName() + ", " + s.getFirstName()));

	}

	public static ArrayList<Account> loadAccounts(ArrayList<Client> listClients) {
		ArrayList<Account> listAccounts = new ArrayList<Account>();
		listClients.forEach(s -> {
			CurrentAccount cAcc = new CurrentAccount("CurrentAccount", s);
			SavingsAccount sAcc = new SavingsAccount("SavingsAccount", s);
			listAccounts.add(cAcc);
			listAccounts.add(sAcc);

		});
		return listAccounts;
	}

	public static void showAccountsList(ArrayList<Account> listAccounts) {

		listAccounts.stream().forEach(s -> {
			System.out.println(s.getLabel() + " : " + s.getClient().getName() + ", " + s.getClient().getName() + " : "
					+ s.getBalance());
		});

	}

	public static Map<Integer, Account> loadHashMap(ArrayList<Account> listAccounts) {
		Map<Integer, Account> accountInfos = new HashMap<Integer, Account>();
		listAccounts.stream().forEach(s -> {
			accountInfos.put(s.getAccountNumber(), s);
		});

		return accountInfos;

	}

	public static void showHashMap(Map<Integer, Account> accountInfos) {
		List<Map.Entry<Integer, Account>> list = new ArrayList<>(accountInfos.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Account>>() {

			@Override
			public int compare(Entry<Integer, Account> o1, Entry<Integer, Account> o2) {
				return (int) (o1.getValue().getBalance() - o2.getValue().getBalance());
			}
		});

		for (Map.Entry<Integer, Account> e : list) {
			System.out.println(e.getKey() + " | " + e.getValue().getClient().getName() + " "
					+ e.getValue().getClient().getFirstName() + " " + e.getValue().getLabel() + " balance = "
					+ e.getValue().getBalance());
		}

	}

}
