package gui.javafx_g048;

import app.controller.App;
import app.controller.LoadLegacyDataController;
import app.domain.model.Company;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class LegacyDataGUI implements Initializable {


    @FXML
    private TextField email;
    @FXML
    private Button file;

    private String filePath;
    @FXML
    private ListView filename;

    private Company company;
    private AuthFacade authFacade;
    private gui.javafx_g048.App mainApp;

    private LoadLegacyDataController controller;
    @FXML
    private ComboBox criteria;
    @FXML
    private ComboBox order;
    @FXML
    private ComboBox algorithm;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            company = App.getInstance().getCompany();
            authFacade = company.getAuthFacade();

            algorithm.getItems().addAll("Insertion Sort", "Merge Sort");

            criteria.getItems().addAll("Arrival Time","Leaving Time");
            order.getItems().addAll("Ascendent","Descendent");


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
    //======================================================

    public void email(ActionEvent actionEvent) {
        controller.getVaccCenterName(String.valueOf(email));
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
        controller.readFile(filePath); // sends filepath tho controller
        filename.getItems().add(selectedFile.getName());// displays the name of the selected file
    }



//===================================================

    /**
     * method to set the chosen sorting algorithm in the configuration file
     * @param algorithm
     * @throws IOException
     */
    private void setConfig(String algorithm) throws IOException {
        if (algorithm == null) {
            throw new IllegalArgumentException("Please choose an algorithm so that the process can run.");
        } else {
            Properties prop =new Properties();
            String value;

            switch (algorithm){
                case "Merge Sort":
                    prop.load(new FileInputStream("config.properties"));
                    value = "app.domain.algorithms.sorting.MergeSort";
                    prop.setProperty("Company.Algorithms.sorting", value);
                    prop.store(new FileOutputStream("configuration.conf"),null);
                    break;
                case "Insertion Sort":
                    prop.load(new FileInputStream("config.properties"));
                    value = "app.domain.algorithms.sorting.InsertionSort";
                    prop.setProperty("Company.Algorithms.sorting", value);
                    prop.store(new FileOutputStream("configuration.conf"),null);
                    break;
            }
        }
    }


    //=================CONFIRM=================

    @FXML
    public void seeButton(ActionEvent actionEvent) {
        try{
            setConfig(String.valueOf(algorithm.getValue())); // set algorithm to use

            String time = String.valueOf(criteria.getSelectionModel().getSelectedItem());
            String ordering = String.valueOf(order.getSelectionModel().getSelectedItem());

            switch (time){
                case "Arrival Time":
                     if(ordering.equals("Ascendent")) {
                         controller.sortingCriteria("5", "ascendent");
                     }else if(ordering.equals("Descendent")){
                         controller.sortingCriteria("5", "descendent");
                     }
                    break;
                case "Leaving Time":
                    if(ordering.equals("Ascendent")) {
                        controller.sortingCriteria("7", "ascendent");
                    }else if(ordering.equals("Descendent")){
                        controller.sortingCriteria("7", "descendent");
            }
                    break;
            }


        } catch (Exception e) {
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");

            alert.initModality(Modality.APPLICATION_MODAL);
            //alert.initOwner(mainApp.getStage());

            alert.getDialogPane().setContentText(e.getMessage());
            alert.getDialogPane().setHeaderText("Error while doing the process");

            alert.showAndWait();
        }
    }
}
