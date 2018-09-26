/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 25, 2018
 * Time: 1:24:49 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Account
 * Description: This file contains Account, which is a generalized cash account
 *              that handles paying Payable objects.
 *
 * ****************************************
 */
package lab11;

/**
 * Checked exception representing any issues that might arise from the Account
 * class, including there not being enough funds to withdraw a particular amount
 * of money from the existing balance
 */
class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

/**
 * Account is a generalized cash account that handles paying Payable objects.
 *
 * @author Kartikeya Sharma
 */
public class Account {

    /**
     * Private instance field that stores the balance of the cash account
     */
    private double balance;

    /**
     * Explicit constructor that initializes the Account with a starting cash
     * balance
     *
     * @param initBalance starting cash balance to initialize an account with
     */
    public Account(double initBalance) {
        this.balance = initBalance;
    }

    /**
     * Gets the balance of this cash account
     *
     * @return balance of this cash account
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Adds a requested amount to this account
     *
     * @param amount amount to be added to this account
     */
    public void credit(double amount) {
        this.balance += amount;
    }

    /**
     *
     * @param amount amount to be removed from this account if there are
     * sufficient funds to do so
     * @throws InsufficientFundsException if there are insufficient funds to
     * debit/withdraw <code>amount</code> amount of cash/money.
     */
    public void debit(double amount) throws InsufficientFundsException {
        if (amount > this.balance) {
            throw new InsufficientFundsException(
                    "INSUFFICIENT FUNDS! Required: $" + String.format(
                            "%.2f", amount) + ", Available: $" + String.format(
                            "%.2f", this.balance));
        }
        this.balance -= amount;
    }

    /**
     * Prints a check made out to a payee for the number of hours worked.
     *
     * @param payee person that the check being processed is written for
     * @param hoursBilled number of hours worked by the payee
     * @throws InsufficientFundsException if there are insufficient funds to
     * process the check
     */
    public void processCheck(Payable payee, double hoursBilled) throws InsufficientFundsException {
        double amountOwed = payee.calculatePay(hoursBilled);
        this.debit(amountOwed);
        System.out.println(
                "Pay to:     " + payee.getPayTo() + "\nPay memo:   "
                + payee.getPayMemo() + "\nPay amount: $" + String.format("%.2f",
                                                                         amountOwed));
    }

    /**
     * Gets a string representation of the account with the balance of the
     * account
     *
     * @return string representation of the account with the balance of the
     * account
     */
    @Override
    public String toString() {
        return "Account Balance: $" + String.format("%.2f", this.balance);
    }
}
