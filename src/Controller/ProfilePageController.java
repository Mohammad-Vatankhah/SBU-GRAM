package Controller;

import Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ProfilePageController {
    public Button feetButton;
    public Button newPostButton;

    public void feedButton(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("feed" , 414 , 637);
    }

    public void newPostButton(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("newPost" , 414 , 637);
    }

    public void newPostImage(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("newPost" , 414 , 637);
    }

    public void feedImage(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("feed" , 414 , 637);
    }

    public void settingImage(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("setting" , 414 , 637);
    }
}
