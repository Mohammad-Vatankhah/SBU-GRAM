package Client.Controller;

import Client.Model.*;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
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
