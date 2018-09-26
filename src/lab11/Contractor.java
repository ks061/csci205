/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 25, 2018
 * Time: 1:02:16 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Contractor
 * Description: This file contains the Contractor class, which represents
 *              contractors, i.e. those who are paid on an hourly rate for
 *              their work
 *
 * ****************************************
 */
package lab11;

import java.util.Date;

/**
 * Contractor represents contractors, i.e. people who are paid on an hourly rate
 * for their work
 *
 * @author Kartikeya Sharma
 */
public class Contractor implements Payable {

    /**
     * Instance variables representing particular data attributes of a
     * contractor
     */
    private int id;
    private String firstName;
    private String lastName;
    private int ssNum;
    private double hourlyRate;

    /**
     * Explicit constructor to create new contractor
     *
     * @param id id of the contractor
     * @param firstName first name of the contractor
     * @param lastName last name of the contractor
     * @param ssNum social security number of the contractor
     * @param hourlyRate hourly rate by which the contractor will be paid
     */
    public Contractor(int id, String firstName, String lastName, int ssNum,
                      double hourlyRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Gets contractor ID
     *
     * @return contractor ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets first name of contractor
     *
     * @return first name of contractor
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name of contractor
     *
     * @return last name of contractor
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets social security number of contractor
     *
     * @return social security number of contractor
     */
    public int getSsNum() {
        return ssNum;
    }

    /**
     * Gets hourly rate by which this contractor will be paid
     *
     * @return hourly rate by which this contractor will be paid
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Gets a string representation of the contractor, including their
     * contractor ID, social security number, full name, and hourly rate
     *
     * @return string representation of the contractor, including their
     * contractor ID, social security number, full name, and hourly rate
     */
    @Override
    public String toString() {
        return "Contractor: " + this.id + "," + this.lastName + "," + this.firstName + "," + this.ssNum + "," + String.format(
                "%.2f", this.hourlyRate);
    }

    /**
     * Gets the gross pay due to the contractor based on the number of hours
     * worked by the contractor; this does not include overtime pay, as the
     * contractor is solely paid on an hourly basis for all work done
     *
     * @param numHrs number of hours worked by the contractor
     * @return gross pay due to the contractor
     */
    @Override
    public double calculatePay(double numHrs) {
        if (numHrs < 0) {
            throw new IllegalArgumentException(
                    "The number of hours billed is and yet cannot be negative.");
        }
        return numHrs * hourlyRate;
    }

    /**
     * Gets a string representation of the first and last name of the contractor
     * for the payee field of the check
     *
     * Example: Jane Doe
     *
     * @return string representation of the first and last name of the
     * contractor
     */
    @Override
    public String getPayTo() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * Gets a string representation of the contractor ID with today's date for
     * the memo field of the check
     *
     * Example: Contractor ID: 12345, Pay Date: 2015-Sep-24
     *
     * @return string representation of the contractor ID with today's date
     */
    @Override
    public String getPayMemo() {
        return "Contractor ID: " + this.id + ", Pay Date: " + HRUtility.dateToStr(
                new Date());
    }

}
