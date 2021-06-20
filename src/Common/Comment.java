package Common;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable , Comparable<Comment> {
    public String comment;
    public Date date;
    public String user;

    public Comment(String comment, Date date, String user) {
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int compareTo(Comment comment) {
        return comment.date.compareTo(this.date);
    }
}
