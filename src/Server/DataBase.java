package Server;

import Common.User;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class DataBase {
    public static final String USERS_FILE = "F:\\SBU\\exc\\AP\\SBU_gram\\db\\Users.bin";

    private static final DataBase instance = new DataBase();

    public static DataBase getInstance() {
        return instance;
    }

    private DataBase(){}

    public synchronized void initializeServer() {
        File file = new File(USERS_FILE);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
                FileInputStream fileIn = new FileInputStream(USERS_FILE);
                ObjectInputStream ois = new ObjectInputStream(fileIn);
                Server.users = new ConcurrentHashMap<>((ConcurrentHashMap<String, User>) ois.readObject());
                fileIn.close();
                ois.close();
            }catch (EOFException | StreamCorruptedException e){
            Server.users = new ConcurrentHashMap<>();
        }
        catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }

    public synchronized void updateDataBase(){
        try {
            FileOutputStream fileOut = new FileOutputStream(USERS_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.reset();
            oos.writeObject(Server.users);
            fileOut.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
