package app.controller;


import app.domain.model.ArrivalOfSNSUser;
import app.domain.model.SNSUser;
import app.domain.model.VaccineSchedule;
import app.store.*;
import app.domain.model.*;

import app.mappers.ArrivalOfSNSUserMapper;
import app.mappers.SNSUserMapper;
import app.mappers.VaccineMapper;
import app.mappers.VaccineScheduleMapper;
import app.mappers.dto.ArrivalOfSNSUserDTO;
import app.mappers.dto.SNSUserDTO;
import app.mappers.dto.VaccineDTO;
import app.mappers.dto.VaccineScheduleDTO;

import java.util.ArrayList;
import java.util.List;

public class VaccineAdministrationController {

    private ArrivalOfSNSUserStore aStore;

    private ArrivalOfSNSUserMapper aMapper;

    private SNSUserStore uStore;

    private VaccineScheduleMapper vMapper;

    private ArrayList<ArrivalOfSNSUser> listOfWaitingRoomFromStore;

    private ArrayList<SNSUser> listOfSNSUsersFromStore;

    private ArrayList<VaccineSchedule> listOfVaccineSchedulesFromStore;

    private List<Vaccine> listOfVaccinesFromStore;

    private VaccineScheduleStore vSStore;

    private SNSUserMapper uMapper;

    private NewVaccineStore vaxStore;

    private VaccineMapper vaxMapper;

    private VaccineAdministrationStore adminStore;


    public VaccineAdministrationController() {
        Company company = App.getInstance().getCompany();
        aStore = company.getArrivalStore();
        uStore = company.getSNSUserStore();
        vSStore = company.getVaccineScheduleStore();
        vaxStore = company.getVaccineStore();
        aMapper = new ArrivalOfSNSUserMapper();
        vMapper = new VaccineScheduleMapper();
        uMapper = new SNSUserMapper();
        vaxMapper = new VaccineMapper();
        adminStore = new VaccineAdministrationStore();
    }

    /**
     * Sends the list of the waiting room to the mapper
     * @return the DTO list of people waiting in the waiting room
     */

    public ArrayList<ArrivalOfSNSUserDTO> ToRegisterArraivalOfSNSUserMapper(){
        ArrayList<ArrivalOfSNSUserDTO> listOfWaitingRoomDTO = new ArrayList<>();
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

    public ArrayList<SNSUser> GetSNSUserList(){
        listOfSNSUsersFromStore = uStore.getSnsUserList();
        return listOfSNSUsersFromStore;
    }

    public ArrayList<SNSUserDTO> ToSNSUserMapper(){
        ArrayList<SNSUserDTO> SNSUserListDTO = new ArrayList<>();
        ArrayList<SNSUser> SNSUserList = GetSNSUserList();
        for (SNSUser SNSUser:SNSUserList){
            SNSUserListDTO.add(uMapper.toDTO(SNSUser));
        }
        return SNSUserListDTO;
    }

    public ArrayList<VaccineSchedule> GetVaccineSchedule(){
        listOfVaccineSchedulesFromStore = vSStore.getKnows();
        return listOfVaccineSchedulesFromStore;
    }

    public ArrayList<VaccineScheduleDTO> ToVaccineScheduleDTO(){
        ArrayList<VaccineScheduleDTO> VaccineScheduleDTO = new ArrayList<>();
        ArrayList<VaccineSchedule> VaccineSchedules = GetVaccineSchedule();
        for (VaccineSchedule vaccineSchedule:VaccineSchedules){
            VaccineScheduleDTO.add(vMapper.toDTO(vaccineSchedule));
        }
        return VaccineScheduleDTO;
    }

    public List<Vaccine> getVaccine(){
        return vaxStore.getArray1();
    }

    public ArrayList<VaccineDTO> ToVaccineDTO(){
        ArrayList<VaccineDTO> VaccinesDTO = new ArrayList<VaccineDTO>();
        List<Vaccine> Vaccines = getVaccine();
        for (Vaccine vaccine:Vaccines){
            VaccinesDTO.add(vaxMapper.toDTO(vaccine));
        }
        return VaccinesDTO;
    }

    public void removeScheduleAfterVaccine(String snsUserNumber){
        vSStore.removeVaccineScheduleAfterVaccine(snsUserNumber);
    }

    public void removeUserFromWaitingRoom(String snsUserNumber){
        aStore.removeUserFromWaitingRoom(snsUserNumber);
    }

    public void saveAdministration(String exitTime,String snsUserNumber,VaccineDTO vaccine,int dose,String notes, String administrationTime, String lotNumber){
        adminStore.addAdministration(exitTime,snsUserNumber,vaccine,dose,notes,administrationTime,lotNumber);
    }

}
