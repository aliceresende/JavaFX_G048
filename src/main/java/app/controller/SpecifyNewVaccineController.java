package app.controller;
import app.domain.model.AdministrationProcess;
import app.domain.model.Company;
import app.domain.model.Vaccine;
import app.domain.store.NewVaccineStore;

import java.util.ArrayList;

/**
 * The type Specify new vaccine controller.
 */
public class SpecifyNewVaccineController {
    /**
     * Controller of the UserStory 14: Specify a new vaccine and its administration process
     * @author Miguel Oliveira 1200874@isep.ipp.pt
     */

    private Company company;
    private Vaccine v;
    private NewVaccineStore store;

    /**
     * Constructor of the class, gets an instance of the company class
     */


    public SpecifyNewVaccineController() { this(App.getInstance().getCompany());
    }

    /**
     * Constructor of the class, receives an instance of the company class
     *
     * @param company instance of Company
     */
    public SpecifyNewVaccineController(Company company) {
        this.company = company;
        this.v = null;
    }

    /**
     * Creates a new Vaccine  instance, firstly creates a instance of VaccineStore and then call the method of this instance that creates the Vaccine instance
     *
     * @param code           id of the Vaccine type
     * @param designation    name of the Vaccine type
     * @param VaccineType    of the vaccine
     * @param AgeGroup       the age group
     * @param intv           time between doses
     * @param disease        that the vaccine is treating
     * @param description    description of the vaccine
     * @param administration the administration
     */

    public void createVaccine(String code, String designation, String VaccineType, ArrayList<String> AgeGroup, String intv, String disease,
                              String description, ArrayList<AdministrationProcess> administration){
        store =company.getVaccineStore();
        store.createVaccine( code,  designation,  VaccineType, AgeGroup,  intv,  disease, description, administration);
    }


    /**
     * Gets v.
     *
     * @return the v
     */
    public Vaccine getV() {
        return store.getV();
    }


    /**
     * Save vaccine boolean.
     *
     * @return the boolean
     */
    public boolean saveVaccine(){
        return saveVaccine();
    }

}

