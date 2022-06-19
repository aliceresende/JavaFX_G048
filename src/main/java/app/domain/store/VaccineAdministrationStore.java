package app.domain.store;

import app.domain.model.VaccineAdministration;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Administration store.
 */
public class VaccineAdministrationStore {

    private ArrayList<VaccineAdministration> knows = new ArrayList<>();

    /**
     * Gets knows.
     *
     * @return the knows
     */
    public ArrayList<VaccineAdministration> getKnows() {return this.knows; }

    /**
     * Instantiates a new Administration store.
     */
    public VaccineAdministrationStore() {}

}
