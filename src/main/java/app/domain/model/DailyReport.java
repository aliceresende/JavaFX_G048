package app.domain.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyReport {
    private Date time1;
    private String vaccinationCenterName;
    private int dailyNumberOfVaccinatedPeople;
    private String formattedTime;
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH/mm");

    public DailyReport(String time1, String vaccinationCenterName, String dailyNumberOfVaccinatedPeople) throws ParseException {
        this.formattedTime = timeFormat.format(time1);
        this.vaccinationCenterName = vaccinationCenterName;
        this.dailyNumberOfVaccinatedPeople = Integer.parseInt(dailyNumberOfVaccinatedPeople);
    }

    public Date getTime1() {
        return time1;
    }

    public String getVaccinationCenterName() {
        return vaccinationCenterName;
    }

    public int getDailyNumberOfVaccinatedPeople() {
        return dailyNumberOfVaccinatedPeople;
    }

    @Override
    public String toString() {
        return "DailyReport{" +
                "time1=" + time1 + ", vaccinationCenterName='" + vaccinationCenterName + '\'' + ", dailyNumberOfVaccinatedPeople=" + dailyNumberOfVaccinatedPeople + '}';
    }
}





