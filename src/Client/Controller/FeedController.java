package Client.Controller;

import Client.Model.PageLoader;
import Common.Post;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class FeedController {


    public Button newPostButton;
    public Button profileButton;
    public JFXListView<Post> postList;
    public Button feedButton;
    ArrayList<Post> posts = new ArrayList<>();

    @FXML
    public void initialize(){
        postList.setItems(FXCollections.observableArrayList(posts));
        postList.setCellFactory(postList -> new PostItem());
    }

    public void newPostButton(ActionEvent actionEvent){
        try {
            new PageLoader().load("newPost" , 414 , 637);
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
            new PageLoader().load("newPost" , 414 , 637);
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
