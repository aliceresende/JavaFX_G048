package gui.javafx_g048;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CenterCoordinatorGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CenterCoordinatorGUI.class.getResource("CenterCoordinatorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 430);
        stage.setTitle("Center Coordinator Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}