package Client.Controller;


import Client.Model.API;
import Client.Model.PageLoader;
import Common.Comment;
import Common.User;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CommentCellController {
    public Label username;
    public Label date;
    public Label description;
    public Circle profileCircle;
    public AnchorPane root;
    public Comment comment;

    public CommentCellController(Comment comment) {
        this.comment = comment;
        try {
            new PageLoader().load("commentCell" , this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AnchorPane init(){
        User user = API.getUser(comment.getUser());
        username.setText(comment.getUser());
        profileCircle.setStroke(javafx.scene.paint.Color.SEAGREEN);
        profileCircle.setFill(new ImagePattern(new Image(new ByteArrayInputStream(user.getProfile()))));
        profileCircle.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        profileCircle.setVisible(true);
        description.setText(comment.getComment());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        date.setText(dateFormat.format(comment.getDate()));
        return root;
    }

    public void username(MouseEvent mouseEvent){
        if (this.username.getText().equals(LoginController.currentUser)){
            try {
                new PageLoader().load("CurrentUserProfile" , 414 , 637);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                new PageLoader().load("UserProfile" , 414 , 637);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
