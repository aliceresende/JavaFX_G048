package gui.javafx_g048;

import app.controller.VaccinatedUsersController;
import app.domain.model.Company;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class VaccinatedUsersUI implements Initializable {

    ObservableList<String> option= FXCollections.observableArrayList("Yes", "No");

    private VaccinatedUsersController controller = new VaccinatedUsersController();

    @FXML
    private ChoiceBox<String> check;

    @FXML
    private Button createcsvfile;

    @FXML
    private DatePicker datePickerDay;

    @FXML
    private Button file;

    @FXML
    private ListView<String> foldername;

    @FXML
    private Button seebutton;

    @FXML
    private TextField tfData;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            check.setVisible(false);
            createcsvfile.setVisible(false);
            file.setVisible(false);
            foldername.setVisible(false);
            check.setItems(option);
            check.setOnAction((event) -> {
                Object answer = check.getSelectionModel().getSelectedItem();
                if (answer == "Yes") {
                    createcsvfile.setVisible(false);
                    check.setVisible(false);
                } else {
                    createcsvfile.setVisible(true);
                }
            });
        } catch(Exception e) {
        Alert.AlertType type = Alert.AlertType.WARNING;
        Alert alert = new Alert(type, "");
        alert.getDialogPane().setContentText(e.getMessage());
        alert.getDialogPane().setHeaderText("Error while doing the process");
        alert.showAndWait();
        }
    }

    @FXML
    void createCsv(ActionEvent event) {
        foldername.setVisible(true);
    }

    @FXML
    void date(ActionEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String numberOfVaccinatedUsers  = controller.numberOfVaccinatedUsers(datePickerDay.getValue().format(formatter));
        tfData.setText(numberOfVaccinatedUsers);
        check.setVisible(true);
    }

    @FXML
    void fileButton(ActionEvent event) {

    }
}