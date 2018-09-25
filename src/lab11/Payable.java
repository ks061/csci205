/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 25, 2018
 * Time: 12:05:28 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Payable
 * Description: This file contains the Payable interface, which
 *              is inherited by classes that represent entities that
 *              can be paid/have payment functionality associated with
 *              or compatible with them.
 *
 * ****************************************
 */
package lab11;

/**
 * Payable interface that abstracts the set of functionalities/characteristics
 * an entity that is paid must have.
 *
 * @author Kartikeya Sharma
 */
public interface Payable {

    /**
     * Gets the amount of money that should be paid to the Payable entity based
     * on the number of hours passed in.
     *
     * @param numHrs number of hours to be paid for
     * @return total amount of money paid for <code>numHrs</code> hours worth of
     * work
     */
    double calculatePay(double numHrs);

    /**
     * Gets a string representation of what should be printed in the "Pay To:"
     * field on the check
     *
     * @return string representation of the check payee
     */
    String getPayTo();

    /**
     * Gets a string representation of what should be printed in the memo field
     * on the check
     *
     * @return string representation of the check memo
     */
    String getPayMemo();

}
