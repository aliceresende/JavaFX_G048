package app.mappers.dto;

public class LegacyDataDTO {
    private String snsUserNumber;
    private String snsUserName;
    private String vaccineName;
    private String vaccDescription;
    private String dose;
    private String lotNumber;
    private String schedule;
    private String arrival;
    private String administration;
    private String leaving;


    public LegacyDataDTO(String snsUserNumber, String snsUserName, String vaccineName, String vaccDescription, String dose, String lotNumber, String schedule, String arrival, String administration, String leaving) {
        this.snsUserNumber = snsUserNumber;
        this.snsUserName = snsUserName;
        this.vaccineName = vaccineName;
        this.vaccDescription = vaccDescription;
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

    public String getSnsUserName() {
        return snsUserName;
    }

    public void setSnsUserName(String snsUserName) {
        this.snsUserName = snsUserName;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccDescription() {
        return vaccDescription;
    }

    public void setVaccDescription(String vaccDescription) {
        this.vaccDescription = vaccDescription;
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
        return  "SNS User Number: " + snsUserNumber + '\'' +
                "| SNS User Name: " + snsUserName + '\'' +
                "| Vaccine Name: " + vaccineName + '\'' +
                "| Vaccine Description: " + vaccDescription + '\'' +
                "| Dose: " + dose + '\'' +
                "| Lot Number: " + lotNumber + '\'' +
                "| Schedule: " + schedule + '\'' +
                "| Arrival: " + arrival + '\'' +
                "| Administration: " + administration + '\'' +
                "| Leaving: " + leaving + '\'';
    }



}
