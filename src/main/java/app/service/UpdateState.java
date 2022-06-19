package app.service;

import app.controller.App;
import app.domain.States.VaccinationStates;
import app.domain.model.Company;
import app.domain.model.VaccinationProcess;
import app.store.VaccinationProcessStore;

public class UpdateState {
    // acrescentar service
    private VaccinationProcessStore store;
    private Company company;

    public UpdateState() {
        this.company = App.getInstance().getCompany();
        this.store = company.getVaccinationProcessStore();
    }

    public boolean arrives(String snsuserNumber){
        VaccinationProcess vp = store.getVaccProcessBySNSUserNumber(snsuserNumber);
        if(vp==null){
            return false;
        }
        vp.arrives();
        store.updateVaccProcess(vp);
        return true;
    }

    public boolean waiting(String snsuserNumber){
        VaccinationProcess vp = store.getVaccProcessBySNSUserNumber(snsuserNumber);
        if(vp==null){
            return false;
        }
        vp.waiting();
        store.updateVaccProcess(vp);
        return true;
    }

    public boolean receivesVaccine(String snsuserNumber){
        VaccinationProcess vp = store.getVaccProcessBySNSUserNumber(snsuserNumber);
        if(vp==null){
            return false;
        }
        vp.receivesVaccine();
        store.updateVaccProcess(vp);
        return true;
    }

    public boolean leaves (String snsuserNumber){
        VaccinationProcess vp = store.getVaccProcessBySNSUserNumber(snsuserNumber);
        if(vp==null){
            return false;
        }
        vp.receivesVaccine();
        store.updateVaccProcess(vp);
        return true;
    }

}
