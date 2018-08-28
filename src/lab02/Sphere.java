/*******************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: 08/26/2018
 *
 * Lab: Lab02, Exercise 4
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

public class Sphere {
    public static void main (String[] args) {
	System.out.print("Enter the radius of a sphere: ");
	Scanner in = new Scanner(System.in);
	double radius  = in.nextDouble();
	double volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3.0);
    	System.out.println(String.format("The volume is: %.2f", volume));
    	System.out.println(String.format("Rounded to nearest integer: %d", Math.round(volume)));
    }
}
