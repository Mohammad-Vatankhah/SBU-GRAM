package Controller;

import Model.PageLoader;
import Model.Post;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class NewPostController {
    public Button feetButton;
    public Button newPostButton;
    public Button profileButton;
    public JFXTextArea descriptionField;
    public TextField titleField;
    public JFXButton shareButton;

    public void share(ActionEvent actionEvent) {
    }

    public void feedButton(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("feed" , 400 , 637);
    }

    public void profileButton(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("profilePage" , 400 , 637);
    }

    public void profileImage(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("profilePage" , 400 , 637);
    }

    public void feedImage(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("feed" , 400 , 637);
    }
}
