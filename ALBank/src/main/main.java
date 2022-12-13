package main;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

//1.1.2 Creation of main class for tests

import components.Account;
import components.Client;
import components.Credit;
import components.CurrentAccount;
import components.Debit;
import components.Flow;
import components.SavingsAccount;
import components.Transfer;

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
		showHashMap(accountInfos);

		// 1.3.4 Creation of the flow array
		ArrayList<Flow> listFlows = new ArrayList<Flow>();
		listFlows = loadFlowList(listAccounts);

		// 1.3.5 Updating accounts
		// updateBalance(listFlows, accountInfos);
		showHashMap(accountInfos);

		// 2.1 JSON file of flows
		updateBalance(createFlowsFromJson(), accountInfos);
		createAccountsFromXml(listClients);

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
			Account cAcc = new CurrentAccount("CurrentAccount", s);
			Account sAcc = new SavingsAccount("SavingsAccount", s);
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

	public static ArrayList<Flow> loadFlowList(ArrayList<Account> listAccounts) {
		ArrayList<Flow> listFlows = new ArrayList<Flow>();
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, 2);
		Date currentDatePlusTwo = c.getTime();
		Flow debit = new Debit("debit", 0, 50, 1, true, currentDatePlusTwo);
		listFlows.add(debit);
		listAccounts.forEach(s -> {
			if (s.getLabel().equals("SavingsAccount")) {
				Flow credit = new Credit("credit", 1, 1500, s.getAccountNumber(), true, currentDatePlusTwo);
				Flow credit2 = new Credit("credit", 1, 100.50, s.getAccountNumber(), true, currentDatePlusTwo);
				listFlows.add(credit);
				listFlows.add(credit2);
			} else {
				Flow credit = new Credit("credit", 1, 100.50, s.getAccountNumber(), true, currentDatePlusTwo);
				listFlows.add(credit);
			}

		});
		Flow transfer = new Transfer("transfer", 2, 50, 2, true, currentDatePlusTwo, 1);
		listFlows.add(transfer);
		System.out.print(listFlows);
		return listFlows;

	}

	public static void updateBalance(ArrayList<Flow> flowList, Map<Integer, Account> accountInfos) {
		flowList.forEach(s -> {
			accountInfos.get(s.getTargetAccountNumber()).setBalance(s);

		});
		Predicate<Double> less_than = x -> x < 0;
		accountInfos.entrySet().forEach(entry -> {
			if (less_than.test(entry.getValue().getBalance())) {
				System.out.println("Negative balance");
			} else {
				System.out.println("ok");
			}
			System.out.println(entry.getKey() + " " + entry.getValue().getBalance());
		});
	}

	public static ArrayList<Flow> createFlowsFromJson() {
		ArrayList<Flow> listFlows = new ArrayList<Flow>();

		File file = new File("src\\files\\Flows.JSON");

		JsonElement fileElement;
		try {
			fileElement = JsonParser.parseReader(new FileReader(file));
			Map<String, Object> retMap = new GsonBuilder().setLenient().create().fromJson(fileElement,
					new TypeToken<HashMap<String, Object>>() {
					}.getType());
			for (Entry<String, Object> mapentry : retMap.entrySet()) {
				if (mapentry.getKey().startsWith("debit")) {
					String json = new Gson().toJson(mapentry.getValue());
					Flow debit = new Gson().fromJson(json, Debit.class);
					listFlows.add(debit);
					System.out.println(debit);
				} else if (mapentry.getKey().startsWith("transfer")) {
					String json = new Gson().toJson(mapentry.getValue());
					Flow transfer = new Gson().fromJson(json, Transfer.class);
					listFlows.add(transfer);
					System.out.println(transfer);
				} else if (mapentry.getKey().startsWith("credit")) {
					String json = new Gson().toJson(mapentry.getValue());
					json.replace("dateOfFlow", json);
					Flow credit = new Gson().fromJson(json, Credit.class);
					listFlows.add(credit);
					System.out.println(credit);
				}

			}
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listFlows;

	}

	public static void createAccountsFromXml(List<Client> listClients) {
		/*
		 * File file = new File("src\\files\\Accounts.xml"); try { JAXBContext
		 * jaxbContext = JAXBContext.newInstance(CurrentAccount.class); Unmarshaller ums
		 * = jaxbContext.createUnmarshaller(); Account acc = (Account)
		 * ums.unmarshal(file); System.out.println(acc.getLabel()); } catch
		 * (JAXBException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		/*
		 * listClients.stream().forEach(s -> {
		 * 
		 * 
		 * });
		 */

		Account cAcc = new CurrentAccount("currentAccount", listClients.get(0));
		try {
			FileOutputStream fos = new FileOutputStream(new File("personn.xml"));
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(cAcc);
			encoder.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
