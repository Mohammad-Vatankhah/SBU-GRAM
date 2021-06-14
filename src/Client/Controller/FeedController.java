package Client.Controller;

import Client.Model.*;
import Common.Post;
import Common.User;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FeedController {

    public static String currentUsername = LoginController.currentUser;
    public Button newPostButton;
    public Button profileButton;
    public Button feedButton;
    public JFXListView<Post> PostList;
    public ArrayList<Post> posts = new ArrayList<>();

    @FXML
    public void initialize(){
        User currentUser = API.getUser(currentUsername);
        for (User user:currentUser.getFollowings()){
            posts.addAll(API.getPosts(user.getUsername()));
        }
        posts.addAll(API.getPosts(currentUsername));
        Collections.sort(posts);
        PostList.setItems(FXCollections.observableArrayList(posts));
        PostList.setCellFactory(postList -> new PostItem());
    }

    public void newPostButton(ActionEvent actionEvent){
        try {
            new PageLoader().load("newPostPage" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void profileButton(ActionEvent actionEvent){
        try {
            new PageLoader().load("profilePage" , 414 , 637);
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

    public void profileImage(MouseEvent mouseEvent){
        try {
            new PageLoader().load("profilePage" , 414 , 637);
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
