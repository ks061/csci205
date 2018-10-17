/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 17, 2018
 * Time: 1:55:40 PM
 *
 * Project: csci205
 * Package: lab13
 * File: RectTreeNode
 * Description: This file contains RectTreeNode, which represents
 *              a rectangle node within a tree.
 *
 * ****************************************
 */
package lab13;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * RectTreeNode represents a rectangle node within a tree.
 *
 * @author Kartikeya Sharma
 */
public class RectTreeNode extends Rectangle {

    private static final double INIT_WIDTH = 100;
    private static final double INIT_HEIGHT = 75;

    public RectTreeNode(Paint fillColor) {
        super(INIT_WIDTH, INIT_HEIGHT, fillColor);
        setupEffects();
        continuousTransitions();
    }

    private void setupEffects() {
        DropShadow ds = new DropShadow();
        ds.setOffsetX(4.0);
        ds.setOffsetY(4.0);
        ds.setColor(Color.BLACK);
        this.setEffect(ds);

        // Extra credit: Added reflection effect
        Reflection reflection = new Reflection();
        reflection.setFraction(0.25);
        this.setEffect(reflection);
    }

    private void continuousTransitions() {
        // Extra credit: Additional RotateTransition effect
        RotateTransition rotate = new RotateTransition(Duration.millis(1000));
        rotate.setFromAngle(-10);
        rotate.setToAngle(10);

        // Extra credit: Additional ScaleTransition effect
        ScaleTransition scale = new ScaleTransition(Duration.millis(250));
        scale.setToX(0.9);
        scale.setToY(0.9);

        ParallelTransition transition = new ParallelTransition(this, rotate,
                                                               scale);
        transition.setAutoReverse(true);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.play();
    }
}
