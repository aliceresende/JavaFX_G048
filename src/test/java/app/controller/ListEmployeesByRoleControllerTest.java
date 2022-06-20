package app.controller;


import app.store.EmployeeStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pt.isep.lei.esoft.auth.domain.model.UserRole;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class ListEmployeesByRoleControllerTest {

    private EmployeeStore employeeStore;

    private ListEmployeesByRoleController listEmployeesByRoleController;

    @Test
    @DisplayName("Should return the list of roles")
    public void testGetListOfRolesShouldReturnTheListOfRoles() {

        ListEmployeesByRoleController controller = new ListEmployeesByRoleController();
        ArrayList<UserRole> roles = controller.getListOfRoles();

        assertEquals(3, roles.size());
    }



    /*@Test
    @DisplayName("Should return a list of employees when there are employees with the selected role")
    public void testGetEmployeesBySelectedRoleWhenThereAreEmployeesWithTheSelectedRoleThenReturnListOfEmployees() {

        Employee employee1 = new Employee("John", "123456789", "john@gmail.com", "Rua da Alegria", "12345678", Constants.ROLE_RECEPT);
        Employee employee2 = new Employee("Mary", "987654321", "mary@gmail.com", "Rua da Saudade", "87654321", Constants.ROLE_NURSE);
        Employee employee3 = new Employee("Peter", "123789456", "peter@gmail.com", "Rua da Felicidade", "12378945", Constants.ROLE_CENTER_COORDINATOR);
        Employee employee4 = new Employee("Paul", "456123789", "paul@gmail.com", "Rua da Tristeza", "45612378", Constants.ROLE_RECEPT);
        Employee employee5 = new Employee("Maria", "789456123", "maria@gmail.com", "Rua da Esperança", "78945612", Constants.ROLE_NURSE);

        employeeStore.addEmployee(employee1);
        employeeStore.addEmployee(employee2);
        employeeStore.addEmployee(employee3);
        employeeStore.addEmployee(employee4);
        employeeStore.addEmployee(employee5);

        ArrayList<Employee> expected = new ArrayList<>();
        expected.add(employee1);
        expected.add(employee4);

        ArrayList<Employee> actual = listEmployeesByRoleController.getEmployeesBySelectedRole(Constants.ROLE_RECEPT);

        assertEquals(expected, actual);
    }*/
}