package app.domain.model;

/**
 * The type Administration.
 */
public class VaccineAdministration {
    private String exitTime;

    private String snsUserNumber;

    private String vaccine;

    private String dose;

    private String additionalNotes;

    /**
     * Instantiates a new Administration.
     *
     * @param exitTime        the exit time
     * @param snsUserNumber   the sns user number
     * @param vaccine         the vaccine
     * @param dose            the dose
     * @param additionalNotes the additional notes
     */
    public VaccineAdministration(String exitTime, String snsUserNumber, String vaccine, String dose, String additionalNotes) {
        this.exitTime = exitTime;
        this.snsUserNumber = snsUserNumber;
        this.vaccine = vaccine;
        this.dose = dose;
        this.additionalNotes = additionalNotes;
    }

    /**
     * Gets exit time.
     *
     * @return the exit time
     */
    public String getExitTime() {
        return exitTime;
    }

    /**
     * Gets sns user number.
     *
     * @return the sns user number
     */
    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    /**
     * Gets vaccine.
     *
     * @return the vaccine
     */
    public String getVaccine() {
        return vaccine;
    }

    /**
     * Gets dose.
     *
     * @return the dose
     */
    public String getDose() {
        return dose;
    }

    /**
     * Gets additional notes.
     *
     * @return the additional notes
     */
    public String getAdditionalNotes() {
        return additionalNotes;
    }
}
