package gui.javafx_g048;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NurseUI {
    public void Action(ActionEvent actionEvent) {
        Scene scene = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AdverseReactions.fxml"));
            scene = new Scene(fxmlLoader.load(), 684, 543);
            Stage stage = new Stage();
            stage.setTitle("Adverse Reactions");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void RegisterVaccine(ActionEvent actionEvent) {
        Scene scene = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("VaccineAdministration.fxml"));
            scene = new Scene(fxmlLoader.load(), 684, 543);
            Stage stage = new Stage();
            stage.setTitle("Register Vaccine Administration");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
