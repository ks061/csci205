/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 4, 2018
 * Time: 8:31:36 PM
 *
 * Project: csci205
 * Package: lab12
 * File: WordCount
 * Description: This file contains the WordCount class, which counts the number
 *              of entities within a file.
 *
 * ****************************************
 */
package lab12;

/**
 * Imports necessary classes from java.io and java.util.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * WordCount counts the number of entities within a file.
 *
 * @author Kartikeya Sharma
 */
public class WordCount {

    /**
     * File and attributes to be examined by WordCount
     */
    private File file;
    private int numCharacters;
    private int numWords;
    private int numLines;

    /**
     * Explicit constructor setting the file to be examined using a File object
     * input.
     *
     * @param file file to be examined
     * @throws java.io.FileNotFoundException if file does not exist
     */
    public WordCount(File file) throws FileNotFoundException {
        this.file = file;
        if (!this.file.exists()) {
            throw new FileNotFoundException(
                    "The inputted file could not be found.");
        }
    }

    /**
     * Explicit constructor initializing the file to be examined using a String
     * input representing the filename of the file.
     *
     * @param filename file name of the file to be examined
     * @throws java.io.FileNotFoundException if file with filename
     * <code>filename</code> does not exist
     */
    public WordCount(String filename) throws FileNotFoundException {
        this(new File(filename));
    }

    /**
     * Counts the number of characters in the file
     *
     * @param in scanner
     * @return number of characters in the file
     * @throws FileNotFoundException file associated with this WordCount
     * instance does not exist
     */
    public int countCharacters(FileInputStream in) throws FileNotFoundException, IOException {
        try {
            in = new FileInputStream(this.file);
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(
                    "The file associated with this WordCount instance does not exist.");
        }

        int characterCount = 0;
        while (in.available() > 0) {
            in.read();
            characterCount++;
        }

        in.close();

        return characterCount;
    }

    /**
     * Counts the number of words in the file
     *
     * @param in scanner
     * @return number of words in the file
     * @throws FileNotFoundException file associated with this WordCount
     * instance does not exist
     */
    public int countWords(FileInputStream in) throws FileNotFoundException, IOException {
        try {
            in = new FileInputStream(this.file);
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(
                    "The file associated with this WordCount instance does not exist.");
        }

        int wordCount = 0;
        boolean prevWasWhitespace = true;
        char currentChar;
        while (in.available() > 0) {
            currentChar = (char) in.read();
            if (Character.isWhitespace(currentChar) && (currentChar) != '\n') {
                prevWasWhitespace = true;
            }
            else {
                if (prevWasWhitespace) {
                    wordCount++;
                    prevWasWhitespace = false;
                }
            }
        }

        in.close();

        return wordCount;
    }

    /**
     * Counts the number of lines in the file
     *
     * @param in scanner
     * @return number of lines in the file
     * @throws FileNotFoundException file associated with this WordCount
     * instance does not exist
     */
    public int countLines(Scanner in) throws FileNotFoundException {
        try {
            in = new Scanner(this.file);
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(
                    "The file associated with this WordCount instance does not exist.");
        }

        int lineCount = 0;
        while (in.hasNextLine()) {
            in.nextLine();
            lineCount++;
        }

        in.close();

        return lineCount;
    }

    /**
     * Stores the number of characters, words, and lines in the file.
     *
     * @throws IOException if an exception occurs related to an input/output
     * operation
     */
    public void doIt() throws IOException {
        this.numCharacters = countCharacters(new FileInputStream(this.file));
        this.numWords = countWords(new FileInputStream(this.file));
        this.numLines = countLines(new Scanner(this.file.getAbsoluteFile()));
    }

    /**
     * Returns a string representation including the number of lines, words, and
     * characters of the file associated with this instance of WordCount
     *
     * @return string representation including the number of lines, words, and
     * characters of the file associated with this instance of WordCount
     */
    @Override
    public String toString() {
        return this.numLines + " " + this.numWords + " " + this.numCharacters + " " + file.getName();
    }
}
