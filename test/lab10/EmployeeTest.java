/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 20, 2018
 * Time: 7:28:34 PM
 *
 * Project: csci205
 * Package: lab10
 * File: EmployeeTest
 * Description:
 *
 * ****************************************
 */
package lab10;

import java.text.ParseException;
import junit.framework.TestCase;

/**
 * Employee tests Employee using JUnit
 *
 * @author Kartikeya Sharma
 */
public class EmployeeTest extends TestCase {

    private Employee emp;
    static final double EPSILON = 1.0E-12;

    public EmployeeTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception, ParseException {
        super.setUp();
        emp = new Employee(1, "Brian", "King", 123456789,
                           Employee.strToDate("2010-08-20"),
                           60000);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of changeName method, of class Employee.
     */
    public void testChangeName() {
        System.out.println("changeName");
        emp.changeName("Bryan", "King");
        assertTrue(emp.getFirstName().equals("Bryan"));
        assertTrue(emp.getLastName().equals("King"));
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
                                  Employee.strToDate("2010-08-20"),
                                  60000);
        assertTrue(emp.equals(obj));
    }

}
