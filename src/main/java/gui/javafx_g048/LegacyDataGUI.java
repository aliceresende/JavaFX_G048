package gui.javafx_g048;


import app.controller.LoadLegacyDataController;
import app.domain.model.PerformanceData;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
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
    @FXML
    private ListView list;


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
            list.setVisible(false);


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
        fileChooser.setInitialDirectory(new File("C:\\"));
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


        try {
            controller.loadLegacyData(filePath,time,ordering); // sends information to controller
        } catch (IOException | ParseException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            System.out.println("Somehting went wrong with the file");
        }

        List<PerformanceData> data = controller.getPerformanceDataAndExtras();
        list.setVisible(true);
        list.setItems(FXCollections.observableList(data));

    }
}
