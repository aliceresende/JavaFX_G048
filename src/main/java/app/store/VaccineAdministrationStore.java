package app.store;

import app.domain.model.VaccineAdministration;
import app.mappers.dto.VaccineDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VaccineAdministrationStore {

    private ArrayList<VaccineAdministration> knows = new ArrayList<>();

    public ArrayList<VaccineAdministration> getKnows() { return this.knows; }

    public VaccineAdministrationStore() {
        Collections.sort(knows, new SortByDate());


    }

    public VaccineAdministration createAdministration(String exitTime, String snsUserNumber, VaccineDTO vaccine, int dose, String notes, String administrationTime, String lotNumber) {
        return new VaccineAdministration(administrationTime,exitTime,snsUserNumber,vaccine,dose,notes,lotNumber);
    }

    public void addAdministration(String exitTime, String snsUserNumber, VaccineDTO vaccine, int dose, String notes, String administrationTime, String lotNumber){
        knows.add(createAdministration(exitTime,snsUserNumber,vaccine,dose,notes,administrationTime,lotNumber));
    }

    static class SortByDate implements Comparator<VaccineAdministration> {
        @Override
        public int compare(VaccineAdministration o1, VaccineAdministration o2) {
            return o1.getExitTime().compareTo(o2.getExitTime());
        }
    }
}
