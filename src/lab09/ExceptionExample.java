/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 17, 2018
 * Time: 12:17:21 PM
 *
 * Project: csci205
 * Package: lab09
 * File: ExceptionExample
 * Description: This file contains ExceptionExample, which contains an example of an exception
 *
 * ****************************************
 */
package lab09;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ExceptionExample contains an example of an exception
 *
 * @author Kartikeya Sharma
 */
public class ExceptionExample {

    /**
     * Size to initialize the test array with
     */
    public static final int SIZE = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] x = new int[SIZE];
        int i = 0;

        do {
            try {
                System.out.print(
                        "Enter an index to fill, or " + SIZE + " to finish: ");
                i = in.nextInt();
                if (i != SIZE) {
                    x[i] = i;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(i + " is out of range! Try again!");
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Please enter integers! Try again!");
                in.nextLine();
                continue;
            }
        } while (i != SIZE);
    }
}
