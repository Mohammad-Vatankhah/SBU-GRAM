package Client.Controller;

import Common.Post;
import javafx.scene.control.ListCell;

public class PostItem extends ListCell<Post> {
    @Override
    public void updateItem(Post post , boolean empty){
        super.updateItem(post, empty);
        if (post != null) {
            setGraphic(new PostItemController(post).init());
        }
    }
}