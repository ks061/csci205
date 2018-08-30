/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 * Instructor: Professor Dancy
 * Section: 12 PM
 *
 * Name: Kartikeya Sharma
 * Date: 08/29/2018
 *
 * Lab / Assignment: Lab 04, Exercise 4
 *
 * Description: Computing the nth Fibonacci number using recursion and iteration.
 *
 * *****************************************/

package lab03;

import java.util.Scanner;
import java.lang.System;

/**
 * A simple class designed to give the user an opportunity to test a recursive
 * and non-recursive version of fibonacci
 *
 * Date: 2015-fall
 *
 * @author BRK
 */
public class Fibonacci {

    /**
     * Compute the nth fibonacci number recursively
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int recFib(int n) {
        // TODO - Complete this method
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return recFib(n-2) + recFib(n-1);
    }

    /**
     * Compute the nth fibonacci number non-recursively, using a while loop.
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int nonRecFib(int n) {
        // TODO - Complete this method
        if (n <= 1)
            return n;

        int lastFib = 0;
        int curFib = 1;
        int calcFib = 1;

        for (int count = 2; count <= n; count++) {
            curFib = calcFib;
            calcFib += lastFib;
            lastFib = curFib; 
        }
     
        return calcFib;
    }

    /**
     * Main program to test both fibonacci methods
     */
    public static void main(String[] args) {
        System.out.println("Request your fibonacci number:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Recursive fib: " + recFib(n));
        System.out.println("Non-recursive fib: " + nonRecFib(n));
    }

}
