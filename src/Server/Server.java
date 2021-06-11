package Server;

import Common.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Server {
    public static final int PORT = 2222;
    private static boolean isServerUp = true;
    public static DataBase dataBase = DataBase.getInstance();

    public static Map<String , User> users = null;

    public boolean isIsServerUp(){
        return isServerUp;
    }

    public static void main(String[] args) {
        dataBase.initializeServer();

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (isServerUp){
            Socket userSocket = null;
            try {
                userSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(userSocket);
                new Thread(clientHandler).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
