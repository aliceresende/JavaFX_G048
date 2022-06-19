package app.mappers.dto;

import app.domain.model.VaccinationCenter;

import java.util.Date;

public class VaccineScheduleDTO {
    private String vaccineName;
    private String dateAndHour;
    private Date date;
    private String dateString;
    private String hour;
    private VaccinationCenter vaccinationCenter;
    private String vaccinationCenterName;
    private String snsUserNumber;

    /**
     * Builds an instance of the vaccine schedule DTO receiving the vaccine name, hour, vaccination center name and sns user number
     * @param vaccineName the name of the virus the vaccine was made for confronting
<<<<<<< Updated upstream
     * @param dateAndHour the hour scheduled for the vaccination
=======
>>>>>>> Stashed changes
     * @param vaccinationCenterName the name of the vaccination center
     * @param snsUserNumber the sns user number
     */
    public VaccineScheduleDTO(String vaccineName, String dateAndHour, String vaccinationCenterName, String snsUserNumber) {



        this.dateAndHour = dateAndHour;
        this.vaccineName = vaccineName;

        this.vaccinationCenterName = vaccinationCenterName;
        this.snsUserNumber = snsUserNumber;
    }


    /**
     * Builds an instance of the vaccine schedule DTO receiving the vaccine name, hour, vaccination center name and sns user number
     * @param vaccineName the name of the virus the vaccine was made for confronting
     * @param date the day scheduled for the vaccine
     * @param hour the hour scheduled for the vaccination
     * @param vaccinationCenter the name of the vaccination center
     */
    public VaccineScheduleDTO(String vaccineName, Date date, String hour, VaccinationCenter vaccinationCenter) {
        this.vaccineName = vaccineName;
        this.date = date;
        this.hour = hour;
        this.vaccinationCenter = vaccinationCenter;
    }

    public String getDateAndHour() {
        return dateAndHour;
    }


    public String getVaccineName() {
        return vaccineName;
    }
    public String getVaccinationCenterName() {
        return vaccinationCenterName;
    }
    public String getSnsUserNumber() {
        return snsUserNumber;
    }
}
