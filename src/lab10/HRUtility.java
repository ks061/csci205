/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 20, 2018
 * Time: 7:45:28 PM
 *
 * Project: csci205
 * Package:
 * File: HRUtility
 * Description: This file contains the HRUtility class
 *
 * ****************************************
 */
package lab10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * HRUtility is a utility class that manages employee data of a company
 *
 * @author Kartikeya Sharma
 */
public final class HRUtility {

    /**
     * Date format for Employee class
     */
    private static SimpleDateFormat empDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd");

    public static void displayEmployee(Employee emp) {
        System.out.print(
                emp.getEmpID() + ": " + emp.getFirstName() + " " + emp.getLastName());
        if (emp instanceof Manager) {
            System.out.println(" [MANAGER]");
        }
        else {
            System.out.println();
        }
    }

    public static void displayEmployees(List<Employee> listOfEmps) {
        for (Employee e : listOfEmps) {
            displayEmployee(e);
        }
    }

    /**
     * Converts a String object to a date using the empDateFormat
     * {@link SimpleDateFormat} object
     *
     * @param sDate - a date string
     * @return a <code>Date</code> object
     * @throws ParseException if the string cannot be parse correctly.
     */
    public static Date strToDate(String sDate) throws ParseException {
        return empDateFormat.parse(sDate);
    }

    /**
     * Converts a Date object to a string using the empDateFormat
     * {@link SimpleDateFormat} object
     *
     * @param d - Date object to be converted
     * @return a String representing the date
     */
    public static String dateToStr(Date d) {
        return empDateFormat.format(d);
    }
}
