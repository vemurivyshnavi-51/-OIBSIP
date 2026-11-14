	package task3_atm_interface;
	
	import java.util.List;
	import java.util.Scanner;
	
	/** The ATM machine: login, menu and all user interaction. */
	public class ATM {
	
	    private static final int MAX_LOGIN_ATTEMPTS = 3;
	
	    private final Bank bank;
	    private final Scanner scanner = new Scanner(System.in);
	
	    public ATM(Bank bank) {
	        this.bank = bank;
	    }
	
	    public void start() {
	        System.out.println("=================================");
	        System.out.println("        WELCOME TO THE ATM       ");
	        System.out.println("=================================");
	
	        Account account = login();
	        if (account == null) {
	            System.out.println("Too many failed attempts. Access denied.");
	            return;
	        }
	
	        System.out.println("\nWelcome, " + account.getHolderName() + "!");
	        runMenu(account);
	        System.out.println("\nThank you for using the ATM. Goodbye!");
	    }
	
	    private Account login() {
	        for (int attempt = 1; attempt <= MAX_LOGIN_ATTEMPTS; attempt++) {
	            System.out.print("\nEnter User ID: ");
	            String id = scanner.nextLine().trim();
	            System.out.print("Enter PIN: ");
	            String pin = scanner.nextLine().trim();
	
	            Account account = bank.authenticate(id, pin);
	            if (account != null) {
	                return account;
	            }
	            System.out.println("Invalid User ID or PIN. Attempts left: "
	                    + (MAX_LOGIN_ATTEMPTS - attempt));
	        }
	        return null;
	    }
	
	    private void runMenu(Account account) {
	        boolean running = true;
	        while (running) {
	            System.out.println("\n------------- MENU -------------");
	            System.out.println("1. Transaction History");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Deposit");
	            System.out.println("4. Transfer");
	            System.out.println("5. Quit");
	            System.out.print("Choose an option (1-5): ");
	
	            String choice = scanner.nextLine().trim();
	            switch (choice) {
	                case "1":
	                    showHistory(account);
	                    break;
	                case "2":
	                    withdraw(account);
	                    break;
	                case "3":
	                    deposit(account);
	                    break;
	                case "4":
	                    transfer(account);
	                    break;
	                case "5":
	                    running = false;
	                    break;
	                default:
	                    System.out.println("Invalid option. Please choose 1-5.");
	            }
	        }
	    }
	
	    private void showHistory(Account account) {
	        List<Transaction> history = account.getHistory();
	        System.out.println("\n--- Transaction History ---");
	        if (history.isEmpty()) {
	            System.out.println("No transactions yet.");
	        } else {
	            for (Transaction t : history) {
	                System.out.println(t);
	            }
	        }
	        System.out.printf("Current balance: Rs. %.2f%n", account.getBalance());
	    }
	
	    private void withdraw(Account account) {
	        double amount = readAmount("Enter amount to withdraw: ");
	        if (amount <= 0) {
	            return;
	        }
	        if (account.withdraw(amount)) {
	            System.out.printf("Please collect your cash. New balance: Rs. %.2f%n", account.getBalance());
	        } else {
	            System.out.println("Insufficient Funds.");
	        }
	    }
	
	    private void deposit(Account account) {
	        double amount = readAmount("Enter amount to deposit: ");
	        if (amount <= 0) {
	            return;
	        }
	        if (account.deposit(amount)) {
	            System.out.printf("Deposit successful. New balance: Rs. %.2f%n", account.getBalance());
	        }
	    }
	
	    private void transfer(Account account) {
	        System.out.print("Enter recipient User ID: ");
	        String recipientId = scanner.nextLine().trim();
	
	        if (recipientId.equals(account.getUserId())) {
	            System.out.println("You cannot transfer to your own account.");
	            return;
	        }
	        Account recipient = bank.getAccount(recipientId);
	        if (recipient == null) {
	            System.out.println("Recipient account not found.");
	            return;
	        }
	
	        double amount = readAmount("Enter amount to transfer: ");
	        if (amount <= 0) {
	            return;
	        }
	        if (account.transferTo(recipient, amount)) {
	            System.out.printf("Transferred Rs. %.2f to %s. New balance: Rs. %.2f%n",
	                    amount, recipient.getHolderName(), account.getBalance());
	        } else {
	            System.out.println("Insufficient Funds.");
	        }
	    }
	
	    /** Reads a positive amount; returns -1 if the input is invalid. */
	    private double readAmount(String prompt) {
	        System.out.print(prompt);
	        String input = scanner.nextLine().trim();
	        try {
	            double amount = Double.parseDouble(input);
	            if (amount <= 0) {
	                System.out.println("Amount must be greater than zero.");
	                return -1;
	            }
	            return amount;
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid amount. Please enter a number.");
	            return -1;
	        }
	    }
	}
