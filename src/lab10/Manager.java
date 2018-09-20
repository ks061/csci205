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

import java.util.Date;

/**
 * Manager represents a manager, a type of employee.
 *
 * @author Kartikeya Sharma
 */
public class Manager extends Employee {

    /**
     * Department name manager works in
     */
    private String deptName;

    /**
     * Explicit construct to create new manager
     *
     * @param empID - employee ID
     * @param firstName - employee first name
     * @param lastName - employee last name
     * @param ssNum - employee social security number
     * @param hireDate - date employee was hired on
     * @param salary - salary employee receives
     * @param deptName - department manager works in
     */
    public Manager(int empID, String firstName, String lastName, int ssNum,
                   Date hireDate, double salary, String deptName) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.deptName = deptName;
    }

    /**
     * Get the value of deptName
     *
     * @return the value of deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * Set the value of deptName
     *
     * @param deptName new value of deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

}
