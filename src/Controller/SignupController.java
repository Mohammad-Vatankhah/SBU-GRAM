package Controller;

import Model.PageLoader;
import javafx.scene.control.*;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import com.jfoenix.controls.JFXButton;
import com.sun.glass.ui.CommonDialogs;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class SignupController {
    public TextField usernameField;
    public PasswordField passwordField;
    public TextField firstNameField;
    public TextField lastNAmeField;
    public JFXButton signupButton;
    public JFXButton loginButton;
    public TextField PhoneNumberField;
    public TextField passwordVisible;
    public TextField locationField;
    public DatePicker birthdatePick;
    public JFXButton addImageButton;
    public ImageView profilePhoto;
    public Label passwordRegexError;
    public Label passwordHint1;
    public Label passwordHint2;
    public Label emptyFields;


    public void signUp(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password;
        String name = firstNameField.getText();
        String lastName = lastNAmeField.getText();
        String phone = PhoneNumberField.getText();
        String location = locationField.getText();
        String birthdate = birthdatePick.getEditor().getText();
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])"
                + "(?=\\S+$).{8,20}$";

        if (usernameField.getText().equals("") || firstNameField.getText().equals("") || lastNAmeField.getText().equals("")){
            passwordHint1.setVisible(false);
            passwordHint2.setVisible(false);
            emptyFields.setVisible(true);
        }

        if (passwordField.isVisible()) {
            if (passwordField.getText().matches(regex)) {
                password = passwordField.getText();
                passwordRegexError.setVisible(false);
            }
            else{
                passwordRegexError.setVisible(true);
                passwordHint1.setVisible(false);
                passwordHint2.setVisible(false);
            }
        }

        else if (passwordVisible.isVisible()) {
            if (passwordVisible.getText().matches(regex)) {
                password = passwordVisible.getText();
                passwordRegexError.setVisible(false);
            }

            else{
                passwordRegexError.setVisible(true);
                passwordHint1.setVisible(false);
                passwordHint2.setVisible(false);
            }
        }

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

    public void addImage(ActionEvent actionEvent) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        ArrayList<String> imageFormats = new ArrayList<>();
        imageFormats.add("*.jpeg");
        imageFormats.add("*.JPEG");
        imageFormats.add("*.png");
        imageFormats.add("*.PNG");
        imageFormats.add("*.jpg");
        imageFormats.add("*.JPG");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("images", imageFormats));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null){
            Image image = new Image(selectedFile.toURI().toString());
            profilePhoto.setImage(image);
        }
    }
}
