package gui.javafx_g048;

import app.controller.LoadLegacyDataController;
import app.domain.model.PerformanceData;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LegacyDataShow implements Initializable {

    @javafx.fxml.FXML
    private ListView infolist;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        infolist.setVisible(true);

        this.controller = main.getLegacyDataController();


        List<PerformanceData> data = controller.getPerformanceDataAndExtras();
        infolist.setVisible(true);
        infolist.setItems(FXCollections.observableList(data));

    }
    private LegacyDataGUI main;
    private LoadLegacyDataController controller;




}
