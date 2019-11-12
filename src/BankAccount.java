public class BankAccount {

    private int pin;
    private long accountNo;
    private double balance;
    private User accountHolder;

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
