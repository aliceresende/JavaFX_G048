package app.controller;

import app.domain.algorithms.sorting.SortingAlgorithm;
import app.domain.model.*;
import app.domain.store.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LoadLegacyDataController {
    /*
    @FXML
    private AnchorPane anchorID;

    @FXML
    private TextField performanceDataFileTxtField;

    @FXML
    private void performanceDataFileButton (){
        final DirectoryChooser dirChooser = new DirectoryChooser();
        Stage stage = (Stage) anchorID.getScene().getWindow();
        File file = dirChooser.showDialog(stage);

        if(file != null){
            System.out.println("Path: " + file.getAbsolutePath());
            performanceDataFileTxtField.setText(file.getAbsolutePath());
        }
    }*/

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

    public Company getCompany() {
        return this.company;
    }

   public LoadLegacyDataController(){
        this(App.getInstance().getCompany());
   }

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
    }*/




    public List<List<String>> sortList(String[] array) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Properties properties = new Properties();
        InputStream in = new FileInputStream("config.properties");
        properties.load(in);
        Class<?> sortClass = Class.forName(properties.getProperty("Company.Algorithms.sorting"));
        SortingAlgorithm sortAlgorithm = null;
        try {
            sortAlgorithm = (SortingAlgorithm)  sortClass.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        in.close();
        return sortAlgorithm.sort(array);
    }
}

