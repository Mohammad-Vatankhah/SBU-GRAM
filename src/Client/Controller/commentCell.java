package Client.Controller;

import Common.Comment;
import javafx.scene.control.ListCell;

public class commentCell extends ListCell<Comment> {
    @Override
    public void updateItem(Comment comment , boolean empty){
        super.updateItem(comment, empty);
        if (comment != null) {
            setGraphic(new CommentCellController(comment).init());
        }
    }
}