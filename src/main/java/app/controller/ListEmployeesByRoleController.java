package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.store.EmployeeRoleStore;
import app.domain.store.EmployeeStore;
import pt.isep.lei.esoft.auth.domain.model.UserRole;

import java.util.ArrayList;

/**
 * The type List employees by role controller.
 */
public class ListEmployeesByRoleController {

    private Company company;
    private EmployeeRoleStore roleStore;
    private EmployeeStore employeeStore;

    /**
     * Instantiates a new List employees by role controller.
     */
    public ListEmployeesByRoleController() {
        this(App.getInstance().getCompany());
    }


    /**
     * Instantiates a new List employees by role controller.
     *
     * @param company the company
     */
    public ListEmployeesByRoleController(Company company){
        this.company = company;
        this.roleStore = company.getEmployeeRoleStore();
        employeeStore = company.getEmployeeStore();
    }

    /**
     * Get list of roles array list.
     *
     * @return the array list
     */
    public ArrayList<UserRole> getListOfRoles(){
        return roleStore.getRoles();
    }

    /**
     * Get employees by selected role array list.
     *
     * @param selectedRole the selected role
     * @return the array list
     */
    public ArrayList<Employee> getEmployeesBySelectedRole(String selectedRole){
        return employeeStore.getEmployeesBySelectedRole(selectedRole);
    }
}