package app.domain.model;

import app.mappers.dto.VaccineDTO;

public class VaccineAdministration {
    private String exitTime;

    private String snsUserNumber;

    private VaccineDTO vaccine;

    private int dose;

    private String additionalNotes;

    private String administrationTime;

    private String lotNumber;



    public VaccineAdministration(String administrationTime, String exitTime, String snsUserNumber, VaccineDTO vaccine, int dose, String additionalNotes, String lotNumber) {

        this.administrationTime = administrationTime;
        this.exitTime = exitTime;
        this.snsUserNumber = snsUserNumber;
        this.vaccine = vaccine;
        this.dose = dose;
        this.additionalNotes = additionalNotes;
        this.lotNumber = lotNumber;
    }

    public String getExitTime() {
        return exitTime;
    }

    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    public VaccineDTO getVaccine() {
        return vaccine;
    }

    public int getDose() {
        return dose;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public String getAdministrationTime() {
        return administrationTime;
    }

    public String getLotNumber() {
        return lotNumber;
    }
}
