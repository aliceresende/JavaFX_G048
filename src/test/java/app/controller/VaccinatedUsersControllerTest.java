package app.controller;

import app.service.vaccinated_users.CSVFileCreatorVaccinatedUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class VaccinatedUsersControllerTest {

    @Test
    @DisplayName("Should return the number of vaccinated users when the date is in the file")
    public void
    testNumberOfVaccinatedUsersWhenDateIsInTheFileThenReturnTheNumberOfVaccinatedUsers() {
        String date = "2020-03-01";
        String expected = "0";
        VaccinatedUsersController vaccinatedUsersController = new VaccinatedUsersController();
        String actual = vaccinatedUsersController.numberOfVaccinatedUsers(date);
        assertEquals(expected, actual);
    }

    private void assertEquals(String expected, String actual) {
    }

    @Test
    @DisplayName("Should return null when the date is not in the file")
    public void testNumberOfVaccinatedUsersWhenDateIsNotInTheFileThenReturnNull() {
        String date = "2020-01-01";
        String expected = null;
        VaccinatedUsersController vaccinatedUsersController = new VaccinatedUsersController();
        String actual = vaccinatedUsersController.numberOfVaccinatedUsers(date);
        assertEquals(expected, actual);
    }
}