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
        knows.add(new PerformanceData("123456789","121211","primeira","2","30/05/2022 8:00","30/05/2022 8:10","30/05/2022 8:40","30/05/2022 8:40"));
        knows.add(new PerformanceData("123456789","121211","primeira","2","30/05/2022 8:00","30/05/2022 8:30","30/05/2022 9:00","30/05/2022 9:00"));
        knows.add(new PerformanceData("123456789","121211","primeira","2","30/05/2022 8:00","30/05/2022 8:20","30/05/2022 8:50","30/05/2022 8:50"));
        knows.add(new PerformanceData("123456789","121211","primeira","2","30/05/2022 8:00","30/05/2022 8:35","30/05/2022 8:49","30/05/2022 8:49"));
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
