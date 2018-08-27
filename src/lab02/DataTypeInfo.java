/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: 8/26/2018
 *
 * Lab: Lab02, Exercise 4
 *
 * Description:
 * A simple exercise to to compute e, and to illustrate BigDecimal and
 * its computational cost
 * *****************************************
 */
package lab02;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Euler - a class of static methods to illustrate different ways to compute
 * Euler's number
 */
public class Euler {

    /**
     * computeEulerTerm - compute the nth term of the power series of e^x
     *
     * @param n - The nth term of the power series to compute
     * @param x - the power of e used
     * @return - The computed term in the expansion
     */
    public static double computeEulerTerm(int n, double x) {
        // TODO - Complete this method based on the code given in the lab
    	double numerator = 1.0, denominator = 1.0;
	for(int i = 1; i <= n; i++) {
    	    numerator *= x; // Compute the x to the n
	    denominator *= i; // Compute n!
	}
	double term = numerator / denominator;
    	return term;
    }

    /**
     * compute Euler's number to the x power using the Taylor series expansion.
     * This is a bit inefficient. It calls a separate method to compute each
     * term in the expansion.
     *
     * @param x - compute e^x
     * @param numTerms - Number of terms to compute in the expansion
     * @return Euler's number
     */
    public static double computeEulerSlow(double x, int numTerms) {
        // TODO - Complete this method!
    	double sum = 0.0;
	for(int i = 0; i <= numTerms; i++) {
            sum += computeEulerTerm(i, x);
        }
        return sum;
    }

    /**
     * compute Euler's number to the x power using the Taylor series expansion.
     * This is a faster implementation, using only one loop to compute the
     * result.
     *
     * @param x - compute e^x
     * @param numTerms - Number of terms to compute in the expansion
     * @return Euler's number
     */
    public static double computeEulerFast(double x, int numTerms) {
        // TODO - Complete this method!
        double currentTerm = 1.0 / 1.0;
        double sum = currentTerm;
        for(int i = 1; i <= numTerms; i++) {
            currentTerm *= (x/i);
            sum += currentTerm;
        }
        return sum;
    }

    /**
     * computeEulerBig - compute e using BigDecimal so that we do not lose
     * accuracy
     *
     * @param x - the exponent of e to use
     * @param numTerms - the number of terms of the series to compute
     * @return - e as a BigDecimal
     */
    public static BigDecimal computeEulerBig(double x, int numTerms) {
        // TODO - Complete this method!
        BigDecimal sum = new BigDecimal(1.0);
        BigDecimal currentTerm = new BigDecimal(1.0);
        for(int i = 1; i <= numTerms; i++) {
            currentTerm = currentTerm.multiply(new BigDecimal(x));
            try {
                currentTerm = currentTerm.divide(new BigDecimal(i));
            } catch (ArithmeticException e) {
                currentTerm = currentTerm.divide(new BigDecimal(i), 100, RoundingMode.HALF_UP);
            }
            sum = sum.add(currentTerm);
        }
        return sum;
    }

    /**
     * Main program to test out Euler computations
     */

    public static void main(String args[]) {

        final int X = 5;
        final int NUM_TERMS = 20;

        System.out.printf("Evaluating e^%d using %d terms:\n", X, NUM_TERMS);

        long startTime = System.nanoTime();
        double dAnswer = Math.exp(X);
        long elapsedTime = System.nanoTime() - startTime;
        System.out.printf("Math.exp answer:      %.20f : Elapsed time (ns): %d\n", dAnswer, elapsedTime);

        startTime = System.nanoTime();
        double num = computeEulerSlow(X, NUM_TERMS);
        elapsedTime = System.nanoTime() - startTime;
        System.out.printf("My slow answer:       %.20f : Elapsed time (ns): %d\n", num, elapsedTime);

        startTime = System.nanoTime();
        num = computeEulerFast(X, NUM_TERMS);
        elapsedTime = System.nanoTime() - startTime;
        System.out.printf("My fast answer:       %.20f : Elapsed time (ns): %d\n", num, elapsedTime);

        startTime = System.nanoTime();
        BigDecimal bigAnswer = computeEulerBig(X, NUM_TERMS);
        elapsedTime = System.nanoTime() - startTime;
        System.out.printf("My BigDecimal answer: %.20f : Elapsed time (ns): %d\n", bigAnswer, elapsedTime);
    }
}
