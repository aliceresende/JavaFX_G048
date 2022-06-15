package app.mappers;

import app.domain.model.SNSUser;
import app.mappers.dto.SNSUserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Sns user mapper.
 */
public class SNSUserMapper {

    /**
     * Instantiates a new Sns user mapper.
     */
    public SNSUserMapper() {
    }

    /**
     * To dto list.
     *
     * @param user the user
     * @return the list
     */
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
     * @param u the u
     * @return sns user dto
     */
    public SNSUserDTO toDTO(SNSUser u){
        return new SNSUserDTO(u.getName(), u.getSex(), u.getBirthDate(),u.getAddress(), u.getPhoneNumber(), u.getEmail(),u.getSnsUserNumber(),u.getCitizenCardNumber());
    }


    /**
     * Receive a SNSN User list and make it a dto.
     *
     * @param allUsersInfo the all users info
     * @return list
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
