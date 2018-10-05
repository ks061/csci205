/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 2, 2018
 * Time: 10:15:51 AM
 *
 * Project: csci205
 * Package: lab12
 * File: ScanWebPageTest
 * Description: This file contains ScanWebPageTest, which
 *              tests the ScanWebPage class using JUnit tests.
 *
 * ****************************************
 */
package lab12;

/**
 * Imports necessary classes from java.io, java.nio, and junit.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import junit.framework.TestCase;

/**
 * ScanWebPageTest tests the ScanWebPage class using JUnit tests.
 *
 * @author Kartikeya Sharma
 */
public class ScanWebPageTest extends TestCase {

    /**
     * Represents the input stream to be used in each JUnit test
     */
    private ByteArrayInputStream inputStream;

    /**
     * Represents the byte array representation of the output stream to be used
     * in each JUnit test
     */
    private ByteArrayOutputStream byteOutputStream;

    /**
     * Represents the output stream to be used in each JUnit test
     */
    private PrintStream outputStream;

    /**
     * Explicit constructor with a customizable test name for this test
     * instance.
     *
     * @param testName name for this test instance
     */
    public ScanWebPageTest(String testName) {
        super(testName);
    }

    /**
     * Initializes up instance variables prior to each JUnit test
     *
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        byteOutputStream = new ByteArrayOutputStream();
        outputStream = new PrintStream(byteOutputStream);
    }

    /**
     * Clears instance variables (sets to null) after each JUnit test
     *
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        ScanWebPage.resetInStream();
        ScanWebPage.resetOutStream();
        inputStream = null;
        outputStream = null;
        byteOutputStream = null;
    }

    private void testMain(String address, String programResponse) {
        byte[] byteList = (address + "\nhttp://www.bucknell.edu\ndiv\noutput_ignore.txt").getBytes(
                (StandardCharsets.UTF_8));
        inputStream = new ByteArrayInputStream(byteList);
        ScanWebPage.setInStream(inputStream);

        ScanWebPage.setOutStream(outputStream);

        ScanWebPage.main(null);

        assertEquals(
                "Enter the URL address of the web page you would like to scan: " + programResponse,
                byteOutputStream.toString().split("\n")[0]);
    }

    /**
     * Test of main method with an invalid URL, of class ScanWebPage.
     */
    public void testMainInvalidURL() {
        System.out.println("main: Invalid URL");

        String address = "http:\\\\www.bucknell.edu";
        String programResponse = "The URL address has invalid URL syntax.";

        testMain(address, programResponse);
    }

    /**
     * Test of main method with an incomplete URL, of class ScanWebPage.
     */
    public void testMainIncompleteURL() {
        System.out.println("main: Incomplete URL");

        String address = "www.bucknell.edu";
        String programResponse = "The URL address is incomplete or malformed.";

        testMain(address, programResponse);
    }

    /**
     * Test of main method with a valid URL but nonexistent host, of class
     * ScanWebPage.
     */
    public void testMainValidURLHostNonexistent() {
        System.out.println("main: Valid URL but Host Nonexistent");

        String address = "https://www.bucknell.ed";
        String programResponse = "The URL is valid, but the host does not exist.";

        testMain(address, programResponse);
    }

    /**
     * Test of main method with a valid URL and valid host but page specified
     * does not exist, of class ScanWebPage.
     */
    public void testMainValidURLValidHostPageNonexistent() {
        System.out.println("main: Valid URL and Valid Host but Page Nonexistent");

        String address = "https://www.bucknell.edu/blah.html";
        String programResponse = "The URL is valid, but the page specified in the URL does not exist.";

        testMain(address, programResponse);
    }

    /**
     * Test of main method with a valid URL, valid host, and valid page
     * specified, of class ScanWebPage.
     */
    public void testMainValidURLValidHostValidPage() {
        System.out.println(
                "main: Valid URL, Valid Host, and Valid Page Specified");

        String input = "https://www.bucknell.edu\ndiv\ndiv_output.txt";
        String programResponse = "";

        byte[] byteList = (input).getBytes(
                (StandardCharsets.UTF_8));
        inputStream = new ByteArrayInputStream(byteList);
        ScanWebPage.setInStream(inputStream);

        ScanWebPage.setOutStream(outputStream);

        ScanWebPage.main(null);

        assertEquals(
                "Enter the URL address of the web page you would like to scan: Connection established. What tag do you want to scan for? Enter the file name to store the results: Wrote 125 <div> tags to div_output.txt",
                byteOutputStream.toString().split("\n")[0]);
        assertEquals(
                "Goodbye!",
                byteOutputStream.toString().split("\n")[1]);
    }

}
