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

/**
 * The Calculator class contains a main method, which
 * runs the calculator program.
 */
public class Calculator {
    /*
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
            switch(operator) {
                case "+": 
                    double sum = firstNum + secondNum;
                    System.out.println("The sum is " + sum);
                    break;
                case "-":
                    double difference = firstNum - secondNum;
                    System.out.println("The difference is " + difference);
                    break;
                case "*":
                    double product = firstNum * secondNum;
                    System.out.println("The product is " + product);
                    break;
                case "/":
                    double quotient = firstNum / secondNum;
                    System.out.println("The quotient is " + quotient);
                    break;
                case "%":
                    double remainder = firstNum % secondNum;
                    System.out.println("The remainder is " + remainder);
                    break;
                case "^":
                    double power = Math.pow(firstNum, secondNum);
                    System.out.println("The power is " + power);
                    break;
                default:
                    System.out.println("ERROR: " + operator + " is not a valid " +
                                       "operator.");
                    continue;
            }
            System.out.print("Try again? [y | n] ");
            userInputKeepLooping = input.next();
            if (!userInputKeepLooping.toLowerCase().equals("y")) {
                keepLooping = false;
            }
        }
    }
}
