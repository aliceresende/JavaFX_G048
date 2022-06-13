package app.mappers;


import app.domain.model.VaccineSchedule;
import app.mappers.dto.VaccineScheduleDTO;

public class VaccineScheduleMapper {
    public VaccineScheduleMapper() {
    }

    /**
     * This method converts the vaccine schedule to DTO
     * @param vS the vaccine schedule
     * @return the DTO of the vaccine schedule
     */
    public VaccineScheduleDTO toDTO(VaccineSchedule vS){
        return new VaccineScheduleDTO(vS.getVaccineName(),vS.getDateString(),vS.getHour(),vS.getVaccinationCenterName(),vS.getSNSUserNumber());
    }
}
