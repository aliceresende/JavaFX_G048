package app.domain.model;

import app.domain.States.VaccinationProcessStates;
import app.domain.States.VaccinationStates;

import java.text.SimpleDateFormat;
import java.io.Serializable;


public class VaccineSchedule implements Serializable{

    private String vaccineName;
    private String vaccinationCenterName;
    private String snsUserNumber;
    private String dateAndHour;
    private VaccinationCenter vaccinationCenter;
    private SNSUser snsUser;


    /**
     * Builds an instance of the vaccine schedule receiving the vaccine name, date, hour, vaccination center name and sns user number
     *
     * @param vaccineName the name of the virus the vaccine was made for confronting
     * @param dateAndHour the date and hour scheduled for the vaccine;
     * @param vaccinationCenterName the name of the vaccination center
     * @param snsUserNumber the sns user number
     */

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public VaccineSchedule(String vaccineName, String dateAndHour, String vaccinationCenterName, String snsUserNumber) {
        this.vaccineName = vaccineName;
        this.dateAndHour = dateAndHour;
        this.vaccinationCenterName = vaccinationCenterName;
        this.snsUserNumber = snsUserNumber;
    }



    /**
     * Returns the name of the virus the vaccine was made for confronting
     *
     * @return the name of the virus the vaccine was made for confronting
     */

    public String getVaccineName() {
        return vaccineName;
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
     * Returns the dateAndHour
     *
     * @return the dateAndHour
     */

    public String getDateAndHour() {
        return dateAndHour;
    }

    /**
     * Returns the textual description of the vaccine schedule
     *
     * @return vaccine schedule features
     */

    @Override
    public String toString() {
        return "\nVaccine Schedule\nVaccine Name: " + vaccineName + "\nDate and Hour: " + dateAndHour + "\nVaccination Center: " + vaccinationCenterName + "\nSNS User Number: " + snsUserNumber;
    }


}



