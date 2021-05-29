package Controller;

import Model.PageLoader;
import Model.Post;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;

public class FeedController {


    public Button feetButton;
    public Button newPostButton;
    public Button profileButton;
    public JFXListView<String> PostList;
    ArrayList<Post> posts = new ArrayList<>();

    public void newPostButton(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("newPost" , 400 , 610);
    }

    public void profileButton(ActionEvent actionEvent) {
    }
}
