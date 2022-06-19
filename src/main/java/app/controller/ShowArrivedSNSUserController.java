package app.controller;

import app.domain.model.ArrivalOfSNSUser;

import app.store.ArrivalOfSNSUserStore;
import app.domain.model.Company;

import app.mappers.ArrivalOfSNSUserMapper;
import app.mappers.dto.ArrivalOfSNSUserDTO;

import java.util.ArrayList;


public class ShowArrivedSNSUserController {
    private Company company = App.getInstance().getCompany();
    private ArrivalOfSNSUserStore aStore = company.getArrivalStore();
    private ArrivalOfSNSUserMapper aMapper = new ArrivalOfSNSUserMapper();
    private ArrayList<ArrivalOfSNSUser> listOfWaitingRoomFromStore = new ArrayList<ArrivalOfSNSUser>();


    /**
     * Sends the list of the waiting room to the mapper
     * @return the DTO list of people waiting in the waiting room
     */

    public ArrayList<ArrivalOfSNSUserDTO> ToRegisterArraivalOfSNSUserMapper(){
        ArrayList<ArrivalOfSNSUserDTO> listOfWaitingRoomDTO = new ArrayList<ArrivalOfSNSUserDTO>();
        ArrayList<ArrivalOfSNSUser> waitingRoomList = GetWaitingList();
        for (ArrivalOfSNSUser waitingUser:waitingRoomList){
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
