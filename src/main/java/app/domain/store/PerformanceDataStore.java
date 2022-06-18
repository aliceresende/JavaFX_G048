package app.domain.store;

import app.domain.model.Employee;
import app.domain.model.PerformanceData;

import java.util.ArrayList;
import java.util.List;

public class PerformanceDataStore {

    private ArrayList <PerformanceData> knows = new ArrayList<>();

    public PerformanceData createPerformanceData(String snsusernumber, String vaccineName, String dose, String lotNumber, String scheduletime,String arrivaltime, String vaccAdmintime,String leavingTime ){
        PerformanceData pd = new PerformanceData(snsusernumber,vaccineName,dose,lotNumber,scheduletime,arrivaltime,vaccAdmintime,leavingTime);

    }

    public boolean addPerfData(PerformanceData perfdata){
        int cont = 0;
        boolean check = true;
        if (perfdata != null) {
            for (PerformanceData pd : knows) {
                if (knows.equals(pd)) {
                    check = false;
                    break;
                }
                cont++;
            }
            if (check) {
                knows.add(perfdata);
                return true;
            }
        }
        return false;
    }

    public void savePerformanceData(PerformanceData pd){
        knows.add(createPerformanceData());
    }



    public ArrayList<PerformanceData> getPerformanceDataList() {
        return knows;
    }

}
