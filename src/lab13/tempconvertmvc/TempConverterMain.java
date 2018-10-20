/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 16, 2018
 * Time: 9:49:42 PM
 *
 * Project: csci205
 * Package: lab13
 * File: TempConverterMain
 * Description: This file contains TempConverterMain, which is an MVC application
 *              that converts temperature values from Fahrenheit to Celsius.
 *
 * ****************************************
 */
package lab13.tempconvertmvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * TempConverterMain is an application that converts temperature values from
 * Fahrenheit to Celsius.
 *
 * @author Kartikeya Sharma
 */
public class TempConverterMain extends Application {

    /**
     * Model of the temperature conversion application
     */
    private TempConverterModel theModel;
    /**
     * View of the temperature conversion application
     */
    private TempConverterView theView;
    /**
     * Control of the temperature conversion application
     */
    private TempConverterController theCtrl;

    /**
     * Initializes the application
     *
     * @throws Exception if an unexpected issue arises
     */
    @Override
    public void init() throws Exception {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        this.theModel = new TempConverterModel();
        this.theView = new TempConverterView(theModel);
        this.theCtrl = new TempConverterController(theModel, theView);
    }

    /**
     * Starts the application
     *
     * @param primaryStage stage of the GUI
     */
    @Override
    public void start(Stage primaryStage) {
        // Sets up scene and connects to age
        Scene scene = new Scene(this.theView.getRootNode());

        primaryStage.setTitle("Temperature Calculator");
        primaryStage.setScene(scene);
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
