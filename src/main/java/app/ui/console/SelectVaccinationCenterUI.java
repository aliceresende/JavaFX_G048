package app.ui.console;

import app.controller.SelectVaccinationCenterController;
import app.mappers.dto.VaccinationCenterDTO;
import app.ui.console.utils.Utils;

import java.util.List;

public class SelectVaccinationCenterUI implements Runnable{
    private SelectVaccinationCenterController selectCenter = new SelectVaccinationCenterController();
    @Override
    public void run() {
        System.out.println("-----------------------------");
        System.out.println("List of vaccination centers: ");
        System.out.println("-----------------------------");
        selectVaccinationCenter();

    }

    /**
     * Returns the selected vaccination center
     * @return the selected vaccination center
     */
    public VaccinationCenterDTO selectVaccinationCenter() {
        System.out.println("-----------------------------");
        System.out.println("List of vaccination centers: ");
        System.out.println("-----------------------------");
        List<VaccinationCenterDTO> vCenterList = selectCenter.getVaccinationCenter();
        if (vCenterList.isEmpty()) {
            throw new IllegalArgumentException("There's no vaccination centers");
        }
        int counter = 1;
        for (VaccinationCenterDTO VCenterDTO : vCenterList) {
            System.out.println(counter+" - "+VCenterDTO.getName());
            counter++;
        }
        String option = Utils.readLineFromConsole("Select the vaccination center where you currently in: ");
         try{
             VaccinationCenterDTO vCenterDTO = vCenterList.get(Integer.parseInt(option) - 1);
             selectCenter.currentCenter(vCenterDTO);
             return vCenterDTO;
         }catch (Exception e){
             System.out.println("Error: " + e.getMessage());
             System.out.println("Please enter the option you want correctly!");
         }
        return null;

    }

}
