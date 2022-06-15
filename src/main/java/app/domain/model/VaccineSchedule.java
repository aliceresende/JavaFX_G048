package app.domain.model;

import java.util.Date;

/**
 * The type Vaccine schedule.
 */
public class VaccineSchedule {
    private String vaccineName;
    private Date date;
    private String dateString;
    private String hour;
    private VaccinationCenter vaccinationCenter;
    private String vaccinationCenterName;
    private SNSUser snsUser;
    private String snsUserNumber;

    /**
     * Builds an instance of the vaccine schedule receiving the vaccine name, date, hour, vaccination center name and sns user number
     *
     * @param vaccineName           the name of the virus the vaccine was made for confronting
     * @param dateString            the day scheduled for the vaccine
     * @param hour                  the hour scheduled for the vaccination
     * @param vaccinationCenterName the name of the vaccination center
     * @param snsUserNumber         the sns user number
     */
    public VaccineSchedule(String vaccineName, String dateString, String hour, String vaccinationCenterName, String snsUserNumber) {
        this.vaccineName = vaccineName;
        this.dateString = dateString;
        this.hour = hour;
        this.vaccinationCenterName = vaccinationCenterName;
        this.snsUserNumber = snsUserNumber;
    }
/*
    /**
     * Builds an instance of the vaccine schedule receiving the vaccine name, date, hour, vaccination center name and sns user number
     * @param vaccineName the name of the virus the vaccine was made for confronting
     * @param date the day scheduled for the vaccine
     * @param hour the hour scheduled for the vaccination
     * @param vaccinationCenterName the name of the vaccination center
     * @param snsUserNumber the sns user number
     */
/*
    public VaccineSchedule(String vaccineName, Date date, String hour, String vaccinationCenterName, String snsUserNumber) {
        this.vaccineName = vaccineName;
        this.date = date;
        this.hour = hour;
        this.vaccinationCenterName = vaccinationCenterName;
        this.snsUserNumber = snsUserNumber;
    }
*/

    /**
     * Returns the name of the virus the vaccine was made for confronting
     *
     * @return the name of the virus the vaccine was made for confronting
     */

    public String getVaccineName() {
        return vaccineName;
    }

    /**
     * Returns the day scheduled for the vaccination
     *
     * @return the day scheduled for the vaccination
     */
    public Date getDate() {
        return date;
    }

    /**
     * Returns the hour scheduled for the vaccination
     *
     * @return the hour scheduled for the vaccination
     */
    public String getHour() {
        return hour;
    }

    /**
     * Returns the name of the vaccination center
     *
     * @return the name of the vaccination center
     */
    public String getVaccinationCenterName() {
        return vaccinationCenterName;
    }

    /**
     * Returns the sns user number
     *
     * @return the sns user number
     */
    public String getSNSUserNumber() {
        return snsUserNumber;
    }

    /**
     * Returns the date
     *
     * @return the date
     */
    public String getDateString() {
        return dateString;
    }

    /**
     * Returns the vaccination center
     *
     * @return the vaccination center
     */
    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    /**
     * Returns the sns user
     *
     * @return the sns user
     */
    public SNSUser getSnsUser() {
        return snsUser;
    }

    /**
     * Returns the sns user number
     *
     * @return the sns user number
     */
    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    /**
     * Returns the textual description of the vaccine schedule
     * @return vaccine schedule features
     */

    @Override
    public String toString() {
        return "\nVaccine Schedule\nVaccine Name: " + vaccineName + "\nDate: " + dateString + "\nHour: " + hour + "\nVaccination Center: " + vaccinationCenterName + "\nSNS User Number: " + snsUserNumber;
    }
}
