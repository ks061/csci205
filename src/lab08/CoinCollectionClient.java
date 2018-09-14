/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 13, 2018
 * Time: 6:27:59 PM
 *
 * Project: csci205
 * Package: lab08
 * File: CoinCollectionClient
 * Description: This file contains a runner method, main,
                to test the CoinCollection class.
 *
 * ****************************************
 */
package lab08;

import javax.swing.JOptionPane;

/**
 * CoinCollectionClient contains a runner method, main, that tests out the
 * CoinCollection class.
 *
 * @author Kartikeya Sharma
 */
public class CoinCollectionClient {

    /**
     * Runner method that tests out the CoinCollection class by leveraging the
     * JOptionPane class to interact with the user.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CoinCollection myCoins = new CoinCollection();

        // Initialize the coin collection with some coins
        myCoins.addCoins(Coin.NICKEL, 5);
        myCoins.addCoins(Coin.DIME, 3);
        myCoins.addCoins(Coin.QUARTER, 7);

        String[] whatNextOptions = new String[AddRemoveChoices.values().length];
        for (int i = 0; i < AddRemoveChoices.values().length; i++) {
            whatNextOptions[i] = AddRemoveChoices.values()[i].toString();
        }

        int functionalitySelection;
        Object coinTypeSelection = null;
        String amountCoinsInput = null;
        int amountCoinsRequested;
        int amountCoinsRemoved;

        do {
            functionalitySelection = JOptionPane.showOptionDialog(null,
                                                                  myCoins.toStringNewLine() + "Select your action: ",
                                                                  "Add or remove?",
                                                                  JOptionPane.DEFAULT_OPTION,
                                                                  JOptionPane.QUESTION_MESSAGE,
                                                                  null,
                                                                  whatNextOptions,
                                                                  whatNextOptions[0]);
            if (functionalitySelection == AddRemoveChoices.ADD.ordinal() || functionalitySelection == AddRemoveChoices.REMOVE.ordinal()) {
                coinTypeSelection = JOptionPane.showInputDialog(null,
                                                                "Select coin type",
                                                                "Coin Selection",
                                                                JOptionPane.QUESTION_MESSAGE,
                                                                null,
                                                                Coin.values(),
                                                                Coin.values()[0]);
                if (coinTypeSelection == null) {
                    functionalitySelection = JOptionPane.CLOSED_OPTION;
                }

                if (functionalitySelection == AddRemoveChoices.ADD.ordinal()) {
                    amountCoinsInput = JOptionPane.showInputDialog(null,
                                                                   "How many do you want to add?",
                                                                   "Add coins",
                                                                   JOptionPane.QUESTION_MESSAGE);
                    if (amountCoinsInput == null) {
                        functionalitySelection = JOptionPane.CLOSED_OPTION;
                    }
                    else {
                        amountCoinsRequested = Integer.parseInt(amountCoinsInput);
                        myCoins.addCoins((Coin) coinTypeSelection,
                                         amountCoinsRequested);
                    }
                }
                else if (functionalitySelection == AddRemoveChoices.REMOVE.ordinal()) {
                    amountCoinsInput = JOptionPane.showInputDialog(null,
                                                                   "How many do you want to remove? Max = " + myCoins.getCount(
                                                                           (Coin) coinTypeSelection),
                                                                   "Remove coins",
                                                                   JOptionPane.QUESTION_MESSAGE);

                    if (amountCoinsInput == null) {
                        functionalitySelection = JOptionPane.CLOSED_OPTION;
                    }
                    else {
                        amountCoinsRequested = Integer.parseInt(amountCoinsInput);
                        amountCoinsRemoved = myCoins.removeCoins(
                                (Coin) coinTypeSelection,
                                amountCoinsRequested);
                        if (amountCoinsRemoved < amountCoinsRequested) {
                            JOptionPane.showMessageDialog(null,
                                                          "Requested: Removal of "
                                                          + amountCoinsRequested
                                                          + " " + coinTypeSelection
                                                          + "\n" + "Actual: Removal of "
                                                          + amountCoinsRemoved
                                                          + " " + coinTypeSelection
                                                          + "\n\n"
                                                          + "Reason: You only had "
                                                          + amountCoinsRemoved
                                                          + " " + coinTypeSelection,
                                                          "Coin Removal Issue",
                                                          JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                }

            }

        } while (functionalitySelection == AddRemoveChoices.ADD.ordinal() || functionalitySelection == AddRemoveChoices.REMOVE.ordinal());

        JOptionPane.showMessageDialog(null,
                                      "You have: \n" + myCoins.toStringNewLine() + "\nGoodbye!",
                                      "Goodbye!",
                                      JOptionPane.INFORMATION_MESSAGE);
    }

}
