package Client.Controller;

import Client.Model.*;
import Common.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ProfilePageController {
    public Button newPostButton;
    public Button feedButton;
    public Circle circleProfile;
    public Label username;
    public Label location;
    public Label followers;
    public Label followings;
    public Label name;

    @FXML
    public void initialize(){
        User currentUser = API.getUser(LoginController.currentUser);
        circleProfile.setStroke(Color.SEAGREEN);
        circleProfile.setFill(new ImagePattern(new Image(new ByteArrayInputStream(currentUser.getProfile()))));
        circleProfile.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        circleProfile.setVisible(true);
        username.setText(currentUser.getUsername());
        followers.setText(String.valueOf(currentUser.getFollowers().size()));
        followings.setText(String.valueOf(currentUser.getFollowings().size()));
        if (!currentUser.getLocation().equals("")){
            location.setText(currentUser.getLocation());
            location.setVisible(true);
        }
        name.setText(currentUser.getName() + " " + currentUser.getLastName());
    }

    public void feedButton(ActionEvent actionEvent){
        try {
            new PageLoader().load("feed" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newPostButton(ActionEvent actionEvent){
        try {
            new PageLoader().load("newPostPage" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newPostImage(MouseEvent mouseEvent){
        try {
            new PageLoader().load("newPostPage" , 414 , 637);
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

    public void settingImage(MouseEvent mouseEvent){
        try {
            new PageLoader().load("setting" , 414 , 637);
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
}
