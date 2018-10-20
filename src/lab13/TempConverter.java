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
 * File: TempConverter
 * Description: This file contains TempConverter, which is an application
 *              that converts temperature values from Fahrenheit to Celsius.
 *
 * ****************************************
 */
package lab13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * TempConverter is an application that converts temperature values from
 * Fahrenheit to Celsius.
 *
 * @author Kartikeya Sharma
 */
public class TempConverter extends Application {

    /**
     * Sets up the GUI at the start of the application launch
     *
     * @param primaryStage stage of the GUI
     */
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(5);
        root.setPrefWidth(250);
        root.setPadding(new Insets(10, 5, 10, 5));
        root.setAlignment(Pos.CENTER);

        FlowPane topCell = new FlowPane(Orientation.HORIZONTAL);
        topCell.setAlignment(Pos.CENTER);
        topCell.setHgap(10);
        Label label = new Label("Temperature (F):");
        final TextField txtFieldTempInput = new TextField();
        txtFieldTempInput.setAlignment(Pos.CENTER);
        txtFieldTempInput.setPrefColumnCount(5);
        topCell.getChildren().addAll(label, txtFieldTempInput);

        Label labelResult = new Label();
        labelResult.setAlignment(Pos.CENTER);
        labelResult.setMinWidth(75);
        labelResult.setMinHeight(25);
        Border tempOutputBorder = new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                                 new CornerRadii(6),
                                 BorderWidths.DEFAULT));
        labelResult.setBorder(tempOutputBorder);

        Button btnConvert = new Button("Convert!");

        Text errorMessage = new Text();
        errorMessage.setFill(Color.DARKRED);

        root.getChildren().addAll(topCell, labelResult, btnConvert, errorMessage);

        btnConvert.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * Converts temperatures from Fahrenheit to Celsius
             *
             * @param fahrenheitTemp Fahrenheit temperature to convert to
             * Celsius
             * @return converted Celsius temperature
             */
            private double convertFahrenheitToCelsius(double fahrenheitTemp) {
                return (5.0 / 9) * (fahrenheitTemp - 32);
            }

            /**
             * Handles events that occur in the application
             *
             * @param event event that occurs in the application
             */
            @Override
            public void handle(ActionEvent event) {
                try {
                    double fahrenheitTemp = Double.parseDouble(
                            txtFieldTempInput.getText());
                    double celsiusTemp = convertFahrenheitToCelsius(
                            fahrenheitTemp);
                    labelResult.setText(String.format("%.1f \u00b0C",
                                                      celsiusTemp));
                    errorMessage.setText("");
                } catch (NumberFormatException ex) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Incorrect input!");
                    alert.setHeaderText("Incorrect input specified!");
                    alert.setContentText(String.format("Can not convert \"%s\"",
                                                       txtFieldTempInput.getText()));
                    alert.show();

                } catch (Exception ex) {
                    errorMessage.setText(ex.toString());
                }
            }
        });

        txtFieldTempInput.setOnAction(btnConvert.getOnAction());

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Temperature Converter");
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
