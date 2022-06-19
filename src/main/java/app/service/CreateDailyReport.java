package app.service;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CreateDailyReport {
    Date time1 ;// RecordDailyNumberOfVaccinatedPeopleStore.ReadDateFromConfigFile();
    List<String> vaccinationCenterName ;//RecordDailyNumberOfVaccinatedPeopleStore.getVaccinationCenterName();

    int dailyNumberOfVaccinatedPeople;


    Timer timer = new Timer();
    TimerTask createFileTask = new TimerTask() {
        public void run() {
            long period = 1;
            period /= (24 * 60 * 60 * 1000);
            timer.schedule(createFileTask, time1, period);
            createCsvFile(time1,vaccinationCenterName,dailyNumberOfVaccinatedPeople);

        }
        public void createCsvFile( Date time1, List<String> vaccinationCenterName,int dailyNumberOfVaccinatedPeople){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Date").append(",").append("Vaccination Center Name").append(",").append("Number of vaccinated people").append("\n");
            for (int i = 0; i < vaccinationCenterName.size(); i++) {
                stringBuilder.append(time1).append(",").append(vaccinationCenterName).append(",").append(dailyNumberOfVaccinatedPeople);
            }
            try (FileWriter writer = new FileWriter("src/TestingCSVfiles")) {
                writer.write(stringBuilder.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("CVS file created......");
        }
    };

    public CreateDailyReport() throws ParseException {
    }
}


