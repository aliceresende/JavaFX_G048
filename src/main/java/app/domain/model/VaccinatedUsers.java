package app.domain.model;
import java.io.Serializable;
public class VaccinatedUsers implements Serializable{
    private String date;
    private String filePath;
    //private String allDataPath;
/*
    /**
     * Builds an instance of the vaccinated users in a specified day and the path to where it will be extracted
     * @param date the chosen day
     * @param filePath the path to where the data will be extracted
     */

/*    public VaccinatedUsers(String date, String filePath) {
        this.date = date;
        this.filePath = filePath;
    }
*/
    /**
     * Builds an instance of the vaccinated users in a specified day
     * @param date the chosen day
     */

    public VaccinatedUsers(String date) {
        this.date = date;
        this.filePath = null;
    }

    /**
     * Returns the chosen day
     * @return the chosen day
     */

    public String getDate() {
        return date;
    }

    /**
     * Returns the path to where the data will be extracted
     * @returns the path to where the data will be extracted
     */

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return "\nNumber of Vaccinated Users\nDay: " + date + "\nFile Path: " + filePath;
    }
}
