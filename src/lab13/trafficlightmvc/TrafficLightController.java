/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 19, 2018
 * Time: 9:18:50 PM
 *
 * Project: csci205
 * Package: lab13.trafficlightmvc
 * File: TrafficLightController
 * Description: This file contains TrafficLightController, which serves as the
 *              connector between the model and view in the interactive traffic
 *              light MVC application.
 * ****************************************
 */
package lab13.trafficlightmvc;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 * TrafficLightController serves as the connector between the model and view in
 * the interactive traffic light MVC application.
 *
 * @author Kartikeya Sharma
 */
public class TrafficLightController implements EventHandler<MouseEvent> {

    /**
     * View of the interactive traffic light MVC application
     */
    private final TrafficLightView theView;

    /**
     * Constructor that initializes a pointer to the view of the interactive
     * traffic light MVC application, binds the radius of the traffic light
     * circles to the size of the window, creates each circle, and binds their
     * colors to the value of the model enum representing the value of the
     * lights
     *
     * @param theView view of the interactive traffic light MVC application
     */
    public TrafficLightController(TrafficLightView theView) {
        this.theView = theView;
        NumberBinding radBinding = theView.getRootNode().heightProperty().divide(
                6).add(-15);
        for (Circle c : theView.getCircles()) {
            c.radiusProperty().bind(radBinding);
            c.setOnMouseClicked(this);
            TrafficLightModel light = getLightForCircle(c);
            c.fillProperty().bind(Bindings.when(light.getIsOnProperty()).then(
                    light.getOnColor()).otherwise(light.getOffColor()));
        }
    }

    /**
     * Gets the light enum for the corresponding circle in the GUI
     *
     * @param c circle in the GUI
     * @return light corresponding to the circle in the GUI <code>c</code>
     */
    private TrafficLightModel getLightForCircle(Circle c) {
        return TrafficLightModel.values()[theView.getCircles().indexOf(
                c)];
    }

    /**
     * Handles events that occur in the application
     *
     * @param event event that occurs in the application
     */
    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            int circleIndex = theView.getCircles().indexOf(event.getSource());
            TrafficLightModel.values()[circleIndex].toggle();
        }
    }

}
