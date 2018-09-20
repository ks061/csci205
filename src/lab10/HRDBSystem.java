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

import java.text.ParseException;
import java.util.ArrayList;

/**
 * HRDBSystem simulates an HR Database System, including entering in and looking
 * up people in the HR database.
 *
 * @author Kartikeya Sharma
 */
public class HRDBSystem {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {

        ArrayList<Manager> mgrList = new ArrayList<>();
        ArrayList<Employee> empList = new ArrayList<>();

        mgrList.add(new Manager(0, "Keith", "Buffinton", 101010101,
                                Employee.strToDate("2010-08-20"),
                                150000, "ENGINEERING"));
        mgrList.add(new Manager(1, "Mick", "Smyer", 121230103,
                                Employee.strToDate(
                                        "2001-02-19"), 1000000, "ADMIN"));
        empList.add(new Employee(1, "Brian", "King", 123456789,
                                 Employee.strToDate("2010-08-20"),
                                 60000));
        empList.add(new Employee(2, "Jane", "Smith", 402040302,
                                 Employee.strToDate("2011-07-02"), 60000));
        empList.add(new Employee(201, "Meredith", "Jones", 111111111,
                                 Employee.strToDate("1989-02-10"), 60000));
        empList.add(new Employee(4, "Robert", "Randolph", 891929323,
                                 Employee.strToDate("2012-04-20"), 60000));
        empList.add(new Employee(0, "James", "Hendrix", 549829402,
                                 Employee.strToDate("1966-03-01"), 60000));
        empList.add(new Employee(200, "Florence", "Machine", 149285729,
                                 Employee.strToDate("2014-12-01"), 60000));

        for (Manager m : mgrList) {
            System.out.println(m);
        }
        for (Employee e : empList) {
            System.out.println(e);
        }
    }

}
