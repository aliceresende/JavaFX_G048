package app.controller;
import app.domain.model.AdministrationProcess;
import app.domain.model.Company;
import app.domain.model.Vaccine;
import app.domain.store.NewVaccineStore;

import java.util.ArrayList;

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
     * @param code id of the Vaccine type
     * @param designation name of the Vaccine type
     * @param disease that the vaccine is treating
     * @param VaccineType of the vaccine
     * @param min_age miminum age to take the vaccine
     * @param max_age maximum age to take the vaccine
     * @param doses amount of dose in each vaccine
     * @param intv time between doses
     * @param description description of the vaccine
     */

    public void createVaccine(String code, String designation, String VaccineType, ArrayList<String> AgeGroup, String intv, String disease,
                              String description, ArrayList<AdministrationProcess> administration){
        store =company.getVaccineStore();
        store.createVaccine( code,  designation,  VaccineType, AgeGroup,  intv,  disease, description, administration);
    }


    public Vaccine getV() {
        return store.getV();
    }


    public boolean saveVaccine(){
        return saveVaccine();
    }

}

