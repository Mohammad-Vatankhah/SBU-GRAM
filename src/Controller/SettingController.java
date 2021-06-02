package Controller;

import Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SettingController {
    public Circle circleProfile;

    public void logout(ActionEvent actionEvent){
        try {
            new PageLoader().load("login" , 363 , 470);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeProfilePhoto(MouseEvent mouseEvent) {
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

    public void changePassword(MouseEvent mouseEvent){
        try {
            new PageLoader().load("changePassword" , 363 , 470);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editInformation(MouseEvent mouseEvent){
        try {
            new PageLoader().load("editInformation" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void back(MouseEvent mouseEvent){
        try {
            new PageLoader().load("profilePage" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeProfileImage(MouseEvent mouseEvent) {
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

    public void changePasswordImage(MouseEvent mouseEvent){
        try {
            new PageLoader().load("changePassword" , 363 , 470);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editInformationImage(MouseEvent mouseEvent){
        try {
            new PageLoader().load("editInformation" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
