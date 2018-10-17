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

        Label tempOutput = new Label();
        tempOutput.setAlignment(Pos.CENTER);
        tempOutput.setMinWidth(75);
        tempOutput.setMinHeight(25);
        Border tempOutputBorder = new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                                 new CornerRadii(6),
                                 BorderWidths.DEFAULT));
        tempOutput.setBorder(tempOutputBorder);

        Button btnConvert = new Button("Convert!");

        Text errorMessage = new Text();
        errorMessage.setFill(Color.DARKRED);

        root.getChildren().addAll(topCell, tempOutput, btnConvert, errorMessage);

        btnConvert.setOnAction(new EventHandler<ActionEvent>() {
            private double convertFahrenheitToCelsius(double fahrenheitTemp) {
                return (5.0 / 9) * (fahrenheitTemp - 32);
            }

            @Override
            public void handle(ActionEvent event) {
                try {
                    double celsiusTempInput = Double.parseDouble(
                            txtFieldTempInput.getText());
                    double fahrenheitTempOutput = convertFahrenheitToCelsius(
                            celsiusTempInput);
                    tempOutput.setText(String.format("%.1f \u00b0C",
                                                     fahrenheitTempOutput));
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

        //        btn.setText("Say 'Hello World'");
        //        btn.setOnAction(new EventHandler<ActionEvent>() {
        //
        //            @Override
        //            public void handle(ActionEvent event) {
        //                System.out.println("Hello World!");
        //            }
        //        });
        //
        //        StackPane root = new StackPane();
        //        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
