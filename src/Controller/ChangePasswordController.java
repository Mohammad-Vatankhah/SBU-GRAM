package Controller;

import Model.PageLoader;
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

    public void changePassword(ActionEvent actionEvent) {
        if (!newPassword.getText().equals(confirm.getText())){
            matchError.setVisible(true);
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
