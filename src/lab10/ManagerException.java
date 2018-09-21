/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 20, 2018
 * Time: 8:51:45 PM
 *
 * Project: csci205
 * Package: lab10
 * File: ManagerException
 * Description: This file contains the ManagerException class, which is an
                exception thrown in the Manager class if an issue arises
 *
 * ****************************************
 */
package lab10;

/**
 * Checked exception representing any issues that might arise from the Manager
 * class
 */
public class ManagerException extends Exception {

    /**
     * Explicit constructor that initializes the ManagerException exception with
     * a custom message
     *
     * @param message custom message to display to the program user when the
     * exception arises
     */
    public ManagerException(String message) {
        super(message);
    }
}
