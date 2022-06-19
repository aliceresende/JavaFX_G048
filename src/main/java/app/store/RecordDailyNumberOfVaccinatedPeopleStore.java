 /** package app.store;

import app.domain.model.*;
import app.domain.shared.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static java.lang.System.getProperties;
public class RecordDailyNumberOfVaccinatedPeopleStore {
    private List<DailyReport> dailyReports;
    private ArrayList<DailyReport> knows = new ArrayList<>();

    private Date time1;
    private DailyReport dr;
    private static Company company;


    public RecordDailyNumberOfVaccinatedPeopleStore() throws ParseException {
        this.dailyReports = new ArrayList<DailyReport>();
        dailyReports.add(new DailyReport("14:41","Unilabs Aveiro","1242"));
        dailyReports.add(new DailyReport("12:51", "Centro de Vacinação de Coimbra", "412"));
        dailyReports.add(new DailyReport("12:12","Unilabs Lisboa","5153"));


    }
    public DailyReport createDailyReport(String time1,String vaccinationCenterName, String dailyNumberOfVaccinatedPeople) throws ParseException {
        return new DailyReport(time1,vaccinationCenterName,dailyNumberOfVaccinatedPeople);

    }
    public boolean validateDailyReport(DailyReport dailyReport) {
        if (dailyReport == null)
            return false;
        int i = 0;
        for (DailyReport dr : knows) {
            if (dailyReport.getVaccinationCenterName().equals(knows.get(i).getVaccinationCenterName())) {
                System.out.println("Daily " + dailyReport.getVaccinationCenterName() + " already exists");
                break;
            }
            i++;
        }
        return !this.knows.contains(dailyReport);
    }
    public void saveDailyReport(DailyReport dailyReport) {
        addDailyReport(dailyReport);
    }

    public boolean addDailyReport(DailyReport dailyReport) {
        int i = 0;
        boolean check = true;
        if (dailyReport != null) {
            for (DailyReport dr : knows) {
                if (knows.equals(dailyReport)) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                knows.add(dailyReport);
                return check;
            }
        }
        return false;
    }


    public static Date ReadDateFromConfigFile() throws ParseException {

        Properties props = getProperties();
        String dailyTimer = props.getProperty(Constants.PARAMS_DAILY_TIMER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        Date time1 = simpleDateFormat.parse(dailyTimer);

        return time1;
    }
    public static List  getDailyNumberOfVaccinatedPeople() {
        ArrayList<ArrivalOfSNSUser> vaccinatedPeople = company.getArrivalStore().getSize();
        List<String> vaccinatedPeopleList = null;
        for (ArrivalOfSNSUser v : vaccinatedPeople) {
            vaccinatedPeople.add();

        }return vaccinatedPeopleList;
    }


    public  static List<String> getVaccinationCenterName() {
        List<ComunityMassVaccinationCenter> massVaccinationCenter = company.getRegisterCenterStore().ArrayListGetter();
        List<String> vaccinationCenterName = null;
        for (ComunityMassVaccinationCenter m : massVaccinationCenter) {
            vaccinationCenterName.add(m.getName());

        }return vaccinationCenterName;
    }
}
*/