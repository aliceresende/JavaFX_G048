package app.service.algorithm.sorting;

import app.domain.model.PerformanceData;
import app.domain.shared.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SortingTimeService {

    private final String arrival = "Arrival Time";
    private final String leaving = "Leaving Time";

    private final String ascendent = "Ascendent" ;
    private final String descendant = "Descendent";

    private String index;


    public List<PerformanceData> sortPerfData (List<PerformanceData> toSort, String time, String ordering) throws IOException, ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        this.index = time;
        List<PerformanceData> pd = new ArrayList<>();
        pd = sortList(toSort,time,ordering);
        return pd;
    }


    /**
     * Sort list list.
     *
     * @param info  the info
     * @return the list
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws InstantiationException the instantiation exception
     * @throws IllegalAccessException the illegal access exception
     * @throws ParseException         the parse exception
     */
    public List<PerformanceData> sortList (List<PerformanceData> info, String time, String order) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
        Properties properties = new Properties();
        InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
        properties.load(in);
        Class<?> sortClass = Class.forName(properties.getProperty("Company.Algorithms.sorting"));
        SortAlgorithm sortAlgorithm;
        try {
            sortAlgorithm = (SortAlgorithm)  sortClass.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        in.close();
        //-------------------------------------------------------------

        List<PerformanceData> infoOrdered = info;

        datesFormattedToSort(infoOrdered);

        long startTime = System.nanoTime();
        sortAlgorithm.sort(infoOrdered,index);
        long endTime = System.nanoTime();

        System.out.println("Time:" + (endTime-startTime));

        if(order == descendant){
            Collections.reverse(infoOrdered);
        }


        datesFormattedToPrint(infoOrdered);
        return infoOrdered;
    }

    //----------------------------------------Dates transformation--------------------------------------


    private final SimpleDateFormat printingFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private final SimpleDateFormat sortingFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");


    /**
     * this method format the dates to sort (more significant to least)
     *
     * @param datesInput the dates in string
     * @return formattedDateTime - array with the dates formatted
     * @throws ParseException the parse exception
     */

    public List<PerformanceData> datesFormattedToSort(List<PerformanceData> datesInput) throws ParseException {

        if(index == arrival) {
            for (PerformanceData p : datesInput) {
                Date d = printingFormat.parse(p.getArrival());
                String s2 = sortingFormat.format(d);
                p.setArrival(s2);
            }
        }else if(index == leaving){
            for (PerformanceData p : datesInput) {
                Date d = printingFormat.parse(p.getLeaving());
                String s2 = sortingFormat.format(d);
                p.setLeaving(s2);
            }
        }

        return datesInput;
    }

    /**
     * this method makes the dates return to their original format
     *
     * @param datesOutput the dates in string
     * @return formattedDateTime - array with the dates formatted
     * @throws ParseException the parse exception
     */

    public List<PerformanceData> datesFormattedToPrint(List<PerformanceData> datesOutput) throws ParseException {
        if(index == arrival) {
            for (PerformanceData p : datesOutput) {
                Date d = sortingFormat.parse(p.getArrival());
                String s2 = printingFormat.format(d);
                p.setArrival(s2);
            }
        }else if(index == leaving){
            for (PerformanceData p : datesOutput) {
                Date d = sortingFormat.parse(p.getLeaving());
                String s2 = printingFormat.format(d);
                p.setLeaving(s2);
            }
        }

        return datesOutput;
    }


}
