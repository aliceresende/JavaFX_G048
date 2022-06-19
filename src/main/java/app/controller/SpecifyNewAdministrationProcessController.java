/*package app.controller;
import app.domain.model.AdministrationProcess;
import app.domain.model.Company;
import app.domain.store.NewAdministrationProcessStore;

public class SpecifyNewAdministrationProcessController {

    private Company company;
    private AdministrationProcess ap;
    private String code;
    private String vaccine;
    private double ageGroup;
    private int dosesToBeAdministered;
    private double vaccineDosage;
    private String vaccineType;
    private NewAdministrationProcessStore store;

    public SpecifyNewAdministrationProcessController() { this(App.getInstance().getCompany());
    }

    public SpecifyNewAdministrationProcessController(Company company) {
        this.company = company;
        this.ap = null;
    }

    public void createAdministrationProcess(String code, String vaccine, int ageGroup,int dosesToBeAdministered, double vaccineDosage, String VaccineType ){
        store =company.getAdministrationProcess();
        store.createAdministrationProcess(code,vaccine,ageGroup,dosesToBeAdministered,vaccineDosage,VaccineType);
    }


    public AdministrationProcess getAp() {
        return store.getAp();
    }


    public boolean saveAdministrationProcess(){
        return saveAdministrationProcess();
    }

}*/

