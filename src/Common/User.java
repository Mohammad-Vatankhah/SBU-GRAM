package Common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class User implements Serializable {
    private byte[] profile;
    private String profileAddress;
    private final String username;
    private String password;
    private String phoneNumber;
    private String name;
    private String lastName;
    private String birthdate;
    private String location;
    private CopyOnWriteArrayList<String> followings = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<String> followers = new CopyOnWriteArrayList<>();
    private ArrayList<Post> posts = new ArrayList<>();

    public User(String name ,String lastName , String username, String password) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(profile, user.profile) && username.equals(user.username) && password.equals(user.password) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(birthdate, user.birthdate) && Objects.equals(location, user.location) && Objects.equals(followings, user.followings) && Objects.equals(followers, user.followers) && Objects.equals(posts, user.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profile, username, password, phoneNumber, name, lastName, birthdate, location, followings, followers, posts);
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

    public CopyOnWriteArrayList<String> getFollowings() {
        return followings;
    }

    public void addFollowings(String user) {
        this.followings.add(user);
    }

    public void removeFollowings(String user){
        this.followings.remove(user);
    }

    public CopyOnWriteArrayList<String> getFollowers() {
        return followers;
    }

    public void addFollowers(String user) {
        this.followers.add(user);
    }

    public void removeFollowers(String user){
        this.followers.remove(user);
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    public void setProfileAddress(String profileAddress) {
        this.profileAddress = profileAddress;
    }

    public String getProfileAddress() {
        return profileAddress;
    }
}
