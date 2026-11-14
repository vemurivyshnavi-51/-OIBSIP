package task3_atm_interface;

import java.util.ArrayList;
import java.util.List;

/** A bank account holding a balance, a PIN and its transaction history. */
public class Account {

    private final String userId;
    private final String pin;
    private final String holderName;
    private double balance;
    private final List<Transaction> history = new ArrayList<>();

    public Account(String userId, String pin, String holderName, double openingBalance) {
        this.userId = userId;
        this.pin = pin;
        this.holderName = holderName;
        this.balance = openingBalance;
    }

    public String getUserId() {
        return userId;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getHistory() {
        return history;
    }

    public boolean checkPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    /** Adds money. Returns false for non-positive amounts. */
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        history.add(new Transaction("DEPOSIT", amount, "Cash deposit"));
        return true;
    }

    /** Removes money. Returns false if amount is invalid or funds are insufficient. */
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        history.add(new Transaction("WITHDRAW", amount, "Cash withdrawal"));
        return true;
    }

    /** Sends money to another account and logs it on both. */
    public boolean transferTo(Account recipient, double amount) {
        if (recipient == null || amount <= 0 || amount > balance) {
            return false;
        }
        this.balance -= amount;
        recipient.balance += amount;
        this.history.add(new Transaction("TRANSFER OUT", amount, "To account " + recipient.getUserId()));
        recipient.history.add(new Transaction("TRANSFER IN", amount, "From account " + this.userId));
        return true;
    }
}
