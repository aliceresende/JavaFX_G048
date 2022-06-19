package app.controller;

import app.domain.model.Company;
import app.domain.model.ComunityMassVaccinationCenter;
import app.store.VaccinationCenterStore;

import java.io.IOException;



public class RegisterCenterController {

private Company company;
private ComunityMassVaccinationCenter center;
private VaccinationCenterStore store;




    public Company getCompany() {
        return this.company;
    }
    public RegisterCenterController() { this(App.getInstance().getCompany());
    }

    public RegisterCenterController(Company company){
        this.center = null;
        this.company = company;
        store = company.getRegisterCenterStore();
    }

    /**
     * registers the center in the store with all of it's information
     * @param name name of the center
     * @param address of the center
     * @param phoneNumber phone number of the SNS User
     * @param email email of the SNS User
     * @param faxNumber fax number of the center
     * @param websiteAdress website addres of the center
     * @param openingHour opening hour of the center
     * @param closingHour closing hour of the center
     * @param slotDuration vaccine slots on the center
     * @param maxNumVaxPerSlot maximum number of vaccines that can be given per slot
     */

public void RegisterCenterD(String id, String name, String address, String phoneNumber, String email, String faxNumber, String websiteAdress, String openingHour, String closingHour, String slotDuration, String maxNumVaxPerSlot){

    center = store.RegistersCenter(id,name, address, phoneNumber, email, faxNumber, websiteAdress, openingHour, closingHour, slotDuration, maxNumVaxPerSlot);
    store.ValidateCenter(center);
}

    /**
     * Saves a center
     */

public void SaveCenter() throws IOException {
    store.SaveCenter(center);
}

}
