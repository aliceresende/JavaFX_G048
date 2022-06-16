package gui.javafx_g048;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class LegacyDataGUI {

    @FXML
    private TextField filepath;
    @FXML
    private TextField email;
    @FXML
    private Button file;

    @javafx.fxml.FXML
    public void seeButton(ActionEvent actionEvent) {
    }


<<<<<<< Updated upstream
    /*@FXML
=======

    public void file(ActionEvent event){
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Csv Files",".csv"));
        if(selectedFile != null){
            String path = selectedFile.getAbsolutePath();
            filepath.setText(path);
        }else{
            System.out.println("File is not valid!");
        }
    }
    @Deprecated
>>>>>>> Stashed changes
    public String performanceDataFileButton(){
        String filePerformanceData;
        FileChooser performanceFileChosen = new FileChooser();
        performanceFileChosen.setTitle("Open performance data file: ");
        Stage stage = new Stage();
        stage.getScene().getWindow();

        File performanceFile = performanceFileChosen.showOpenDialog(stage);

        if(performanceFile != null){
            filePerformanceData = performanceFile.getAbsolutePath();
            System.out.println(filePerformanceData);
            return filePerformanceData;
        }
        return null;
    }*/
}
