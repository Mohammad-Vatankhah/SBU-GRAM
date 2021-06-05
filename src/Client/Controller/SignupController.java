package Client.Controller;

import Client.Model.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SignupController {
    public byte[] userProfile;
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
    public Label passwordRegexError;
    public Label passwordHint1;
    public Label passwordHint2;
    public Label emptyFields;
    public Circle circleProfile;

    {
        try {
            userProfile = new FileInputStream("F:\\SBU\\exc\\AP\\SBU_gram\\images").readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
                password = passwordField.getText();
        }

        else {
                password = passwordVisible.getText();
        }

        if (!password.matches(regex)){
            passwordRegexError.setText("-your password does not meet the requirements.");
            passwordRegexError.setVisible(true);
            passwordHint1.setVisible(false);
            passwordHint2.setVisible(false);
        } else passwordRegexError.setVisible(false);

        boolean usernameUnique = API.isUsernameExist(username);

        if (usernameUnique){
            passwordRegexError.setText("-Username already picked.");
            passwordRegexError.setVisible(true);
        }

        if (!usernameField.getText().equals("") && !firstNameField.getText().equals("") && !lastNAmeField.getText().equals("") && password.matches(regex) && !usernameUnique){
            API.signup(username , password , name , lastName , location , phone , birthdate , userProfile);
            try {
                new PageLoader().load("feed" , 414 , 637);
            } catch (IOException e) {
                e.printStackTrace();
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
            try {
                userProfile = new FileInputStream(selectedFile).readAllBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            circleProfile.setStroke(Color.SEAGREEN);
            circleProfile.setFill(new ImagePattern(image));
            circleProfile.setEffect(new DropShadow(+25d , 0d , +2d , Color.DARKSEAGREEN));
            circleProfile.setVisible(true);
        }
    }
}
