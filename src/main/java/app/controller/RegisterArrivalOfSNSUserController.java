package app.controller;

import app.domain.model.ArrivalOfSNSUser;
import app.domain.model.Company;
import app.domain.model.VaccineSchedule;
import app.domain.store.ArrivalOfSNSUserStore;
import app.domain.store.VaccineScheduleStore;
import app.mappers.VaccinationCenterMapper;

/**
 * The type Register arrival of sns user controller.
 */
public class RegisterArrivalOfSNSUserController {
    private App app;
    private VaccineSchedule vaccineSchedule;
    private VaccineScheduleStore storeVS;
    private Company company;
    private VaccinationCenterMapper vCenterMapper;
    private ArrivalOfSNSUser arrivalU;
    private ArrivalOfSNSUserStore storeArrival;


    /**
     * Gets company.
     *
     * @return the company
     */
    public Company getCompany() { return this.company; }

    /**
     * Constructor
     */
    public RegisterArrivalOfSNSUserController() { this(App.getInstance().getCompany());
    }

    /**
     * Constructor defining company, store and arrival
     *
     * @param company the company
     */
    public RegisterArrivalOfSNSUserController(Company company) {
        this.vaccineSchedule = null;
        this.arrivalU = null;
        this.company = company;
        storeVS = company.getVaccineScheduleStore();
        storeArrival = company.getArrivalStore();
        this.vCenterMapper = new VaccinationCenterMapper();
    }

    /**
     * This method gets the Vaccination Schedule of a chosen SNS User and prints
     *
     * @param SNSUserNumber SNS User number of the SNS User
     * @return the vaccine schedule
     */
    public VaccineSchedule getVaccineScheduleBySNSUserNumber(String SNSUserNumber){
        try {
            if(!storeVS.getVaccineScheduleBySNSUserNumber(SNSUserNumber).isEmpty()){
                System.out.println(storeVS.getVaccineScheduleBySNSUserNumber(SNSUserNumber));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("The SNS user number enter doesn't have a schedule appointment.");
        }
        return null;
    }

    /**
     * This method gets the Vaccination Schedule of a chosen SNS User
     *
     * @param SNSUserNumber SNS User number of the SNS User
     * @return the vaccine schedule
     */
    public VaccineSchedule getVaccinationCenterName(String SNSUserNumber){
        return storeVS.getVaccineSchedule(SNSUserNumber);
    }

    /**
     * This method registers the arrival of an SNS User
     *
     * @param SNSUserNumber         SNS User number of the SNS User
     * @param timeOfArrival         Time of arrival to the vaccination center
     * @param vaccinationCenterName Vaccination center where the SNS User are
     */
    public void registerArrivalUser(String SNSUserNumber, String timeOfArrival, String vaccinationCenterName){
        arrivalU = storeArrival.createArrivalOfSNSUser(SNSUserNumber,timeOfArrival,vaccinationCenterName);

    }

    /**
     * This method saves the arrival of an SNS User
     *
     * @param SNSUserNumber         SNS User number of the SNS User
     * @param vaccinationCenterName Vaccination center name where the user are
     */
    public void saveArrival(String SNSUserNumber,String vaccinationCenterName){
        storeArrival.saveArrivalOfSNSUser(arrivalU,vaccinationCenterName);
    }
}
