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
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
