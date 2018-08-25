/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: 08/26/2018
 *
 * Lab: Lab02, Exercise 2 and 3
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
    
    // Declaring temperature boundary class constants for temperature-based statements.
    public static final int UPPER_BOUND_FREEZE = 32;
    public static final int UPPER_BOUND_COOL = 60;
    public static final int UPPER_BOUND_WARM = 85;
    
    public static void main(String[] args) {
	boolean runProgram = true;
        do {
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

	    // Print statement based on converted Fahrenheit temperature.
	    if (fahrenheit <= UPPER_BOUND_FREEZE) {
	        System.out.println("Brrr... it is FREEZING out!");
	    } else if (fahrenheit <= UPPER_BOUND_COOL) {
		System.out.println("It's a bit cool out");
	    } else if (fahrenheit <= UPPER_BOUND_WARM) {
		System.out.println("It's comfortably warm");
	    } else {
		System.out.println("It's HOT! I need A/C!");
	    }
		
	    // Ask user if they wish to continue running the program and process input accordingly.
	    System.out.print("Try again? [y | n]: ");
	    String input = in.next();
	    if (!input.toLowerCase().equals("y")) {
		runProgram = false;
		System.out.println("Goodbye!");
	    }		
    	} while (runProgram);
    }
}
