package Client.Controller;

import Client.Model.API;
import Client.Model.PageLoader;
import Common.Post;
import Common.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UserProfileController {

    public static String user;
    public ArrayList<Post> posts;
    public Circle profileCircle;
    public Label followings;
    public Label followers;
    public Label username;
    public Label name;
    public JFXButton followButton;
    public JFXButton unfollowButton;
    public JFXListView<Post> postList;

    @FXML
    public void initialize(){
        User user = API.getUser(UserProfileController.user);
        username.setText(user.getUsername());
        name.setText(user.getName() + " " + user.getLastName());
        followers.setText(String.valueOf(user.getFollowers().size()));
        followings.setText(String.valueOf(user.getFollowings().size()));
        profileCircle.setStroke(javafx.scene.paint.Color.SEAGREEN);
        profileCircle.setFill(new ImagePattern(new Image(new ByteArrayInputStream(user.getProfile()))));
        profileCircle.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        profileCircle.setVisible(true);
        posts.addAll(API.getPosts(UserProfileController.user));
        Collections.sort(posts);
        postList.setItems(FXCollections.observableArrayList(posts));
        postList.setCellFactory(postList -> new PostItem());
    }

    public void follow(ActionEvent actionEvent){
        API.follow(LoginController.currentUser , user);
    }

    public void unfollow(ActionEvent actionEvent){
        API.unfollow(LoginController.currentUser , user);
    }
}
