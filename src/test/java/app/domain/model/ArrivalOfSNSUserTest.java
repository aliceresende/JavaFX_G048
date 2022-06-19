package app.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrivalOfSNSUserTest {

    @Test
    @DisplayName("Should return a string that contains the SNSUserNumber")
    public void testToStringShouldReturnAStringThatContainsTheSNSUserNumber() {

        ArrivalOfSNSUser arrivalOfSNSUser = new ArrivalOfSNSUser("123456789", "12:00", "Vaccination Center 1");
        String expected = "123456789";
        String actual = arrivalOfSNSUser.toString();
        assertTrue(actual.contains(expected));
    }

    @Test
    @DisplayName("Should return a string that contains the timeOfArrival")
    public void testToStringShouldReturnAStringThatContainsTheTimeOfArrival() {

        ArrivalOfSNSUser arrivalOfSNSUser = new ArrivalOfSNSUser("123456789", "12:00", "Vaccination Center 1");
        String expected = "12:00";
        String actual = arrivalOfSNSUser.toString();
        assertTrue(actual.contains(expected));
    }

    @Test
    @DisplayName("Should return the vCenterName")
    public void testGetvCenterNameShouldReturnTheVaccinationCenterName() {

        ArrivalOfSNSUser arrivalOfSNSUser = new ArrivalOfSNSUser("123456789", "12:00", "Vaccination Center 1");
        String expected = "Vaccination Center 1";
        String actual = arrivalOfSNSUser.getvCenterName();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return the time of arrival")
    public void testGetTimeOfArrivalShouldReturnTheTimeOfArrival() {

        ArrivalOfSNSUser arrivalOfSNSUser = new ArrivalOfSNSUser("123456789", "12:00", "Vaccination center 1");
        String timeOfArrival = arrivalOfSNSUser.getTimeOfArrival();
        assertEquals("12:00", timeOfArrival);
    }

    @Test
    @DisplayName("Should return the SNSUserNumber")
    public void testGetSNSUserNumberShouldReturnTheSNSUserNumber() {

        ArrivalOfSNSUser arrivalOfSNSUser = new ArrivalOfSNSUser("123456789", "10:00", "Vaccination Center 1");
        String result = arrivalOfSNSUser.getSNSUserNumber();
        assertEquals("123456789", result);
    }
}