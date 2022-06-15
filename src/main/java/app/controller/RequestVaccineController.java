package app.controller;

import app.domain.model.Company;
import app.domain.model.ComunityMassVaccinationCenter;
import app.domain.model.Vaccine;
import app.domain.model.VaccineSchedule;
import app.domain.store.NewVaccineStore;
import app.domain.store.VaccinationCenterStore;
import app.domain.store.VaccineScheduleStore;

import java.io.IOException;
import java.util.List;

/**
 * The type Request vaccine controller.
 */
public class RequestVaccineController {
    private VaccinationCenterStore vaccinationCenter;
    private NewVaccineStore vaccine = new NewVaccineStore();
    private App app;
    private Company company;
    private VaccineSchedule vaccineSchedule;
    private VaccineScheduleStore store;


    /**
     * Gets company.
     *
     * @return the company
     */
    public Company getCompany() {
        return this.company;
    }

    /**
     * Instantiates a new Request vaccine controller.
     */
    public RequestVaccineController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor
     *
     * @param company the company
     */
    public RequestVaccineController(Company company) {
        this.vaccineSchedule = null;
        this.company = company;
        store = company.getVaccineScheduleStore();
    }

    /**
     * Request the Vaccine in the store with vaccineName, date, hour, vaccinationCenterID and SnsUserNumber
     *
     * @param vaccineName           the name of the virus the vaccine was made for confronting
     * @param date                  the scheduled day to take the vaccine (format: DD-MM-YYYY)
     * @param hour                  the scheduled hour to take the vaccine (format: 00:00)
     * @param vaccinationCenterName the name of the vaccination center
     * @param SnsUserNumber         the SNS user number of the SNS user
     */
    public void createVaccineSchedule(String vaccineName, String date, String hour, String vaccinationCenterName, String SnsUserNumber) {
        vaccineSchedule = store.createVaccineSchedule(vaccineName, date, hour, vaccinationCenterName, SnsUserNumber);
        store.validateVaccineSchedule(vaccineSchedule);
    }

    /**
     * Saves a vaccination schedule
     *
     * @throws IOException
     */
    public void saveVaccineSchedule() {
        store.saveVaccineSchedule(vaccineSchedule);
    }

    /**
     * Returns the information of the vaccine schedule
     *
     * @return info of the vaccine schedule
     */
    public String VaccineScheduleInfo() {
        return vaccineSchedule.toString();
    }

    /**
     * Gets the vaccination center array list
     *
     * @return the vaccination center array list
     */
    public List<ComunityMassVaccinationCenter> GetVaccinationCenterList() {
        vaccinationCenter = company.getRegisterCenterStore();
        return vaccinationCenter.ArrayListGetter();
    }

    /**
     * Gets the vaccine array list
     *
     * @return the vaccine array list
     */
    public List<Vaccine> GetVaccineList() {
        return vaccine.ArrayList();
    }

}
