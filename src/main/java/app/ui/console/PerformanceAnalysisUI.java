package app.ui.console;

import app.controller.PerformanceAnalysisController;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PerformanceAnalysisUI implements Runnable {
    private final PerformanceAnalysisController controller = new PerformanceAnalysisController();
    @Override
    public void run() {
        try {

            System.out.println("************************");
            System.out.println("Performance of a Center");
            System.out.println("************************");
            String day = Utils.readLineFromConsole("Enter the day you wish to analyze (format: dd/mm/yyyy): ");
            System.out.println("Enter the time interval");
            int interval = Integer.parseInt(Utils.readLineFromConsole("Possible intervals (minutes: 1, 5, 10, 20, 30):"));
            boolean validInterval;
            do {
                if (interval != 1 && interval != 5 && interval != 10 && interval != 20 && interval != 30) {
                    validInterval = false;
                    System.out.println("Invalid interval");
                    interval = Integer.parseInt(Utils.readLineFromConsole("Enter a valid interval (minutes: 1, 5, 10, 20, 30):"));
                } else {
                    try {
                        validInterval = true;
                    } catch (Exception e) {
                        System.out.println("Invalid interval");
                        validInterval = false;
                        interval = Integer.parseInt(Utils.readLineFromConsole("Enter a valid interval (minutes: 1, 5, 10, 20, 30):"));
                    }
                }
            } while (!validInterval);

            int[] inputList = getInputList(interval, day);
            long startTime = System.currentTimeMillis();
            int[] subList = getMaxSublist(inputList);
            long endTime = System.currentTimeMillis();
            System.out.println("That took " + (endTime - startTime) + " milliseconds");
            List<Integer> inputArrList = Arrays.stream(inputList).boxed().toList();
            List<Integer> subArrList  = Arrays.stream(subList).boxed().toList();
            int indexStart = Collections.indexOfSubList(inputArrList, subArrList);
            int indexEnd = indexStart + (subList.length);
            int DateIMin = getMinute(Constants.OPEN_HOUR) + indexStart * interval;
            int DateEMin = getMinute(Constants.OPEN_HOUR) + indexEnd * interval;
            System.out.println("Input list:\n"+Arrays.toString(inputList));
            System.out.println("Contiguous sublist with maximum sum:\n"+Arrays.toString(subList));
            System.out.println("Sum: "+controller.sumSublist(subList));
            System.out.println("[" + day + " " + fromMinutesToHHmm(DateIMin) + ", " + day + " " + fromMinutesToHHmm(DateEMin) + "]");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    private int[] getInputList(int interval,String day){
       return controller.getInputList(interval,day);
    }
    private int[] getMaxSublist(int[] subsequence) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return controller.getMaxSublist(subsequence);
    }

    public String fromMinutesToHHmm(int minutes) {
        long hours = TimeUnit.MINUTES.toHours(Long.valueOf(minutes));
        long remainMinutes = minutes - TimeUnit.HOURS.toMinutes(hours);
        return  String.format("%02d:%02d", hours, remainMinutes);
    }
    public static int getMinute(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[HH][H]:mm");
        LocalTime time = LocalTime.parse(timeString, formatter);
        return time.getHour()*60 + time.getMinute();
    }
}
