/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 19, 2018
 * Time: 7:17:53 PM
 *
 * Project: csci205
 * Package: lab13.tempconvertmvc
 * File: TempConverterModel
 * Description: This file contains TempConverterModel, which serves as the
 *              model for the temperature conversion MVC application.
 * ****************************************
 */
package lab13.tempconvertmvc;

import javafx.beans.property.SimpleBooleanProperty;

/**
 * TempConverterModel serves as the model for the temperature conversion MVC
 * application.
 *
 * @author Kartikeya Sharma
 */
public class TempConverterModel {

    /**
     * Represents if the option to convert from Fahrenheit to Celsius is
     * selected
     */
    private SimpleBooleanProperty propDoFtoC;
    /**
     * Represents if the option to convert from Celsius to Fahrenheit is
     * selected
     */
    private SimpleBooleanProperty propDoCtoF;

    /**
     * Constructor that initializes the option for converting from Fahrenheit to
     * Celsius to true and that for converting from Celsius to Fahrenheit to
     * false
     */
    public TempConverterModel() {
        this.propDoFtoC = new SimpleBooleanProperty(true);
        this.propDoCtoF = new SimpleBooleanProperty(false);
    }

    /**
     * FStringToC - Convert a Fahrenheit string to a Celsius string
     *
     * @param sFTemp - the Fahrenheit temp as a string
     * @return the Celsius string
     * @throws NumberFormatException if the string can't be converted
     */
    public String FStringToC(String sFTemp) {
        double fTemp = Double.parseDouble(sFTemp);
        double cTemp = (fTemp - 32.0) * 5.0 / 9.0;
        String result = String.format("%.1f", cTemp);
        return result;
    }

    /**
     * CStringToF - Convert a Celsius string to a Fahrenheit string
     *
     * @param sCTemp - the Fahrenheit temp as a string
     * @return the Fahrenheit string
     * @throws NumberFormatException if the string can't be converted
     */
    public String CStringToF(String sCTemp) {
        double cTemp = Double.parseDouble(sCTemp);
        double fTemp = 9.0 / 5.0 * cTemp + 32;
        String result = String.format("%.1f", fTemp);
        return result;
    }

    /**
     * Use the boolean properties to determine how to convert the temperature
     * string
     *
     * @param temp String to convert
     * @return the converted temperature as a String
     */
    public String stringConvert(String temp) {
        if (propDoFtoC.get()) {
            return this.FStringToC(temp);
        }

        if (propDoCtoF.get()) {
            return this.CStringToF(temp);
        }

        // if for some reason neither is true
        return temp;
    }

    /**
     * Gets the property representing if the option to convert from Fahrenheit
     * to Celsius is selected
     *
     * @return property representing if the option to convert from Fahrenheit to
     * Celsius is selected
     */
    public SimpleBooleanProperty getPropDoFtoC() {
        return propDoFtoC;
    }

    /**
     * Gets the property representing if the option to convert from Celsius to
     * Fahrenheit is selected
     *
     * @return property representing if the option to convert from Celsius to
     * Fahrenheit is selected
     */
    public SimpleBooleanProperty getPropDoCtoF() {
        return propDoCtoF;
    }

}
