package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.PasswordGenerator;
import app.domain.store.EmployeeStore;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.io.IOException;

/**
 * The type Register employee controller.
 */
public class RegisterEmployeeController {
    private App app;
    private Company company;
    private Employee emp;
    private EmployeeStore store;

    /**
     * Gets company.
     *
     * @return the company
     */
    public Company getCompany() {
        return this.company;
    }

    /**
     * Constructor
     */
    public RegisterEmployeeController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Instantiates a new Register employee controller.
     *
     * @param company the company
     */
    public RegisterEmployeeController(Company company){
        this.emp = null;
        this.company = company;
        this.store = company.getEmployeeStore();
    }

    /**
     * Register the Employee in the store with name, phone number, email, address, citizen card number and role
     *
     * @param name              name of the Employee
     * @param phoneNumber       phone number of the Employee
     * @param email             email of the Employee
     * @param address           address of the Employee
     * @param citizenCardNumber citizen card number of the Employee
     * @param role              role of the Employee
     */
    public void createEmployee(String name, String phoneNumber, String email, String address, String citizenCardNumber, String role){
        emp = store.createEmployee(name,phoneNumber,email,address,citizenCardNumber,role);
        store.validateEmployee(emp);
    }

    /**
     * Saves an Employee
     *
     * @throws IOException the io exception
     */
    public void saveEmployee() throws IOException {
        String password = PasswordGenerator.generatePassword();
        AuthFacade pwd = company.getAuthFacade();
        pwd.addUserRole(emp.getRole(), emp.getRole());
        pwd.addUserWithRole(emp.getName(), emp.getEmail(), password, emp.getRole());
        this.store.saveEmployee(emp);
        System.out.println(store.showAuthenticationData(emp,password));

    }

    /**
     * Returns the information of the Employee
     *
     * @return info of the SNS user
     */
    public String EmployeeInfo(){
        return emp.toString();
    }

}
