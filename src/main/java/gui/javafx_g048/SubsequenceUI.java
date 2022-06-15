package gui.javafx_g048;

import app.controller.PerformanceAnalysisController;
import app.domain.shared.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static app.ui.console.PerformanceAnalysisUI.*;

public class SubsequenceUI implements Initializable {

    public DatePicker datePickerDay;
    public TextField lblInterval;
    public VBox vboxSubsequence;

    private PerformanceAnalysisController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{

        }catch(Exception e){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.getDialogPane().setContentText(e.getMessage());
            alert.getDialogPane().setHeaderText("Error while doing the process");
            alert.showAndWait();
        }
    }


    public void seeButton(ActionEvent actionEvent) {
        try{
            vboxSubsequence.getChildren().clear();
            vboxSubsequence.setOpacity(1);
            controller = new PerformanceAnalysisController();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            int[] inputList = controller.inputList(Integer.parseInt(lblInterval.getText()), datePickerDay.getValue().format(formatter));
            int[] subList = controller.getMaxSublist(inputList);
            List<Integer> inputArrList = Arrays.stream(inputList).boxed().collect(Collectors.toList());
            List<Integer> subArrList  = Arrays.stream(subList).boxed().collect(Collectors.toList());
            int indexStart = Collections.indexOfSubList(inputArrList, subArrList);
            int indexEnd = indexStart + (subList.length);
            int DateIMin = getMinute(Constants.OPEN_HOUR) + indexStart * Integer.parseInt(lblInterval.getText());
            int DateEMin = getMinute(Constants.OPEN_HOUR) + indexEnd * Integer.parseInt(lblInterval.getText());
            Label labelInputList = new Label("Input list: "+Arrays.toString(inputList));
            Label labelSubsequence = new Label("Contiguous sublist of maximum output sum: "+Arrays.toString(subList));
            Label labelSum = new Label("Sum: "+sum(subList));
            Label labelInterval = new Label("Interval: [" + datePickerDay.getValue().format(formatter) + " " + fromMinutesToHHmm(DateIMin) + ", " + datePickerDay.getValue().format(formatter) + " " + fromMinutesToHHmm(DateEMin) + "]");
            vboxSubsequence.getChildren().add(labelInputList);
            vboxSubsequence.getChildren().add(labelSubsequence);
            vboxSubsequence.getChildren().add(labelSum);
            vboxSubsequence.getChildren().add(labelInterval);



        }catch(Exception e){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.getDialogPane().setContentText(e.getMessage());
            alert.getDialogPane().setHeaderText("Error while doing the process");
            alert.showAndWait();
        }
    }
}
