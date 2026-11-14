package task3_atm_interface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** A single record of money movement on an account. */
public class Transaction {

    private final String type;        // DEPOSIT, WITHDRAW, TRANSFER OUT, TRANSFER IN
    private final double amount;
    private final String description;
    private final LocalDateTime timestamp;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return String.format("[%s] %-13s Rs. %10.2f  %s",
                timestamp.format(fmt), type, amount, description);
    }
}
