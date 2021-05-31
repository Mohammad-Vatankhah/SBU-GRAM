package Controller;

import Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class EditInformationController {
    public TextField firstNameField;
    public TextField lastNAmeField;
    public DatePicker birthdatePick;
    public TextField locationField;
    public TextField PhoneNumberField;
    public Label emptyFields;

    public void change(ActionEvent actionEvent) {
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("setting" , 414 , 637);
    }
}
