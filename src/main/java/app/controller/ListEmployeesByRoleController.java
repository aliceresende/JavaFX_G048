package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.store.EmployeeRoleStore;
import app.domain.store.EmployeeStore;
import pt.isep.lei.esoft.auth.domain.model.UserRole;

import java.util.ArrayList;

public class ListEmployeesByRoleController {

    private Company company;
    private EmployeeRoleStore roleStore;
    private EmployeeStore employeeStore;

    public ListEmployeesByRoleController() {
        this(App.getInstance().getCompany());
    }


    public ListEmployeesByRoleController(Company company){
        this.company = company;
        this.roleStore = company.getEmployeeRoleStore();
        employeeStore = company.getEmployeeStore();
    }

    public ArrayList<UserRole> getListOfRoles(){
        return roleStore.getRoles();
    }

    public ArrayList<Employee> getEmployeesBySelectedRole(String selectedRole){
        return employeeStore.getEmployeesBySelectedRole(selectedRole);
    }
}