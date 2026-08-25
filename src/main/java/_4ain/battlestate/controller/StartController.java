package _4ain.battlestate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    @FXML
    private void onPlay(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("/_4ain/battlestate/battle-view.fxml")
        );

        Scene scene = new Scene(root, 1280, 721);

        Stage stage =
                (Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();

        stage.setScene(scene);
    }

    @FXML
    private void onExit() {
        System.exit(0);
    }
}
