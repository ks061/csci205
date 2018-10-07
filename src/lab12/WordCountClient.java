/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 4, 2018
 * Time: 9:59:11 PM
 *
 * Project: csci205
 * Package: lab12
 * File: WordCountClient
 * Description: This file contains WordCountClient, which uses WordCount.
 *
 * ****************************************
 */
package lab12;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * WordCountClient uses WordCount.
 *
 * @author Kartikeya Sharma
 */
public class WordCountClient {

    /**
     * Finds attribute character, word, and line counts of a file using
     * WordCount
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        boolean runProgram = true;
        JFileChooser fc;
        WordCount wc;
        int userResponse;

        while (runProgram) {
            fc = new JFileChooser(".");
            if (fc.showOpenDialog(new JFrame()) != JFileChooser.APPROVE_OPTION) {
                break;
            }

            try {
                wc = new WordCount(fc.getSelectedFile());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex, "File Not Found",
                                              JOptionPane.ERROR_MESSAGE
                );
                continue;
            }

            try {
                wc.doIt();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex,
                                              "IOException: File could not be processed.",
                                              JOptionPane.ERROR_MESSAGE
                );
                break;
            }

            userResponse = JOptionPane.showOptionDialog(new JFrame(),
                                                        wc.toString() + "\nTry again?",
                                                        "WordCount Results",
                                                        JOptionPane.YES_NO_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE,
                                                        null,
                                                        null,
                                                        null);

            if (userResponse != JOptionPane.YES_OPTION) {
                runProgram = false;
            }
        }

        JOptionPane.showMessageDialog(new JFrame(), "Goodbye!", "Goodbye!",
                                      JOptionPane.INFORMATION_MESSAGE);

    }

}
