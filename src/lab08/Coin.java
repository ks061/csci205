/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Sep 13, 2018
 * Time: 1:23:14 PM
 *
 * Project: csci205
 * Package: lab08
 * File: Coin
 * Description: This file contains enumerated
                types of coins.
 *
 * ****************************************
 */
package lab08;

/**
 * Coin - A simple enumerated type to represent the different types of coins
 *
 * @author Kartikeya Sharma
 */
enum Coin {
    /**
     * Enumerated types of coins
     */
    NICKEL(0.05),
    DIME(0.10),
    QUARTER(0.25);

    /**
     * Dollar value associated with enumerated type
     */
    private double value;

    /**
     * Constructs an enumerated type with an associated dollar value
     *
     * @param value dollar value associated with enumerated type
     */
    private Coin(double value) {
        this.value = value;
    }

    /**
     * Gets the dollar value of the enum type
     *
     * @return dollar value of the enum type
     */
    public double getValue() {
        return this.value;
    }
}
