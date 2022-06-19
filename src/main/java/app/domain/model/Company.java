package app.domain.model;

import app.domain.model.CSV.CSV;
import app.store.*;
import org.apache.commons.lang3.StringUtils;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private SNSUserStore uses;
    private EmployeeStore employees;
    private EmployeeRoleStore roles;
    private NewVaccineTypeStore vtstore;
    private VaccinationCenterStore centers;
    private VaccineScheduleStore vSStore;
    private NewVaccineStore vstore;
    private ArrivalOfSNSUserStore arrivalStore;

    private PerformanceDataStore performanceDataStore;
    private VaccineAdministrationStore administrationStore;



    private ReactionStore reactionStore;
    private VaccineAdministrationStore vaccineAdministrationStore;
    private VaccinationProcessStore vaccProcessStore;



    /**
     * Builds an instance of the Company receiving the designation
     * @param designation of the Company
     */
    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.uses= new SNSUserStore();
        this.authFacade = new AuthFacade();
        this.vtstore= new NewVaccineTypeStore();
        this.vSStore = new VaccineScheduleStore();
        this.employees = new EmployeeStore();
        this.roles = new EmployeeRoleStore();
        this.centers = new VaccinationCenterStore();
        this.arrivalStore = new ArrivalOfSNSUserStore();
        this.vstore= new NewVaccineStore();
        this.vaccProcessStore = new VaccinationProcessStore();
        this.reactionStore=new ReactionStore();
        this.vaccineAdministrationStore = new VaccineAdministrationStore();
        this.performanceDataStore = new PerformanceDataStore();

    }



    public EmployeeRoleStore getEmployeeRoleStore(){
        return this.roles;

    }

    public NewVaccineTypeStore getVaccineTypeList(){return this.vtstore;}
    /**
     * Returns the SNS user store from the company
     * @return the SNS user store from the company
     */

    public NewVaccineStore getVaccineStore(){
        return this.vstore;
    }

    /**
     * Returns the SNS user store from the company
     * @return the SNS user store from the company
     */
    public SNSUserStore getSNSUserStore() {
        return uses;
    }

    public ReactionStore getReactionStore() {
        return reactionStore;
    }

    /**
     * Returns the SNS user store from the company
     * @return the SNS user store from the company
     */
    public VaccinationCenterStore getRegisterCenterStore(){ return centers;}

    /**
     * Returns the SNS user store from the company
     * @return the SNS user store from the company
     */
    public EmployeeStore getEmployeeStore() {
        return employees;
    }

    /**
     * Returns the designation from the company
     * @return the designation from the company
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Returns the auth facade from the company
     * @return the auth facade from the company
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * Returns the vaccine schedule store from the company
     * @return the vaccine schedule store from the company
     */
    public VaccineScheduleStore getVaccineScheduleStore() {
        return vSStore;
    }


    /**
     * Returns the arrival of the SNS user store from the company
     * @return the arrival of the SNS user store from the company
     */
    public ArrivalOfSNSUserStore getArrivalStore() {
        return arrivalStore;
    }

    public VaccineAdministrationStore getAdministrationStore() {return vaccineAdministrationStore;}


    public VaccinationProcessStore getVaccinationProcessStore() {
        return vaccProcessStore;
    }
    public PerformanceDataStore getPerformanceDataStore() {
        return performanceDataStore;
    }

    public Company() {}

    /**
     * Reflection technique to return the instance of the interface CSVFileReader according to the csv file path entered
     *
     * @param filepath
     * @return CSVFileReader
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public CSV knowsFileType(String filepath) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> header = Class.forName("app.domain.model.CSV.CSVWithHeader");
        Class<?> noheader = Class.forName("app.domain.model.CSV.CSVNoHeader");
        Class<?> dates = Class.forName("app.domain.model.CSV.CSVWithDates");
        CSV csv;
        String line,line2;
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        line = br.readLine();
        line2 = br.readLine();
        if(line2.contains(":")){
            csv = (CSV) dates.getDeclaredConstructor().newInstance();
            return csv;
        }else if (line.contains(";")) {
            csv = (CSV) header.getDeclaredConstructor().newInstance();
            return csv;
        } else {
            csv = (CSV) noheader.getDeclaredConstructor().newInstance();
            return csv;
        }

    }


}



