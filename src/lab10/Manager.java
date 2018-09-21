/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 20, 2018
 * Time: 4:59:52 PM
 *
 * Project: csci205
 * Package: lab10
 * File: Manager
 * Description: This file contains the Manager class, a type of Employee.
 *
 * ****************************************
 */
package lab10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum DeptType {
    ENGINEERING, HR, ADMIN, STAFF, OTHER;
}

/**
 * Manager represents a manager, a type of employee.
 *
 * @author Kartikeya Sharma
 */
public class Manager extends Employee {

    /**
     * Department name manager works in
     */
    private DeptType dept;

    /**
     * List of employees that the manager manages
     */
    private ArrayList<Employee> listOfEmps;

    /**
     * Explicit constructor to create new manager with department name inputted
     * as a String
     *
     * @param empID - employee ID
     * @param firstName - employee first name
     * @param lastName - employee last name
     * @param ssNum - employee social security number
     * @param hireDate - date employee was hired on
     * @param salary - salary employee receives
     * @param dept - department manager works in
     */
    public Manager(int empID, String firstName, String lastName, int ssNum,
                   Date hireDate, double salary, String dept) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.dept = DeptType.valueOf(dept);
        listOfEmps = new ArrayList<>();
    }

    /**
     * Explicit constructor to create new manager with department name
     * represented as a DeptType object
     *
     * @param empID - employee ID
     * @param firstName - employee first name
     * @param lastName - employee last name
     * @param ssNum - employee social security number
     * @param hireDate - date employee was hired on
     * @param salary - salary employee receives
     * @param dept - department manager works in
     */
    public Manager(int empID, String firstName, String lastName, int ssNum,
                   Date hireDate, double salary, DeptType dept) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.dept = dept;
        listOfEmps = new ArrayList<>();
    }

    /**
     * Gets the value of deptName
     *
     * @return the value of deptName
     */
    public String getDeptName() {
        return this.dept.name();
    }

    /**
     * Sets the value of deptName
     *
     * @param deptName new value of deptName
     */
    public void setDeptName(String deptName) {
        this.dept = DeptType.valueOf(deptName);
    }

    /**
     * Gets the department type
     *
     * @return department type
     */
    public DeptType getDept() {
        return this.dept;
    }

    /**
     * Sets the department type
     *
     * @param dept new department type
     */
    public void setDept(DeptType dept) {
        this.dept = dept;
    }

    /**
     * Adds an employee that this manager keeps track of
     *
     * @param emp employee to be added to this manager's list
     * @throws ManagerException if <code>emp</code> already exists in the
     * internal list of employees that the manager keeps track of
     */
    public void addEmployee(Employee emp) throws ManagerException {
        if (listOfEmps.contains(emp)) {
            throw new ManagerException(
                    "The inputted employee is already kept track of by the manager");
        }
        else {
            listOfEmps.add(emp);
        }
    }

    /**
     * Gets the list of employees that the manager keeps track of
     *
     * @return list of employees that the manager keeps track of
     */
    public List<Employee> getEmpList() {
        return listOfEmps;
    }

    /**
     * Removes an employee that this manager keeps track of
     *
     * @param emp employee to be removed from the manager's list
     * @throws ManagerException if <code>emp</code> does not already exist in
     * the internal list of employees that the manager keeps track of
     */
    public void removeEmployee(Employee emp) throws ManagerException {
        if (listOfEmps.contains(emp)) {
            listOfEmps.remove(emp);
        }
        else {
            throw new ManagerException(
                    "The inputted employee is not already kept track of by the manager");
        }
    }

    /**
     * Gets the number of employees that the manager keeps track of
     *
     * @return number of employees that the manager keeps track of
     */
    public int numEmployees() {
        return listOfEmps.size();
    }

    /**
     * Returns a string representation of the manager
     *
     * @return a string representation of the manager
     */
    @Override
    public String toString() {
        return super.toString() + ",MANAGER," + this.getDeptName();
    }

    /**
     * Prints a formatted string representation of each manager, including the
     * manager's first and last name, department name, number of employees the
     * manager tracks, the employee ID number and name of each employee that
     * manager tracks, and the employee ID number and name of the manager
     *
     * @param m - manager whose formatted string representation will be printed
     */
    public static void displayManager(Manager m) {
        System.out.println(
                "Manager:     " + m.getFirstName() + " " + m.getLastName());
        System.out.println("Department:  " + m.getDeptName());
        System.out.println("# Employees: " + m.numEmployees());
        for (Employee e : m.getEmpList()) {
            System.out.print("  ");
            HRUtility.displayEmployee(e);
        }
        HRUtility.displayEmployee(m);
    }

}
