package Model;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Post {
    private String writer;
    private String title;
    private String description;
    private int likes = 0;
    private int reposts = 0;
    private final Date date;
    private ConcurrentHashMap<Date , String> comments = new ConcurrentHashMap<>();

    public Post(String writer, String title, String description , Date date) {
        this.writer = writer;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
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

    public void addLike(){
        this.likes++;
    }

    public int getLikes() {
        return likes;
    }

    public void addRepost(){
        this.reposts++;
    }

    public int getReposts() {
        return reposts;
    }

    public void addComment(Date date , String comment){
        comments.put(date , comment);
    }

    public Map<Date, String> getComments() {
        return comments;
    }
}
