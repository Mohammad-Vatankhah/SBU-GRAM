package Controller;

import Model.PageLoader;
import Model.Post;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class FeedController {


    public Button feetButton;
    public Button newPostButton;
    public Button profileButton;
    public JFXListView<String> PostList;
    ArrayList<Post> posts = new ArrayList<>();

    public void newPostButton(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("newPost" , 414 , 637);
    }

    public void profileButton(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("profilePage" , 414 , 637);
    }

    public void newPostImage(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("newPost" , 414 , 637);
    }

    public void profileImage(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("profilePage" , 414 , 637);
    }
}
