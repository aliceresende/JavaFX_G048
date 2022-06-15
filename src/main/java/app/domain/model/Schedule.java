package app.domain.model;

/**
 * The type Schedule.
 */
public class Schedule {
    private String openingHour;
    private String closingHour;

    /**
     * Instantiates a new Schedule.
     *
     * @param openingHour the opening hour
     * @param closingHour the closing hour
     */
    public Schedule(String openingHour, String closingHour) {
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    /**
     * Instantiates a new Schedule.
     *
     * @param otherSchedule the other schedule
     */
    public Schedule(Schedule otherSchedule){
        openingHour = otherSchedule.openingHour;
        closingHour = otherSchedule.closingHour;
    }

    /**
     * Gets opening hour.
     *
     * @return the opening hour
     */
    public String getOpeningHour() {
        return this.openingHour;
    }

    /**
     * Gets closing hour.
     *
     * @return the closing hour
     */
    public String getClosingHour() {
        return this.closingHour;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "openingHour=" + openingHour +
                ", ClosingHour=" + closingHour +
                '}';
    }
}
