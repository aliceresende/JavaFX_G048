package app.domain.store;

import app.domain.model.VaccineType;
import app.domain.shared.Constants;
import app.store.NewVaccineTypeStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewVaccineStoreTest {
    @Test
    void createVaccineType() {
        NewVaccineTypeStore store = new NewVaccineTypeStore();
        VaccineType vaccineTypeA =new VaccineType("12312", Constants.TECH_1_TYPE,Constants.TECH_1);
        String expected1= String.valueOf(vaccineTypeA);
        //value should be the same
        String expected = String.valueOf(store.createVaccineType("12312", Constants.TECH_1_TYPE,Constants.TECH_1));
        Assertions.assertEquals(expected1, expected);

    }

    @Test
    void validateVaccineType() {
        NewVaccineTypeStore store = new NewVaccineTypeStore();
        VaccineType vaccineTypeA =new VaccineType("12312", Constants.TECH_1_TYPE,Constants.TECH_1);
        //value should be true because values are valid
        Assertions.assertTrue(store.ValidateVaccineType(vaccineTypeA));
    }



    @Test
    void getVt() {
        NewVaccineTypeStore store = new NewVaccineTypeStore();
        VaccineType vaccineTypeA =new VaccineType("12312", Constants.TECH_1_TYPE,Constants.TECH_1);
        String expected1= String.valueOf(vaccineTypeA);
        store.createVaccineType("12312", Constants.TECH_1_TYPE,Constants.TECH_1);
        store.saveVaccineType();
        //value should be the same
        String expected = String.valueOf(store.getVt());
        Assertions.assertEquals(expected1, expected);


    }
}
