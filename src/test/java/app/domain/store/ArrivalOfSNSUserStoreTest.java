package app.domain.store;

import app.domain.model.ArrivalOfSNSUser;
import app.store.ArrivalOfSNSUserStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class ArrivalOfSNSUserStoreTest {

    @Test
    @DisplayName("Should return true when the vCenterNameSchedule is different from the arrival.getvCenterName()")
    public void testValidateArrivalOfSNSUserWhenVCenterNameScheduleIsDifferentFromArrivalGetVCenterNameThenReturnTrue() {

        ArrivalOfSNSUserStore arrivalOfSNSUserStore = new ArrivalOfSNSUserStore();
        ArrivalOfSNSUser arrival = new ArrivalOfSNSUser("1234567891", "22:05", "Unilabs Aveiro");
        String vCenterNameSchedule = "Centro de Vacinação Coimbra";
        boolean result = arrivalOfSNSUserStore.validateArrivalOfSNSUser(vCenterNameSchedule, arrival);
        assertTrue(result);
    }

    @Test
    @DisplayName("Should return false when the vCenterNameSchedule is equal to the arrival.getvCenterName()")
    public void testValidateArrivalOfSNSUserWhenVCenterNameScheduleIsEqualToArrivalGetVCenterNameThenReturnFalse() {

        ArrivalOfSNSUserStore arrivalOfSNSUserStore = new ArrivalOfSNSUserStore();
        ArrivalOfSNSUser arrival = new ArrivalOfSNSUser("1234567891", "22:05", "Unilabs Aveiro");
        String vCenterNameSchedule = "Unilabs Aveiro";
        boolean result = arrivalOfSNSUserStore.validateArrivalOfSNSUser(vCenterNameSchedule, arrival);
        assertFalse(result);
    }

    @Test
    @DisplayName("Should return true when the arrival is already in the list")
    public void testChecksDuplicatesEntriesWhenArrivalIsAlreadyInTheListThenReturnTrue() {

        ArrivalOfSNSUser arrival = new ArrivalOfSNSUser("1234567891", "22:05", "Unilabs Aveiro");
        ArrivalOfSNSUserStore arrivalOfSNSUserStore = new ArrivalOfSNSUserStore();
        assertTrue(arrivalOfSNSUserStore.checksDuplicatesEntries(arrival));
    }

    @Test
    @DisplayName("Should add the arrival of the SNS user when the SNS user is in the right vaccination center and there are no duplicate entries")
    public void testAddArrivalOfSNSUserWhenSNSUserIsInTheRightVaccinationCenterAndThereAreNoDuplicateEntries() {

        ArrivalOfSNSUser arrival = new ArrivalOfSNSUser("1234567891", "22:05", "Unilabs Aveiro");
        ArrivalOfSNSUserStore arrivalOfSNSUserStore = new ArrivalOfSNSUserStore();
        arrivalOfSNSUserStore.saveArrivalOfSNSUser(arrival, "Unilabs Aveiro");
        ArrayList<ArrivalOfSNSUser> arrivals = arrivalOfSNSUserStore.GetArrivalOfSNSUsers();
        assertEquals(arrivals.get(0).getSNSUserNumber(), arrival.getSNSUserNumber());
    }

    @Test
    @DisplayName("Should return an ArrivalOfSNSUser with the given parameters")
    public void testCreateArrivalOfSNSUserShouldReturnAnArrivalOfSNSUserWithTheGivenParameters() {

        ArrivalOfSNSUserStore arrivalOfSNSUserStore = new ArrivalOfSNSUserStore();
        String SNSUserNumber = "1234567891";
        String timeOfArrival = "22:05";
        String vCenterName = "Unilabs Aveiro";

        ArrivalOfSNSUser arrivalOfSNSUser = arrivalOfSNSUserStore.createArrivalOfSNSUser(SNSUserNumber, timeOfArrival, vCenterName);

        assertEquals(SNSUserNumber, arrivalOfSNSUser.getSNSUserNumber());
        assertEquals(timeOfArrival, arrivalOfSNSUser.getTimeOfArrival());
        assertEquals(vCenterName, arrivalOfSNSUser.getvCenterName());
    }
}