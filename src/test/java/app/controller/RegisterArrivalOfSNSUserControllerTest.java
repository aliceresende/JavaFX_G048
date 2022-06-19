package app.controller;

import app.domain.model.Company;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RegisterArrivalOfSNSUserControllerTest {

    @Test
    @DisplayName("Should throw an exception when the SNS user number doesn't have a schedule appointment")
    public void testGetVaccineScheduleBySNSUserNumberWhenSNSSerNumberDoesntHaveAScheduleAppointmentThenThrowsException() {

        Company company = new Company();
        RegisterArrivalOfSNSUserController controller = new RegisterArrivalOfSNSUserController(company);
        assertThrows(IllegalArgumentException.class, () -> controller.getVaccineScheduleBySNSUserNumber("1234567890"));
    }

}