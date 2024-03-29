import java.util.*;
import java.text.*;

public class BankAccount {

    private int pin;
    private long accountNo;
    private double balance;
    private User accountHolder;

    public BankAccount(int pin, long accountNo, User accountHolder) {
        this.pin = pin;
        this.accountNo = accountNo;
        this.balance = 0.0;
        this.accountHolder = accountHolder;
    }

    public int getPin() {
        System.out.println("# LIVEPIN: " + pin);
        return pin;
    }

    public long getAccountNo() {
        System.out.println("# LIVEACCNUM: " + accountNo);
        return accountNo;
    }

    public String getBalance() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(balance);
    }

    public User getAccountHolder() {
        return accountHolder;
    }

    public int deposit(double amount) {
        if (amount <= 0) {
            return ATM.INVALID;
        } else {
            balance = balance + amount;
        }

        return ATM.SUCCESS;
    }

    public int withdraw(double amount) {
        if (amount <= 0) {
            return ATM.INVALID;
        } else if (amount > balance) {
            return ATM.INSUFFICIENT;
        } else {
            balance = balance - amount;
        }

        return ATM.SUCCESS;
    }
}
