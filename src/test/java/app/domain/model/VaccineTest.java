package app.domain.model;
import app.store.NewVaccineStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VaccineTest {


    @Test
    @DisplayName("ArrayList must be sorted by type and designation")
    void test_ArrayList_sorting(){

        int res;
        NewVaccineStore store = new NewVaccineStore();
        List <Vaccine> sortedArray = new ArrayList<Vaccine>();
        ArrayList<String> age;
        ArrayList<AdministrationProcess> adm;

        age = new ArrayList<String>();
        age.add("child");
        age.add("teenager");
        age.add("adult");
        age.add("old");
        adm = new ArrayList<AdministrationProcess>();
        adm.add(new AdministrationProcess("123", "varicela", 2, "child", 30, "cheiro"));

        sortedArray.add(new Vaccine ("VAC-1234", "varicela (chickenpox) vaccine","12345", age, "6", "varicela", "The vaccine is given as 2 separate injections, usually into the upper arm, 4 to 8 weeks apart.", adm));

        sortedArray.add(new Vaccine ("VAC-1345", "hepatitis B", "12347", age, "4", "Hepatitis B","Immunization against hepatitis B disease is recommended for all newborn babies, infants, children, and adolescents up to 19 years of age.", adm));

        sortedArray.add(new Vaccine ("VAC-2312", "ebola vaccine", "12349", age, "4", "Ebola", "prevention of disease caused by Zaire ebolavirus in individuals 18 years of age and older as a single dose administration", adm));
        sortedArray.add(new Vaccine ("VAC-1252", "Johnson&Johnson ", "12349", age, "4", "COVID-19", "Administer a booster dose at least 2 months after the primary series dose (1st dose) or additional primary dose (2nd dose) for those who are moderately or severely immunocompromised.", adm));


        store.sort_ArrayList();
        List<Vaccine> array=store.ArrayList();
        for (int i = 0; i<array.size(); i++){
            assertEquals(sortedArray.get(i).get_code(),array.get(i).get_code());
        }

    }



}