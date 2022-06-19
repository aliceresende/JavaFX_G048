package app.store;

import app.domain.model.CenterCoordinator;
import app.domain.model.Employee;
import app.domain.model.PasswordGenerator;
import app.domain.model.Vaccine;
import app.domain.shared.Constants;
import app.mappers.dto.VaccinationCenterDTO;
import app.ui.Persistence;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {
    private ArrayList<Employee> knows = new ArrayList<Employee>();
    private ArrayList<CenterCoordinator> CC = new ArrayList<>();
    private AuthFacade auth;
    private PasswordGenerator pwd;
    private String selectedRole;
    public EmployeeStore (){
        try{
            knows = (ArrayList<Employee>) Persistence.readObjectFromFile("Employees.bin");
        }catch (Exception e){
            //System.out.println("The clientStore was not loaded :)");
        }
        try{
            CC = (ArrayList<CenterCoordinator>) Persistence.readObjectFromFile("CenterCoordinator.bin");
        }catch (Exception e){
            //System.out.println("The clientStore was not loaded :)");
        }

        /*knows.add(new Employee("Gonçalo Carneiro", "987654321", "carneiro666@gmail.com", "rua do agrelo",
                "123456789", Constants.ROLE_CENTER_COORDINATOR));*/

    }

    /**
     * Creates an Employee with name, phone number, email, address, citizen card number and role
     * @param name the name of the Employee
     * @param phoneNumber the phone number of the Employee
     * @param email the email of the Employee
     * @param address the address of the Employee
     * @param citizenCardNumber the citizen card number of the Employee
     * @param role the role of the Employee
     * @return the SNS user information
     */


    public Employee createEmployee(String name, String phoneNumber, String email, String address, String citizenCardNumber, String role){
        Employee employee = new Employee(name,phoneNumber,email,address,citizenCardNumber,role);
        return employee;
    }
    public CenterCoordinator createCenterCoordinator(String name, String phoneNumber, String email, String address, String citizenCardNumber, String role, VaccinationCenterDTO center){
        CenterCoordinator employee = new CenterCoordinator(name,phoneNumber,email,address,citizenCardNumber,role, center);
        return employee;
    }

    /**
     * Validates the Employee data and increments an Employee.
     * @param employee the Employee data of the Employee
     * @return true if the Employee data is valid and false otherwise
     * @throws IllegalArgumentException if the Employee already exists
     */

    public boolean validateEmployee(Employee employee) {
        if (employee == null)
            return false;
        int i = 0;
        for (Employee emp : knows) {
            if (employee.equals(knows.get(i))) {
                throw new IllegalArgumentException("Employee " + emp.getName() + " already exists");
            }
            i++;
        }
        return !this.knows.contains(employee);
    }

    /**
     * Saves a Employee
     * @param employee the Employee data of the Employee
     */

    public void saveEmployee(Employee employee) {
        validateEmployee(employee);
        addEmployee(employee);
    }
    public void SaveCenterCoordinator(CenterCoordinator center) {
        addCenterCoordinator(center);
    }

    private PasswordGenerator generatePassword() {
        return generatePassword();
    }

    /**
     * Adds a new Employee to the list
     * @param employee the Employee data of the Employee
     * @return true and adds a new Employee if the Employee is fulfilled, otherwise returns false
     */

    public boolean addEmployee(Employee employee){
        int cont = 0;
        boolean check = true;
        if (employee != null) {
            for (Employee emp:knows) {
                if (knows.equals(employee)) {
                    check = false; break;
                }
                cont++;
            }
            if (check) {
                knows.add(employee);
                return true;
            }
        }
        return false;
    }
    public boolean addCenterCoordinator(CenterCoordinator center){
        int cont = 0;
        boolean check = true;
        if (center != null) {
            for (CenterCoordinator emp:CC) {
                if (CC.equals(center)) {
                    check = false; break;
                }
                cont++;
            }
            if (check) {
                CC.add(center);
                return true;
            }
        }
        return false;
    }


    /**
     * Show the authentication data of the SNS User
     * @param employee
     * @param pwd
     * @return
     */

    public String showAuthenticationData(Employee employee, String pwd){
        return String.format("\n\nEMPLOYEE AUTHENTICATION DATA\n\nName: %s\nEmail: %s\nPassword: %s\n",
                employee.getName(), employee.getEmail(), pwd);
    }


    public ArrayList<Employee> getKnows() {
        return knows;
    }

    /**
     * Creates a list with all the employees with the same role
     * @param selectedRole: the role selected to list all the employees by
     * @return List<Employee> employeeByRole: return the list filtered
     */

    public ArrayList<Employee> getEmployeesBySelectedRole(String selectedRole){

        ArrayList<Employee> employeeByRole = new ArrayList<>();
        for (Employee employee : knows) {
            if (employee.getRole().equals(selectedRole)) {
                employeeByRole.add(employee);
            }
        }

        return employeeByRole;
    }
    public ArrayList<CenterCoordinator> getCenterCoordinators(){

        ArrayList<CenterCoordinator> CenterByRole = new ArrayList<>();
        for (CenterCoordinator C : CC) {

            CenterByRole.add(C);

        }

        return CenterByRole;
    }
}

