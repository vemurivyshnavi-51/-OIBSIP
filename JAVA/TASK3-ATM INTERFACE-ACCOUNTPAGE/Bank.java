package task3_atm_interface;

import java.util.HashMap;
import java.util.Map;

/** Stores all accounts and handles lookup and authentication. */
public class Bank {

    private final Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getUserId(), account);
    }

    public Account getAccount(String userId) {
        return accounts.get(userId);
    }

    /** Returns the Account if ID and PIN match, otherwise null. */
    public Account authenticate(String userId, String pin) {
        Account account = accounts.get(userId);
        if (account != null && account.checkPin(pin)) {
            return account;
        }
        return null;
    }
}
