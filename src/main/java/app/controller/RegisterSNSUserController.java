package app.controller;

import app.domain.model.Company;
import app.domain.model.PasswordGenerator;
import app.domain.model.SNSUser;
import app.domain.shared.Constants;
import app.store.SNSUserStore;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;


public class RegisterSNSUserController {
    private App app;
    private Company company;
    private SNSUser snsU;
    private SNSUserStore store;

    public Company getCompany() {
        return this.company;
    }
    public RegisterSNSUserController() { this(App.getInstance().getCompany());
    }
    /**
     * Constructor
     */
    public RegisterSNSUserController(Company company){
        this.snsU = null;
        this.company = company;
        store = company.getSNSUserStore();
    }

    /**
     * Register the SNS User in the store with name, birthdate, SNS User number, phone number, email, address, sex and citizen card number
     * @param name name of the SNS user
     * @param birthdate birth date of the SNS user
     * @param SNSUserNumber  SNS user number of the SNS user
     * @param phoneNumber phone number of the SNS user
     * @param email email of the SNS user
     * @param
     * @param sex sex of the SNS user
     * @param citizenCardNumber citizen card number of the SNS user
     */

    public void createSNSUser(String name, Date birthdate, String SNSUserNumber, String phoneNumber, String email,  String street, String doornumber ,String postCode, String city, String sex, String citizenCardNumber) throws ParseException {
         snsU = store.createSNSUser(name,birthdate,SNSUserNumber,phoneNumber,email, street, doornumber, postCode, city,sex,citizenCardNumber);
         store.validateSNSUser(snsU);
    }

    /**
     * Register the SNS User in the store with name, birthdate, SNS User number, phone number, email, address and citizen card number
     * @param name name of the SNS user
     * @param birthdate birth date of the SNS user
     * @param SNSUserNumber  SNS user number of the SNS user
     * @param phoneNumber phone number of the SNS user
     * @param email email of the SNS user
     * @param citizenCardNumber citizen card number of the SNS user
     */
    public void createSNSUser(String name, Date birthdate, String SNSUserNumber, String phoneNumber, String email,  String street, String doornumber ,String postCode, String city, String citizenCardNumber){
        snsU = store.createSNSUser(name,birthdate,SNSUserNumber,phoneNumber,email, street, doornumber, postCode, city,citizenCardNumber);
        store.validateSNSUser(snsU);
    }
    /**
     * Saves an SNS user
     * @throws IOException
     */
    public void saveSNSUser() throws IOException {
        String password = PasswordGenerator.generatePassword();
        AuthFacade auth = company.getAuthFacade();
        auth.addUserRole(Constants.ROLE_SNSUSER,Constants.ROLE_SNSUSER);
        auth.addUserWithRole(snsU.getName(), snsU.getEmail(), password, Constants.ROLE_SNSUSER);
        this.store.saveSNSUser(snsU);
        System.out.println(store.showAuthenticationData(snsU, password));
    }

    /**
     * Returns the information of the SNS User
     * @return info of the SNS user
     */
    public String SNSUserInfo(){
        return snsU.toString();
    }

}
