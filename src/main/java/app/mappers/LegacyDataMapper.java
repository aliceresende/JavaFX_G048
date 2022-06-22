package app.mappers;

import app.mappers.dto.LegacyDataDTO;

import java.util.ArrayList;
import java.util.List;


public class LegacyDataMapper {

    public LegacyDataMapper() {
    }

    public List<LegacyDataDTO> multipletoDTO(List<List<String>> info){
        List<LegacyDataDTO> listDTO = new ArrayList<>();
        for(List<String> s: info){
            listDTO.add(toDTO(s));
        }
        return listDTO;
    }


    public LegacyDataDTO toDTO(List<String> u){
        return new LegacyDataDTO(u.get(0),u.get(1),u.get(2),u.get(3),u.get(4),u.get(5), u.get(6),u.get(7), u.get(8),u.get(9));
    }




}
