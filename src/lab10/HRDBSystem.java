/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 20, 2018
 * Time: 6:20:33 PM
 *
 * Project: csci205
 * Package: lab10
 * File: HRDBSystem
 * Description: This file contains the HRDBSystem class, which simulates an HR Database System, including entering in and looking up people in the HR database.
 *
 * ****************************************
 */
package lab10;

import java.util.Date;

/**
 * HRDBSystem simulates an HR Database System, including entering in and looking
 * up people in the HR database.
 *
 * @author Kartikeya Sharma
 */
public class HRDBSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee emp = new Employee(0, "Brian", "King", 123456789, new Date(),
                                    60000);
        Manager mgr = new Manager(1, "Keith", "Buffinton", 101010101, new Date(),
                                  150000, "ENGINEERING");

        System.out.println(emp);
        System.out.println(mgr);
    }

}
