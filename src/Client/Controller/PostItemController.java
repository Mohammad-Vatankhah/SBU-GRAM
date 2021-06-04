package Client.Controller;

import Common.Post;
import Client.Model.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.io.IOException;

public class PostItemController {
    public Label username;
    public Label title;
    public Circle profileImage;
    public Label reposts;
    public Pane root;
    public Label writer;
    public Label likes;
    Post post;

    public PostItemController(Post post) throws IOException {
        new PageLoader().load("postItem", this);
        this.post = post;
    }

    public Pane init(){
        writer.setText(post.getWriter());
        title.setText(post.getTitle());
        reposts.setText(String.valueOf(post.getReposts()));
        likes.setText(String.valueOf(post.getLikes().size()));
        return root;
    }

    public void repost(MouseEvent mouseEvent){

    }
}
