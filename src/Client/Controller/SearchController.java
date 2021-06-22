package Client.Controller;

import Client.Model.*;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class SearchController {
    public Button feedButton;
    public Button searchButton;
    public Button newPostButton;
    public Button profileButton;
    public JFXTextField usernameField;
    public Label existError;
    public Label emptyError;

    public void search(ActionEvent actionEvent) {
        if (usernameField.getText().equals("")) {
            existError.setVisible(false);
            emptyError.setVisible(true);
        }
        else if (!API.isUsernameExist(usernameField.getText())){
            existError.setVisible(true);
            emptyError.setVisible(false);
        }
        else {
            UserProfileController.user = usernameField.getText();
            try {
                new PageLoader().load("UserProfile" , 414 , 637);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void newPostButton(ActionEvent actionEvent) {
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

    public void feedButton(ActionEvent actionEvent) {
        try {
            new PageLoader().load("feed" , 414 , 637);
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

    public void profileImage(MouseEvent mouseEvent) {
        try {
            new PageLoader().load("CurrentUserProfile" , 414 , 637);
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
