/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 19, 2018
 * Time: 9:04:12 PM
 *
 * Project: csci205
 * Package: lab13.trafficlightmvc
 * File: TrafficLightView
 * Description: This file contains TrafficLightView, which serves as the
 *              view for the interactive traffic light MVC application.
 * ****************************************
 */
package lab13.trafficlightmvc;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * TrafficLightView serves as the view for the interactive traffic light MVC
 * application.
 *
 * @author Kartikeya Sharma
 */
public class TrafficLightView {

    /**
     * Contains the root node of the stage of the GUI
     */
    private VBox root;
    /**
     * Contains each of the circles representing lights in the GUI
     */
    private ArrayList<Circle> lights;

    /**
     * Constructor that initializes the lights with a radius and a color and
     * adds them to the root node of the stage
     *
     */
    public TrafficLightView() {
        root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setMinHeight(300);
        lights = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lights.add(new Circle());
            lights.get(i).setRadius(50);
            lights.get(i).setFill(TrafficLightModel.values()[i].getOffColor());
        }
        root.getChildren().addAll(lights);
    }

    /**
     * Gets the list of traffic lights
     *
     * @return list of traffic lights
     */
    public ArrayList<Circle> getCircles() {
        return lights;
    }

    /**
     * Gets the root node of the stage
     *
     * @return root node of the stage
     */
    public VBox getRootNode() {
        return root;
    }

}
