package app.service;

import app.controller.App;
import app.domain.model.ArrivalOfSNSUser;
import app.domain.model.Company;
import app.domain.model.PerformanceData;
import app.domain.model.VaccineAdministration;
import app.domain.shared.Constants;
import app.domain.store.ArrivalOfSNSUserStore;
import app.domain.store.PerformanceDataStore;
import app.domain.store.VaccineAdministrationStore;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CenterPerformanceCSV implements ICenterPerformance{
    private final ArrivalOfSNSUserStore storeArrival;
    private final VaccineAdministrationStore storeAdmin;

    private final PerformanceDataStore storePerform;


    public CenterPerformanceCSV() {
        Company company = App.getInstance().getCompany();
        storeArrival = company.getArrivalStore();
        storeAdmin = company.getAdministrationStore();
        storePerform = company.getPerformanceDataStore();
    }


    @Override
    public int[] listOfInput(int interval, String day) {
        return inputtedList(interval, centerPerformanceByDay(day));
    }
    public int sumSublist(int[] arr) {
        int sum = 0;

        for (int j : arr) sum += j;

        return sum;
    }
    private int[] inputtedList(int interval, List<PerformanceData> list) {
        int[] differenceForInterval = new int[Constants.TOTAL_MINUTES / interval];
        int[] arrivalForInterval = countArrivalsByInterval(interval, list);
        int[] exitForInterval = countExitsByInterval(interval, list);
        for (int i = 0; i < arrivalForInterval.length; i++) {
            differenceForInterval[i] = arrivalForInterval[i] - exitForInterval[i];
        }
        return differenceForInterval;
    }

    private int[] countArrivalsByInterval(int interval, List<PerformanceData> list) {
        int nOfArrivals, index = 0, position;
        int[] arrivals = new int[Constants.TOTAL_MINUTES / interval];
        for (int i = 0; i < arrivals.length; i++) {
            position = convertToMinutes(Constants.OPEN_HOUR) + (i + 1) * interval;
            nOfArrivals = 0;
            while (index < list.size() && convertToMinutes(splitDateFromTime(list.get(index).getArrival())) < position) { //length -1
                nOfArrivals++;
                index++;
            }
            arrivals[i] = nOfArrivals;

        }
        return arrivals;
    }

    private int[] countExitsByInterval(int interval, List<PerformanceData> list) {
        int nOfExits, index = 0, position;
        int[] exits = new int[Constants.TOTAL_MINUTES / interval];
        for (int i = 0; i < exits.length; i++) {
            position = convertToMinutes(Constants.OPEN_HOUR) + (i + 1) * interval;
            nOfExits = 0;
            while (index < list.size() && convertToMinutes(splitDateFromTime(list.get(index).getAdministration())) < position) { //length -1
                nOfExits++;
                index++;
            }
            exits[i] = nOfExits;

        }
        return exits;
    }

    private int convertToMinutes(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[HH][H]:mm");
        LocalTime time = LocalTime.parse(timeString, formatter);
        return time.getHour() * 60 + time.getMinute();
    }

    private String splitDateFromTime(String str) {
        String time = str.split("\\s")[1];
        return time;
    }

    private List<PerformanceData> centerPerformanceByDay(String day) {
        List<PerformanceData> performanceByDay = new ArrayList<>();
        ArrayList<PerformanceData> centerPerform = storePerform.getPerformanceDataList();
        for (PerformanceData byDayPerform : centerPerform) {
            if (byDayPerform.getSchedule().contains(day)) {
                performanceByDay.add(byDayPerform);
            }
        }
        return performanceByDay;
    }

    private List<VaccineAdministration> exitByDay(String day) {
        List<VaccineAdministration> exitDay = new ArrayList<>();
        ArrayList<VaccineAdministration> exitOfSNSUsers = storeAdmin.getKnows();
        for (VaccineAdministration know : exitOfSNSUsers) {
            if (know.getExitTime().contains(day)) {
                exitDay.add(know);
            }
        }
        return exitDay;
    }
}
