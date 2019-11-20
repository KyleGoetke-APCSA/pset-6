import java.text.NumberFormat;

public class BankAccount {

    private int pin;
    private long accountNo;
    private double balance;
    private User accountHolder;

    public BankAccount(int pin, long accountNo, double balance, User accountHolder) {
        this.pin = pin;
        this.accountNo = accountNo;
        this.balance = balance;
        this.accountHolder = accountHolder;
    }
    public BankAccount(int pin, long accountNo, User accountHolder) {
        this.pin = pin;
        this.accountNo = accountNo;
        this.balance = 0.0;
        this.accountHolder = accountHolder;
    }

    public int getPin() {
        return pin;
    }

    public long getAccountNo() {
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
        } else if ((amount + balance) > 999999999999.99){
        	return ATM.OVERFLOW;
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

    ////////////////////////////////////////////////////////////////////////////
    //                                                                        //
    // Refer to the Simple ATM tutorial to fill in the details of this class. //
    //                                                                        //
    ////////////////////////////////////////////////////////////////////////////

    /*
     * Formats the account balance in preparation to be written to the data file.
     *
     * @return a fixed-width string in line with the data file specifications.
     */

    private String formatBalance() {
        return String.format("%1$15s", balance);
    }

    /*
     * Converts this BankAccount object to a string of text in preparation to
     * be written to the data file.
     *
     * @return a string of text formatted for the data file
     */

    @Override
    public String toString() {
        return String.valueOf(accountNo) +
            String.valueOf(pin) +
            accountHolder.serialize() +
            formatBalance();
    }

}
