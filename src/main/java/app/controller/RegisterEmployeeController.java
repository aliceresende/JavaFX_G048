package app.controller;

import app.domain.model.CenterCoordinator;
import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.PasswordGenerator;
import app.store.EmployeeStore;
import app.mappers.dto.VaccinationCenterDTO;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.io.IOException;

public class RegisterEmployeeController {
    public Object SaveCenterCoordinator;
    private App app;
    private Company company;
    private Employee emp;
    private CenterCoordinator CC;

    private EmployeeStore store;

    public Company getCompany() {
        return this.company;
    }

    /**
     * Constructor
     */

    public RegisterEmployeeController() {
        this(App.getInstance().getCompany());
    }

    public RegisterEmployeeController(Company company){
        this.emp = null;
        this.company = company;
        this.store = company.getEmployeeStore();
    }

    /**
     * Register the Employee in the store with name, phone number, email, address, citizen card number and role
     * @param name name of the Employee
     * @param phoneNumber phone number of the Employee
     * @param email email of the Employee
     * @param address address of the Employee
     * @param citizenCardNumber citizen card number of the Employee
     * @param role role of the Employee
     */

    public void createEmployee(String name, String phoneNumber, String email, String address, String citizenCardNumber, String role){
        emp = store.createEmployee(name,phoneNumber,email,address,citizenCardNumber,role);
        store.validateEmployee(emp);
    }
    public void createCenterCoordinator(String name, String phoneNumber, String email, String address, String citizenCardNumber, String role, VaccinationCenterDTO center){
        CC = store.createCenterCoordinator(name,phoneNumber,email,address,citizenCardNumber,role, center);
        store.validateEmployee(emp);
    }

    /**
     * Saves an Employee
     * @throws IOException
     */

    public void saveEmployee() throws IOException {
        String password = PasswordGenerator.generatePassword();
        AuthFacade pwd = company.getAuthFacade();
        pwd.addUserRole(emp.getRole(), emp.getRole());
        pwd.addUserWithRole(emp.getName(), emp.getEmail(), password, emp.getRole());
        this.store.saveEmployee(emp);
        System.out.println(store.showAuthenticationData(emp,password));

    }
    public void setSaveCenterCoordinator() throws IOException {
        String password = PasswordGenerator.generatePassword();
        AuthFacade pwd = company.getAuthFacade();
        pwd.addUserRole(CC.getRole(), CC.getRole());
        pwd.addUserWithRole(CC.getName(), CC.getEmail(), password, CC.getRole());
        this.store.SaveCenterCoordinator(CC);
        System.out.println(store.showAuthenticationData(CC,password));

    }

    /**
     * Returns the information of the Employee
     * @return info of the SNS user
     */

    public String EmployeeInfo(){
        return emp.toString();
    }

}
