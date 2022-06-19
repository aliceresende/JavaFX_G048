package app.store;

import app.domain.model.VaccinationProcess;

import java.util.List;

public class VaccinationProcessStore {

    private VaccinationProcess vp;
    private List<VaccinationProcess> knows;

    public VaccinationProcess getVaccProcessBySNSUserNumber (String snsusernumber){
        for(VaccinationProcess vp: knows){
            if(vp.getSnsuser().equals(snsusernumber)){
                return vp;
            }
        }
        return null;
    }

    public VaccinationProcess createVaccProcessBySNSUserNumber (String snsusernumber){
        return new VaccinationProcess(snsusernumber);
    }


    public void addVaccProcess(String snsuserNumber){
        knows.add(createVaccProcessBySNSUserNumber(snsuserNumber));
    }


    public boolean updateVaccProcess(VaccinationProcess vp) {
        for(VaccinationProcess v: knows){
            if(v.getSnsuser().equals(vp.getSnsuser())){
                knows.set(knows.indexOf(v),vp);
                return true;
            }
        }
        return false;
    }
}
