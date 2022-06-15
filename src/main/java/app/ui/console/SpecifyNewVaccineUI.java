
package app.ui.console;


import app.controller.SpecifyNewVaccineController;
import app.domain.model.AdministrationProcess;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static app.domain.shared.Constants.*;

/**
 * The type Specify new vaccine ui.
 */
public class SpecifyNewVaccineUI implements Runnable {

    private SpecifyNewVaccineController ctrl;

    /**
     * Instantiates a new Specify new vaccine ui.
     */
    public SpecifyNewVaccineUI() {
        this.ctrl = new SpecifyNewVaccineController();
    }

    /**
     * Choose string.
     *
     * @return the string
     */
    public String choose() {
        List<String> options = new ArrayList<String>();
        options.add(AGEGROUP_CHILD);
        options.add(AGEGROUP_ADULT);
        options.add(AGEGROUP_TEENAGER);
        options.add(AGEGROUP_OLD);
        int option = 0;
        option = Utils.showAndSelectIndex(options, "Please enter the Age Group of people meant for the Vaccine:");
        switch (option + 1) {
            case 1:
                return AGEGROUP_CHILD;
            case 2:
                return AGEGROUP_ADULT;
            case 3:
                return AGEGROUP_TEENAGER;
            case 4:
                return AGEGROUP_OLD;
        }
        return null;
    }


    /**
     * Gets vaccine data.
     */
    public void getVaccineData() {
        String code = Utils.readLineFromConsole("Please enter the code of the new Vaccine:");
        String designation = Utils.readLineFromConsole("Please enter the name of the new Vaccine:");
        String Type = Utils.readLineFromConsole("Please enter the type code of the new Vaccine:");
        String description = Utils.readLineFromConsole("Please enter the description of the new Vaccine:");
        String intv = Utils.readLineFromConsole("Please enter the necessary amount of" +
                "weeks to wait to take the vaccine since a different vaccine:");
        String disease = Utils.readLineFromConsole("Please enter the disease that the new Vaccine will fight:");
        ArrayList<String> age_group = new ArrayList<String>();
        ArrayList<AdministrationProcess> administration = new ArrayList<AdministrationProcess>();
        Boolean res = true;
        String age;
        while (res == true) {
            age = choose();
            age_group.add(age);
            res = Utils.confirm("Do you wish to add another Age group of people to this vaccine?");
        }
        for (int i = 0; i < age_group.size(); i++) {
            age = age_group.get(i);
            System.out.println("\nAdministrator process for " + age + "'");
            String Processcode = Utils.readLineFromConsole("Please enter the code of the new Administration process:");
            int doses = Utils.readIntegerFromConsole("Please enter the number of doses: ");
            int dosage = Utils.readIntegerFromConsole("Please enter the dosage per doses: ");
            String adm_description = Utils.readLineFromConsole("Please enter the description of the new Administration process:");
            administration.add(new AdministrationProcess(Processcode, designation, doses, age, dosage, adm_description));
        }
        ctrl.createVaccine(code, designation, Type, age_group, intv, disease, description, administration);

    }
    public void run(){
        boolean cont;
        do{
            getVaccineData();
            cont = Utils.confirm("The following Vaccine type was created do you want to save? \n----> Yes or No? <----\n" + ctrl.getV().toString());

        }while (!cont);
    }









}



