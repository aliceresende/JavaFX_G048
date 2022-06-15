package app.ui.console;

import app.controller.SpecifyNewVaccineTypeController;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Specify new vaccine type ui.
 */
public class SpecifyNewVaccineTypeUI implements Runnable {
    private SpecifyNewVaccineTypeController ctrl;

    /**
     * Instantiates a new Specify new vaccine type ui.
     */
    public SpecifyNewVaccineTypeUI() {
        this.ctrl = new SpecifyNewVaccineTypeController();

    }

    /**
     * Menu for the admin to choose witch tech the vaccine will have.
     *
     * @return String that represents tech
     */
    public String ChooseTech() {
        String[] array = new String[2];
        System.out.println("\nChoose the vaccine tech you want to register.");
        List<String> options = new ArrayList<String>();
        options.add(Constants.TECH_1);
        options.add(Constants.TECH_2);
        options.add(Constants.TECH_3);
        options.add(Constants.TECH_4);
        options.add(Constants.TECH_5);
        options.add(Constants.TECH_6);
        int option = 0;
        option = Utils.showAndSelectIndex(options, "Select an option to continue:");
        switch (option + 1) {
            case 1:
                return Constants.TECH_1;
            case 2:
                return Constants.TECH_2;
            case 3:
                return Constants.TECH_3;
            case 4:
                return Constants.TECH_4;
            case 5:
                return Constants.TECH_5;
            case 6:
                return Constants.TECH_6;
        }
        return null;
    }


    public void run() {
        boolean cont;

        do {

            String code = Utils.readLineFromConsole("Please enter the code of the new Vaccine Type:");
            String type;
            String tech = ChooseTech();
            if (tech == Constants.TECH_1) {
                type = Constants.TECH_1_TYPE;
                ctrl.createVaccineType(code, type, tech);
            } else if (tech == Constants.TECH_2) {
                type = Constants.TECH_2_TYPE;
                ctrl.createVaccineType(code, type, tech);
            } else if (tech == Constants.TECH_3) {
                type = Constants.TECH_3_TYPE;
                ctrl.createVaccineType(code, type, tech);
            } else if (tech == Constants.TECH_4) {
                type = Constants.TECH_4_TYPE;
                ctrl.createVaccineType(code, type, tech);
            } else if (tech == Constants.TECH_5) {
                type = Constants.TECH_5_TYPE;
                ctrl.createVaccineType(code, type, tech);
            } else if (tech == Constants.TECH_6) {
                type = Constants.TECH_6_TYPE;
                ctrl.createVaccineType(code, type, tech);
            }


            cont = Utils.confirm("The following Vaccine type was created do you want to save? \n----> Yes or No? <----\n" + ctrl.getVt().toString());

            if (cont) {

                if (ctrl.saveVaccineType()) {
                    System.out.println("The Vaccine type was saved with success");

                }

            } else if(!cont){
                System.out.println("Couldn't save the Vaccine type please try again ");

            }


        } while (!cont);


    }
}
