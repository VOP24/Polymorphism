package vop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

@SuppressWarnings("ReassignedVariable")
public class PrimaryController {
    @FXML
    private RadioButton squareRadio;
    @FXML
    private RadioButton rectangleRadio;
    @FXML
    private  RadioButton ellipseRadio;
    @FXML
    private RadioButton circleRadio;
    @FXML
    private ToggleGroup radioButtonToggle;
    @FXML
    private TextField param1;
    @FXML
    private TextField param2;
    @FXML
    private TextArea output;

    @FXML
    public void initialize() {
        ellipseRadio.setUserData(ShapeFacade.SHAPES.ELLIPSE);
        rectangleRadio.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        circleRadio.setUserData(ShapeFacade.SHAPES.CIRCLE);
        squareRadio.setUserData(ShapeFacade.SHAPES.SQUARE);
    }

    @FXML
    private void getShapeInfo() {
        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES)radioButtonToggle.getSelectedToggle().getUserData();
        Double val1 = 0d;
        Double val2 = 0d;
        String info;
        try {
            if (radioButtonToggle.getSelectedToggle() == squareRadio || radioButtonToggle.getSelectedToggle() == circleRadio) {
                val1 = Double.parseDouble(param1.getText());
                info = ShapeFacade.getInstance().getShapeInfo(shape, val1);
            } else {
                val1 = Double.parseDouble(param1.getText());
                val2 = Double.parseDouble(param2.getText());
                info = ShapeFacade.getInstance().getShapeInfo(shape, val1, val2);
            }
        } catch (NumberFormatException e) {
            info = "You have entered something which isn't a number";
        }

        output.setText(info);
    }
    @FXML
    private void radioChange(ActionEvent event) {
        if (event.getSource() == circleRadio || event.getSource() == squareRadio) {
            param1.setVisible(true);
            param2.setVisible(false);
        } else if (event.getSource() == ellipseRadio || event.getSource() == rectangleRadio) {
            param1.setVisible(true);
            param2.setVisible(true);
        }
    }

}
