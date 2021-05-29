package Controller;
import Model.PageLoader;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;

public class LoginController {
    @FXML
    public PasswordField passwordField;
    public JFXButton loginButton;
    public JFXButton signupButton;
    public TextField usernameField;
    public Label wrongPasswordLabel;
    public TextField passwordVisible;

    public void login(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password;
        if (passwordField.isVisible())
            password = passwordField.getText();
        else if (passwordVisible.isVisible())
            password = passwordVisible.getText();
    }

    public void signUp(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("signUp" , 400 , 610);
    }

    public void showPass(ActionEvent actionEvent) {
        if (!passwordVisible.isVisible()) {
            passwordField.setVisible(false);
            passwordVisible.setVisible(true);
            passwordVisible.setText(passwordField.getText());
        }
        else{
            passwordField.setVisible(true);
            passwordVisible.setVisible(false);
            passwordField.setText(passwordVisible.getText());
        }
    }
}

