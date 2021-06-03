package Client.Controller;

import Client.Model.PageLoader;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class SearchController {
    public Button feedButton;
    public Button searchButton;
    public Button newPostButton;
    public Button profileButton;
    public JFXTextField usernameField;

    public void search(ActionEvent actionEvent) {
    }

    public void newPostButton(ActionEvent actionEvent) {
        try {
            new PageLoader().load("newPost" , 414 , 637);
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

    public void feedButton(ActionEvent actionEvent) {
        try {
            new PageLoader().load("feed" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newPostImage(MouseEvent mouseEvent) {
        try {
            new PageLoader().load("newPost" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void profileImage(MouseEvent mouseEvent) {
        try {
            new PageLoader().load("profilePage" , 414 , 637);
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
}
