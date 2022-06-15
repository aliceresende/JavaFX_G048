package app.mappers.dto;

import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;

import java.util.Date;

/**
 * The type Vaccine schedule dto.
 */
public class VaccineScheduleDTO {
    private String vaccineName;
    private Date date;
    private String dateString;
    private String hour;
    private VaccinationCenter vaccinationCenter;
    private String vaccinationCenterName;
    private SNSUser snsUser;
    private String snsUserNumber;

    /**
     * Builds an instance of the vaccine schedule DTO receiving the vaccine name, hour, vaccination center name and sns user number
     *
     * @param vaccineName           the name of the virus the vaccine was made for confronting
     * @param dateString            the date string
     * @param hour                  the hour scheduled for the vaccination
     * @param vaccinationCenterName the name of the vaccination center
     * @param snsUserNumber         the sns user number
     */
    public VaccineScheduleDTO(String vaccineName, String dateString, String hour, String vaccinationCenterName, String snsUserNumber) {
        this.vaccineName = vaccineName;
        this.dateString = dateString;
        this.hour = hour;
        this.vaccinationCenterName = vaccinationCenterName;
        this.snsUserNumber = snsUserNumber;
    }

    /**
     * Builds an instance of the vaccine schedule DTO receiving the vaccine name, hour, vaccination center name and sns user number
     *
     * @param vaccineName       the name of the virus the vaccine was made for confronting
     * @param date              the day scheduled for the vaccine
     * @param hour              the hour scheduled for the vaccination
     * @param vaccinationCenter the name of the vaccination center
     * @param snsUser           the sns user number
     */
    public VaccineScheduleDTO(String vaccineName, Date date, String hour, VaccinationCenter vaccinationCenter, SNSUser snsUser) {
        this.vaccineName = vaccineName;
        this.date = date;
        this.hour = hour;
        this.vaccinationCenter = vaccinationCenter;
        this.snsUser = snsUser;
    }


    /**
     * Gets vaccine name.
     *
     * @return the vaccine name
     */
    public String getVaccineName() {
        return vaccineName;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets date string.
     *
     * @return the date string
     */
    public String getDateString() {
        return dateString;
    }

    /**
     * Gets hour.
     *
     * @return the hour
     */
    public String getHour() {
        return hour;
    }

    /**
     * Gets vaccination center.
     *
     * @return the vaccination center
     */
    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    /**
     * Gets vaccination center name.
     *
     * @return the vaccination center name
     */
    public String getVaccinationCenterName() {
        return vaccinationCenterName;
    }

    /**
     * Gets sns user.
     *
     * @return the sns user
     */
    public SNSUser getSnsUser() {
        return snsUser;
    }

    /**
     * Gets sns user number.
     *
     * @return the sns user number
     */
    public String getSnsUserNumber() {
        return snsUserNumber;
    }
}
