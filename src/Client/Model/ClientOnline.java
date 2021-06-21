package Client.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

public class ClientOnline {
    public static String serverAddress = "localhost";
    public static final int PORT = 2222;

    private static boolean isConnected = false;
    public static Socket socket;
    public static ObjectInputStream socketIn;
    public static ObjectOutputStream socketOut;

    public static boolean isIsConnected() {
        return isConnected;
    }

    public static Boolean connectToServer(){
        if (socket != null)
            return false;
        try {
            socket = new Socket(serverAddress , PORT);
            socketIn = new ObjectInputStream(socket.getInputStream());
            socketOut = new ObjectOutputStream(socket.getOutputStream());
            isConnected = true;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean disconnectFromServer(){
        try {
            socketOut.close();
            socketIn.close();
            socket.close();
            isConnected = false;
            socket = null;
            socketOut = null;
            socketIn = null;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket = null;
        socketOut = null;
        socketIn = null;
        return false;
    }

    public static Map<String , Object> send(Map<String , Object> send){
        Map<String , Object> receive = null;
        try {
            socketOut.reset();
            socketOut.writeObject(send);
            socketOut.flush();
            socketOut.reset();
            receive = (Map<String, Object>) socketIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return receive;
    }
}
