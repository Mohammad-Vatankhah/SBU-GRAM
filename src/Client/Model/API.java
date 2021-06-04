package Client.Model;

import Common.Command;
import Common.Comment;
import Common.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class API {
    public static boolean isUsernameExist(String username){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.USERNAME_UNIQUE);
        send.put("username" , username);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static boolean login(String username , String password){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.LOGIN);
        send.put("username" , username);
        send.put("password" , password);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static boolean signup(String username , String password , String name , String lastname , String location , String phoneNumber , String birthdate , byte[] profile){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.SIGNUP);
        send.put("username" , username);
        send.put("password" , password);
        send.put("name" , name);
        send.put("lastname" , lastname);
        send.put("phoneNumber" , phoneNumber);
        send.put("location" , location);
        send.put("birthdate" , birthdate);
        send.put("profile" , profile);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static boolean publishPost(String username,Post post){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.PUBLISH_POST);
        send.put("post" , post);
        send.put("username" , username);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static boolean follow(String username , String target){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.FOLLOW);
        send.put("username" , username);
        send.put("target" , target);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static boolean unfollow(String username , String target){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.UNFOLLOW);
        send.put("username" , username);
        send.put("target" , target);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static boolean like(String username , String target , Post post){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.LIKE);
        send.put("username" , username);
        send.put("targetUsername" , target);
        send.put("post" , post);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static boolean dislike(String username , String target , Post post){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.DISLIKE);
        send.put("username" , username);
        send.put("targetUsername" , target);
        send.put("post" , post);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static boolean addComment(String username , String target , Post post , Comment comment){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.ADD_COMMENT);
        send.put("username" , username);
        send.put("targetUsername" , target);
        send.put("post" , post);
        send.put("comment" , comment);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static ArrayList<Post> getPosts(String username){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.GET_POSTS);
        send.put("username" , username);
        receive = ClientOnline.send(send);
        return (ArrayList<Post>) receive.get("answer");
    }

    public static boolean updateProfile(String username , String newName , String newBirthdate , String newLastname , String newLocation , String newPhoneNumber){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.UPDATE_PROFILE);
        send.put("username" , username);
        send.put("newName" , newName);
        send.put("newBirthdate" , newBirthdate);
        send.put("newLastname" , newLastname);
        send.put("newLocation" , newLocation);
        send.put("newPhoneNumber" , newPhoneNumber);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static boolean repost(String username , Post post){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.REPOST);
        send.put("username" , username);
        send.put("post" , post);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static Map<String , Object> getInfo(String username , String target){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" ,Command.GET_INFO);
        send.put("username" , username);
        send.put("targetUsername" , target);
        receive = ClientOnline.send(send);
        return receive;
    }

    public static boolean logout(String username){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.LOGOUT);
        send.put("username" , username);
        receive = ClientOnline.send(send);
        return (boolean) receive.get("answer");
    }

    public static String getPassword(String username){
        Map<String,Object> send = new HashMap<>();
        Map<String,Object> receive;
        send.put("command" , Command.GET_PASSWORD);
        send.put("username" , username);
        receive = ClientOnline.send(send);
        return (String) receive.get("answer");
    }
}