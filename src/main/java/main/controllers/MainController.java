package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.utils.ColorUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Label rsColorLabel, rgbLabel, redLabel, greenLabel, blueLabel;

    @FXML
    private TextField rsColorField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    private void init() {
        colorPicker.valueProperty().addListener(x -> {
            int r = (int) (colorPicker.getValue().getRed() * 255.0D);
            int g = (int) (colorPicker.getValue().getBlue() * 255.0D);
            int b = (int) (colorPicker.getValue().getGreen() * 255.0D);
            int rsColor = ColorUtils.convertToHSB(r, g, b);
            rsColorLabel.setText("RS Color: " + rsColor);
            rsColorField.setText(String.valueOf(rsColor));
            updateColors();
        });


        rsColorField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                rsColorField.setText(newValue.replaceAll("[^\\d]", ""));
            }

            if (rsColorField.getText().isEmpty()) {
                return;
            }

            updateColors();

        });


    }

    private void updateColors() {

        javafx.scene.paint.Color c = ColorUtils.RS2HSB_to_RGB(Integer.parseInt(rsColorField.getText()));
        int r = (int) (c.getRed() * 255D);
        int g = (int) (c.getBlue() * 255D);
        int b = (int) (c.getGreen() * 255D);
        int rgb = (r << 16 | g << 8 | b);
        rgbLabel.setText("RGB: " + rgb);
        redLabel.setText("Red: " + r);
        greenLabel.setText("Green: " + g);
        blueLabel.setText("Blue: " + b);
    }

}
