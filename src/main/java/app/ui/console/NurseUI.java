package app.ui.console;

import app.mappers.dto.VaccinationCenterDTO;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class NurseUI implements Runnable {

    public NurseUI(){}
    private static VaccinationCenterDTO vCenterDTO = null;

    public void run()
    {
        SelectVaccinationCenterUI vC = new SelectVaccinationCenterUI();
        try {
            if(vCenterDTO==null){
                vCenterDTO = vC.selectVaccinationCenter();
                System.out.println("Vaccination Center Chosen: " + vCenterDTO.getName());
            }
        }
        catch (Exception e){
            System.out.println("\n" + e.getMessage());
            new AuthUI().run();
        }


        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Show waiting room", new ShowArrivedSNSUserUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nNurse Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
