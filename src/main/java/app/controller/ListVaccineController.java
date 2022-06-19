package app.controller;

import app.domain.model.Company;
import app.domain.model.Vaccine;
import app.store.NewVaccineStore;
import app.store.NewVaccineTypeStore;


public class ListVaccineController {
    private Company company;
    private Vaccine vt;
    private NewVaccineStore st;
    private NewVaccineTypeStore st_type;
    /**
     * Constructor of the class, gets an instance of the company class
     */
    public ListVaccineController(){this(App.getInstance().getCompany());}
    /**
     * Constructor of the class, receives an instance of the company class
     *
     * @param company instance of Company
     */

    public ListVaccineController(Company company) {
        st=company.getVaccineStore();
        st_type=company.getVaccineTypeList();
        this.vt=null;
    }

    /**invoques ListAll method from New Vaccine Store*/
    public void VaccineList(){
        st.ListAll(st_type);
    }

}
