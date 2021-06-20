package Client.Controller;

import Client.Model.*;
import com.jfoenix.controls.JFXPasswordField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ChangePasswordController {
    public JFXPasswordField newPassword;
    public JFXPasswordField confirm;
    public JFXPasswordField currentPassword;
    public Label matchError;
    public Label currentPassError;
    public Label passwordRegexError;

    public void changePassword(ActionEvent actionEvent) {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])"
                + "(?=\\S+$).{8,20}$";
        if (!newPassword.getText().equals(confirm.getText())){
            passwordRegexError.setVisible(false);
            matchError.setVisible(true);
            currentPassError.setVisible(false);
        }
        else if (!currentPassword.getText().equals(API.getPassword(LoginController.currentUser))){
            matchError.setVisible(false);
            passwordRegexError.setVisible(false);
            currentPassError.setVisible(true);
        }
        else if (!newPassword.getText().matches(regex)){
            passwordRegexError.setVisible(true);
            currentPassError.setVisible(false);
            matchError.setVisible(false);
        }
        else {
            API.changePass(LoginController.currentUser , newPassword.getText());
            try {
                new PageLoader().load("setting" , 414 , 637);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void back(MouseEvent mouseEvent){
        try {
            new PageLoader().load("setting" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
