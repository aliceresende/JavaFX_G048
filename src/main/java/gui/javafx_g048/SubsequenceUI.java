package gui.javafx_g048;

import app.controller.App;
import app.controller.PerformanceAnalysisController;
import app.domain.model.Company;
import app.domain.shared.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static app.ui.console.PerformanceAnalysisUI.*;

public class SubsequenceUI implements Initializable {

    public DatePicker datePickerDay;
    public TextField lblInterval;
    public VBox vboxSubsequence;
    private Company company;
    private AuthFacade authFacade;

    private PerformanceAnalysisController controller;
    private gui.javafx_g048.App mainApp;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            company = App.getInstance().getCompany();
            authFacade = company.getAuthFacade();

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

    public void seeButton(ActionEvent actionEvent) {
        try{
            vboxSubsequence.getChildren().clear();
            vboxSubsequence.setOpacity(1);
            controller = new PerformanceAnalysisController();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            int[] inputList = controller.getInputList(Integer.parseInt(lblInterval.getText()), datePickerDay.getValue().format(formatter));
            int[] subList = controller.getMaxSublist(inputList);
            List<Integer> inputArrList = Arrays.stream(inputList).boxed().collect(Collectors.toList());
            List<Integer> subArrList  = Arrays.stream(subList).boxed().collect(Collectors.toList());
            int indexStart = Collections.indexOfSubList(inputArrList, subArrList);
            int indexEnd = indexStart + (subList.length);
            int DateIMin = getMinute(Constants.OPEN_HOUR) + indexStart * Integer.parseInt(lblInterval.getText());
            int DateEMin = getMinute(Constants.OPEN_HOUR) + indexEnd * Integer.parseInt(lblInterval.getText());
            Label labelInputList = new Label("Input list: "+Arrays.toString(inputList));
            Label labelSubsequence = new Label("Contiguous sublist of maximum output sum: "+Arrays.toString(subList));
            Label labelSum = new Label("Sum: "+controller.sumSublist(subList));
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
    public String fromMinutesToHHmm(int minutes) {
        long hours = TimeUnit.MINUTES.toHours(Long.valueOf(minutes));
        long remainMinutes = minutes - TimeUnit.HOURS.toMinutes(hours);
        return  String.format("%02d:%02d", hours, remainMinutes);
    }
}
