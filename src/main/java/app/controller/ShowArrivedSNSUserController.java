package app.controller;

import app.domain.model.ArrivalOfSNSUser;
import app.domain.store.ArrivalOfSNSUserStore;
import app.mappers.ArrivalOfSNSUserMapper;
import app.mappers.dto.ArrivalOfSNSUserDTO;

import java.util.ArrayList;


public class ShowArrivedSNSUserController {
    private ArrivalOfSNSUserStore aStore = new ArrivalOfSNSUserStore();
    private ArrivalOfSNSUserMapper aMapper = new ArrivalOfSNSUserMapper();
    private ArrayList<ArrivalOfSNSUserDTO> listOfWaitingRoomDTO = new ArrayList<ArrivalOfSNSUserDTO>();
    private ArrayList<ArrivalOfSNSUser> listOfWaitingRoomFromStore = new ArrayList<ArrivalOfSNSUser>();


    /**
     * Sends the list of the waiting room to the mapper
     * @return the DTO list of people waiting in the waiting room
     */

    public ArrayList<ArrivalOfSNSUserDTO> ToRegisterArraivalOfSNSUserMapper(){
        ArrayList<ArrivalOfSNSUser> listOfWaitingRoom = GetWaitingList();
        for (ArrivalOfSNSUser waitingUser:listOfWaitingRoom){
            listOfWaitingRoomDTO.add(aMapper.toDTO(waitingUser));
        }
        return listOfWaitingRoomDTO;
    }

    /**
     * Gets the list of the waiting room
     * @return list of waitingRoom
     */

    public ArrayList<ArrivalOfSNSUser> GetWaitingList(){
        listOfWaitingRoomFromStore = aStore.GetArrivalOfSNSUsers();
        return listOfWaitingRoomFromStore;
    }

}
