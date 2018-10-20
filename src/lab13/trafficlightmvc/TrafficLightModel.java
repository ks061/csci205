/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 19, 2018
 * Time: 9:01:10 PM
 *
 * Project: csci205
 * Package: lab13.trafficlightmvc
 * File: TrafficLightModel
 * Description: This file contains TrafficLightModel, which serves as the
 *              model for the interactive traffic light MVC application.
 * ****************************************
 */
package lab13.trafficlightmvc;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Color;

/**
 * TrafficLightModel serves as the model for the interactive traffic light MVC
 * application.
 *
 * @author Kartikeya Sharma
 */
public enum TrafficLightModel {
    RED(Color.RED, Color.DARKRED),
    YELLOW(Color.YELLOW, Color.DARKKHAKI),
    GREEN(Color.GREEN, Color.DARKGREEN);

    /**
     * Represents whether the light is on
     */
    private BooleanProperty isOn;
    /**
     * Color of the light when it is on
     */
    private Color onColor;
    /**
     * Color of the light when it is off
     */
    private Color offColor;

    /**
     * Initializes each light with a color for when it is on and one for when it
     * is off
     *
     * @param onColor color of the light when it is on
     * @param offColor color of the light when it is off
     */
    private TrafficLightModel(Color onColor, Color offColor) {
        isOn = new SimpleBooleanProperty(false);
        this.onColor = onColor;
        this.offColor = offColor;
    }

    /**
     * Toggles the light
     */
    public void toggle() {
        isOn.set(!isOn.get());
    }

    /**
     * Determines whether the light is on or off
     *
     * @return true if the light is on; otherwise false
     */
    public boolean isLightOn() {
        return isOn.get();
    }

    /**
     * Gets the property representing whether the light is on or off
     *
     * @return property representing whether the light is on or off
     */
    public BooleanProperty getIsOnProperty() {
        return isOn;
    }

    /**
     * Gets the color of the light when it is on
     *
     * @return color of the light when it is on
     */
    public Color getOnColor() {
        return onColor;
    }

    /**
     * Gets the color of the light when it is off
     *
     * @return color of the light when it is off
     */
    public Color getOffColor() {
        return offColor;
    }
}
