package Controller;

import Model.PageLoader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class LoginController {
    @FXML
    public JFXPasswordField passwordField;
    public JFXButton loginButton;
    public JFXButton signupButton;
    public JFXTextField usernameField;
    public Label wrongPasswordLabel;
    public JFXTextField passwordVisible;

    public void login(ActionEvent actionEvent){
        String username = usernameField.getText();
        String password = null;
        if (passwordField.isVisible())
            password = passwordField.getText();
        else if (passwordVisible.isVisible())
            password = passwordVisible.getText();
        if (password.equals("mamad123456") && username.equals("mamadi")) {
            try {
                new PageLoader().load("feed" , 414 , 637);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void signUp(ActionEvent actionEvent){
        try {
            new PageLoader().load("signUp" , 414 , 610);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

