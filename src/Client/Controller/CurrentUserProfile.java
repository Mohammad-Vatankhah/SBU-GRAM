package Client.Controller;

import Client.Model.*;
import Common.Post;
import Common.User;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
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
import java.util.ArrayList;
import java.util.Collections;

public class CurrentUserProfile {

    public Button feedButton;
    public Button newPostButton;
    public Circle profileCircle;
    public Label followings;
    public Label followers;
    public Label username;
    public Label name;
    public JFXListView<Post> postList;
    public ArrayList<Post> posts = new ArrayList<>();

    @FXML
    public void initialize(){
        User currentUser = API.getUser(LoginController.currentUser);
        profileCircle.setStroke(javafx.scene.paint.Color.SEAGREEN);
        profileCircle.setFill(new ImagePattern(new Image(new ByteArrayInputStream(currentUser.getProfile()))));
        profileCircle.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        profileCircle.setVisible(true);
        followings.setText(String.valueOf(currentUser.getFollowings().size()));
        followers.setText(String.valueOf(currentUser.getFollowers().size()));
        username.setText(currentUser.getUsername());
        name.setText(currentUser.getName() + " " + currentUser.getLastName());
        posts.addAll(API.getPosts(LoginController.currentUser));
        Collections.sort(posts);
        postList.setItems(FXCollections.observableArrayList(posts));
        postList.setCellFactory(postList -> new PostItem());
    }

    public void setting(MouseEvent mouseEvent) {
        try {
            new PageLoader().load("setting" , 414 , 637);
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

    public void searchButton(ActionEvent actionEvent) {
        try {
            new PageLoader().load("search" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newPostImage(MouseEvent mouseEvent) {
        try {
            new PageLoader().load("newPostPage" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void feedImage(MouseEvent mouseEvent) {
        try {
            new PageLoader().load("feed" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newPostButton(ActionEvent actionEvent) {
        try {
            new PageLoader().load("newPostPage" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void feedbutton(ActionEvent actionEvent) {
        try {
            new PageLoader().load("feed" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
