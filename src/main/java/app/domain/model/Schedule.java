package app.domain.model;

public class Schedule {
    private String openingHour;
    private String closingHour;

    public Schedule(String openingHour, String closingHour) {
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }
    public Schedule(Schedule otherSchedule){
        openingHour = otherSchedule.openingHour;
        closingHour = otherSchedule.closingHour;
    }

    public String getOpeningHour() {
        return this.openingHour;
    }

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
