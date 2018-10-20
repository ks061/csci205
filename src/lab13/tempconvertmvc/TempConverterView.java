/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 *
 * Name: Kartikeya Sharma
 * Date: Oct 19, 2018
 * Time: 7:18:02 PM
 *
 * Project: csci205
 * Package: lab13.tempconvertmvc
 * File: TempConverterView
 * Description: This file contains TempConverterView, which serves as the
 *              view for the temperature conversion MVC application.
 * ****************************************
 */
package lab13.tempconvertmvc;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 * TempConverterView serves as the view for the temperature conversion MVC
 * application.
 *
 * @author Kartikeya Sharma
 */
public class TempConverterView {

    /**
     * Models for the temperature conversion MVC application
     */
    private TempConverterModel theModel;
    /**
     * Root node on the stage in the GUI
     */
    private BorderPane root;
    /**
     * Button that when pressed processes the temperature conversion
     */
    private Button btnConvert;
    /**
     * Label that holds the converted temperature
     */
    private Label lblResult;
    /**
     * Text field that takes in a temperature
     */
    private TextField txtFieldTempInput;
    /**
     * Label that holds the units for the temperature being inputted
     */
    private Label lblUnits;
    /**
     * Radio button representing the option to convert from Fahrenheit to
     * Celsius
     */
    private RadioButton rbFtoC;
    /**
     * Radio button representing the option to convert from Celsius to
     * Fahrenheit
     */
    private RadioButton rbCtoF;

    /**
     * Constructor that initializes a pointer to the model for the temperature
     * conversion MVC application and initializes and connects the components of
     * the GUI
     *
     * @param theModel pointer to the model for the temperature conversion MVC
     * application
     */
    public TempConverterView(TempConverterModel theModel) {
        this.theModel = theModel;

        root = new BorderPane();
        root.setPrefWidth(300);
        root.setPrefHeight(150);
        root.setPadding(new Insets(15, 15, 15, 15));

        FlowPane topPane = new FlowPane(Orientation.HORIZONTAL);
        topPane.setAlignment(Pos.CENTER);
        topPane.setHgap(10);
        Label label = new Label("Temperature");

        lblUnits = new Label("(F)");

        rbFtoC = new RadioButton("F to C");
        rbCtoF = new RadioButton("C to F");
        ToggleGroup group = new ToggleGroup();
        rbFtoC.setToggleGroup(group);
        rbCtoF.setToggleGroup(group);
        rbFtoC.setSelected(true);
        VBox leftPane = new VBox(10);
        leftPane.getChildren().addAll(rbFtoC, rbCtoF);

        txtFieldTempInput = new TextField();
        txtFieldTempInput.setAlignment(Pos.CENTER);
        txtFieldTempInput.setPrefColumnCount(5);
        topPane.getChildren().addAll(label, txtFieldTempInput, lblUnits);

        lblResult = new Label();
        lblResult.setMinWidth(75);
        lblResult.setMinHeight(25);
        Border tempOutputBorder = new Border(
                new BorderStroke(null, BorderStrokeStyle.SOLID,
                                 new CornerRadii(4),
                                 BorderWidths.DEFAULT));
        lblResult.setBorder(tempOutputBorder);
        lblResult.setAlignment(Pos.CENTER);

        btnConvert = new Button("Convert!");

        root.setTop(topPane);
        root.setLeft(leftPane);
        root.setCenter(lblResult);
        root.setBottom(btnConvert);

        BorderPane.setAlignment(btnConvert, Pos.CENTER);
    }

    /**
     * Gets the root node of the stage
     *
     * @return root node of the stage
     */
    public BorderPane getRootNode() {
        return root;
    }

    /**
     * Gets the button that converts the inputted temperature when pressed
     *
     * @return button that converts the inputted temperature when pressed
     */
    public Button getBtnConvert() {
        return btnConvert;
    }

    /**
     * Gets the converted temperature
     *
     * @return converted temperature
     */
    public Label getLabelResult() {
        return lblResult;
    }

    /**
     * Gets the text field for inputting a temperature to convert
     *
     * @return text field for inputting a temperature to convert
     */
    public TextField getTxtFieldTempInput() {
        return txtFieldTempInput;
    }

    /**
     * Gets the units for the temperature being inputted
     *
     * @return units for the temperature being inputted
     */
    public Label getLblUnits() {
        return lblUnits;
    }

    /**
     * Gets the radio button that allows the user to select the option to
     * convert the inputted value from a Fahrenheit temperature to a Celsius
     * temperature
     *
     * @return radio button that allows the user to select the option to convert
     * the inputted value from a Fahrenheit temperature to a Celsius temperature
     */
    public RadioButton getRbFtoC() {
        return rbFtoC;
    }

    /**
     * Gets the radio button that allows the user to select the option to
     * convert the inputted value from a Celsius temperature to a Fahrenheit
     * temperature
     *
     * @return radio button that allows the user to select the option to convert
     * the inputted value from a Celsius temperature to a Fahrenheit temperature
     */
    public RadioButton getRbCtoF() {
        return rbCtoF;
    }

    /**
     * Sets the units for the temperature being inputted
     *
     * @param lblUnits units for the temperature being inputted
     */
    public void setLblUnits(Label lblUnits) {
        this.lblUnits = lblUnits;
    }

    /**
     * Sets the radio button that allows the user to select the option to
     * convert the inputted value from a Celsius temperature to a Fahrenheit
     * temperature
     *
     * @param rbFtoC radio button that allows the user to select the option to
     * convert the inputted value from a Celsius temperature to a Fahrenheit
     * temperature
     */
    public void setRbFtoC(RadioButton rbFtoC) {
        this.rbFtoC = rbFtoC;
    }

    /**
     * Sets the radio button that allows the user to select the option to
     * convert the inputted value from a Celsius temperature to a Fahrenheit
     * temperature
     *
     * @param rbCtoF radio button that allows the user to select the option to
     * convert the inputted value from a Celsius temperature to a Fahrenheit
     * temperature
     */
    public void setRbCtoF(RadioButton rbCtoF) {
        this.rbCtoF = rbCtoF;
    }

}
