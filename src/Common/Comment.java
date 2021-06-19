package Common;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable , Comparable<Comment> {
    public String comment;
    public Date date;
    public User user;

    public Comment(String comment, Date date, User user) {
        this.comment = comment;
        this.date = date;
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int compareTo(Comment comment) {
        return comment.date.compareTo(this.date);
    }
}
