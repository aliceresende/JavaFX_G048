package app.controller;

import app.domain.model.ArrivalOfSNSUser;
import app.domain.model.Company;
import app.domain.model.ComunityMassVaccinationCenter;
import app.store.VaccinationCenterStore;
import java.util.*;

import static java.lang.System.getProperties;

public class RecordDailyNumberOfVaccinatedPeopleController {
    private App app;
    private ArrayList<ComunityMassVaccinationCenter> knows = new ArrayList<>();
    private Company company = App.getInstance().getCompany();
    private VaccinationCenterStore CommunityMassVaccinationCenter = company.getRegisterCenterStore();
    private Date time1;
    int dailyNumberOfVaccinatedPeople = knows.size();

    /**
     * Constructor
     */
    public Company getCompany() {
        return this.company;
    }
    public RecordDailyNumberOfVaccinatedPeopleController(Company company) {
        this.company = company;
    }
    public RecordDailyNumberOfVaccinatedPeopleController() {
        this(App.getInstance().getCompany());
    }
    public ArrayList<ArrivalOfSNSUser> ListOfVaccinatedUsers = company.getArrivalStore().GetArrivalOfSNSUsers();

}


