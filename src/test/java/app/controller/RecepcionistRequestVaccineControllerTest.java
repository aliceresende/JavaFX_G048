package app.controller;

import app.domain.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecepcionistRequestVaccineControllerTest {
    private Company company;
    private RecepcionistRequestVaccineController recepcionistRequestVaccineController;

    @BeforeEach
    public void setUp() {
        company = new Company("Company");
        recepcionistRequestVaccineController = new RecepcionistRequestVaccineController(company);
    }

    @Test
    @DisplayName("Should return the company")
    public void testGetCompanyShouldReturnTheCompany() {
        assertEquals(company, recepcionistRequestVaccineController.getCompany());
    }

    @Test
    @DisplayName("Should return a list of vaccines")
    void getCompany() {
    }

    @Test
    void createVaccineSchedule() {
    }

    @Test
    void saveVaccineSchedule() {
    }

    @Test
    void validateVaccineSchedule() {
    }

    @Test
    void add() {
    }

    @Test
    void testCreateVaccineSchedule() {
    }

    @Test
    void getVaccinationCenterList() {
    }
}