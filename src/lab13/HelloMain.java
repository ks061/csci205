/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 15, 2018
 * Time: 8:42:11 PM
 *
 * Project: csci205
 * Package: lab13
 * File: HelloMain
 * Description: This file contains the HelloMain, which is an application
 *              with a Hello World button.
 *
 * ****************************************
 */
package lab13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * HelloMain is an application with a Hello World button.
 *
 * @author Kartikeya Sharma
 */
public class HelloMain extends Application {

    /**
     * Sets up the GUI at the start of the application launch
     *
     * @param primaryStage stage of the GUI
     */
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15, 15, 15, 15));
        root.setAlignment(Pos.CENTER);

        HBox topPane = new HBox(10);
        root.getChildren().add(topPane);
        topPane.getChildren().add(new Label("Your name:"));
        TextField txtNameInput = new TextField();
        topPane.getChildren().add(txtNameInput);

        Button btn = new Button();
        btn.setText("Show my name!");

        root.getChildren().add(btn);

        root.getChildren().add(new Separator());

        Text textNameOutput1 = new Text();
        textNameOutput1.setFont(Font.font(null, FontWeight.BOLD, 30));
        textNameOutput1.setFill(Color.GREEN);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        dropShadow.setHeight(5);
        dropShadow.setRadius(2);
        dropShadow.setColor(Color.DARKOLIVEGREEN);
        textNameOutput1.setEffect(dropShadow);

        Text textNameOutput2 = new Text();
        textNameOutput2.setFont(Font.font(null, FontWeight.NORMAL, 30));
        textNameOutput2.setFill(Color.CRIMSON);
        Reflection reflection = new Reflection();
        reflection.setFraction(0.8);
        textNameOutput2.setEffect(reflection);

        Region spacer = new Region();
        // VBox.setVgrow(spacer, Priority.ALWAYS);

        Text textNameOutput3 = new Text();
        textNameOutput3.setFont(Font.font(null, FontWeight.LIGHT, 30));
        textNameOutput3.setFill(Color.RED);
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(1.5f);
        innerShadow.setOffsetY(1.5f);
        textNameOutput3.setEffect(innerShadow);

        VBox textNameOutputBox = new VBox(12.5, textNameOutput1, textNameOutput2,
                                          new Region(), new Region(),
                                          textNameOutput3);
        textNameOutputBox.setAlignment(Pos.CENTER);
        root.getChildren().add(textNameOutputBox);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Handles events that occur in the application
             *
             * @param event event that occurs in the application
             */
            @Override
            public void handle(ActionEvent event) {
                textNameOutput1.setText(txtNameInput.getText());
                textNameOutput2.setText(txtNameInput.getText());
                textNameOutput3.setText(txtNameInput.getText());
            }
        });

        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");
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
