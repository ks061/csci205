/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
* Instructor: Professor Dancy
* Section: 12 PM
*
* Name: Kartikeya Sharma
* Date: 09/02/2018
*
* Lab / Assignment: Lab 04, Exercise 3
*
* Description: This file contains the TestGaussian class, which tests
*              the Java's Gaussian random number generation. 
* 
* *****************************************/

package lab04;

import java.util.Random;
import java.lang.Math;

/**
 * This class contains all of the methods related to the Gaussian
 * random number generator problems and a testing main method to
 * call and test aforementioned methods with test parameters.
 */ 
public class TestGaussian {
    /**
     * Constant with the number of random numbers that will
     * be added to the tester array in the main method.
     */ 
    public static final int MAX_NUMS = 5000000;

    /**
     * Calculates the standard deviation of the numbers using
     * the formula that uses the sum of the squared differences for
     * each entry in the array from the mean.
     *
     * @param num Array of doubles that represents the data set
     * @return Standard deviation of <code>num</code> using the formula
     * that uses the sum of the squared differences for each entry in the
     * array from the mean.
     */
    public static double calcStDev(double nums[]) {
        double mean = 0;
        for (double value : nums) {
            mean += value;
        }
        mean /= nums.length;

        double stdev = 0;
        for (double value : nums) {
            stdev += (value - mean) * (value - mean);
        }
        stdev /= nums.length;
        return Math.sqrt(stdev);
    }

    /**
     * Calculates the standard deviation of the numbers using
     * the formula that uses the sum of the differences between the squares
     * of each entry in the array and the mean.
     *
     * @param num Array of doubles that represents the data set
     * @return Standard deviation of <code>num</code> using the formula
     * that uses the sum of the differences between the squares of each
     * entry in the array and the mean.
     */
    public static double calcAltStDev(double nums[]) {
        double mean = 0;
        double alt_stdev = 0;
        for (double value : nums) {
            mean += value;
            alt_stdev += value * value;
        }
        mean /= nums.length;
        alt_stdev /= nums.length;
        alt_stdev -= mean * mean;
        return Math.sqrt(alt_stdev);
    }

    /**
     * This is a runner method that tests the methods above by calling them with
     * test inputs. 
     */
    public static void main(String[] args) {
        System.out.println("Generating " + MAX_NUMS + " numbers...");
        Random rand = new Random();
        double[] nums = new double[MAX_NUMS];
        for (int i = 0; i < MAX_NUMS; i++) {
            nums[i] = rand.nextGaussian();
        }
        
        double startTimeStDev = (double) System.nanoTime();
        double stDev = calcStDev(nums);
        double diffTimeStDev = (double) System.nanoTime() - startTimeStDev;
        diffTimeStDev /= 1000;
        System.out.println("sd:  " + String.format("%.8f",stDev));
        System.out.println("TIME:      " + 
                           String.format("%.3f",diffTimeStDev) + " usec");
        
        double startTimeAltStDev = (double) System.nanoTime();
        double altStDev = calcAltStDev(nums);
        double diffTimeAltStDev = (double) System.nanoTime() - startTimeAltStDev;
        diffTimeAltStDev /= 1000;
        System.out.println("alt_sd:    " + String.format("%.8f",altStDev));
        System.out.println("TIME:      " + 
                           String.format("%.3f",diffTimeAltStDev) + " usec");

        double percentEfficiencyAltSd = (diffTimeAltStDev / diffTimeStDev)*100;
        System.out.println("alt_sd computed in " + 
                           String.format("%.2f",percentEfficiencyAltSd) + 
                           "% of the time of sd");
    }
}
