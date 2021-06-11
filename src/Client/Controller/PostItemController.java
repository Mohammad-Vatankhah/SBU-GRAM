package Client.Controller;

import Common.Post;
import Client.Model.*;
import Common.User;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PostItemController {
    public User currentUser = LoginController.currentUser;
    public Label username;
    public Label title;
    public Label writer;
    public Label likes;
    public ImageView greenLike;
    public Rectangle imageBox;
    public Label reposts;
    public Circle profileImage;
    public Pane root;
    public ImageView whiteLike;
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
        profileImage.setStroke(javafx.scene.paint.Color.SEAGREEN);
        profileImage.setFill(new ImagePattern(new Image(new ByteArrayInputStream(post.getPublisher().getProfile()))));
        profileImage.setEffect(new DropShadow(+25d , 0d , +2d , Color.DARKSEAGREEN));
        profileImage.setVisible(true);
        imageBox.setStroke(javafx.scene.paint.Color.SEAGREEN);
        imageBox.setFill(new ImagePattern(new Image(new ByteArrayInputStream(post.getImage()))));
        imageBox.setEffect(new DropShadow(+25d , 0d , +2d , Color.DARKSEAGREEN));
        imageBox.setVisible(true);
        return root;
    }

    public void repost(MouseEvent mouseEvent){

    }

    public void disLike(MouseEvent mouseEvent) {
        API.dislike(currentUser.getUsername() , post.getPublisher().getUsername() , post);
        greenLike.setVisible(false);
        whiteLike.setVisible(true);
    }

    public void addComment(MouseEvent mouseEvent) {
    }

    public void likeImage(MouseEvent mouseEvent) {
        API.like(currentUser.getUsername() , post.getPublisher().getUsername() , post);
        greenLike.setVisible(true);
        whiteLike.setVisible(false);
    }

    public void writerID(MouseEvent mouseEvent) {
    }

    public void publisherID(MouseEvent mouseEvent) {
    }
}
