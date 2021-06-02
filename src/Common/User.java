package Common;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class User {
    private Image profile;
    private final String username;
    private String password;
    private String phoneNumber;
    private String name;
    private String lastName;
    private String birthdate;
    private String location;
    private ArrayList<User> followings = new ArrayList<>();
    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<Post> posts = new ArrayList<>();

    public User(String name ,String lastName , String username, String password) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<User> getFollowings() {
        return followings;
    }

    public void addFollowings(User user) {
        this.followings.add(user);
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void addFollowers(User user) {
        this.followers.add(user);
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
    public void addPost(Post post){
        this.posts.add(post);
    }
}
