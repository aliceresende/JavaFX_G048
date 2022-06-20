package app.store;

import app.domain.model.PerformanceData;
import app.ui.Persistence;

import java.util.ArrayList;

public class PerformanceDataStore {

    private ArrayList <PerformanceData> knows = new ArrayList<>();

    public PerformanceDataStore(ArrayList<PerformanceData> knows) {
        try{
            knows = (ArrayList<PerformanceData>) Persistence.readObjectFromFile("PerformanceData.bin");
        }catch (Exception e){
            //System.out.println("The clientStore was not loaded :)");
        }
        this.knows = knows;
    }

    public PerformanceData createPerformanceData(String snsusernumber, String vaccineName, String dose, String lotNumber, String scheduletime, String arrivaltime, String vaccAdmintime, String leavingTime ){
        return new PerformanceData(snsusernumber,vaccineName,dose,lotNumber,scheduletime,arrivaltime,vaccAdmintime,leavingTime);
    }

    public PerformanceDataStore() {

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
        knows.add(pd);
    }



    public ArrayList<PerformanceData> getPerformanceDataList() {
        return knows;
    }
}
