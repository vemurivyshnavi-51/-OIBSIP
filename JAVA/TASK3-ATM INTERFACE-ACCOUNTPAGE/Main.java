package task3_atm_interface;

/** Entry point: sets up sample accounts and starts the ATM. */
public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();

        // Sample accounts for testing (User ID, PIN, Name, Opening balance)
        bank.addAccount(new Account("1001", "1234", "Alice", 5000.00));
        bank.addAccount(new Account("1002", "4321", "Bob", 3000.00));
        bank.addAccount(new Account("1003", "1111", "Charlie", 10000.00));

        ATM atm = new ATM(bank);
        atm.start();
    }
}
