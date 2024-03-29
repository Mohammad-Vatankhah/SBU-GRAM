package Common;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class Post implements Serializable , Comparable<Post> {
    private final String writer;
    private String publisher;
    private String title;
    private int numOfLikes = 0;
    private String description;
    private byte[] image;
    private CopyOnWriteArrayList<String> likes = new CopyOnWriteArrayList<>();
    private int reposts = 0;
    private Date date;
    private CopyOnWriteArrayList<Comment> comments = new CopyOnWriteArrayList<>();

    public Post(String writer, String publisher , String title, String description , Date date) {
        this.writer = writer;
        this.publisher = publisher;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public int getHashcode(){
        return this.hashCode();
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

    public void addLike(String username){
        this.likes.add(username);
    }

    public void removeLike(String username){
        this.likes.remove(username);
    }

    public CopyOnWriteArrayList<String> getLikes() {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void addLikeNum(){
        this.numOfLikes++;
    }

    public void removeLikeNum(){
        this.numOfLikes--;
    }

    public int getNumOfLikes() {
        return numOfLikes;
    }

    public void removeAllLikesAndComments(){
        comments.clear();
        likes.clear();
        numOfLikes = 0;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Post post) {
        return post.date.compareTo(this.date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return writer.equals(post.writer) && title.equals(post.title) && description.equals(post.description) && Arrays.equals(image, post.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(writer, title, description);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}