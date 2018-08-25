/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: 08/26/2018
 *
 * Lab: Lab02, Exercise 2
 *
 * @author Brian King, 2012-Fall
 *
 * Description:
 * A simple program to ask the user for a temperature in Celsius, and converts
 * it to Fahrenheit.
 * *****************************************
 */

package lab02;

import java.util.Scanner;

public class CtoF {
    public static void main(String[] args) {

        // Prompt user for a Celsius temp
	System.out.print("Enter a temperature in Celsius: ");

        // Create the Scanner object, attached to console input
        Scanner in = new Scanner(System.in);

        // Read and store the Celsius temp	
	int celsius  = in.nextInt();

        // Convert the temp to Fahrenheit
        float fahrenheit = celsius * 9.0f / 5 + 32;

        // Output the results with correct formatting, one significant digit
	System.out.println(String.format("%d C = %.1f F", celsius, fahrenheit));
    }
}
