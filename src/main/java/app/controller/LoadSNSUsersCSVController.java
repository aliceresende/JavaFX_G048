package app.controller;


import app.domain.model.CSV.CSV;
import app.domain.model.Company;
import app.domain.model.PasswordGenerator;
import app.domain.model.SNSUser;
import app.domain.shared.Constants;
import app.store.SNSUserStore;
import pt.isep.lei.esoft.auth.AuthFacade;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class LoadSNSUsersCSVController {

    private Company company;
    private SNSUserStore userStore;
    private SNSUser user;

    private List<SNSUser> listSNSUsers;

    public Company getCompany() {
        return this.company;
    }

    public LoadSNSUsersCSVController() {
        this(App.getInstance().getCompany());
    }


    public LoadSNSUsersCSVController(Company company){
        this.company = company;
        userStore = company.getSNSUserStore();
        this.user = null;
        this.listSNSUsers = new ArrayList<>();
    }

    /**
     * this method reads the info from the file
     *
     * @param filePath file uploaded
     * @return listSNSUsers: list with all the SNSUsers from the file
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public List<SNSUser> readFile(String filePath) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        try {
            CSV csv = company.knowsFileType(filePath); //instance
            listSNSUsers = userStore.fileTreatmentUsers(filePath,csv);
            boolean validation = userStore.validateSNSUsers(listSNSUsers);
            if(validation){
                return listSNSUsers;
            }else{
                return listSNSUsers = null;
            }

        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }




    /**
     * this method validates all the list from the listSNSUsers
     *
     * @param listSNSUsers list with all the users confirmed by the administrator
     * @return true if all the info is valid and added
     */

    public boolean saveUsers(List<SNSUser> listSNSUsers) {
        boolean add = false;
        for (SNSUser user : listSNSUsers) {
            String password = PasswordGenerator.generatePassword();
            AuthFacade auth = company.getAuthFacade();
            auth.addUserRole(Constants.ROLE_SNSUSER, Constants.ROLE_SNSUSER);
            auth.addUserWithRole(user.getName(), user.getEmail(), password, Constants.ROLE_SNSUSER);
            this.userStore.saveSNSUser(user);
            add=true;
        }
        return add;
    }


}
