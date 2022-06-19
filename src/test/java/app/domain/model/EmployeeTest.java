package app.domain.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Rule
    public Employee emp;
    public List<Employee> employeeList = new ArrayList<>();

    @BeforeEach
    void setUp() throws Exception {
        employeeList.add(new Employee("Diogo","999999999","diogo@gmail.com","Avenida da Restauração","12345678","Nurse"));
        emp = new Employee("Diogo","999999999","diogo@gmail.com","Avenida da Restauração","12345678","Nurse");
    }


    @Test
    void getName() {
        Assert.assertEquals(emp.getName(),"Diogo");
    }

    @Test
    void getEmail() {
        Assert.assertEquals(emp.getEmail(),"diogo@gmail.com");
    }

    @Test
    void checkCitizenCardNumberSmall() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> emp.checkCitizenCardNumber("1234"));
        assertEquals("Invalid Citizen Card Number, it must contain 8 digits", exception.getMessage());
    }
    @Test
    void checkCitizenCardNumberBig() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> emp.checkCitizenCardNumber("1234567890"));
        assertEquals("Invalid Citizen Card Number, it must contain 8 digits", exception.getMessage());
    }

    @Test
    public void checkCitizenNumberEmpty()  {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> emp.checkCitizenCardNumber(""));
        assertEquals("You must enter a valid Citizen Card Number", exception.getMessage());

    }
    @Test
    public void checkCitizenNumberCorrect() {
        emp.checkCitizenCardNumber("12345678");
    }

    @Test
    void checkRoleInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> emp.checkRole("Administrator"));
        assertEquals("You must select a valid Role [Receptionist/Nurse/Center Coordinator]", exception.getMessage());

    }

    @Test
    void checkPhoneNumberLetters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> emp.checkPhoneNumber("9214212aa"));
        assertEquals("Invalid Phone Number", exception.getMessage());
    }

    @Test
    void checkPhoneNumberWrongSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> emp.checkPhoneNumber("9214212"));
        assertEquals("Invalid Phone Number! Must have 9 digits", exception.getMessage());
    }

    @Test
    void checkEmailEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> emp.checkEmail(""));
        assertEquals("Invalid Email", exception.getMessage());
    }
    @Test
    void checkEmailInvalidFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> emp.checkEmail("gmail.com"));
        assertEquals("Invalid Email", exception.getMessage());
    }

    @Test
    void checkAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> emp.checkAddress(""));
        assertEquals("Address cannot be empty", exception.getMessage());
    }

    @Test
    void checkNameEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> emp.checkName(""));
        assertEquals("Name cannot be empty", exception.getMessage());
    }
}