package Controller;

import Model.PageLoader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SignupController {
    public TextField usernameField;
    public JFXPasswordField passwordField;
    public JFXTextField firstNameField;
    public JFXTextField lastNAmeField;
    public JFXButton signupButton;
    public JFXButton loginButton;
    public JFXTextField PhoneNumberField;
    public JFXTextField passwordVisible;
    public JFXTextField locationField;
    public DatePicker birthdatePick;
    public JFXButton addImageButton;
    public ImageView profilePhoto;
    public Label passwordRegexError;
    public Label passwordHint1;
    public Label passwordHint2;
    public Label emptyFields;
    public Circle circleProfile;


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

    public void login(ActionEvent actionEvent){
        try {
            new PageLoader().load("login" , 363 , 470);
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

    public void addImage(ActionEvent actionEvent){
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
            circleProfile.setStroke(Color.SEAGREEN);
            circleProfile.setFill(new ImagePattern(image));
            circleProfile.setEffect(new DropShadow(+25d , 0d , +2d , Color.DARKSEAGREEN));
            circleProfile.setVisible(true);
        }
    }
}
