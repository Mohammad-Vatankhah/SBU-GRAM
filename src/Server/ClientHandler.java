package Server;

import Common.Command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

public class ClientHandler implements Runnable{

    private Socket userSocket;
    private ObjectOutputStream socketOut;
    private ObjectInputStream socketIn;
    public Boolean clientOnline = true;

    public ClientHandler(Socket socket){
        userSocket = socket;
        try {
            this.socketOut = new ObjectOutputStream(userSocket.getOutputStream());
            this.socketIn = new ObjectInputStream(userSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (clientOnline){
            Map<String , Object> receive = null;
            try {
                receive = (Map<String, Object>) socketIn.readObject();
                Map<String , Object> answer = null;
                Command command = (Command) receive.get("command");
                switch (command){
                    case USERNAME_UNIQUE:
                        answer = API.isUsernameExist(receive);
                        break;
                    case LOGIN:
                        answer = API.login(receive);
                        break;
                    case SIGNUP:
                        answer = API.signup(receive);
                        break;
                    case PUBLISH_POST:
                        answer = API.publishPost(receive);
                        break;
                    case FOLLOW:
                        answer = API.follow(receive);
                        break;
                    case UNFOLLOW:
                        answer = API.unfollow(receive);
                        break;
                    case LIKE:
                        answer = API.like(receive);
                        break;
                    case DISLIKE:
                        answer = API.dislike(receive);
                        break;
                    case ADD_COMMENT:
                        answer = API.addComment(receive);
                        break;
                    case GET_POSTS:
                        answer = API.getPosts(receive);
                        break;
                    case UPDATE_PROFILE:
                        answer = API.updateProfile(receive);
                        break;
                    case REPOST:
                        answer = API.repost(receive);
                        break;
                    case GET_INFO:
                        answer = API.getInfo(receive);
                        break;
                    case LOGOUT:
                        answer = API.logout(receive);
                        break;
                    case GET_PASSWORD:
                        answer = API.getPassword(receive);
                        break;
                    case GET_USER:
                        answer = API.getUser(receive);
                        break;
                    case GET_COMMENTS:
                        answer = API.getComment(receive);
                        break;
                    case CHANGE_PASS:
                        answer = API.changePass(receive);
                        break;
                    case CHANGE_PHOTO:
                        answer = API.changeProfilePhoto(receive);
                        break;
                }
                socketOut.writeObject(answer);
                socketOut.flush();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            socketOut.close();
            socketIn.close();
            userSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
