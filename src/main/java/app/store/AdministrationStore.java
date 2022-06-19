package app.store;

import app.domain.model.Administration;
import app.domain.model.ArrivalOfSNSUser;
import app.domain.model.VaccineType;
import app.ui.Persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdministrationStore {

    private ArrayList<Administration> knows = new ArrayList<>();

    public ArrayList<Administration> getKnows() {return this.knows; }

    public AdministrationStore() {

        knows.add(new Administration("14/06/2022 8:40","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("14/06/2022 8:52","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("14/06/2022 9:00","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("14/06/2022 9:13","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("14/06/2022 9:20","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("14/06/2022 9:34","1234567890","vaccine1","2","No side effects"));
        Collections.sort(knows, new SortByDate());
    }

    public void saveAdministration(Administration administration) {
        //new Administration();
    }

    static class SortByDate implements Comparator<Administration> {
        @Override
        public int compare(Administration o1, Administration o2) {
            return o1.getExitTime().compareTo(o2.getExitTime());
        }
    }
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
