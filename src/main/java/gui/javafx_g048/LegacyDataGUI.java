package gui.javafx_g048;


import app.controller.LoadLegacyDataController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

public class LegacyDataGUI implements Initializable {


    @FXML
    private Button file;

    private String filePath;
    @FXML
    private ListView filename;
    private gui.javafx_g048.App mainApp;
    private LoadLegacyDataController controller;
    @FXML
    private ComboBox criteria;
    @FXML
    private ComboBox order;

    private Stage infoStage;
    @FXML
    private ImageView timeimage;
    @FXML
    private ImageView timeimage1;


    /**
     * this method iniatializes the gui and the ComboBox's
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{

            criteria.getItems().addAll("Arrival Time","Leaving Time");
            order.getItems().addAll("Ascendent","Descendent");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("LegacyDataShow.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            infoStage = new Stage();
            infoStage.initModality(Modality.APPLICATION_MODAL);
            infoStage.setScene(scene);
            LegacyDataShow showdata = loader.getController();
            showdata.associarParentUI(this);



        }catch(Exception e){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.getDialogPane().setContentText(e.getMessage());
            alert.getDialogPane().setHeaderText("Error while doing the process");
            alert.showAndWait();
        }
    }
    public void setMainApp(gui.javafx_g048.App mainApp) {
        this.mainApp = mainApp;
    }

    public LoadLegacyDataController getLegacyDataController() {
        return controller;
    }

    //=======================FILEPATH========================

    /**
     * method to show the user all the csv files in his computer and select one
     * @param actionEvent
     */
    @FXML
    public void fileButton(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(null);
        filePath = selectedFile.getAbsolutePath(); //gets absolute path
        filename.getItems().add(selectedFile.getName());// displays the name of the selected file
    }



//=================CONFIRM====================================

    /**
     * method to send the confirmed data to controller
     * @param actionEvent
     */

    @FXML
    public void seeButton(ActionEvent actionEvent) throws RuntimeException {

        String time = String.valueOf(criteria.getSelectionModel().getSelectedItem());
        String ordering = String.valueOf(order.getSelectionModel().getSelectedItem());

        controller = new LoadLegacyDataController();

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("LegacyDataShow.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 630, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();


        try {
            controller.loadLegacyData(filePath,time,ordering); // sends information to controller
        } catch (IOException | ParseException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            System.out.println("Somehting went wrong with the file");
        }

    }
}
