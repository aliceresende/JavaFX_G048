package app.domain.store;

import app.domain.model.Administration;

import java.util.ArrayList;
import java.util.List;

public class AdministrationStore {

    private ArrayList<Administration> knows = new ArrayList<>();

    public ArrayList<Administration> getKnows() {return this.knows; }

    public AdministrationStore() {
        knows.add(new Administration("06/06/2020 8:40","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("06/06/2020 8:52","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("06/06/2020 9:00","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("06/06/2020 9:13","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("06/06/2020 9:20","1234567890","vaccine1","2","No side effects"));
        knows.add(new Administration("06/06/2020 9:34","1234567890","vaccine1","2","No side effects"));
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
