package Client.Controller;

import Client.Model.API;
import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PassRecoveryController {
    public static String usernameS;
    public MenuButton questionMenu;
    public Label error;
    public TextField answer;
    public TextField username;
    public Label usernameErr;

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

    public void check(ActionEvent actionEvent) {
        if (username.getText().equals("")) {
            usernameErr.setVisible(true);
        } else {
            usernameS = username.getText();
            String answer = (String) API.getSecurity(username.getText()).get("answer");
            String question = (String) API.getSecurity(username.getText()).get("question");
            if (!answer.equals(this.answer.getText()) || !question.equals(this.questionMenu.getText())){
                error.setVisible(true);
                usernameErr.setVisible(false);
            }
            else if (answer.equals(this.answer.getText()) && question.equals(this.questionMenu.getText())){
                try {
                    new PageLoader().load("changePassR" , 363 , 470);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
