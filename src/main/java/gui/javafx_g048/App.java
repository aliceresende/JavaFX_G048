package gui.javafx_g048;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Auth.fxml"));
            scene = new Scene(fxmlLoader.load(), 600, 450);
            stage.setTitle("Analyze Performance");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
