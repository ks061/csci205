/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 20, 2018
 * Time: 9:34:34 PM
 *
 * Project: csci205
 * Package: lab11
 * File: ManagerTest
 * Description: This file contains ManagerTests, which tests Manager using JUnit.
 *
 * ****************************************
 */
package lab11;

import java.text.ParseException;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * ManagerTest tests the Manager class
 *
 * @author Kartikeya Sharma
 */
public class ManagerTest extends TestCase {

    /**
     * Manager instance used to test the Manager class
     */
    private Manager mgr;

    /**
     * List of employees added to/removed from the manager list during testing
     */
    private ArrayList<Employee> listOfEmp;

    /**
     * Explicit constructor to create JUnit test for Manager class
     *
     * @param testName - customized name for this instance of ManagerTest
     * @throws ParseException
     */
    public ManagerTest(String testName) throws ParseException {
        super(testName);
        listOfEmp = new ArrayList<>();
    }

    /**
     * Sets up instance fields before each JUnit test
     *
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        listOfEmp.add(new Employee(1, "Brian", "King", 123456789,
                                   HRUtility.strToDate("2010-08-20"),
                                   60000));
        listOfEmp.add(new Employee(2, "Jane", "Smith", 402040302,
                                   HRUtility.strToDate("2011-07-02"), 60000));
        listOfEmp.add(new Employee(201, "Meredith", "Jones", 111111111,
                                   HRUtility.strToDate("1989-02-10"), 60000));
        listOfEmp.add(new Employee(4, "Robert", "Randolph", 891929323,
                                   HRUtility.strToDate("2012-04-20"), 60000));
        listOfEmp.add(new Employee(0, "James", "Hendrix", 549829402,
                                   HRUtility.strToDate("1966-03-01"), 60000));
        listOfEmp.add(new Employee(200, "Florence", "Machine", 149285729,
                                   HRUtility.strToDate("2014-12-01"), 60000));
        mgr = new Manager(0, "Keith", "Buffinton", 101010101,
                          HRUtility.strToDate("2010-08-20"),
                          150000, "ENGINEERING");
        mgr.addEmployee(listOfEmp.get(0));
        mgr.addEmployee(listOfEmp.get(1));
        mgr.addEmployee(listOfEmp.get(2));
    }

    /**
     * Resets instance fields after each JUnit test
     *
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        listOfEmp.clear();
        mgr = null;
    }

    /**
     * Test of addEmployee method, of class Manager.
     *
     * @throws ManagerException
     */
    public void testAddEmployee() throws ManagerException {
        System.out.println("addEmployee");
        assertEquals(3, mgr.getEmpList().size());
        mgr.addEmployee(listOfEmp.get(3));
        assertTrue(mgr.getEmpList().contains(listOfEmp.get(3)));
        assertEquals(4, mgr.getEmpList().size());
    }

    /**
     * Test of getEmpList method, of class Manager.
     *
     * @throws ManagerException
     */
    public void testGetEmpList() throws ManagerException {
        System.out.println("getEmpList");
        assertTrue(mgr.getEmpList().equals(listOfEmp.subList(0, 3)));
        mgr.addEmployee(listOfEmp.get(3));
        assertTrue(mgr.getEmpList().equals(listOfEmp.subList(0, 4)));
        mgr.removeEmployee(listOfEmp.get(0));
        assertTrue(mgr.getEmpList().equals(listOfEmp.subList(1, 4)));
        mgr.removeEmployee(listOfEmp.get(1));
        mgr.removeEmployee(listOfEmp.get(2));
        mgr.removeEmployee(listOfEmp.get(3));
        assertTrue(mgr.getEmpList().equals(new ArrayList<>()));
    }

    /**
     * Test of removeEmployee method, of class Manager.
     *
     * @throws ManagerException
     */
    public void testRemoveEmployee() throws ManagerException {
        System.out.println("removeEmployee");
        assertTrue(mgr.getEmpList().equals(listOfEmp.subList(0, 3)));
        mgr.removeEmployee(listOfEmp.get(2));
        assertTrue(mgr.getEmpList().equals(listOfEmp.subList(0, 2)));
        mgr.removeEmployee(listOfEmp.get(0));
        assertTrue(mgr.getEmpList().equals(listOfEmp.subList(1, 2)));
        mgr.removeEmployee(listOfEmp.get(1));
        assertTrue(mgr.getEmpList().equals(new ArrayList<>()));
    }

    /**
     * Tests to ensure that addEmployee method throws a ManagerException if the
     * employee being added already exists in the manager list
     *
     * @throws ManagerException
     */
    @Test(expected = ManagerException.class)
    public void testAddEmployeeException() throws ManagerException {
        System.out.println("throw ManagerException in addEmployee");
        try {
            mgr.addEmployee(listOfEmp.get(0));
            fail("ManagerException should have been thrown because employee being added already exists in manager list");
        } catch (ManagerException e) {
        }
    }

    /**
     * Tests to ensure that removeEmployee method throws a ManagerException if
     * the employee being removed does not already exist in the manager list
     *
     * @throws ManagerException
     */
    @Test(expected = ManagerException.class)
    public void testRemoveEmployeeException() throws ManagerException {
        System.out.println("throw ManagerException in removeEmployee");
        try {
            mgr.removeEmployee(listOfEmp.get(3));
            fail("ManagerException should have been thrown because employee being removed does not already exist in manager list");
        } catch (ManagerException e) {
        }

    }

}
