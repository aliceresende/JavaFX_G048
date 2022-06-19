package app.controller;

import app.domain.model.Company;
import app.domain.model.Vaccine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestVaccineControllerTest {

    @Test
    @DisplayName("Should return a list of vaccines")
    public void testGetVaccineListShouldReturnAListOfVaccines() {

        RequestVaccineController requestVaccineController = new RequestVaccineController();

        List<Vaccine> vaccineList = requestVaccineController.GetVaccineList();

        assertEquals(1, vaccineList.size());
    }

    @Test
    @DisplayName("Should return the company")
    public void testGetCompanyShouldReturnTheCompany() {

        Company company = new Company("Company");
        RequestVaccineController requestVaccineController = new RequestVaccineController(company);

        Company result = requestVaccineController.getCompany();

        assertEquals(company, result);
    }
}