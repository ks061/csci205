/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 19, 2018
 * Time: 7:19:08 PM
 *
 * Project: csci205
 * Package: lab13.tempconvertmvc
 * File: TempConverterController
 * Description: This file contains TempConverterController, which serves as the
 *              connector between the model and view in the temperature
 *              conversion MVC application.
 * ****************************************
 */
package lab13.tempconvertmvc;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 * TempConverterController serves as the connector between the model and view in
 * the temperature conversion application.
 *
 * @author Kartikeya Sharma
 */
public class TempConverterController implements EventHandler<ActionEvent> {

    /**
     * Model of the temperature conversion application
     */
    private TempConverterModel theModel;
    /**
     * View of the temperature conversion application
     */
    private TempConverterView theView;

    /**
     * Constructor that initializes references to the model and view of the
     * temperature conversion application
     *
     * @param theModel model of the temperature conversion application
     * @param theView view of the temperature conversion application
     */
    public TempConverterController(TempConverterModel theModel,
                                   TempConverterView theView) {
        this.theModel = theModel;
        this.theView = theView;
        this.theView.getBtnConvert().setOnAction(this);
        this.theView.getTxtFieldTempInput().setOnAction(this);
        theModel.getPropDoCtoF().bind(theView.getRbCtoF().selectedProperty());
        theModel.getPropDoFtoC().bind(theView.getRbFtoC().selectedProperty());
        theView.getLblUnits().textProperty().bind(Bindings.when(
                theModel.getPropDoCtoF()).then("(C)").otherwise("(F)"));
    }

    /**
     * Handles events that occur in the application
     *
     * @param event event that occurs in the application
     */
    @Override
    public void handle(ActionEvent event) {
        // Setting up the event handlers
        try {
            String temp = this.theView.getTxtFieldTempInput().getText();
            if (temp.length() > 0) {
                String result = theModel.stringConvert(temp);
                this.theView.getLabelResult().setText(result);
            }

        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect input!");
            alert.setHeaderText("Incorrect input specified!");
            alert.setContentText(String.format("Can not convert \"%s\"",
                                               this.theView.getTxtFieldTempInput().getText()));
            alert.show();

        }
    }

}
