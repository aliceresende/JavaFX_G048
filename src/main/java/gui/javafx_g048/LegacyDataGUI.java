package gui.javafx_g048;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class LegacyDataGUI {

    @javafx.fxml.FXML
    private VBox vboxSubsequence;
    @javafx.fxml.FXML
    private TextField lblInterval;

    @javafx.fxml.FXML
    public void seeButton(ActionEvent actionEvent) {
    }


    @FXML
    public String performanceDataFileButton(){
        String filePerformanceData;
        FileChooser performanceFileChosen = new FileChooser();
        performanceFileChosen.setTitle("Open performance data file: ");
        Stage stage = (Stage) .getScene().getWindow();

        File performanceFile = performanceFileChosen.showOpenDialog(stage);

        if(performanceFile != null){
            filePerformanceData = performanceFile.getAbsolutePath();
            System.out.println(filePerformanceData);
            return filePerformanceData;
        }
        return null;
    }
}
