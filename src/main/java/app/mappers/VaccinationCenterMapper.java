package app.mappers;

import app.domain.model.ComunityMassVaccinationCenter;
import app.mappers.dto.VaccinationCenterDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccination center mapper.
 */
public class VaccinationCenterMapper {

    /**
     * Instantiates a new Vaccination center mapper.
     */
    public VaccinationCenterMapper() {
    }

    /**
     * This method converts the list of vaccination center to DTO
     *
     * @param VC the community mass vaccination center list
     * @return List of VaccinationCenterDTO
     */
    public List<VaccinationCenterDTO> toDTO(List<ComunityMassVaccinationCenter> VC){
      List<VaccinationCenterDTO> listDTO = new ArrayList<>();
      for(ComunityMassVaccinationCenter vc: VC){
          listDTO.add(toDTO(vc));
      }
      return listDTO;
    }

    /**
     * This method converts a vaccination center to DTO
     *
     * @param vC the community mass vaccination center
     * @return VaccinationCenterDTO vaccination center dto
     */
    public VaccinationCenterDTO toDTO(ComunityMassVaccinationCenter vC){
    return new VaccinationCenterDTO(vC.getId(), vC.getName(), vC.getAddress(), vC.getPhoneNumber(), vC.getEmail(), vC.getFaxNumber(), vC.getWebsiteAddress(), vC.getCenterSchedule(), vC.getSlotDuration(), vC.getMaxNumVaxPerSlot());
    }

    /**
     * This method converts a VaccinationCenterDTO to ComunityMassVaccinationCenter
     *
     * @param vC the vaccination center DTO
     * @return ComunityMassVaccinationCenter comunity mass vaccination center
     */
    public ComunityMassVaccinationCenter toCenter(VaccinationCenterDTO vC){
        return new ComunityMassVaccinationCenter(vC.getId(), vC.getName(), vC.getAddress(), vC.getPhoneNumber(), vC.getEmail(), vC.getFaxNumber(), vC.getWebsiteAddress(), vC.getCenterSchedule(), vC.getSlotDuration(), vC.getMaxNumVaxPerSlot());

    }
}

