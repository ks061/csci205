/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
* Instructor: Professor Dancy
* Section: 12 PM
*
* Name: Kartikeya Sharma
* Date: 09/02/2018
*
* Lab / Assignment: Lab 04, Exercise 04
*
* Description: This file contains the Calculator class,
*              which has methods that address the problem
*              statements given in Exercise 04 of Lab 04. 
* 
* *****************************************/

package lab04;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * The Calculator class contains a main method, which
 * runs the calculator program.
 */
public class Calculator {
    /**
     * This method produces the pattern template for the DecimalFormat
     * class to process based on the inputted double.
     *
     * @param n Inputted double
     * @return A string representing the pattern template for the
     *         DecimalFormat class to process based on <code>n</code>.
     */
    public static String patternGenerator(double n) {
        boolean isDecimal = true;
        if((n - (long) n) == 0)
            isDecimal = false;
        String strInput = Double.toString(n);
        String output = "";
        for (int i = strInput.length()-1; i > 0; i--) {
            if ((strInput.length()-1-i)%3 == 0 && (strInput.length()-1-i != 0))
                output = "," + output;
            output = "#" + output;
        }
        if (isDecimal)
            output += ".##";
        return output;     
    }

    /**
     * This is the main method of the class, which
     * runs the calculator program.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator");
        System.out.println("Enter expressions with two numeric operands");
        System.out.println("and a single operator from +, -, *, /, %, or ^");
        boolean keepLooping = true;
        double firstNum = 0;
        String operator = "";
        double secondNum = 0;
        String userInputKeepLooping = "";
        while (keepLooping) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a simple arithmetic expression with spacing: ");
            if (input.hasNextDouble()) {
                firstNum = input.nextDouble();
            }
            else {
                System.out.println("ERROR: Cannot parse operand 1");
                continue;
            }
            operator = input.next();
            if (input.hasNextDouble()) {
                secondNum = input.nextDouble();
            }
            else {
                System.out.println("ERROR: Cannot parse operand 2");
                continue;
            }
            double result = 0;
            String operation = "";
            switch(operator) {
                case "+": 
                    result = firstNum + secondNum;
                    operation = "sum";
                    break;
                case "-":
                    result = firstNum - secondNum;
                    operation = "difference";
                    break;
                case "*":
                    result = firstNum * secondNum;
                    operation = "product";
                    break;
                case "/":
                    result = firstNum / secondNum;
                    operation = "quotient";
                    break;
                case "%":
                    result = firstNum % secondNum;
                    operation = "remainder";
                    break;
                case "^":
                    result = Math.pow(firstNum, secondNum);
                    operation = "power";
                    break;
                default:
                    System.out.println("ERROR: " + operator + " is not a valid " +
                                       "operator.");
                    continue;
            }
            DecimalFormat formatter = new DecimalFormat(patternGenerator(result));
            String outputtedResult = formatter.format(result);
            System.out.println("The " + operation + " is " + outputtedResult);
            System.out.print("Try again? [y | n] ");
            userInputKeepLooping = input.next();
            if (!userInputKeepLooping.toLowerCase().equals("y")) {
                keepLooping = false;
            }
        }
    }
}
