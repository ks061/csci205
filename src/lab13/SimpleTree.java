/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 17, 2018
 * Time: 1:22:29 PM
 *
 * Project: csci205
 * Package: lab13
 * File: SimpleTree
 * Description: This file contains a SimpleTree, which is an application
 *              designed with JavaFX to display a tree.
 *
 * ****************************************
 */
package lab13;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * SimpleTree is an application designed with JavaFX to display a tree.
 *
 * @author Kartikeya Sharma
 */
public class SimpleTree extends Application {

    private void updateLinePosition(Line line, RectTreeNode r1, RectTreeNode r2) {
        line.setStartX(r1.getX() + r1.getWidth() / 2);
        line.setStartY(r1.getY() + r1.getHeight() / 2);
        line.setEndX(r2.getX() + r2.getWidth() / 2);
        line.setEndY(r2.getY() + r2.getHeight() / 2);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        // Let's create some tree nodes..
        RectTreeNode r1 = new RectTreeNode(Color.BLUE);
        r1.setX(200);
        r1.setY(100);

        RectTreeNode r2 = new RectTreeNode(Color.LIGHTBLUE);
        r2.setX(75);
        r2.setY(250);

        RectTreeNode r3 = new RectTreeNode(Color.LIGHTBLUE);
        r3.setX(325);
        r3.setY(250);

        Line line1to2 = new Line();
        line1to2.setStrokeWidth(3);
        updateLinePosition(line1to2, r1, r2);

        Line line1to3 = new Line();
        line1to3.setStrokeWidth(3);
        updateLinePosition(line1to3, r1, r3);

        root.getChildren().addAll(line1to2, line1to3, r1, r2, r3);

        Scene scene = new Scene(root, 500, 500, Color.DARKGRAY);

        primaryStage.setTitle("Shapes Demo");
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
