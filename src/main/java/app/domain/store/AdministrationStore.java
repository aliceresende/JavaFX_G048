package app.domain.store;

import app.domain.model.Administration;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Administration store.
 */
public class AdministrationStore {

    private ArrayList<Administration> knows = new ArrayList<>();

    /**
     * Gets knows.
     *
     * @return the knows
     */
    public ArrayList<Administration> getKnows() {return this.knows; }

    /**
     * Instantiates a new Administration store.
     */
    public AdministrationStore() {
        knows.add(new Administration("14/06/2022 8:40","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("14/06/2022 8:52","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("14/06/2022 9:00","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("14/06/2022 9:13","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("14/06/2022 9:20","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("14/06/2022 9:34","1234567890","vaccine1","2","No side effects"));
    }

    /**
     * Exit by day list.
     *
     * @param day the day
     * @return the list
     */
    public List<Administration> ExitByDay(String day){
        List<Administration> exitDay=new ArrayList<>();
        for(int i=0;i<knows.size();i++) {
            if(knows.get(i).getExitTime().contains(day)) {
                exitDay.add(knows.get(i));
            }
        }
        return exitDay;
    }
}
