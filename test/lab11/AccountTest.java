/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 25, 2018
 * Time: 11:31:41 PM
 *
 * Project: csci205
 * Package: lab11
 * File: AccountTest
 * Description: This file contains AccountTest, which tests the Account class.
 *
 * ****************************************
 */
package lab11;

import java.util.Date;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * AccountTest tests the Account class.
 *
 * @author Kartikeya Sharma
 */
public class AccountTest extends TestCase {

    /**
     * Instance variables to be used for each JUnit test
     */
    private Account account;
    private Employee employee;

    /**
     * Maximum allowable error in comparing two decimal numbers
     */
    static final double EPSILON = 1.0E-10;

    /**
     * Explicit constructor to create JUnit test for Account class
     *
     * @param testName - customized name for this instance of AccountTest
     */
    public AccountTest(String testName) {
        super(testName);
    }

    /**
     * Sets up instance fields before each JUnit test
     *
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        account = new Account(500.00);
        employee = new Employee(1, "Joe", "Shmoe", 746182718,
                                new Date(), 20800);
    }

    /**
     * Resets instance fields after each JUnit test
     *
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        account = null;
        employee = null;
    }

    /**
     * Test of credit method, of class Account.
     *
     * @throws InsufficientFundsException
     */
    @Test
    public void testCredit() throws InsufficientFundsException {
        System.out.println("credit");
        account.credit(500);
        assertEquals(1000, account.getBalance(), EPSILON);
    }

    /**
     * Test of debit method, of class Account.
     *
     * @throws InsufficientFundsException
     */
    @Test
    public void testDebit() throws InsufficientFundsException {
        System.out.println("debit");
        account.debit(499);
        assertEquals(1, account.getBalance(), EPSILON);
        try {
            account.debit(1.01);
            fail("Account should not have processed debit transaction because "
                 + "amount requested for the transaction is less than the "
                 + "account balance.");
        } catch (InsufficientFundsException e) {
        }
        assertEquals(1, account.getBalance(), EPSILON);
    }

    /**
     * Test of processCheck method, of class Account.
     *
     * @throws InsufficientFundsException
     */
    @Test
    public void testProcessCheck() throws InsufficientFundsException {
        System.out.println("processCheck");
        account.processCheck(employee, 40);
        assertEquals(100, account.getBalance(), EPSILON);
    }

    /**
     * Tests if processCheck method, of class Account, correctly throws
     * InsufficientFundsException
     *
     * @throws InsufficientFundsException
     */
    @Test(expected = InsufficientFundsException.class)
    public void testProcessCheckInsufficientFundsException() throws InsufficientFundsException {
        System.out.println(
                "processCheck in a manner that should throw an InsufficientFundsException");
        try {
            account.processCheck(employee, 70);
            fail("Insufficient funds to process the test check. Check was for $850, yet account only had $500.");
        } catch (InsufficientFundsException e) {
        }
        assertEquals(500, account.getBalance(), EPSILON);
    }

}
