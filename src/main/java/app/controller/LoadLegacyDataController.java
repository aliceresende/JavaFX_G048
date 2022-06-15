package app.controller;


import app.domain.model.*;
import app.domain.store.*;


import java.util.ArrayList;
import java.util.List;

/**
 * The type Load legacy data controller.
 */
public class LoadLegacyDataController {


    //=========================================================

    private String filePath;
    private Company company;
    private SNSUserStore userStore;
    private SNSUser user;

    private NewVaccineStore vaccineStore;
    private Vaccine vaccine;

    private VaccineScheduleStore scheduleStore;
    private VaccineSchedule schedule;

    private ArrivalOfSNSUserStore arrivalStore;
    private ArrivalOfSNSUser arrival;

    private Administration administration;
    private AdministrationStore administrationStore;



    private List<SNSUser> listSNSUsers = new ArrayList<>();

    /**
     * Gets company.
     *
     * @return the company
     */
    public Company getCompany() {
        return this.company;
    }

    /**
     * Instantiates a new Load legacy data controller.
     */
    public LoadLegacyDataController(){
        this(App.getInstance().getCompany());
   }

    /**
     * Instantiates a new Load legacy data controller.
     *
     * @param company the company
     */
    public LoadLegacyDataController(Company company){
        this.company = company;
        userStore = company.getSNSUserStore();
        vaccineStore = company.getVaccineStore();
        scheduleStore = company.getVaccineScheduleStore();
        arrivalStore = company.getArrivalStore();
        administrationStore = company.getAdministrationStore();

        this.user = null;
        this.vaccine = null;
        this.schedule = null;
        this.arrival = null;
        this.administration = null;

    }


/* private void zzz() {

        File folder = new File("C:\\Users\\Inês Alves\\OneDrive\\Ambiente de Trabalho\\SPRINTD");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if(listOfFiles[i].getName().endsWith(".csv")){

                System.out.println("File " + listOfFiles[i].getName());
                }
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();
            System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }*/



}

