/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Kartikeya Sharma
* Date: Sep 8, 2018
* Time: 12:53:40 AM
*
* Project: csci205
* Package: lab06
* File: CashRegister
* Description: This file represents the CashRegister class,
               which simulates the properties and functionalities
               of a cash register found in a store as directed
               through the instruction given in the Lab 06
               assignment.
*
* ****************************************
 */
package lab06;

/**
 * CashRegister simulates the properties and functionalities of a cash register
 * found in a store.
 *
 * @author Kartikeya Sharma
 */
public class CashRegister {

    /**
     * The name of the cash drawer
     */
    private String sName;

    /**
     * The amount of cash in the drawer
     */
    private double cashInDrawer;

    /**
     * Is the cash register currently processing a transaction?
     */
    private boolean isInTransaction;

    /**
     * The total amount of the current transaction
     */
    private double transTotal;

    /**
     * The total number of items purchased in this transaction so far
     */
    private int numItemsInTrans = 0;

    /**
     * The total amount of money collected toward the transaction
     */
    private double amountPaid;

    /**
     * Initializes a default, empty cash register
     */
    public CashRegister() {
        this.cashInDrawer = 0;
        this.isInTransaction = false;
        this.transTotal = 0;
        this.numItemsInTrans = 0;
        this.amountPaid = 0;
        this.sName = "Default";
    }

    /**
     * Initializes an empty cash register with a specified name
     *
     * @param sName - the name of the register
     */
    public CashRegister(String sName) {
        this();
        this.sName = sName;
    }

    /**
     * Sets the amount of cash in the drawer with an inputted amount for the
     * given day
     *
     * @param initCash amount of cash the drawer starts with on a given day
     */
    public void startDay(double initCash) {
        this.cashInDrawer = initCash;
    }

    /**
     * Resets the amount of cash in the drawer on a given day to 0 and returns
     * the amount of cash in the drawer prior to the reset
     *
     * @return Amount of cash left in the drawer at the end of a given day
     */
    public double finishDay() {
        double cashInDrawerDayEnd = this.cashInDrawer;
        this.cashInDrawer = 0;
        return cashInDrawerDayEnd;
    }

    /**
     * Informs whether or not the cash register is ready to begin another
     * transaction, i.e. there is cash in the drawer and the cash register is
     * not currently processing another transaction, and starts a transaction if
     * the cash register is ready to do so
     *
     * @return true if there is cash in the drawer and the cash register is
     * currently not processing a transaction; otherwise false
     */
    public boolean startTransaction() {
        if (this.cashInDrawer > 0 && this.isInTransaction == false) {
            this.isInTransaction = true;
            return true;
        }
        return false;
    }

    /**
     * Informs whether or not the cash register is ready to end a transaction,
     * i.e. no money is owed for the current transaction and the cash register
     * is currently processing a transaction, and ends a transaction if the cash
     * register is ready to do so
     *
     * @return true if no money is owed for the current transaction and the cash
     * register is currently processing a transaction; otherwise false
     */
    public boolean finishTransaction() {
        if (getAmountOwed() == 0 && this.isInTransaction == true) {
            this.amountPaid = 0;
            this.transTotal = 0;
            this.numItemsInTrans = 0;
            this.isInTransaction = false;
            return true;
        }
        return false;
    }

    /**
     * Adds the inputted price to the total transaction amount and increments
     * the number of items purchased
     *
     * @param amountItem price of the item being scanned
     */
    public void scanItem(double amountItem) {
        this.transTotal += amountItem;
        this.numItemsInTrans++;
    }

    /**
     * Gets the total amount of the current transaction
     *
     * @return total amount of the current transaction
     */
    public double getTransactionTotal() {
        return this.transTotal;
    }

    /**
     * Gets the total number of items in the current transaction
     *
     * @return total number of items in the current transaction
     */
    public int getNumItemsInTrans() {
        return this.numItemsInTrans;
    }

    /**
     * Gets the total amount paid for the current transaction
     *
     * @return total amount paid for the current transaction
     */
    public double getAmountPaid() {
        return this.amountPaid;
    }

    /**
     * Gets the name of the register
     *
     * @return name of the register
     */
    public String getName() {
        return this.sName;
    }

    /**
     * Informs whether or not the cash register is currently processing a
     * transaction
     *
     * @return true if the cash register is currently processing a transaction;
     * otherwise false
     */
    public boolean isInTransaction() {
        return this.isInTransaction;
    }

    /**
     * Gets the amount that is owed for the current transaction
     *
     * @return amount owed for current transaction
     */
    public double getAmountOwed() {
        return this.transTotal - this.amountPaid;
    }

    /**
     * Sets the name of the cash register
     *
     * @param sName name of the cash register
     */
    public void setName(String sName) {
        this.sName = sName;
    }

    /**
     * Processes customer payment towards the current transaction and gets the
     * change due to the customer
     *
     * @param amountPaid amount customer is paying towards the current
     * transaction
     * @return change due to the customer
     */
    public double collectPayment(double amountPaid) {
        this.amountPaid += amountPaid;
        this.cashInDrawer += amountPaid;

        double changeDue = this.amountPaid - this.transTotal;

        if (changeDue > 0) {
            this.amountPaid -= changeDue;
            this.cashInDrawer -= changeDue;
        }

        return changeDue;
    }

    /**
     * Gets a String representation of the cash drawer
     *
     * @return String representation of the cash drawer
     */
    @Override
    public String toString() {
        String output;
        output = this.sName
                 + ":  drawer: $"
                 + String.format("%.2f", this.cashInDrawer)
                 + "  ";
        if (this.isInTransaction == true) {
            output += "CURRENT TRANS: #items: "
                      + this.numItemsInTrans
                      + ", total sale: $"
                      + String.format("%.2f", this.transTotal)
                      + ", amount paid: $"
                      + String.format("%.2f", this.amountPaid);
        }
        else {
            output += "NOT IN TRANSACTION";
        }
        return output;
    }

}
