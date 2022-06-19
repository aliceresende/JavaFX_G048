package gui.javafx_g048;

import app.controller.LoadLegacyDataController;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class LegacyDataShow implements Initializable {

    @javafx.fxml.FXML
    private ListView infolist;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTextBoxLegacyDataInfo();
    }
    private LegacyDataGUI main;
    private LoadLegacyDataController controller;

    public void associarParentUI(LegacyDataGUI janelaPrincipalUI) {
//para ter uma referência à janela principal
        this.main = janelaPrincipalUI;
        this.controller = new LoadLegacyDataController();
        //infolist.setItems(FXCollections.observableList(controller.getPerformanceDataAndExtras()));

    }

    public void updateTextBoxLegacyDataInfo() {
        infolist.getItems();
    }


}
