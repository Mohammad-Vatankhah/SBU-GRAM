package Client.Controller;

import Common.Post;
import Client.Model.*;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PostItemController {
    public String currentUser = LoginController.currentUser;
    public Label username;
    public Label title;
    public Label writer;
    public Label description;
    public Label likes;
    public Label date;
    public ImageView greenLike;
    public Rectangle imageBox;
    public Label reposts;
    public Circle profileImage;
    public AnchorPane root;
    public ImageView whiteLike;
    public Post post;

    public PostItemController(Post post) {
        this.post = post;
        try {
            new PageLoader().load("postItem", this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AnchorPane init(){
        writer.setText(post.getWriter());
        title.setText(post.getTitle());
        reposts.setText(String.valueOf(post.getReposts()));
        likes.setText(String.valueOf(post.getNumOfLikes()));
        username.setText(post.getPublisher().getUsername());
        description.setText(post.getPublisher().getUsername() + " : " + post.getDescription());
        profileImage.setStroke(javafx.scene.paint.Color.SEAGREEN);
        profileImage.setFill(new ImagePattern(new Image(new ByteArrayInputStream(post.getPublisher().getProfile()))));
        profileImage.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        profileImage.setVisible(true);
        imageBox.setStroke(javafx.scene.paint.Color.SEAGREEN);
        imageBox.setFill(new ImagePattern(new Image(new ByteArrayInputStream(post.getImage()))));
        imageBox.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        imageBox.setVisible(true);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        date.setText(dateFormat.format(post.getDate()));
        if (post.getLikes().contains(currentUser)) {
            greenLike.setVisible(true);
            whiteLike.setVisible(false);
        }
        else {
            whiteLike.setVisible(true);
            greenLike.setVisible(false);
        }
            return root;
    }

    public void repost(MouseEvent mouseEvent){

    }

    public void disLike(MouseEvent mouseEvent) {
        API.dislike(currentUser , post.getPublisher().getUsername() , post);
        likes.setText(String.valueOf(post.getLikes().size() - 1));
        greenLike.setVisible(false);
        whiteLike.setVisible(true);
    }

    public void viewCommentsIcon(MouseEvent mouseEvent) {
        try {
            CommentPageController.post = post;
            new PageLoader().load("commentPage" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewComments(MouseEvent mouseEvent) {
        try {
            CommentPageController.post = post;
            new PageLoader().load("commentPage" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void likeImage(MouseEvent mouseEvent) {
        API.like(currentUser , post.getPublisher().getUsername() , post);
        likes.setText(String.valueOf(post.getLikes().size() + 1));
        greenLike.setVisible(true);
        whiteLike.setVisible(false);
    }

    public void writerID(MouseEvent mouseEvent) {
    }

    public void publisherID(MouseEvent mouseEvent) {
    }
}
