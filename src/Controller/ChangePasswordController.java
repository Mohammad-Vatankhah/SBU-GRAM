package Controller;

import Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ChangePasswordController {
    public PasswordField newPassword;
    public PasswordField confirm;
    public PasswordField currentPassword;
    public Label matchError;
    public Label currentPassError;

    public void changePassword(ActionEvent actionEvent) {
        if (!newPassword.getText().equals(confirm.getText())){
            matchError.setVisible(true);
        }
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("setting" , 414 , 637);
    }

}
