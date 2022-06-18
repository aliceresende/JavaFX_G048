package app.mappers;

import app.domain.model.PerformanceData;
import app.mappers.dto.PerformanceDataDTO;

import java.util.ArrayList;
import java.util.List;

public class PerformanceDataMapper {

    public PerformanceDataMapper() {
    }



    /**
     * This method converts the list of vaccination center to DTO
     *
     * @param perfData the community mass vaccination center list
     * @return List of VaccinationCenterDTO
     */
    public List<PerformanceDataDTO> multipleToDTO(List<PerformanceData> perfData){
        List<PerformanceDataDTO> listDTO = new ArrayList<>();
        for(PerformanceData pd: perfData){
            listDTO.add(toDTO(pd));
        }
        return listDTO;
    }

    /**
     * This method converts a vaccination center to DTO
     *
     * @param pd the community mass vaccination center
     * @return VaccinationCenterDTO vaccination center dto
     */
    public PerformanceDataDTO toDTO(PerformanceData pd){
        return new PerformanceDataDTO(pd.getSnsUserNumber(),"name",pd.getVaccineName(),"des",pd.getDose(),
                pd.getLotNumber(),pd.getSchedule(),pd.getArrival(),pd.getAdministration(),pd.getLeaving());
    }
}
