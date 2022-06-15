package app.ui.console;

import app.mappers.dto.VaccinationCenterDTO;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Receptionist ui.
 */
public class ReceptionistUI implements Runnable {
    private static VaccinationCenterDTO vCenterDTO = null;

    /**
     * Instantiates a new Receptionist ui.
     */
    public ReceptionistUI(){

    }

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

        options.add(new MenuItem("Register a new SNS user ", new RegisterSNSUserUI()));
        options.add(new MenuItem("Register the arrival of a SNS User", new RegisterArrivalOfSNSUserUI()));
        options.add(new MenuItem("Request vaccination for an asking User",new RecepcionistRequestVaccinationUI()));
        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu:");


            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
            vCenterDTO = null;
        }
        while (option != -1 );
    }
}
