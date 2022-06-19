package app.controller;

import app.domain.model.*;
import app.store.NewVaccineStore;
import app.store.VaccinationCenterStore;
import app.store.VaccineScheduleStore;
import java.io.IOException;
import java.util.List;

public class RequestVaccineController {
    private VaccinationCenterStore vaccinationCenter;
    private NewVaccineStore vaccine = new NewVaccineStore();
    private App app;
    private Company company;
    private VaccineSchedule vaccineSchedule;
    private VaccineScheduleStore store;


    public Company getCompany() {
        return this.company;
    }

    public RequestVaccineController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor
     */

    public RequestVaccineController(Company company) {
        this.vaccineSchedule = null;
        this.company = company;
        store = company.getVaccineScheduleStore();
    }

    /**
     * Request the Vaccine in the store with vaccineName, date, hour, vaccinationCenterID and SnsUserNumber
     * @param vaccineName the name of the virus the vaccine was made for confronting
     * @param dateAndHour the date and hour scheduled for the vaccine (format (DD-MM-YYYY 00:00));
     * @param vaccinationCenterName the name of the vaccination center
     * @param snsUserNumber the SNS user number of the SNS user
     */

    public void createVaccineSchedule(String vaccineName, String dateAndHour, String vaccinationCenterName, String snsUserNumber) {
        vaccineSchedule = store.createVaccineSchedule(vaccineName, dateAndHour, vaccinationCenterName, snsUserNumber);
        //store.validateVaccineSchedule(vaccineSchedule);
        VaccinationProcess vp = new VaccinationProcess(snsUserNumber);
    }

    /**
     * Saves a vaccination schedule
     */

    public void saveVaccineSchedule() {
        store.saveVaccineSchedule(vaccineSchedule);
    }

    /**
     * Returns the information of the vaccine schedule
     * @return info of the vaccine schedule
     */

    public String VaccineScheduleInfo() {
        return vaccineSchedule.toString();
    }

    /**
     * Gets the vaccination center array list
     * @return the vaccination center array list
     */

    public List<ComunityMassVaccinationCenter> GetVaccinationCenterList() {
        vaccinationCenter = company.getRegisterCenterStore();
        return vaccinationCenter.ArrayListGetter();
    }

    /**
     * Gets the vaccine array list
     * @return the vaccine array list
     */

    public List<Vaccine> GetVaccineList() {
        return vaccine.ArrayList();
    }

    public void show(){
        store.show();
    }

}
