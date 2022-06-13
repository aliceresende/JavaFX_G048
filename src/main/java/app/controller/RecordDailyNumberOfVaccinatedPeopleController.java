package app.controller;

import app.domain.model.Company;
import app.domain.store.ArrivalOfSNSUserStore;
import app.mappers.VaccinationCenterMapper;

public class RecordDailyNumberOfVaccinatedPeopleController {
private App app;
private Company company;
private String date;
private VaccinationCenterMapper vCenterMapper;

private ArrivalOfSNSUserStore storeArrival;
private int DailyAmountOfUsers;


    /**
     * Constructor
     */

    public Company getCompany() { return this.company; }

    public RecordDailyNumberOfVaccinatedPeopleController() { this(App.getInstance().getCompany());
    }

    public RecordDailyNumberOfVaccinatedPeopleController(Company company) {
        this.date = date;
        this.vCenterMapper = new VaccinationCenterMapper();
        storeArrival = company.getArrivalStore();

    }
    public void saveRecordDailyNumberOfVaccinatedPeople(String vaccinationCenterName,String date, String hour,int DailyAmountOfUsers){

    }










}
