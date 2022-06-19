package gui.javafx_g048;

import app.controller.App;
import app.controller.ReactionsController;
import app.domain.model.Company;
import app.domain.store.ReactionStore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.net.URL;
import java.util.ResourceBundle;

public class AdverseReactionsUI implements Initializable {

    ObservableList <String> option= FXCollections.observableArrayList("Yes", "No");
    public ChoiceBox Allergybox;
    public ChoiceBox Vaccineallergybox;
    public ChoiceBox Anaphylacticbox;
    public ChoiceBox BloodClottingbox;
    public ChoiceBox Immunodeficiencybox;
    public ChoiceBox Chemobox;
    public ChoiceBox Dosebox;
    public TextField lblInterval;
    public Label label1;
    public TextField lblInterval1;
    public Label label2;
    public TextField lblInterval2;
    private Company company;
    private AuthFacade authFacade;
    private ReactionsController ctrl;
    private ReactionStore st;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            company = App.getInstance().getCompany();
            authFacade = company.getAuthFacade();
            st=company.getReactionStore();
        }catch(Exception e){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.getDialogPane().setContentText(e.getMessage());
            alert.getDialogPane().setHeaderText("Error while doing the process");
            alert.showAndWait();
        }
        label1.setVisible(false);
        lblInterval1.setVisible(false);
        label2.setVisible(false);
        lblInterval2.setVisible(false);
        Allergybox.setItems(option);
        Vaccineallergybox.setItems(option);
        Anaphylacticbox.setItems(option);
        BloodClottingbox.setItems(option);
        Immunodeficiencybox.setItems(option);
        Chemobox.setItems(option);
        Dosebox.setItems(option);
        Allergybox.setOnAction((event)->{
                Object answer=Allergybox.getSelectionModel().getSelectedItem();
                if(answer=="Yes"){
                    label1.setVisible(true);
                    lblInterval1.setVisible(true);
                }else{
                    label1.setVisible(false);
                    lblInterval1.setVisible(false);
                }
        });
        Dosebox.setOnAction((event)->{
            Object answer=Dosebox.getSelectionModel().getSelectedItem();
            if(answer=="Yes"){
                label2.setVisible(true);
                lblInterval2.setVisible(true);
            }else{
                label2.setVisible(false);
                lblInterval2.setVisible(false);
            }
        });
    }
    public void Action(ActionEvent actionEvent) {
        ctrl = new ReactionsController();
        String usernumber;
        String allergy;
        String dose;
        String Anaphylactic;
        String BloodClotting;
        String Immunodeficiency;
        String Chemo;
        String Vaccineallergy;
        usernumber=lblInterval.getText();
        Object answer=Allergybox.getSelectionModel().getSelectedItem();
        if(answer=="Yes"){
            allergy=lblInterval1.getText();
        }else{
           allergy="none";
        }
        answer=Dosebox.getSelectionModel().getSelectedItem();
        if(answer=="Yes"){
            dose=lblInterval2.getText();
        }else{
            dose="none";
        }
        Anaphylactic = String.valueOf(Anaphylacticbox.getSelectionModel().getSelectedItem());
        BloodClotting = String.valueOf(BloodClottingbox.getSelectionModel().getSelectedItem());
        Immunodeficiency = String.valueOf(Immunodeficiencybox.getSelectionModel().getSelectedItem());
        Chemo = String.valueOf(Chemobox.getSelectionModel().getSelectedItem());
        Vaccineallergy = String.valueOf(Vaccineallergybox.getSelectionModel().getSelectedItem());
        ctrl.registerReaction(usernumber, allergy, Vaccineallergy, Anaphylactic, BloodClotting, Immunodeficiency, Chemo, dose);
        ctrl.validateReaction();
    }
}
