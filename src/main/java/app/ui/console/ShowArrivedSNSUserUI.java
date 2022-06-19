package app.ui.console;

import app.controller.SelectVaccinationCenterController;
import app.controller.ShowArrivedSNSUserController;
import app.mappers.dto.ArrivalOfSNSUserDTO;
import app.mappers.dto.VaccinationCenterDTO;

import java.util.ArrayList;

public class ShowArrivedSNSUserUI implements Runnable{

    private final ShowArrivedSNSUserController showArrivalController = new ShowArrivedSNSUserController();
    private final SelectVaccinationCenterController selectCenterController = new SelectVaccinationCenterController();

    /**
     * this method gets information from other classes sending it to other methods
     */

    @Override
    public void run(){
        ArrayList<ArrivalOfSNSUserDTO> arrivalList;
        VaccinationCenterDTO currentCenter = selectCenterController.getCurrentCenter();
        System.out.println("Waiting Room List:");
        arrivalList = showArrivalController.ToRegisterArraivalOfSNSUserMapper();
        ShowWaitingRoom(arrivalList,currentCenter);
    }

    /**
     * prints the waiting room
     * @param waitingRoom
     * @param currentCenter
     */

    public void ShowWaitingRoom(ArrayList<ArrivalOfSNSUserDTO> waitingRoom,VaccinationCenterDTO currentCenter){
        for (ArrivalOfSNSUserDTO waiting: waitingRoom){
            if (waiting.getvCenterDTO().equals(currentCenter.getName())){
                System.out.println(waiting);
            }
        }
    }

}
