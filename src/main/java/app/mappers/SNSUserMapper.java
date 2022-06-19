package app.mappers;

import app.domain.model.SNSUser;
import app.mappers.dto.SNSUserDTO;

import java.util.ArrayList;
import java.util.List;

public class SNSUserMapper {

    public SNSUserMapper() {
    }

    public List<SNSUserDTO> toDTO(List<SNSUser> user){
        List<SNSUserDTO> listDTO = new ArrayList<>();
        for(SNSUser u: user){
            listDTO.add(toDTO(u));
        }
        return listDTO;
    }

    /**
     * Receive a SNS User and make it a dto.
     *
     * @param u
     * @return
     */
    public SNSUserDTO toDTO(SNSUser u){
        return new SNSUserDTO(u.getName(), u.getSex(), u.getDate(),u.getAddress(), u.getPhoneNumber(), u.getEmail(),u.getSnsUserNumber(),u.getCitizenCardNumber());
    }


    /**
     * Receive a SNSN User list and make it a dto.
     *
     * @param allUsersInfo
     * @return
    */

    public List<SNSUserDTO> toDTO(ArrayList<ArrayList<String>> allUsersInfo) {
        List<SNSUserDTO> listDTO = new ArrayList<>();
        for(ArrayList<String> u: allUsersInfo){

            //listDTO.add(this.toDTO(u));
        }
        return listDTO;
    }


    //------------------------------------------


}
