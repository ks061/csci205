/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 13, 2018
 * Time: 7:16:06 PM
 *
 * Project: csci205
 * Package: lab08
 * File: AddRemoveChoices
 * Description: This file contains enumerated types of user choices.
 *
 * ****************************************
 */
package lab08;

/**
 * AddRemoveChoices contains enumerated types of user choices
 *
 * @author Kartikeya Sharma
 */
public enum AddRemoveChoices {

    /**
     * Enumerated types of functionalities that CoinCollectionClient offers to
     * interact with CoinCollection.
     */
    DONE("Done"), REMOVE("Remove Coins"), ADD("Add Coins");

    /**
     * String name for enumerated type
     */
    private String label;

    /**
     * Constructor that initializes <code>label</code> to inputted String name
     * associated with enumerated type.
     *
     * @param s String name associated with enumerated type
     */
    private AddRemoveChoices(String s) {
        this.label = s;
    }

    /**
     * Gets a String representation of the enumerated type, which is its name or
     * label.
     *
     * @return String name associated with enumerated type
     */
    @Override
    public String toString() {
        return label;
    }
}
