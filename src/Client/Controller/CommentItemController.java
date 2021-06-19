package Client.Controller;

import Client.Model.PageLoader;
import Common.Comment;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CommentItemController {
    public String currentUser = LoginController.currentUser;
    public Label username;
    public Label date;
    public Pane root;
    public Label commentText;
    public Circle profile;
    public Comment comment;


    public CommentItemController(Comment comment){
        this.comment = comment;
        try {
            new PageLoader().load("commentItem" , this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pane init(){
        username.setText(comment.getUser().getUsername());
        commentText.setText(comment.getComment());
        profile.setStroke(javafx.scene.paint.Color.SEAGREEN);
        profile.setFill(new ImagePattern(new Image(new ByteArrayInputStream(comment.getUser().getProfile()))));
        profile.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        profile.setVisible(true);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        date.setText(dateFormat.format(comment.getDate()));
        return root;
    }

    public void userProfile(MouseEvent mouseEvent){

    }
}
