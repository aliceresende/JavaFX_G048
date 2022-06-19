package app.domain.store;

import app.domain.model.Employee;
import app.domain.shared.Constants;
import app.store.EmployeeStore;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeStoreTest {


    @Rule
    public Employee emp;
    public List<Employee> employeeList = new ArrayList<>();

    @BeforeEach
    void setUp() throws ParseException {
        employeeList.add(new Employee("Diogo","999999999","diogo@gmail.com","Avenida da Restauração","12345678",Constants.ROLE_NURSE));
        emp = new Employee("Diogo","999999999","diogo@gmail.com","Avenida da Restauração","12345678",Constants.ROLE_NURSE);
    }

    @Test

    void createEmpoloyee() throws ParseException {
        Employee emp1 = new Employee("Diogo","999999999","diogo@gmail.com","Avenida da Restauração","12345678",Constants.ROLE_NURSE);
        EmployeeStore employeeS = new EmployeeStore();
        Employee emp2 = employeeS.createEmployee("Diogo","999999999","diogo@gmail.com","Avenida da Restauração","12345678",Constants.ROLE_NURSE);
        Assert.assertEquals(false,emp1.equals(emp2));
    }

    @Test

    void validateEmployeeDifferent() throws ParseException {
        Employee emp1 = new Employee("Inês","999999999","ines@gmail.com","Rua das cavacas","87654321",Constants.ROLE_CENTER_COORDINATOR);
        EmployeeStore employeeS = new EmployeeStore();
        employeeS.addEmployee(emp);
        employeeS.validateEmployee(emp1);
    }

    @Test
        void saveEmployee() {
        EmployeeStore employeeS = new EmployeeStore();
        employeeS.saveEmployee(emp);
    }

    @Test
        void addSNSUser() {
        employeeList.add(emp);
    }

    //------------------------getEmployeeBySelectedRole tests---------------------------------------------------------------------------
    @Test
    void getEmployeesBySelectedRoleTest()  {
        EmployeeStore actual = new EmployeeStore();
        Employee emp1 = new Employee("Maria","999999999","maria.nurse@isep.pt","Rua desconhecida","12345678", Constants.ROLE_NURSE);
        Employee emp2 = new Employee("António","999999999","antonio.nurse@isep.pt","Rua desconhecida","12345678",Constants.ROLE_NURSE);
        Employee emp3 = new Employee("Clara","999999999","clara.receptionist@isep.pt","Rua desconhecida","12345678",Constants.ROLE_RECEPT);
        Employee emp4 = new Employee("Matias","999999999","matias.nurse@isep.pt","Rua desconhecida","12345678",Constants.ROLE_NURSE);
        actual.saveEmployee(emp1);
        actual.saveEmployee(emp2);
        actual.saveEmployee(emp3);
        actual.saveEmployee(emp4);
        ArrayList<Employee> actualEmployees = actual.getEmployeesBySelectedRole(Constants.ROLE_NURSE);

        ArrayList<Employee> expected = new ArrayList<>();
        expected.add(emp1);
        expected.add(emp2);
        expected.add(emp4);

        assertTrue(actualEmployees.equals(expected));
    }


    @Test
    public void GetEmployeesBySelectedRoleNoEmployeesTest() {
        EmployeeStore employeeStore = new EmployeeStore();
        ArrayList<Employee> employees = employeeStore.getEmployeesBySelectedRole(Constants.ROLE_NURSE);
        assertEquals(0, employees.size());
    }
}