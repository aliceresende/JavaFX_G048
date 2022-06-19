package app.domain.model;

import java.io.Serializable;

public class PerformanceData implements Serializable {

    private String snsUserNumber;
    private String vaccineName;
    private String dose;
    private String lotNumber;
    private String schedule;
    private String arrival;
    private String administration;
    private String leaving;

    public PerformanceData(String snsUserNumber, String vaccineName, String dose, String lotNumber, String schedule, String arrival, String administration, String leaving) {
        this.snsUserNumber = snsUserNumber;
        this.vaccineName = vaccineName;
        this.dose = dose;
        this.lotNumber = lotNumber;
        this.schedule = schedule;
        this.arrival = arrival;
        this.administration = administration;
        this.leaving = leaving;
    }

    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    public void setSnsUserNumber(String snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }

    public String getLeaving() {
        return leaving;
    }

    public void setLeaving(String leaving) {
        this.leaving = leaving;
    }

    @Override
    public String toString() {
        return "PerformanceData{" +
                "snsUserNumber='" + snsUserNumber + '\'' +
                ", vaccineName='" + vaccineName + '\'' +
                ", dose='" + dose + '\'' +
                ", lotNumber='" + lotNumber + '\'' +
                ", schedule='" + schedule + '\'' +
                ", arrival='" + arrival + '\'' +
                ", administration='" + administration + '\'' +
                ", leaving='" + leaving + '\'' +
                '}';
    }

}
