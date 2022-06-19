package app.controller;

import app.domain.model.Company;
import app.domain.model.ComunityMassVaccinationCenter;
import app.store.VaccinationCenterStore;
import app.mappers.VaccinationCenterMapper;
import app.mappers.dto.VaccinationCenterDTO;

import java.util.List;

public class SelectVaccinationCenterController {
    private Company company;
    private ComunityMassVaccinationCenter vCenter;
    private VaccinationCenterMapper vCenterMapper = new VaccinationCenterMapper();
    private VaccinationCenterStore store;

    public Company getCompany() {
        return this.company;
    }

    /**
     * Constructor
     */
    public SelectVaccinationCenterController() { this(App.getInstance().getCompany());}

    /**
     * Constructor
     * @param company
     */
    public SelectVaccinationCenterController(Company company) {
        this.company = company;
        this.vCenterMapper = new VaccinationCenterMapper();
        store = company.getRegisterCenterStore();

    }

    /**
     * Gets the list of vaccination centers
     * @return list of vaccination centers
     */
    public List<VaccinationCenterDTO> getVaccinationCenter() {
        VaccinationCenterStore centerStore = company.getRegisterCenterStore();;
        return vCenterMapper.toDTO(centerStore.ArrayListGetter());
    }

    /**
     * Modified the current vaccination center
     * @param vCenterDTO
     */
    public void currentCenter(VaccinationCenterDTO vCenterDTO) {
        store.setCurrentCenter(vCenterMapper.toCenter(vCenterDTO));
    }

    /**
     * Gets the information from the store of the current vaccination center
     * @return the information of the current vaccination center
     */
    public VaccinationCenterDTO getCurrentCenter(){ return vCenterMapper.toDTO(store.getCurrentCenter());}
}
