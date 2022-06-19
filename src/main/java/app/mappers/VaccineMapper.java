package app.mappers;

import app.domain.model.Vaccine;
import app.mappers.dto.VaccineDTO;

public class VaccineMapper {

    public VaccineDTO toDTO(Vaccine vac){
        return new VaccineDTO(vac.getAdministration(),vac.get_disease(),vac.get_designation());
    }
}
