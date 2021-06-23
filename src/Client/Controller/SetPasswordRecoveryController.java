package Client.Controller;

import Client.Model.API;
import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SetPasswordRecoveryController {
    public TextField answer;
    public MenuButton questionMenu;

    public void confirm(ActionEvent actionEvent) {
            API.setSecurity(LoginController.currentUser , questionMenu.getText() , answer.getText());
        try {
            new PageLoader().load("feed" , 414 , 637);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void car(ActionEvent actionEvent) {
        questionMenu.setText("Car");
    }

    public void fruit(ActionEvent actionEvent) {
        questionMenu.setText("Fruit");
    }

    public void animal(ActionEvent actionEvent) {
        questionMenu.setText("Animal");
    }

    public void game(ActionEvent actionEvent) {
        questionMenu.setText("Game");
    }
}
