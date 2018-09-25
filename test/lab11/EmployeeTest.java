/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 20, 2018
 * Time: 7:28:34 PM
 *
 * Project: csci205
 * Package: lab11
 * File: EmployeeTest
 * Description: This file contains the EmployeeTest class, which tests Employee
 *              using JUnit.
 *
 * ****************************************
 */
package lab11;

import java.text.ParseException;
import junit.framework.TestCase;

/**
 * EmployeeTest tests Employee using JUnit
 *
 * @author Kartikeya Sharma
 */
public class EmployeeTest extends TestCase {

    /**
     * Employee instance used to test the Employee class
     */
    private Employee emp;

    /**
     * Maximum allowable error in comparing two decimal numbers
     */
    static final double EPSILON = 1.0E-12;

    /**
     * Explicit constructor to create JUnit test for Employee class
     *
     * @param testName - customized name for this instance of EmployeeTest
     */
    public EmployeeTest(String testName) {
        super(testName);
    }

    /**
     * Sets up instance fields before each JUnit test
     *
     * @throws Exception
     * @throws java.text.ParseException
     */
    @Override
    protected void setUp() throws Exception, ParseException {
        super.setUp();
        emp = new Employee(1, "Brian", "King", 123456789,
                           HRUtility.strToDate("2010-08-20"),
                           60000);
    }

    /**
     * Resets instance fields after each JUnit test
     *
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        emp = null;
    }

    /**
     * Test of changeName method, of class Employee.
     */
    public void testChangeName() {
        System.out.println("changeName");
        emp.changeName("Bryan", "Kyng");
        assertTrue(emp.getFirstName().equals("Bryan"));
        assertTrue(emp.getLastName().equals("Kyng"));
    }

    /**
     * Test of raiseSalary method, of class Employee.
     */
    public void testRaiseSalary() {
        System.out.println("raiseSalary");
        double salaryAdj = 1111.0;
        double expResult = 61111.0;
        double result = emp.raiseSalary(salaryAdj);
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test of equals method, of class Employee.
     *
     * @throws java.text.ParseException
     */
    public void testEquals() throws ParseException {
        System.out.println("equals");
        Object obj = new Employee(1, "Brian", "King", 123456789,
                                  HRUtility.strToDate("2010-08-20"),
                                  60000);
        assertEquals(emp, obj);
        obj = new Employee(1, "Brian", "King", 123456798,
                           HRUtility.strToDate("2010-08-20"),
                           60000);
        assertFalse(emp.equals(obj));
    }

}
