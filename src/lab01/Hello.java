/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 * Instructor: Professor Dancy
 * Section: 12 PM
 *
 * Name: Kartikeya Sharma
 * Date: 08/22/2018
 *
 * Lab / Assignment: lab01
 *
 * Description: A Hello class in Java.
 *
 * *****************************************/

package lab01;

public class Hello
{
    public static void main( String[] args ){
        long startTime  = System.nanoTime();
	System.out.println("Programming is not a spectator sport!");
	long estimatedTime = System.nanoTime() - startTime;
	System.out.println("Time to execute: " + estimatedTime + " ns");
	System.exit(0);
    }
}
