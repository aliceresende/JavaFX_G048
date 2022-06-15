package gui.javafx_g048;

import app.controller.App;
import app.domain.model.Company;
import app.ui.console.RegisterEmployeeUI;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class AuthUI implements Initializable {
    private AuthFacade authFacade;
    public TextField email;
    public PasswordField password;
    private Company company;

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode().isArrowKey()){
            if (keyEvent.getCode() == KeyCode.DOWN){
                password.requestFocus();
            }
            if (keyEvent.getCode() == KeyCode.UP){
                email.requestFocus();
            }
        }
        if (keyEvent.getCode() == KeyCode.ENTER){

            if (!email.getText().isEmpty() && !password.getText().isEmpty()) {
                try {
                    doLogin(email.getText(), password.getText());
                    if (authFacade.getCurrentUserSession().getUserRoles().isEmpty()){
                        Alert.AlertType type = Alert.AlertType.ERROR;
                        Alert alert = new Alert(type, "");

                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.initOwner(email.getScene().getWindow());

                        alert.getDialogPane().setContentText("Data entered does not correspond to any user of the system.");
                        alert.getDialogPane().setHeaderText("Invalid email/password");

                        alert.showAndWait();
                    }
                    else {
                        getUIForRoles();
                    }
                } catch (Exception e) {
                    Alert.AlertType type = Alert.AlertType.ERROR;
                    Alert alert = new Alert(type, "");

                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.initOwner(email.getScene().getWindow());

                    alert.getDialogPane().setContentText("Data entered does not correspond to any user of the system.");
                    alert.getDialogPane().setHeaderText("Invalid email/password");

                    alert.showAndWait();
                }
            }
            else{
                Alert.AlertType type = Alert.AlertType.ERROR;
                Alert alert = new Alert(type, "");

                alert.initModality(Modality.APPLICATION_MODAL);
                alert.initOwner(email.getScene().getWindow());

                alert.getDialogPane().setContentText("Data entered does not correspond to any user of the system.");
                alert.getDialogPane().setHeaderText("Invalid email/password");

                alert.showAndWait();
            }
        }
    }

    private void getUIForRoles() {
        UserSession userSession = authFacade.getCurrentUserSession();
        String role = userSession.getUserRoles().get(0).getId().toLowerCase(Locale.ROOT);
        switch (role) {
            case "nurse":

                break;
            case "center coordinator":

                break;
        }
    }

    public void doLogin(String email1, String password1){
        authFacade.doLogin(email1, password1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        company = App.getInstance().getCompany();
        authFacade = company.getAuthFacade();
        UserSession userSession = authFacade.getCurrentUserSession();
    }
}
