package app.domain.model;

import java.io.Serializable;

public class Administration implements Serializable {
    private String exitTime;

    private String snsUserNumber;

    private String vaccine;

    private String dose;

    private String additionalNotes;

    public Administration(String exitTime, String snsUserNumber, String vaccine, String dose, String additionalNotes) {
        this.exitTime = exitTime;
        this.snsUserNumber = snsUserNumber;
        this.vaccine = vaccine;
        this.dose = dose;
        this.additionalNotes = additionalNotes;
    }

    public String getExitTime() {
        return exitTime;
    }

    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    public String getVaccine() {
        return vaccine;
    }

    public String getDose() {
        return dose;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }
}
