package gui.javafx_g048;

import app.controller.SelectVaccinationCenterController;
import app.mappers.dto.VaccinationCenterDTO;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SelectCenterUI implements Initializable {
    private SelectVaccinationCenterController selectCenters = new SelectVaccinationCenterController();
    @javafx.fxml.FXML
    private ComboBox selectCenter;


    @javafx.fxml.FXML
    public void SelectCenter(ActionEvent actionEvent) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<VaccinationCenterDTO> vCenterList = selectCenters.getVaccinationCenter();

        selectCenter.getItems().addAll(vCenterList);
    }
}
