package Controller;

import Model.PageLoader;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignupController {
    public TextField usernameField;
    public PasswordField passwordField;
    public TextField firstNameField;
    public TextField lastNAmeField;
    public JFXButton signupButton;
    public JFXButton loginButton;
    public TextField PhoneNumberField;
    public TextField passwordVisible;

    public void signUp(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password;
        String name = firstNameField.getText();
        String lastName = lastNAmeField.getText();
        String phone = PhoneNumberField.getText();
        if (passwordField.isVisible())
            password = passwordField.getText();
        else if (passwordVisible.isVisible())
            password = passwordVisible.getText();
    }

    public void login(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("login" , 363 , 470);
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
