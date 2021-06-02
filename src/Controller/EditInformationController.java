package Controller;

import Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXPasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class EditInformationController {
    public JFXTextField firstNameField;
    public JFXTextField lastNAmeField;
    public DatePicker birthdatePick;
    public JFXTextField locationField;
    public JFXTextField PhoneNumberField;
    public Label emptyFields;

    public void change(ActionEvent actionEvent) {
    }

    public void back(MouseEvent mouseEvent){
        try {
            new PageLoader().load("setting" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
