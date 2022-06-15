package app.controller;

import app.domain.model.Company;
import app.domain.store.ArrivalOfSNSUserStore;
import app.mappers.VaccinationCenterMapper;

/**
 * The type Record daily number of vaccinated people controller.
 */
public class RecordDailyNumberOfVaccinatedPeopleController {
private App app;
private Company company;
private String date;
private VaccinationCenterMapper vCenterMapper;

private ArrivalOfSNSUserStore storeArrival;
private int DailyAmountOfUsers;


    /**
     * Constructor
     *
     * @return the company
     */
    public Company getCompany() { return this.company; }

    /**
     * Instantiates a new Record daily number of vaccinated people controller.
     */
    public RecordDailyNumberOfVaccinatedPeopleController() { this(App.getInstance().getCompany());
    }

    /**
     * Instantiates a new Record daily number of vaccinated people controller.
     *
     * @param company the company
     */
    public RecordDailyNumberOfVaccinatedPeopleController(Company company) {
        this.date = date;
        this.vCenterMapper = new VaccinationCenterMapper();
        storeArrival = company.getArrivalStore();

    }

    /**
     * Save record daily number of vaccinated people.
     *
     * @param vaccinationCenterName the vaccination center name
     * @param date                  the date
     * @param hour                  the hour
     * @param DailyAmountOfUsers    the daily amount of users
     */
    public void saveRecordDailyNumberOfVaccinatedPeople(String vaccinationCenterName,String date, String hour,int DailyAmountOfUsers){

    }










}
