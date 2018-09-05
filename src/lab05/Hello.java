/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 4, 2018
 * Time: 12:46:49 PM
 *
 * Project: csci205
 * Package: lab05
 * File: Hello
 * Description: This file contains a Hello class,
                which is used as a programming tool
                to become accustomed to the Java IDE
                in Netbeans.
 *
 * ****************************************
 */
package lab05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * The Hello class is a programming aid in becoming accustomed to the Java IDE
 * in NetBeans.
 *
 * @author Kartikeya Sharma
 * @version 0.1
 */
public class Hello {

    /**
     * Number of integers to generate.
     */
    private static final int NUM_INTS = 10;

    /**
     * Greets the user and generates random numbers.
     *
     * @param args the command line arguments
     * @see Arrays
     */
    public static void main(String[] args) {
        greetUser();

        int[] x = getArrayOfRandomNums();
        System.out.println(Arrays.toString(x));
    }

    /**
     * Generates an array of random integer values.
     *
     * @return Array of random integer values
     * @see Random
     */
    private static int[] getArrayOfRandomNums() {
        // Some simple code to test out the debugger
        Random rand = new Random();
        int[] x = new int[NUM_INTS];
        for (int i = 0; i <= 9; i++) {
            x[i] = rand.nextInt(100);
        }
        return x;
    }

    /**
     * Greets user using name inputted when prompted.
     *
     * @see Scanner
     */
    private static void greetUser() {
        System.out.println("Hello. What is your name? ");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.println(name + ", becoming a good programmer takes practice.");
    }

}
