/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 2, 2018
 * Time: 9:39:31 AM
 *
 * Project: csci205
 * Package: lab12
 * File: ScanWebPage
 * Description: This file contains the ScanWebPage class, which
 *              scans web pages for HTML tags.
 *
 * ****************************************
 */
package lab12;

/**
 * Imports necessary classes from java.io, java.net, and java.util.
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ScanWebPage scans web pages for HTML tags.
 *
 * @author Kartikeya Sharma
 */
public class ScanWebPage {

    /**
     * Stores the default input stream in the System class
     */
    public static final InputStream defaultIn = System.in;

    /**
     * Stores the default output stream in the System class
     */
    public static final PrintStream defaultOut = System.out;

    /**
     * Represents the input stream to be used (initialized to the default input
     * stream)
     */
    private static InputStream inStream = System.in;

    /**
     * Represents the output stream to be used (initialized to the default
     * output stream)
     */
    private static PrintStream outStream = System.out;

    /**
     * Resets the input stream used to the default input stream.
     */
    public static void resetInStream() {
        setInStream(defaultIn);
    }

    /**
     * Sets the input stream used
     *
     * @param inStream input stream
     */
    public static void setInStream(InputStream inStream) {
        ScanWebPage.inStream = inStream;
        System.setIn(inStream);
    }

    /**
     * Gets the input stream used
     *
     * @return input stream
     */
    public static InputStream getInStream() {
        return inStream;
    }

    /**
     * Resets the output stream used to the default output stream.
     */
    public static void resetOutStream() {
        setOutStream(defaultOut);
    }

    /**
     * Sets the output stream used
     *
     * @param outStream output stream
     */
    public static void setOutStream(PrintStream outStream) {
        ScanWebPage.outStream = outStream;
        System.setOut(outStream);
    }

    /**
     * Gets the output stream used
     *
     * @return output stream
     */
    public static PrintStream getOutStream() {
        return outStream;
    }

    /**
     * Prints the number of a particular tag on a web page and writes each tag
     * to the output file using the inputted printer.
     *
     * @param urlData input stream representing web page data
     * @param tagName tag type to be scanned for
     * @param printerToFile printer setup to <code>outputFilename</code>
     * @param outputFilename output filename
     */
    public static void scanWebPageForTags(BufferedInputStream urlData,
                                          String tagName,
                                          PrintWriter printerToFile,
                                          String outputFilename) {
        Scanner scanner = new Scanner(urlData);
        String regularTagExp = String.format("<%s(.*?)>", tagName);
        Pattern pattern = Pattern.compile(regularTagExp);
        String sMatch;
        int matchesFound = 0;
        while ((sMatch = scanner.findWithinHorizon(pattern, 0)) != null) {
            printerToFile.println(sMatch);
            matchesFound++;
        }
        System.out.println(
                "Wrote " + matchesFound + " <" + tagName + "> tags to " + outputFilename);
    }

    /**
     * Scanner tool that scans the web page of a user-inputted URL for HTML
     * tags.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Prepare for scanning by setting the isScanning switch to true
        // and preparing the input stream to be read using a BufferedReader
        boolean isScanning = true;
        BufferedReader userInput = new BufferedReader(
                new InputStreamReader(getInStream()));

        while (isScanning) {
            // Seeks URL address of web page to be scanned by user with checks to ensure
            // that the URL is not empty and can be read by the BufferedReader.
            String urlAddress;
            try {
                System.out.print(
                        "Enter the URL address of the web page you would like to scan: ");
                urlAddress = userInput.readLine();
                if (urlAddress == null) {
                    System.out.println("The inputted URL address is empty.");
                    continue;
                }
            } catch (IOException ex) {
                System.out.println(
                        "IOException: the input operation for getting the URL address has failed or been interrupted.");
                break;
            }

            // Creates a URL object out of the URL address inputted by the user
            // Warns the user if the URL is incomplete or malformed
            URL locator;
            try {
                locator = new URL(urlAddress);
            } catch (MalformedURLException ex) {
                System.out.println(
                        "The URL address is incomplete or malformed.");
                continue;
            }

            // Creates an input stream from the data received from the URL
            // Warns the user if the URL has invalid syntax, is valid but the
            // host does not exist, is valid but the page specified in the URL
            // does not exist, or the input stream could not be initialized/used.
            BufferedInputStream urlDataBufferedInput = null;
            try {
                urlDataBufferedInput = new BufferedInputStream(
                        locator.openStream());
            } catch (IllegalArgumentException ex) {
                System.out.println(
                        "The URL address has invalid URL syntax.");
                continue;
            } catch (UnknownHostException ex) {
                System.out.println(
                        "The URL is valid, but the host does not exist.");
                continue;
            } catch (FileNotFoundException ex) {
                System.out.println(
                        "The URL is valid, but the page specified in the URL does not exist.");
                continue;
            } catch (IOException ex) {
                System.out.println(
                        "IOException: opening the input stream for the URL address provided has failed or been interrupted.");
                break;
            }

            // Asks the user which tag the user would like to scan the web page for
            System.out.print(
                    "Connection established. What tag do you want to scan for? ");
            String tagName;
            try {
                tagName = userInput.readLine();
            } catch (IOException ex) {
                System.out.println(
                        "IOException: the input operation for getting the tag name has failed or been interrupted.");
                break;
            }

            // Asks the user for the filename of the file that all of the tags being scanned
            // for will be written to
            System.out.print("Enter the file name to store the results: ");
            String outputFilename;
            try {
                outputFilename = userInput.readLine();
            } catch (IOException ex) {
                System.out.println(
                        "IOException: the input operation for getting the output filename has failed or been interrupted.");
                break;
            }

            // Creates a printer with the output filename
            // Warns the user if this file could not be opened/created
            PrintWriter printerToFile;
            try {
                printerToFile = new PrintWriter(outputFilename);
            } catch (FileNotFoundException ex) {
                System.out.println(
                        "Cannot output because either" + outputFilename + " does not represent an existing file at " + System.getProperty(
                                "user.dir") + " and a new file with that name cannot be created or an unexpected error occurs while opening or creating the file.");
                continue;
            }

            // Closes the user input stream
            try {
                userInput.close();
            } catch (IOException ex) {
                System.out.println(
                        "IOException: closing the input stream for user input has failed or been interrupted.");
                break;
            }

            // Scans the web page for the specified tag type
            scanWebPageForTags(urlDataBufferedInput, tagName, printerToFile,
                               outputFilename);

            // Closes the URL data stream
            try {
                urlDataBufferedInput.close();
            } catch (IOException ex) {
                System.out.println(
                        "IOException: closing the input stream for web page data has failed or been interrupted.");
                break;
            }

            // Closes the file printer
            printerToFile.close();

            // Sets the isScanning switch to false because the scanning operation has finished
            isScanning = false;
        }
        System.out.println("Goodbye!");
    }
}
