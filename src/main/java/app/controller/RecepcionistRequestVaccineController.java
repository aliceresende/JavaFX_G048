package app.controller;

import app.domain.model.*;
import app.store.NewVaccineStore;
import app.store.VaccinationCenterStore;
import app.store.VaccineScheduleStore;
import app.mappers.SNSUserMapper;
import java.io.IOException;
import java.util.List;

public class RecepcionistRequestVaccineController {
    private App app;
    private Company company;
    private NewVaccineStore vaccine = new NewVaccineStore();
    private VaccineSchedule vaccineSchedule;
    private VaccineScheduleStore vaccineScheduleStore;
    private VaccinationCenterStore vaccinationCenter;
    private SNSUserMapper SNSUserMapper = new SNSUserMapper();

    List<VaccineSchedule> array;


    public Company getCompany() {
        return this.company;
    }


    public RecepcionistRequestVaccineController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor
     */

    public RecepcionistRequestVaccineController(Company company) {
        this.vaccineSchedule = null;
        this.company = company;
        vaccineScheduleStore = company.getVaccineScheduleStore();
    }
    /**
     * Request the Vaccine in the store with vaccineName, date, hour, vaccinationCenterID and SnsUserNumber
     *
     * @param vaccineName       the name of the virus the vaccine was made for confronting
     * @param VaccinationCenter the name of the vaccination center
     */


    public void createVaccineSchedule(String SNSUserNumber, String vaccineName, String dateanaTimeofVaccination, String VaccinationCenter) {
        vaccineSchedule = vaccineScheduleStore.createVaccineSchedule( vaccineName, dateanaTimeofVaccination, VaccinationCenter, SNSUserNumber);
        vaccineScheduleStore.validateVaccineSchedule(vaccineSchedule);
    }
    /**
     * Saves a vaccination schedule
     * @throws IOException
     */

    public void saveVaccineSchedule() {
        vaccineScheduleStore.saveVaccineSchedule(vaccineSchedule);
    }


    public boolean add(VaccineSchedule vaccineSchedule) {
        array.add(vaccineSchedule);
        return true;
    }
   // public ArrivalOfSNSUserDTO getDateOfLastVaccine(){ return ArrivalOfSNSUserMapper.toDTO(vaccineScheduleStore.getDateOfLastVaccine());}



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
        vaccineScheduleStore.show();
    }
}


