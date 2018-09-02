/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
* Instructor: Professor Dancy
* Section: 12 PM
*
* Name: Kartikeya Sharma
* Date: 09/02/2018
*
* Lab / Assignment: Lab 04, Exercise 2
*
* Description: This contains the ArrayChallenge class, which tackles
*              the Java array challenges presented within Exercise 2
*              in Lab 04.
* 
* *****************************************/

package lab04;

import java.util.Arrays;

/**
 * The ArrayChallenge class contains methods that address the Java array challenges 
 * presented within Exercise 2 of Lab 04 and a runner method to test/call 
 * aforementioned methods.
 */
public class ArrayChallenge {
    /**
     * This method concatenates two inputted array of double values into an 
     * independent array of double values.
     *
     * @param a1 Array of double values that has entries which will be
     *           at the beginning of the outputted array
     *           (before the <code>a2</code> entries).
     * @param a2 Array of double values  that has entries which will be
     *           at the end of the outputted array (after the
     *           <code>a1</code> entries).
     * @return Independent array of double values that starts with the entries 
     *         of <code>a1</code> and, subsequently, contains the
     *         entries of <code>a2</code>.
     */ 
    public static double[] concat(double[] a1, double[] a2) {
        double[] result = new double[a1.length + a2.length];
        for (int i = 0; i < a1.length; i++) {
            result[i] = a1[i];
        }
        for (int j = a1.length; j < a1.length + a2.length; j++) {
            result[j] = a2[j-a1.length];
        }
        return result;
    }

    /**
     * This method returns an array of double values  with the entries of the inputted
     * array of double values in reverse order.
     *
     * @param a Inputted array of double values that will be reversed
     * @return Array of double values with entries of <code>a</code> in reverse order.
     */ 
    public static double[] reverse (double[] a) {
        if (a.length <= 1)
            return a;
        
        double[] a_sub = reverse(Arrays.copyOfRange(a,1,a.length-1));
        
        return concat(concat(new double[] {a[a.length-1]},a_sub),new double[] {a[0]}); 
    }

    /**
     * This method returns an alternating sum of all of the double values in
     * the inputted array of double values; in an alternating sum, an addition of an
     * entry to the sum value is followed by a subtraction of the subsequent entry
     * to the sum value, and vice versa.
     *
     * @param a Inputted array of double values that will have its alternating sum 
     *          computed
     * @return Alternating sum of <code>a</code>
     */ 
    public static double altSum(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i+=2) {
            sum += a[i];
        }
        for (int j = 1; j < a.length; j+=2) {
            sum -= a[j];
        }
        return sum;
    }

    /**
     * This method evaluates whether the inputted array of double values 
     * has double values that are in increasing order or not.
     *
     * @param a Inputted array of double values that will be evaluated for increasing 
     *          order
     * @return true if <code>a</code> is in increasing order; otherwise returns false
     */
    public static boolean isSorted(double[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i-1])
                return false;
        }
        return true;
    }
    
    /**
     * This is a runner method that tests the methods above by calling them with
     * test inputs; it has been specified in the lab assignment.
     */
    public static void main(String[] args) {
        double[] array1 = { 2, 3, 5, 7, 11 };
        double[] array2 = { 1, 4, 6, 8, 0 };
        System.out.printf("array1: %s\n", Arrays.toString(array1));
        System.out.printf("array2: %s\n", Arrays.toString(array2));
        System.out.printf("concat test: %s\n",
        Arrays.toString(concat(array1,array2)));
        System.out.printf("reverse test: %s\n",
        Arrays.toString(reverse(array1)));
        System.out.printf("altSum test: %.1f\n", altSum(concat(array1,array2)));
        System.out.printf("sorted test 1: %b\n", isSorted(array1));
        System.out.printf("sorted test 2: %b\n", isSorted(array2));
    }
}
