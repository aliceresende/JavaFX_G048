package app.domain.store;

import app.domain.model.VaccineSchedule;
import app.store.VaccineScheduleStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VaccineScheduleStoreTest {

    @Test
    @DisplayName("Should return false when the vaccineSchedule is null")
    public void testValidateVaccineScheduleWhenVaccineScheduleIsNullThenReturnFalse() {
        VaccineScheduleStore vaccineScheduleStore = new VaccineScheduleStore();
        assertFalse(vaccineScheduleStore.validateVaccineSchedule(null));
    }

    @Test
    @DisplayName("Should return false when the vaccineSchedule already exists")
    public void testValidateVaccineScheduleWhenVaccineScheduleAlreadyExistsThenReturnFalse() {
        VaccineScheduleStore vaccineScheduleStore = new VaccineScheduleStore();
        VaccineSchedule vaccineSchedule =
                new VaccineSchedule("Covid-19", "14-09-2022 12:00", "Unilabs Aveiro", "1234567890");
        assertTrue(vaccineScheduleStore.validateVaccineSchedule(vaccineSchedule));
    }

    @Test
    @DisplayName("Should return the vaccine schedule when the SNS user number exists")
    public void testGetVaccineScheduleWhenSNSUserNumberExistsThenReturnVaccineSchedule() {

        VaccineScheduleStore vaccineScheduleStore = new VaccineScheduleStore();
        String SNSUserNumber = "1234567890";
        VaccineSchedule vaccineSchedule = vaccineScheduleStore.getVaccineSchedule(SNSUserNumber);
        assertEquals(vaccineSchedule.getSNSUserNumber(), SNSUserNumber);
    }

    @Test
    @DisplayName("Should throw an exception when the SNS user number doesn't exist")
    public void testGetVaccineScheduleWhenSNSUserNumberDoesntExistThenThrowException() {

        VaccineScheduleStore vaccineScheduleStore = new VaccineScheduleStore();
        assertThrows(IllegalArgumentException.class, () -> {
            vaccineScheduleStore.getVaccineSchedule("123456789");
        });
    }

    @Test
    @DisplayName("Should return the list of vaccine schedules")
    public void testGetKnowsShouldReturnListOfVaccineSchedules() {

        VaccineScheduleStore vaccineScheduleStore = new VaccineScheduleStore();
        ArrayList<VaccineSchedule> vaccineSchedules = vaccineScheduleStore.getKnows();

        assertEquals(2, vaccineSchedules.size());
    }

    @Test
    @DisplayName("Should return a list of vaccine schedules")
    public void testGetVaccineScheduleListShouldReturnAListOfVaccineSchedules() {

        VaccineScheduleStore vaccineScheduleStore = new VaccineScheduleStore();
        List<VaccineSchedule> vaccineSchedules = vaccineScheduleStore.getVaccineScheduleList();
        assertEquals(2, vaccineSchedules.size());
    }
}