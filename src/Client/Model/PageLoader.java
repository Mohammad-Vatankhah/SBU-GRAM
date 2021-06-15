package Client.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.nio.file.Paths;

public class PageLoader {

    private static Stage stage;
    private static Scene scene;


    public static void initStage(Stage primaryStage){
        stage = primaryStage;
        stage.setTitle("SBU GRAM");
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(Paths.get("images/SBU gram icon.png").toUri().toString()));
    }

    public void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private Parent loadFXML(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Client/View/" + fxml + ".fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    public static Stage getPrimaryStage() {
        return stage;
    }

    public void load(String url , int width , int height) throws IOException {
        scene = new Scene(new PageLoader().loadFXML(url));
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setScene(scene);
        stage.show();
    }

    public void load(String fxml, Object controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Client/View/" + fxml + ".fxml"));
        fxmlLoader.setController(controller);
            fxmlLoader.load();
    }
}
