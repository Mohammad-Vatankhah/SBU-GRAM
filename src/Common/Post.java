package Common;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Post {
    private final String writer;
    private String publisher;
    private String title;
    private String description;
    private ArrayList<User> likes = new ArrayList<>();
    private int reposts = 0;
    private final Date date;
    private CopyOnWriteArrayList<Comment> comments = new CopyOnWriteArrayList<>();

    public Post(String writer, String title, String description , Date date) {
        this.writer = writer;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return reposts == post.reposts && Objects.equals(writer, post.writer) && Objects.equals(publisher, post.publisher) && Objects.equals(title, post.title) && Objects.equals(description, post.description) && Objects.equals(likes, post.likes) && Objects.equals(date, post.date) && Objects.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(writer, publisher, title, description, likes, reposts, date, comments);
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void addLike(User user){
        this.likes.add(user);
    }

    public void removeLike(User user){
        this.likes.remove(user);
    }

    public ArrayList<User> getLikes() {
        return likes;
    }

    public void addRepost(){
        this.reposts++;
    }

    public int getReposts() {
        return reposts;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public CopyOnWriteArrayList<Comment> getComments() {
        return comments;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
