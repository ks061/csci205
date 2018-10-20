/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 19, 2018
 * Time: 9:03:31 PM
 *
 * Project: csci205
 * Package: lab13.trafficlightmvc
 * File: TrafficLightMain
 * Description: This file contains TrafficLightMain, which is an MVC application
 *              that allows the user to toggle the lights of a traffic light by
 *              clicking them.
 *
 * ****************************************
 */
package lab13.trafficlightmvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * TrafficLightMain represents an MVC application that allows the user to toggle
 * the lights of a traffic light by clicking them.
 *
 * @author Kartikeya Sharma
 */
public class TrafficLightMain extends Application {

    /**
     * View of the interactive traffic light MVC application
     */
    private TrafficLightView theView;
    /**
     * Controller of the interactive traffic light MVC application
     */
    private TrafficLightController theController;
    // Note that the model of the interactive traffic light MVC application
    // is encapsulated within the enum TrafficLightModel

    /**
     * Initializes the application
     *
     * @throws Exception if an unexpected issue arises
     */
    @Override
    public void init() throws Exception {
        super.init();
        theView = new TrafficLightView();
    }

    /**
     * Starts the application
     *
     * @param primaryStage stage of the GUI
     */
    @Override
    public void start(Stage primaryStage) {
        theController = new TrafficLightController(theView);

        Scene scene = new Scene(theView.getRootNode());

        primaryStage.setTitle("Traffic Light");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * Launches the application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
