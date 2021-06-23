package Client.Controller;

import Client.Model.API;
import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.io.IOException;

public class ChangePassRController {
    public Label matchErr;
    public Label regexErr;
    public PasswordField newPass;
    public PasswordField confirmPass;

    public void change(ActionEvent actionEvent) {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])"
                + "(?=\\S+$).{8,20}$";
        if (!newPass.getText().equals(confirmPass.getText())){
            matchErr.setVisible(true);
            regexErr.setVisible(false);
        }
        else if (!newPass.getText().matches(regex)){
            regexErr.setVisible(true);
            matchErr.setVisible(false);
        }
        else {
            API.changePass(PassRecoveryController.usernameS , newPass.getText());
            try {
                new PageLoader().load("login" , 363 , 470);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
