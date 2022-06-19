package app.service.sortingTreatment;

import app.domain.model.PerformanceData;
import app.domain.shared.Constants;
import app.service.algorithms.sorting.SortAlgorithm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SortingArrivalLeavingTime implements SortingTreatment {

    private final String arrival = "Arrival Time";
    private final String leaving = "Leaving Time";

    private final String ascendent = "Ascendent" ;

    private final String descendant = "Descendent";


    public List<PerformanceData> sortPerfData (List<PerformanceData> toSort, String time, String ordering) throws IOException, ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        return sortList(toSort,time,ordering);
    }

    /*public void sortingCriteria (String time, String ordering) {
        try {
            switch (time) {
                case arrival:
                    if (ordering.equals(ascendent)) {

                    } else if (ordering.equals(descendant)) {
                        sortingCriteria("5", "descendent");
                    }
                    break;
                case leaving:
                    if (ordering.equals(ascendent)) {
                        sortingCriteria("7", "ascendent");
                    } else if (ordering.equals(descendant)) {
                        sortingCriteria("7", "descendent");
                    }
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

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
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        in.close();

        List<PerformanceData> infoOrdered = new ArrayList<>();
        String[] sorted = sortDateTime(info,time,sortAlgorithm);
        infoOrdered = sortAllData(sorted,info,time,order);
        return infoOrdered;
    }

    /**
     * method to sortdatetime
     * @param info
     * @param time
     * @param sortAlgorithm
     * @return
     * @throws ParseException
     */
    public String[] sortDateTime(List<PerformanceData> info,String time, SortAlgorithm sortAlgorithm) throws ParseException {

        int i =0;
        String[] timeToSort = new String[info.size()];
        String[] sorted ;

        if(time.equals(arrival)){
            for(PerformanceData line : info){
                timeToSort[i] = line.getArrival();
                i++;
            }
        }else if(time.equals(leaving)){
            for(PerformanceData line : info){
                timeToSort[i] = line.getLeaving();
                i++;
            }
        }

        timeToSort = datesFormattedToSort(timeToSort);

        sorted = sortAlgorithm.sort(timeToSort);

        sorted = datesFormattedToPrint(sorted);

        return sorted;

    }
    //--------------------------------------------sorting all dates---------------------------------------------------------------

    /**
     * this method sorts the list of list, according to the dates and times already sorted
     *
     * @param timeSorted - sortDateTime
     * @param info       - csv info
     * @return list
     */
    public List<PerformanceData> sortAllData(String[] timeSorted, List<PerformanceData> info, String time,String order){

        List<PerformanceData> infoToOrder = info;
        int i = 0;

        if(time.equals(arrival)) {
            for (PerformanceData pd : infoToOrder) {
                if (pd.getArrival().equals(timeSorted[i])) {
                    infoToOrder.set(i,pd);
                    i++;
                }
            }
        } else if(time.equals(leaving)){
            for (PerformanceData pd : infoToOrder) {
                if (pd.getLeaving().equals(timeSorted[i])) {
                    infoToOrder.set(i,pd);
                    i++;
                }
            }
        }


        if(order.equals(descendant)){
            Collections.reverse(infoToOrder);
        }

        return infoToOrder;

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

    public String[] datesFormattedToSort(String[] datesInput) throws ParseException {
        String[] formattedDateTime = new String[datesInput.length];

        for (int i = 0; i < datesInput.length; i++) {
            Date d = printingFormat.parse(datesInput[i]);
            String s = sortingFormat.format(d);
            formattedDateTime[i] = s ;
        }

        return formattedDateTime;
    }

    /**
     * this method makes the dates return to their original format
     *
     * @param datesOutput the dates in string
     * @return formattedDateTime - array with the dates formatted
     * @throws ParseException the parse exception
     */

    public String[] datesFormattedToPrint(String[] datesOutput) throws ParseException {
        String[] formattedDateTime = new String[datesOutput.length];

        for (int i = 0; i < datesOutput.length; i++) {
            Date d = sortingFormat.parse(datesOutput[i]);
            String s = printingFormat.format(d);
            formattedDateTime[i] = s ;
        }

        return formattedDateTime;
    }

}
