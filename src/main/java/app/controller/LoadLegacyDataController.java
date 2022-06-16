package app.controller;


import app.domain.model.*;
import app.domain.model.CSV.CSV;
import app.domain.store.*;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Load legacy data controller.
 */
public class LoadLegacyDataController {


    //=========================================================

    private String filePath;
    private String centerName;

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



    private List<List<String>> csvInfo;

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


    public String getVaccCenterName(String email){
        return email;
    }
    /**
     * Read file list.
     *
     * @param filePath the file path
     * @return the list
     */
    public List<List<String>> readFile(String filePath) {


        try {
            CSV csv = company.knowsFileType(filePath);
            csvInfo = csv.readFile(filePath,csvInfo);

            List<List<String>> csvUsersVerified = validUser(csvInfo);

            //validVaccine(csvUsersVerified);

            //storing(csvUsersVerified);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return csvInfo;
    }

    public String[] sortingCriteria (String index, String order){
        String[] criterias = {index,order};
        return criterias;
    }
//================== Validations ==================================

    /**
     * Valid user list.
     *
     * @param csvInfo the csv info
     * @return the list
     */
    public List<List<String>> validUser(List<List<String>> csvInfo){
        boolean val;
        for (List<String> lineInfo: csvInfo) {
            val = userStore.snsUserNumberExists(lineInfo);
            if(!val){
                csvInfo.remove(lineInfo);
            }
        }
        return csvInfo;
    }

    /**
     * Valid vaccine boolean.
     * @param csvInfo the csv info
     * @return the boolean
     */
   /* public boolean validVaccine(List<List<String>> csvInfo){
        boolean val;
        for(List<String> lineInfo: csvInfo){
            val = vaccineStore.vaccineNameExists(lineInfo);
            if(!val){
                System.out.println("Vaccine does not exist!");
                break;
            }
        }
        return false;
    }*/
//===============================================================

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

