package app.controller;

import app.domain.model.Company;
import app.domain.model.VaccineType;
import app.domain.store.NewVaccineTypeStore;

/**
 * The type Specify new vaccine type controller.
 */
public class SpecifyNewVaccineTypeController {
    /**
     * Controller of the UserStory 12: Specify a new vaccine type
     * @author Gonçalo Carneiro 1210809@isep.ipp.pt
     */
    private Company company;
    private VaccineType vt;
    private NewVaccineTypeStore store;


    /**
     * Constructor of the class, gets an instance of the company class
     */
    public SpecifyNewVaccineTypeController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor of the class, receives an instance of the company class
     *
     * @param company instance of Company
     */
    public SpecifyNewVaccineTypeController(Company company) {
        this.company = company;
        this.vt = null;
    }

    /**
     * Give company.
     *
     * @param st the st
     */
    public void giveCompany(NewVaccineTypeStore st){
        st = store;
    }

    /**
     * Creates a new VaccineType  instance, firstly creates a instance of VaccineTypeStore and then call the method of this instance that creates the Vaccinetype instance
     *
     * @param code id of the Vaccine type
     * @param type name of the Vaccine type
     * @param tech email of the Vaccine type
     */
    public void createVaccineType(String code,String type, String tech) {
        store=company.getVaccineTypeList();

        store.createVaccineType(code,type,tech);

    }

    /**
     * Gets vt.
     *
     * @return String that represents the VaccineType instance
     */
    public VaccineType getVt() {
        return store.getVt();
    }

    /**
     * Calls the method of the instance of VaccineType that saves the VaccineType instance in the ArrayList
     *
     * @return success of the operation
     */
    public boolean saveVaccineType() {
        return this.store.saveVaccineType();
    }
}
