/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2016
 *
 * TODO - Enter the details below!
 * Name: Kartikeya Sharma
 * Date: September 20, 2018
 * Time: 12:00:14 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Employee
 * Description: A very basic abstraction for an employee in a simple HR system
 * ****************************************
 */
package lab11;

/**
 * A basic representation for an Employee.
 *
 * @author Brian King
 */
import java.util.Date;
import java.util.HashSet;

/**
 * Employee - represents an employee in the database system
 *
 * @author brk009
 */
public class Employee {

    /**
     * List of employee IDs
     */
    private static HashSet<Integer> setOfIds = new HashSet<Integer>();

    /**
     * Instance variables representing particular data attributes of an employee
     */
    private int empID;
    private String firstName;
    private String lastName;
    private int ssNum;
    private Date hireDate;
    private double salary;

    /**
     * Explicit constructor to create new employee
     *
     * @param empID - employee ID
     * @param firstName - employee first name
     * @param lastName - employee last name
     * @param ssNum - employee social security number
     * @param hireDate - date employee was hired on
     * @param salary - salary employee receives
     */
    public Employee(int empID, String firstName, String lastName, int ssNum,
                    Date hireDate, double salary) {
        if (setOfIds.contains(empID) || empID <= 0) {
            this.empID = generateID();
        }
        else {
            this.empID = empID;
        }
        setOfIds.add(this.empID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    /**
     * Gets employee ID
     *
     * @return employee ID
     */
    public int getEmpID() {
        return empID;
    }

    /**
     * Gets employee first name
     *
     * @return employee first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets employee last name
     *
     * @return employee last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets employee social security number
     *
     * @return employee social security number
     */
    public int getSsNum() {
        return ssNum;
    }

    /**
     * Gets date employee was hired on
     *
     * @return employee hire date
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * Gets salary employee receives
     *
     * @return employee salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Changes the name of the employee
     *
     * @param first - New first name
     * @param last - New last name
     */
    public void changeName(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    /**
     * Raises the salary by <code>salaryAdj</code> dollars.
     *
     * @param salaryAdj - amount to add to the current salary
     * @return the new salary
     */
    public double raiseSalary(double salaryAdj) {
        this.salary += salaryAdj;
        return this.salary;
    }

    /**
     * Returns a string representation of the Employee
     *
     * @return the String of comma delimited values
     */
    @Override
    public String toString() {
        String s = this.empID + "," + this.lastName + "," + this.firstName;
        s += String.format(",%09d", this.ssNum);
        s += "," + HRUtility.dateToStr(this.hireDate);
        s += String.format(",%.2f", this.salary);
        return s;
    }

    /**
     * Checks if two Employee objects have the same social security number
     *
     * @param obj - object to be checked if it has the same social security
     * number as this object
     * @return true if this object and <code> obj </code> have the same social
     * security number; otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.ssNum != other.ssNum) {
            return false;
        }
        return true;
    }

    /**
     * Generates the first positive number (greater than or equal to 1) that
     * does not already exist in the list of employee IDs
     *
     * @return first positive number not already existing in the list of
     * employee IDs
     */
    private static Integer generateID() {
        int id = 1;
        while (setOfIds.contains(id)) {
            id++;
        }
        return id;
    }

}
