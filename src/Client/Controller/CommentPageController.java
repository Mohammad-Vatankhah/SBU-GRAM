package Client.Controller;

import Client.Model.API;
import Client.Model.PageLoader;
import Common.Comment;
import Common.Post;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

public class CommentPageController {
    public JFXTextArea commentTextArea;
    public JFXListView<Comment> commentList;
    public JFXButton sendButton;
    public static Post post;
    public CopyOnWriteArrayList<Comment> comments;
    public Label err;

    @FXML
    public void initialize(){
        comments = new CopyOnWriteArrayList<>(API.getComment(post , post.getPublisher()));
        Collections.sort(comments);
        commentList.setItems(FXCollections.observableArrayList(comments));
        commentList.setCellFactory(commentList -> new commentCell());
    }

    public void backIcon(MouseEvent mouseEvent) {
        try {
            new PageLoader().load("feed" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(ActionEvent actionEvent) {
        if (commentTextArea.getText().equals("")){
            err.setVisible(true);
        }
        else {
            Comment comment = new Comment(commentTextArea.getText(), new Date(), LoginController.currentUser);
            API.addComment(LoginController.currentUser, post.getPublisher(), post, comment);
            try {
                new PageLoader().load("commentPage", 414, 637);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendIcon(MouseEvent mouseEvent) {
        if (commentTextArea.getText().equals("")) {
            err.setVisible(true);
        } else {
            Comment comment = new Comment(commentTextArea.getText(), new Date(), LoginController.currentUser);
            API.addComment(LoginController.currentUser, post.getPublisher(), post, comment);
            try {
                new PageLoader().load("commentPage", 414, 637);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
