package Server;

import Common.Command;
import Common.Comment;
import Common.Post;
import Common.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class API {
    static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static Map<String, Object> isUsernameExist(Map<String, Object> receive) {
        Map<String, Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        User user = Server.users.get(username);
        Boolean exists = (user != null);
        answer.put("answer", exists);
        answer.put("command", Command.USERNAME_UNIQUE);
        return answer;
    }

    public static Map<String, Object> login(Map<String, Object> receive) {
        Map<String, Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        String password = (String) receive.get("password");
        User user = Server.users.get(username);
        if (user == null || !password.equals(user.getPassword())) {
            answer.put("answer", false);
        }
        else if (password.equals(user.getPassword())){
            answer.put("answer", true);
            Date date = new Date();
            System.out.println("action: connect, login\n" + username + "login\ntime: " + format.format(date));
        }
        answer.put("command", Command.LOGIN);

        return answer;
    }

    public static Map<String, Object> signup(Map<String, Object> receive) {
        Map<String, Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        if (Server.users.get(username) != null) {
            answer.put("answer", false);
        } else {
            String name = (String) receive.get("name");
            String lastname = (String) receive.get("lastname");
            String password = (String) receive.get("password");
            User user = new User(name, lastname, username, password);
            user.setPhoneNumber((String) receive.get("phoneNumber"));
            user.setBirthdate((String) receive.get("birthdate"));
            user.setProfile((byte[]) receive.get("profile"));
            user.setLocation((String) receive.get("location"));
            Server.users.put(username, user);
            answer.put("answer", true);
            Date date = new Date();
            System.out.println(username + " register " + user.getProfileAddress() + "\ntime: " + format.format(date));
        }
        answer.put("command", Command.SIGNUP);
        return answer;
    }

    public static Map<String, Object> publishPost(Map<String, Object> receive) {
        Map<String, Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        Post post = (Post) receive.get("post");
        Server.users.get(username).addPost(post);
        answer.put("answer", true);
        answer.put("command", Command.PUBLISH_POST);
        Date date = new Date();
        System.out.println(username + " publish\n" + "message: " + post.getTitle() + " " + post.getPublisher() + "\ntime: " + format.format(date));
        return answer;
    }

    public static Map<String, Object> follow(Map<String, Object> receive) {
        Map<String, Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        String target = (String) receive.get("target");
        Server.users.get(username).addFollowings(Server.users.get(target));
        Server.users.get(target).addFollowers(Server.users.get(username));
        answer.put("answer", true);
        answer.put("command", Command.FOLLOW);
        Date date = new Date();
        System.out.println("action: follow\n" + username + " action\n" + "message: " + target + "\ntime: " + format.format(date));
        return answer;
    }

    public static Map<String, Object> unfollow(Map<String, Object> receive) {
        Map<String, Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        String target = (String) receive.get("target");
        Server.users.get(username).removeFollowings(Server.users.get(target));
        Server.users.get(target).removeFollowers(Server.users.get(username));
        answer.put("answer", true);
        answer.put("command", Command.UNFOLLOW);
        Date date = new Date();
        System.out.println("action: unfollow\n" + username + " action\n" + "message: " + target + "\ntime: " + format.format(date));
        return answer;
    }

    public static Map<String, Object> like(Map<String, Object> receive) {
        Map<String, Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        String targetUsername = (String) receive.get("targetUsername");
        Post likedPost = (Post) receive.get("post");
        User target = Server.users.get(targetUsername);
        for (Post post : target.getPosts()) {
            if (post.equals(likedPost))
                post.addLike(Server.users.get(username));
        }
        answer.put("answer", true);
        answer.put("command", Command.LIKE);
        Date date = new Date();
        System.out.println("action: like\n" + username + "like\n" + "message: " + targetUsername + " " + likedPost.getTitle() + "\ntime: " + format.format(date));
        return answer;
    }

    public static Map<String, Object> dislike(Map<String, Object> receive) {
        Map<String, Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        String targetUsername = (String) receive.get("targetUsername");
        Post dislikedPost = (Post) receive.get("post");
        User target = Server.users.get(targetUsername);
        for (Post post : target.getPosts()) {
            if (post.equals(dislikedPost))
                post.removeLike(Server.users.get(username));
        }
        answer.put("answer", true);
        answer.put("command", Command.DISLIKE);
        Date date = new Date();
        System.out.println("action: dislike\n" + username + "dislike\n" + "message: " + targetUsername + " " + dislikedPost.getTitle() + "\ntime: " + format.format(date));
        return answer;
    }

    public static Map<String, Object> addComment(Map<String, Object> receive) {
        Map<String, Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        String targetUsername = (String) receive.get("targetUsername");
        Post post = (Post) receive.get("post");
        Comment comment = (Comment) receive.get("comment");
        User target = Server.users.get(targetUsername);
        for (Post post1 : target.getPosts()) {
            if (post1.equals(post))
                post1.addComment(comment);
        }
        answer.put("answer", true);
        answer.put("command", Command.ADD_COMMENT);
        Date date = new Date();
        System.out.println(username + " comment\n" + "message: " + post.getTitle() + "\ntime: " + format.format(date));
        return answer;
    }

    public static Map<String , Object> getPosts(Map<String , Object> receive){
        Map<String , Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        ArrayList<Post> posts = Server.users.get(username).getPosts();
        answer.put("answer" , posts);
        answer.put("command" , Command.GET_POSTS);
        Date date = new Date();
        System.out.println(username + " get posts list\ntime: " + format.format(date));
        return answer;
    }

    public static Map<String , Object> updateProfile(Map<String , Object> receive){
        Map<String , Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        User user = Server.users.get(username);
        user.setName((String) receive.get("newName"));
        user.setBirthdate((String) receive.get("newBirthdate"));
        user.setLastName((String) receive.get("newLastname"));
        user.setLocation((String) receive.get("newLocation"));
        user.setPhoneNumber((String) receive.get("newPhoneNumber"));
        answer.put("answer" , true);
        answer.put("command" , Command.UPDATE_PROFILE);
        Date date = new Date();
        System.out.println(username + " update info\ntime: " + format.format(date));
        return answer;
    }

    public static Map<String , Object> repost(Map<String , Object> receive){
        Map<String , Object> answer = new HashMap<>();
        Post post = (Post) receive.get("post");
        String username = (String) receive.get("username");
        User user = Server.users.get(username);
        post.setPublisher(user);
        user.addPost(post);
        answer.put("answer" , true);
        answer.put("command" , Command.REPOST);
        Date date = new Date();
        System.out.println("action: repost\n" + username + " repost\n" + "message: " + post.getWriter() + " " + post.getTitle() + "\ntime: " + format.format(date));
        return answer;
    }

    public static Map<String , Object> getInfo(Map<String , Object> receive){
        Map<String , Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        String target = (String) receive.get("targetUsername");
        User user = Server.users.get(target);
        answer.put("answer" , true);
        answer.put("name" , user.getName());
        answer.put("lastName" , user.getLastName());
        answer.put("location" , user.getLocation());
        answer.put("birthdate" , user.getBirthdate());
        answer.put("followers" , user.getFollowers().size());
        answer.put("followings" , user.getFollowings());
        answer.put("posts" , user.getPosts());
        answer.put("profile" , user.getProfile());
        answer.put("command" , Command.GET_INFO);
        Date date = new Date();
        System.out.println(username + " get info " + target + "\nmessage: " + target + user.getProfileAddress() + "\ntime: " + format.format(date));
        return answer;
    }

    public static Map<String , Object>logout(Map<String , Object> receive){
        Map<String , Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        answer.put("answer" , true);
        answer.put("command" , Command.LOGOUT);
        Date date = new Date();
        System.out.println(username + " logout\ntime: " + format.format(date));
        return answer;
    }

    public static Map<String , Object> getPassword(Map<String , Object> receive){
        Map<String , Object> answer = new HashMap<>();
        String username = (String) receive.get("username");
        answer.put("answer" , Server.users.get(username).getPassword());
        answer.put("command" , Command.GET_PASSWORD);
        return answer;
    }
}
