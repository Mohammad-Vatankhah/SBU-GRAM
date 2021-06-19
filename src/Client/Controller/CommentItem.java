package Client.Controller;

import Common.Comment;
import Common.Post;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class CommentItem extends ListCell<Comment> {
    @Override
    public void updateItem(Comment comment , boolean empty){
        super.updateItem(comment, empty);
        if (comment != null) {
            setGraphic(new CommentItemController(comment).init());
        }
    }
}
