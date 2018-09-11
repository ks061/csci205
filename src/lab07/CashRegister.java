/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 8, 2018
 * Time: 12:53:40 AM
 *
 * Project: csci205
 * Package: lab07
 * File: CashRegister
 * Description: This file represents the CashRegister class,
                which simulates the properties and functionalities
                of a cash register found in a store as directed
                through the instruction given in the Lab 06 and Lab 07
                assignments.
 *
 * ****************************************
 */
package lab07;

import java.util.ArrayList;

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
     * List of all items purchased during the current day (or previous day if
     * the cash register is currently closed)
     */
    private ArrayList<Double> itemList;

    /**
     * List of all transactions during the current day (or previous day if the
     * cash register is currently closed)
     */
    private ArrayList<Double> transList;

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

        this.itemList = new ArrayList<>();
        this.transList = new ArrayList<>();
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
     * Sets the amount of cash in the drawer for the given day
     *
     * @param initCash amount of cash drawer starts with on a given day
     */
    public void startDay(double initCash) {
        this.itemList.clear();
        this.transList.clear();
        this.cashInDrawer = initCash;
    }

    /**
     * Sets the amount of cash in the drawer on a given day to 0 and gets the
     * amount of cash in the drawer (prior to the reset)
     *
     * @return amount of cash left in the drawer at the end of a given day
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
     * @return true if there is cash in the drawer and the cash register is not
     * currently processing a transaction; otherwise false
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
     * is currently processing a transaction, and ends a transaction, including
     * resetting current transaction-specific instance variables, if the cash
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
     * Adds an item to the current transaction
     *
     * @param amountItem price of the item being scanned
     */
    public void scanItem(double amountItem) {
        this.itemList.add(amountItem);
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
     * Gets the total amount paid by the customer for the current transaction
     *
     * @return total amount paid by the customer for the current transaction
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
     * Processes customer payment towards the current transaction, which will be
     * considered complete if enough is paid to cover the total transaction
     * amount, and gets the change due to the customer
     *
     * @param amountPaid amount customer is paying towards the current
     * transaction
     * @return change due to the customer, i.e. positive value if customer
     * overpaid, 0 if customer paid exact amount due, or negative value if
     * customer underpaid
     */
    public double collectPayment(double amountPaid) {
        this.amountPaid += amountPaid;
        this.cashInDrawer += amountPaid;

        double changeDue = this.amountPaid - this.transTotal;

        if (changeDue > 0) {
            this.amountPaid -= changeDue;
            this.cashInDrawer -= changeDue;
        }

        if (changeDue >= 0) {
            this.transList.add(transTotal);
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
                 + ": drawer: $"
                 + String.format("%.2f", this.cashInDrawer)
                 + " ";
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
        output += "\nTODAY: #items: ";
        output += this.itemList.size();
        output += ", #trans: ";
        output += this.transList.size();
        return output;
    }

    /**
     * Outputs the list of all items transacted within the current day to
     * System.out.
     */
    public void displayItemList() {
        System.out.println(
                "Item Log: " + this.itemList.size() + " items purchased today");
        for (double entry : itemList) {
            System.out.println("$" + String.format("%.2f", entry));
        }
    }

    /**
     * Gets the number of items purchased during the current work day
     *
     * @return number of items purchased during current work day
     */
    public int getNumItemsToday() {
        return this.itemList.size();
    }

    /**
     * Gets the average price across all of the items purchased at the cash
     * register during the current work day
     *
     * @return average price across all items purchased at cash register during
     * current work day
     */
    public double getAveItemPurchasedToday() {
        double sumPrices = 0;
        for (double entry : this.itemList) {
            sumPrices += entry;
        }
        return sumPrices / this.getNumItemsToday();
    }

    /**
     * Gets the number of transactions that the register has processed during
     * the current work day
     *
     * @return the number of transactions processed by the register during the
     * current work day
     */
    public int getNumTransToday() {
        return this.transList.size();
    }

    /**
     * Gets the average total transaction amount across the transactions that
     * the register has processed during the current work day
     *
     * @return the average total transaction amount processed by the register
     * during the current work day
     */
    public double getAveTransToday() {
        double sumAmounts = 0;
        for (double entry : this.transList) {
            sumAmounts += entry;
        }
        return sumAmounts / this.transList.size();
    }
}
