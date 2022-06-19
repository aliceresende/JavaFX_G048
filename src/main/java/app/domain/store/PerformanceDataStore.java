package app.domain.store;

import app.domain.model.PerformanceData;

import java.util.ArrayList;

public class PerformanceDataStore {

    public PerformanceDataStore() {
        this.knows = knows;
    }

    private ArrayList <PerformanceData> knows = new ArrayList<>();

    public PerformanceData createPerformanceData(String snsusernumber, String vaccineName, String dose, String lotNumber, String scheduletime,String arrivaltime, String vaccAdmintime,String leavingTime ){
       return new PerformanceData(snsusernumber,vaccineName,dose,lotNumber,scheduletime,arrivaltime,vaccAdmintime,leavingTime);
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
        knows.add(createPerformanceData(pd.getSnsUserNumber(),pd.getVaccineName(),pd.getDose(),pd.getLotNumber(),pd.getSchedule(),pd.getArrival(),pd.getAdministration(),pd.getLeaving()));
    }



    public ArrayList<PerformanceData> getPerformanceDataList() {
        return knows;
    }

}
