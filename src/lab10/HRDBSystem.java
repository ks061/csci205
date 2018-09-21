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
 * Description: This file contains the HRDBSystem class, which simulates an
 *              HR Database System, including entering in and looking up people
 *              in the HR database.
 *
 * ****************************************
 */
package lab10;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * HRDBSystem simulates an HR database system, including entering in and looking
 * up employees, printing information about employees, and assigning employees
 * to managers.
 *
 * @author Kartikeya Sharma
 */
public class HRDBSystem {

    /**
     * Simulates an HR database system, including entering in and looking up
     * people in the HR database
     *
     * @param args the command line arguments
     * @throws java.text.ParseException
     * @throws lab10.ManagerException
     */
    public static void main(String[] args) throws ParseException, ManagerException {

        ArrayList<Employee> mgrList = new ArrayList<>();
        ArrayList<Employee> empList = new ArrayList<>();

        mgrList.add(new Manager(0, "Keith", "Buffinton", 101010101,
                                HRUtility.strToDate("2010-08-20"),
                                150000, "ENGINEERING"));

        // Asked to throw IllegalArgumentException in the lab
        try {
            mgrList.add(new Manager(1, "Mick", "Smyer", 121230103,
                                    HRUtility.strToDate(
                                            "2001-02-19"), 1000000, "ADMN"));
        } catch (IllegalArgumentException e) {
        }

        mgrList.add(new Manager(1, "Mick", "Smyer", 121230103,
                                HRUtility.strToDate(
                                        "2001-02-19"), 1000000, "ADMIN"));

        empList.add(new Employee(1, "Brian", "King", 123456789,
                                 HRUtility.strToDate("2010-08-20"),
                                 60000));
        empList.add(new Employee(2, "Jane", "Smith", 402040302,
                                 HRUtility.strToDate("2011-07-02"), 60000));
        empList.add(new Employee(201, "Meredith", "Jones", 111111111,
                                 HRUtility.strToDate("1989-02-10"), 60000));
        empList.add(new Employee(4, "Robert", "Randolph", 891929323,
                                 HRUtility.strToDate("2012-04-20"), 60000));
        empList.add(new Employee(0, "James", "Hendrix", 549829402,
                                 HRUtility.strToDate("1966-03-01"), 60000));
        empList.add(new Employee(200, "Florence", "Machine", 149285729,
                                 HRUtility.strToDate("2014-12-01"), 60000));

        HRUtility.displayEmployees(mgrList);
        HRUtility.displayEmployees(empList);

        ((Manager) mgrList.get(0)).addEmployee(empList.get(0));
        ((Manager) mgrList.get(0)).addEmployee(empList.get(1));
        ((Manager) mgrList.get(0)).addEmployee(empList.get(2));
        ((Manager) mgrList.get(1)).addEmployee(empList.get(3));
        ((Manager) mgrList.get(1)).addEmployee(empList.get(4));
        ((Manager) mgrList.get(1)).addEmployee(empList.get(5));

        for (Employee e : mgrList) {
            HRUtility.displayManager((Manager) e);
        }
    }

}
