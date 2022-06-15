package gui.javafx_g048;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CenterCoordinatorUI {
    @FXML
    private Label welcomeText;



    public void ActionButton1(ActionEvent actionEvent) {
        Scene scene = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Subsequence.fxml"));
            scene = new Scene(fxmlLoader.load(), 600, 450);
            Stage stage = new Stage();
            stage.setTitle("Analyze Performance");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}