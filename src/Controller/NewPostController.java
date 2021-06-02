package Controller;

import Model.PageLoader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class NewPostController {
    public Button newPostButton;
    public Button profileButton;
    public JFXTextArea descriptionField;
    public JFXTextField titleField;
    public JFXButton shareButton;
    public Button feedButton;
    public Button searchButton;

    public void share(ActionEvent actionEvent) {
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
}
