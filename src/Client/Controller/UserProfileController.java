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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
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
    public ArrayList<Post> posts = new ArrayList<>();
    public Circle profileCircle;
    public Label followings;
    public Label followers;
    public Label username;
    public Label name;
    public JFXButton followButton;
    public JFXButton unfollowButton;
    public JFXListView<Post> postList;
    public Button newPostButton;
    public Button profileButton;
    public Button searchButton;

    @FXML
    public void initialize() {
        if (user.equals(LoginController.currentUser)) {
            try {
                new PageLoader().load("CurrentUserProfile", 414, 637);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            User user = API.getInfo(LoginController.currentUser, UserProfileController.user);
            username.setText(user.getUsername());
            name.setText(user.getName() + " " + user.getLastName());
            followers.setText(String.valueOf(user.getFollowers().size()));
            followings.setText(String.valueOf(user.getFollowings().size()));
            profileCircle.setStroke(javafx.scene.paint.Color.SEAGREEN);
            profileCircle.setFill(new ImagePattern(new Image(new ByteArrayInputStream(user.getProfile()))));
            profileCircle.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
            profileCircle.setVisible(true);
            if (user.getFollowers().contains(LoginController.currentUser)) {
                followButton.setVisible(false);
                unfollowButton.setVisible(true);
            } else if (!user.getFollowers().contains(LoginController.currentUser)) {
                followButton.setVisible(true);
                unfollowButton.setVisible(false);
            }
            posts.addAll(API.getPosts(UserProfileController.user));
            Collections.sort(posts);
            postList.setItems(FXCollections.observableArrayList(posts));
            postList.setCellFactory(postList -> new PostItem());
        }
    }

    public void follow(ActionEvent actionEvent){
        API.follow(LoginController.currentUser , user);
        try {
            new PageLoader().load("UserProfile" , 414 , 637);
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

    public void profileImage(MouseEvent mouseEvent) {
        try {
            new PageLoader().load("CurrentUserProfile" , 414 , 637);
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

    public void profileButton(ActionEvent actionEvent) {
        try {
            new PageLoader().load("CurrentUserProfile" , 414 , 637);
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

    public void feedButton(MouseEvent mouseEvent) {
        try {
            new PageLoader().load("feed" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unfollow(ActionEvent actionEvent) {
        API.unfollow(LoginController.currentUser , user);
        try {
            new PageLoader().load("UserProfile" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

