/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 20, 2018
 * Time: 6:20:33 PM
 *
 * Project: csci205
 * Package: lab11
 * File: HRDBSystem
 * Description: This file contains the HRDBSystem class, which simulates an
 *              HR Database System, including entering in and looking up people
 *              in the HR database.
 *
 * ****************************************
 */
package lab11;

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
     * @throws ManagerException
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
                                 208000));
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

        System.out.println();

        for (Employee e : mgrList) {
            HRUtility.displayManager((Manager) e);
        }

        System.out.println();

        Contractor cont1 = new Contractor(73, "Builder", "Bob", 342942039,
                                          250.00);
        Contractor cont2 = new Contractor(0, "Joe", "Shmoe", 298347923, 40.00);

        System.out.println(cont1);
        System.out.println(cont2);

        System.out.println();

        System.out.println(empList.get(4));
        empList.get(4).raiseSalary(50000);
        empList.get(4).changeName("Tom", "Dunbrack");
        System.out.println(
                "Raised salary by 50k and changed name to Tom Dunbrack. Should now print: 7,Dunbrack,Tom,549829402,1966-03-01,110000.00");
        System.out.println(empList.get(4));

        System.out.println();

        // Create an account
        Account acc = new Account(2000.0);
        System.out.println(acc);
        // Test out a couple of payments, intentionally throwing an exception
        // with the second payment
        try {
            System.out.println("TEST: Printing a check to employee id: "
                               + empList.get(0).getEmpID());
            acc.processCheck(empList.get(0), 10); // 40 hrs + 10 hrs overtime
            System.out.println("TEST: Printing a check to contractor id: "
                               + cont1.getId());
            acc.processCheck(cont1, 4.0001);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        // Verify that funds were debited from the account
        System.out.println(acc);
    }

}
