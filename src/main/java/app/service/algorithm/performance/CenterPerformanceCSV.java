package app.service.algorithm.performance;

import app.controller.App;
import app.domain.model.ArrivalOfSNSUser;
import app.domain.model.Company;
import app.domain.model.PerformanceData;
import app.domain.model.VaccineAdministration;
import app.domain.shared.Constants;
import app.store.ArrivalOfSNSUserStore;
import app.store.PerformanceDataStore;
import app.store.VaccineAdministrationStore;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CenterPerformanceCSV implements ICenterPerformance{

    private final PerformanceDataStore storePerform;


    public CenterPerformanceCSV() {
        Company company = App.getInstance().getCompany();
        storePerform = company.getPerformanceDataStore();

    }


    @Override
    public int[] listOfInput(int interval, String day) {
        return inputtedList(interval, arrivalByDay(day),exitByDay(day));
    }
    public int sumSublist(int[] arr) {
        int sum = 0;

        for (int j : arr) sum += j;

        return sum;
    }
    private int[] inputtedList(int interval, List<String> listArrival, List<String> listLeaving) {
        int[] differenceForInterval = new int[Constants.TOTAL_MINUTES / interval];
        int[] arrivalForInterval = countArrivalsByInterval(interval, listArrival);
        int[] exitForInterval = countExitsByInterval(interval, listLeaving);
        for (int i = 0; i < arrivalForInterval.length; i++) {
            differenceForInterval[i] = arrivalForInterval[i] - exitForInterval[i];
        }
        return differenceForInterval;
    }

    private int[] countArrivalsByInterval(int interval, List<String> list) {
        int nOfArrivals, index = 0, position;
        int[] arrivals = new int[Constants.TOTAL_MINUTES / interval];
        for (int i = 0; i < arrivals.length; i++) {
            position = convertToMinutes(Constants.OPEN_HOUR) + (i + 1) * interval;
            nOfArrivals = 0;
            while (index < list.size() && convertToMinutes(splitDateFromTime(list.get(index))) < position) { //length -1
                nOfArrivals++;
                index++;
            }
            arrivals[i] = nOfArrivals;

        }
        return arrivals;
    }

    private int[] countExitsByInterval(int interval, List<String> list) {
        int nOfExits, index = 0, position;
        int[] exits = new int[Constants.TOTAL_MINUTES / interval];
        for (int i = 0; i < exits.length; i++) {
            position = convertToMinutes(Constants.OPEN_HOUR) + (i + 1) * interval;
            nOfExits = 0;
            while (index < list.size() && convertToMinutes(splitDateFromTime(list.get(index))) < position) { //length -1
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

    private List<String> arrivalByDay(String day) {
        List<String> performanceByDay = new ArrayList<>();
        ArrayList<PerformanceData> centerPerform = storePerform.getPerformanceDataList();
        for (PerformanceData byDayPerform : centerPerform) {
            if (byDayPerform.getArrival().contains(day)) {
                performanceByDay.add(byDayPerform.getArrival());
                Collections.sort(performanceByDay, new SortByDate());
            }
        }
        return performanceByDay;
    }
    static class SortByDate implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    private List<String> exitByDay(String day) {
        List<String> performanceByDay = new ArrayList<>();
        ArrayList<PerformanceData> centerPerform = storePerform.getPerformanceDataList();
        for (PerformanceData byDayPerform : centerPerform) {
            if (byDayPerform.getLeaving().contains(day)) {
                performanceByDay.add(byDayPerform.getLeaving());
                Collections.sort(performanceByDay, new SortByDate());
            }
        }
        return performanceByDay;
    }


    }
