package app.ui.gui;


import app.controller.LoadLegacyDataController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The type Load legacy data ui.
 */
public class LoadLegacyDataUI extends Application implements Runnable {

    /**
     * The Controller.
     */
    LoadLegacyDataController controller = new LoadLegacyDataController();

    public void run(){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LoadLegacyData.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
