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

    public ManagerException(String message) {
        super(message);
    }
}
