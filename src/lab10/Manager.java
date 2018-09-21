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
     * Returns a string representation of the manager
     *
     * @return a string representation of the manager
     */
    @Override
    public String toString() {
        return super.toString() + ",MANAGER," + this.getDeptName();
    }

}
