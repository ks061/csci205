/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 18, 2018
 * Time: 7:59:21 PM
 *
 * Project: csci205
 * Package: lab09
 * File: CashRegisterTest
 * Description:
 *
 * ****************************************
 */
package lab09;

import java.util.LinkedList;
import junit.framework.TestCase;

/**
 *
 * @author Kartikeya Sharma
 */
public class CashRegisterTest extends TestCase {

    /**
     * How close two doubles must be within to be considered equal
     */
    static final double EPSILON = 1.0E-12;

    private CashRegister instance;
    private CashRegister other_instance;

    public CashRegisterTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        instance = new CashRegister();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        instance = null;
    }

    /**
     * Test of getPurchaseCount method, of class CashRegister.
     */
    public void testGetPurchaseCount() {
        System.out.println("getPurchaseCount");

        // Test the initial state. It should have NO items
        assertEquals(0, instance.getPurchaseCount());

        // Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        int expResult = 2;
        int result = instance.getPurchaseCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfPurchases method, of class CashRegister.
     */
    public void testGetListOfPurchases() {
        System.out.println("getListOfPurchases");

        // Test the initial state. It should have NO items
        assertTrue(
                instance.getListOfPurchases().equals(new LinkedList()));

        // Now, set up a test for 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        LinkedList<Double> expResult = new LinkedList();
        expResult.add(0.55);
        expResult.add(1.27);
        LinkedList<Double> result = (LinkedList<Double>) instance.getListOfPurchases();
        assertTrue(
                expResult.equals(result));
    }

    /**
     * Test of getTransactionTotal method, of class CashRegister.
     */
    public void testGetTransactionTotal() {
        System.out.println("getTransactionTotal");
        assertEquals(0, instance.getTransactionTotal(), EPSILON);

        // Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        double expResult = 1.82;
        double result = instance.getTransactionTotal();
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test of getPaymentCollected method, of class CashRegister.
     */
    public void testGetPaymentCollected() {
        System.out.println("getPaymentCollected");
        assertEquals(0.0, instance.getPaymentCollected());

        // Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);

        // Has not paid yet, so amount paid should still 0
        assertEquals(0.0, instance.getPaymentCollected());

        //
        instance.collectPayment(Money.PENNY, 0);
        assertEquals(0.0, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.PENNY, 10);
        assertEquals(0.10, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.NICKEL, 0);
        assertEquals(0.10, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.NICKEL, 9);
        assertEquals(0.55, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.DIME, 0);
        assertEquals(0.55, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.DIME, 8);
        assertEquals(1.35, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.QUARTER, 0);
        assertEquals(1.35, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.QUARTER, 7);
        assertEquals(3.1, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.HALF, 0);
        assertEquals(3.1, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.HALF, 6);
        assertEquals(6.1, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.DOLLAR, 0);
        assertEquals(6.1, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.DOLLAR, 5);
        assertEquals(11.1, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.FIVE, 0);
        assertEquals(11.1, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.FIVE, 4);
        assertEquals(31.1, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.TEN, 0);
        assertEquals(31.1, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.TEN, 3);
        assertEquals(61.1, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.TWENTY, 0);
        assertEquals(61.1, instance.getPaymentCollected(), EPSILON);
        instance.collectPayment(Money.TWENTY, 2);
        assertEquals(101.1, instance.getPaymentCollected(), EPSILON);
    }

    /**
     * Test of giveChange method, of class CashRegister.
     */
    public void testGiveChange() {
        System.out.println("giveChange");
        double expResult;
        double result;

        // No change expected to be returned yet
        expResult = 0.0;
        try {
            result = instance.giveChange();
            assertEquals(expResult, result, EPSILON);
        } catch (ChangeException notExpected) {
            fail("Improper giveChange() throwing ChangeException: no paid amount should be expected and no change is due.");
        }

        instance.scanItem(0.55);
        instance.scanItem(1.27);
        instance.collectPayment(Money.FIVE, 2);

        // 2 items scanned ($1.82) and $10 paid; $8.18 expected to be returned
        expResult = 8.18;
        try {
            result = instance.giveChange();
            assertEquals(expResult, result, EPSILON);
        } catch (ChangeException notExpected) {
            fail("Improper giveChange() throwing ChangeException: no paid amount should be expected; customer is owed $8.18");
        }
    }

    /**
     * Test if an IllegalArgumentException is properly thrown in collectPayment
     * method if a negative amount of currency is attempted to be paid at the
     * cash register
     */
    public void testCollectPaymentException() {
        System.out.println("IllegalArgumentException thrown in collectPayment");

        instance.scanItem(0.55);
        instance.scanItem(1.27);

        try {
            instance.collectPayment(Money.HALF, -3);
            fail("Improper collectPayment() not throwing IllegalArgumentException: negative amount of currency is attempted to be paid at the cash register");
        } catch (IllegalArgumentException expected) {
        }
    }

    /**
     * Test if a ChangeException in giveChange method is properly thrown when
     * not enough payment has been collected at the time when the transaction is
     * being finalized (cashier gives back customer change)
     */
    public void testGiveChangeException() {
        System.out.println("ChangeException thrown in giveChange");

        instance.scanItem(0.55);
        instance.scanItem(1.27);
        instance.collectPayment(Money.HALF, 3);

        try {
            instance.giveChange();
            fail("Improper giveChange() not throwing ChangeException: not enough paid");
        } catch (ChangeException expected) {
        }
    }

    /**
     * Test for a scanned item to be a bad scan and throw an
     * IllegalArgumentException.
     */
    public void testScanItemIllegalArgumentException() {
        boolean wasThrown = false;
        try {
            instance.scanItem(-0.5);
            fail("Impropert checking for low scanItem()");
        } catch (IllegalArgumentException expected) {
        }
        try {
            // Now, let's scan for a large value
            instance.scanItem(1.0E6);
            fail("Improper checking for a high scanItem()");
        } catch (IllegalArgumentException expected) {
        }
    }

    /**
     * Test of equals method, of class CashRegister.
     */
    public void testEquals() {
        other_instance = new CashRegister();
        assertTrue(instance.equals(other_instance));
        instance.scanItem(1.34);
        instance.scanItem(7.12);
        instance.collectPayment(Money.DOLLAR, 1);
        assertFalse(instance.equals(other_instance));
        other_instance.scanItem(1.34);
        other_instance.scanItem(7.12);
        other_instance.collectPayment(Money.DOLLAR, 1);
        assertTrue(instance.equals(other_instance));
    }
}
