package Client.Controller;

import Client.Model.*;
import Common.Post;
import Common.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class NewPostController {
    public byte[] postImage = null;
    public static String currentUser = LoginController.currentUser;
    public Button newPostButton;
    public Button profileButton;
    public JFXTextArea descriptionField;
    public TextField titleField;
    public JFXButton shareButton;
    public Button feedButton;
    public Button searchButton;
    public JFXButton addImageButton;
    public Rectangle imageBox;
    public Label fieldError;
    public Label imageError;

    public void share(ActionEvent actionEvent) {
        if (titleField.getText().equals("") || descriptionField.getText().equals("") || postImage == null) {
            fieldError.setVisible(titleField.getText().equals("") || descriptionField.getText().equals(""));
            imageError.setVisible(postImage == null);
        }
        else {
            Post post = new Post(currentUser, API.getUser(currentUser), titleField.getText(), descriptionField.getText(), new Date());
            post.setImage(postImage);
            API.publishPost(currentUser, post);
            try {
                new PageLoader().load("feed", 414, 637);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void feedButton(ActionEvent actionEvent){
        try {
            new PageLoader().load("feed" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void profileButton(ActionEvent actionEvent) {
        try {
            new PageLoader().load("profilePage" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void profileImage(MouseEvent mouseEvent){
        try {
            new PageLoader().load("profilePage" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void feedImage(MouseEvent mouseEvent){
        try {
            new PageLoader().load("feed" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchButton(ActionEvent actionEvent) {
        try {
            new PageLoader().load("search" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchImage(MouseEvent mouseEvent) {
        try {
            new PageLoader().load("search" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addImage(ActionEvent actionEvent) {
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
                postImage = new FileInputStream(selectedFile).readAllBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageBox.setStroke(Color.SEAGREEN);
            imageBox.setFill(new ImagePattern(image));
            imageBox.setEffect(new DropShadow(+25d , 0d , +2d , Color.DARKSEAGREEN));
            imageBox.setVisible(true);
        }
    }
}
