/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 4, 2018
 * Time: 2:44:20 PM
 *
 * Project: csci205
 * Package: lab05
 * File: DNAsim
 * Description: Contains the DNAsim class, which generates or
                prints information about DNA sequences.
 *
 * ****************************************
 */
package lab05;

import java.util.Random;
import java.util.Scanner;

/**
 * The DNAsim class generates or prints information about DNA sequences.
 *
 * @author Kartikeya Sharma
 * @version 0.1
 */
public class DNAsim {

    /**
     * Prompts the user for characteristics to use when randomly generating a
     * DNA sequence and prints its properties.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Hello. Welcome to the DNA simulator. How long? ");
        int length = in.nextInt();

        System.out.print("What %GC-content? ");
        double gcContentPct = in.nextDouble() / 100;

        System.out.println("Generating...");
        char[] sequence = generateDNA(length, gcContentPct);
        System.out.println("Complete!");

        printDNAStats(sequence);
        printLongestRepeat(sequence);
        printLongestRepeatDinucleotides(sequence);
    }

    /**
     * Generates an array of characters representing a random DNA sequence of a
     * specified length and with a specified approximate percentage of G and C
     * nucleotides.
     *
     * @param length length of DNA sequence to be generated
     * @param gcContentPct approximate percentage of G and C nucleotides within
     * the DNA sequence to be generated
     * @return array of characters representing the randomly generated DNA
     * sequence
     */
    public static char[] generateDNA(int length, double gcContentPct) {
        char[] sequence = new char[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            double hasGC = rand.nextDouble();
            if (hasGC <= gcContentPct) {
                sequence[i] = "gc".charAt(rand.nextInt(2));
            }
            else {
                sequence[i] = "at".charAt(rand.nextInt(2));
            }
        }
        return sequence;
    }

    /**
     * Prints the A, C, G, and T frequencies and percentages of an inputted DNA
     * sequence.
     *
     * @param dna array of characters representing a DNA sequence
     */
    public static void printDNAStats(char[] dna) {
        int aCount = 0;
        int cCount = 0;
        int gCount = 0;
        int tCount = 0;
        for (int i = 0; i < dna.length; i++) {
            switch (dna[i]) {
                case 'a':
                    aCount++;
                    break;
                case 'c':
                    cCount++;
                    break;
                case 'g':
                    gCount++;
                    break;
                default:
                    tCount++;
                    break;
            }
        }
        System.out.println("Actual content of DNA sequence");
        String aPercentage = String.format("%.1f",
                                           (aCount / (float) dna.length) * 100);
        System.out.println("A:  " + aCount + " (" + aPercentage + "%)");
        String cPercentage = String.format("%.1f",
                                           (cCount / (float) dna.length) * 100);
        System.out.println("C:  " + cCount + " (" + cPercentage + "%)");
        String gPercentage = String.format("%.1f",
                                           (gCount / (float) dna.length) * 100);
        System.out.println("G:  " + gCount + " (" + gPercentage + "%)");
        String tPercentage = String.format("%.1f",
                                           (tCount / (float) dna.length) * 100);
        System.out.println("T:  " + tCount + " (" + tPercentage + "%)");
    }

    /**
     * Prints the length and index of the longest sequence of repeating
     * nucleotide within the inputted DNA sequence
     *
     * @param dna DNA sequence to be analyzed for repeating nucleotide
     */
    public static void printLongestRepeat(char[] dna) {
        char mostRepeatedChar = '-';
        int mostRepeatedCounter = 0;
        int mostRepeatedIndex = 0;
        char currentRepeatingChar = '-';
        int currentRepeatingCounter = 0;
        int currentRepeatingIndex = 0;

        for (int i = 0; i < dna.length; i++) {
            if (dna[i] == currentRepeatingChar) {
                currentRepeatingCounter++;
            }
            else {
                if (currentRepeatingCounter > mostRepeatedCounter) {
                    mostRepeatedChar = currentRepeatingChar;
                    mostRepeatedCounter = currentRepeatingCounter;
                    mostRepeatedIndex = currentRepeatingIndex;
                }
                currentRepeatingChar = dna[i];
                currentRepeatingCounter = 1;
                currentRepeatingIndex = i;
            }
        }

        if (mostRepeatedChar == '-') {
            System.out.println("Longest repeated nucleotide: "
                               + "[Empty DNA sequence.]");
        }
        else {
            System.out.println("Longest repeated nucleotide: "
                               + mostRepeatedCounter + " "
                               + Character.toString(mostRepeatedChar).toUpperCase()
                               + "'s [index: "
                               + mostRepeatedIndex + "]");
        }
    }

    /**
     * Prints the length and index of the longest sequence of repeating
     * dinucleotides within the inputted DNA sequence
     *
     * @param dna DNA sequence to be analyzed for repeating dinucleotides
     */
    public static void printLongestRepeatDinucleotides(char[] dna) {
        String mostRepeatedPair = "";
        int mostRepeatedCounter = 0;
        int mostRepeatedIndex = 0;

        for (int shift = 0; shift < 2; shift++) {

            String currentRepeatingPair = "";
            int currentRepeatingCounter = 0;
            int currentRepeatingIndex = 0;
            String pair = "";

            for (int i = shift; i < dna.length - 1; i += 2) {
                pair = Character.toString(dna[i]) + Character.toString(
                        dna[i + 1]);
                if (pair.equals(currentRepeatingPair)) {
                    currentRepeatingCounter++;
                }
                else {
                    if (currentRepeatingCounter > mostRepeatedCounter) {
                        mostRepeatedPair = currentRepeatingPair;
                        mostRepeatedCounter = currentRepeatingCounter;
                        mostRepeatedIndex = currentRepeatingIndex;
                    }
                    currentRepeatingPair = Character.toString(dna[i])
                                           + Character.toString(dna[i + 1]);
                    currentRepeatingCounter = 1;
                    currentRepeatingIndex = i;
                }
            }

        }

        if (mostRepeatedPair.equals("")) {
            System.out.println("Longest repeated nucleotide: "
                               + "[Empty DNA sequence.]");
        }
        else {
            System.out.println("Longest repeated nucleotide: "
                               + mostRepeatedCounter + " "
                               + mostRepeatedPair.toUpperCase()
                               + "'s [index: "
                               + mostRepeatedIndex + "]");
        }

    }

}
