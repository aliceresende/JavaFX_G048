package app.controller;

import app.domain.model.Company;
import app.domain.model.ComunityMassVaccinationCenter;
import app.domain.model.Vaccine;
import app.domain.model.VaccineSchedule;
import app.domain.store.NewVaccineStore;
import app.domain.store.VaccinationCenterStore;
import app.domain.store.VaccineScheduleStore;
import app.mappers.SNSUserMapper;

import java.io.IOException;
import java.util.List;

/**
 * The type Recepcionist request vaccine controller.
 */
public class RecepcionistRequestVaccineController {

    private App app;
    private Company company;
    private NewVaccineStore vaccine = new NewVaccineStore();
    private VaccineSchedule vaccineSchedule;
    private VaccineScheduleStore vaccineScheduleStore;
    private VaccinationCenterStore vaccinationCenter;
    private SNSUserMapper SNSUserMapper = new SNSUserMapper();

    /**
     * The Array.
     */
    List<VaccineSchedule> array;


    /**
     * Gets company.
     *
     * @return the company
     */
    public Company getCompany() {
        return this.company;
    }


    /**
     * Instantiates a new Recepcionist request vaccine controller.
     */
    public RecepcionistRequestVaccineController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor
     *
     * @param company the company
     */
    public RecepcionistRequestVaccineController(Company company) {
        this.vaccineSchedule = null;
        this.company = company;
        vaccineScheduleStore = company.getVaccineScheduleStore();
    }

    /**
     * Request the Vaccine in the store with vaccineName, date, hour, vaccinationCenterID and SnsUserNumber
     *
     * @param answer            the answer
     * @param vaccineName       the name of the virus the vaccine was made for confronting
     * @param dateOfVaccination the scheduled day to take the vaccine (format: DD-MM-YYYY)
     * @param hourOfVaccination the scheduled hour to take the vaccine (format: 00:00)
     * @param VaccinationCenter the name of the vaccination center
     * @param SNSUserNumber     the SNS user number of the SNS user
     */


    public void createVaccineSchedule(String answer, String vaccineName, String dateOfVaccination, String hourOfVaccination, String VaccinationCenter, String SNSUserNumber) {
        vaccineSchedule = vaccineScheduleStore.createVaccineSchedule( vaccineName, dateOfVaccination, hourOfVaccination, VaccinationCenter, SNSUserNumber);
        vaccineScheduleStore.validateVaccineSchedule(vaccineSchedule);
    }

    /**
     * Saves a vaccination schedule
     *
     * @throws IOException
     */

    public void saveVaccineSchedule() {
        vaccineScheduleStore.saveVaccineSchedule(vaccineSchedule);
    }

    /**
     * Add boolean.
     *
     * @param vaccineSchedule the vaccine schedule
     * @return the boolean
     */
    public boolean add(VaccineSchedule vaccineSchedule) {
        array.add(vaccineSchedule);
        return true;
    }
   // public ArrivalOfSNSUserDTO getDateOfLastVaccine(){ return ArrivalOfSNSUserMapper.toDTO(vaccineScheduleStore.getDateOfLastVaccine());}


    /**
     * Create vaccine schedule.
     *
     * @param vaccineName       the vaccine name
     * @param dateOfVaccination the date of vaccination
     * @param hourOfVaccination the hour of vaccination
     * @param VaccinationCenter the vaccination center
     * @param SNSUserNumber     the sns user number
     */
    public void createVaccineSchedule(String vaccineName, String dateOfVaccination, String hourOfVaccination, String VaccinationCenter, String SNSUserNumber) {
        vaccineSchedule = vaccineScheduleStore.createVaccineSchedule(vaccineName, dateOfVaccination, hourOfVaccination, VaccinationCenter, SNSUserNumber);
        vaccineScheduleStore.validateVaccineSchedule(vaccineSchedule);
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


