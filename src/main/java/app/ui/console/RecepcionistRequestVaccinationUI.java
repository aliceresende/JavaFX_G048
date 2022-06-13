 package app.ui.console;

 import app.controller.RecepcionistRequestVaccineController;
 import app.domain.model.ComunityMassVaccinationCenter;
 import app.domain.model.Vaccine;
 import app.mappers.SNSUserMapper;
 import app.ui.console.utils.Utils;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;

public class RecepcionistRequestVaccinationUI implements Runnable{
    static Scanner ler = new Scanner(System.in);
    private final RecepcionistRequestVaccineController vaccineSchedule = new RecepcionistRequestVaccineController();
    private final RecepcionistRequestVaccineController requestVaccineController = new RecepcionistRequestVaccineController();
    private SNSUserMapper SNSUserMapper;

    /**
     *
     * Asks the information of the employee and reads it
     *
     * @throws Exception if the information enter is not valid
     */

    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Schedule a vaccination", new ShowTextUI("You have chosen to schedule a vaccination.")));

        System.out.print("Enter the required information:\n");

        String vaccineName = null;
        List<Vaccine> vaccine = vaccineSchedule.GetVaccineList();
        List<String> optionsVaccine = vaccineName(vaccine);
        int optionVaccine = Utils.showAndSelectIndex(optionsVaccine, "Vaccine: ");

        do {
            if (optionVaccine > optionsVaccine.size()) {
                System.out.println("Please enter a valid option");
                optionVaccine = Utils.showAndSelectIndex(optionsVaccine, "Vaccine: ");
            }
        } while (optionVaccine > optionsVaccine.size());

        for (int i = 0; i < optionsVaccine.size(); i++) {
            if (optionVaccine == i) {
                vaccineName = optionsVaccine.get(i);
            }
        }

        int vCNumber = 0;
        String vaccinationCenterName = null;
        List<ComunityMassVaccinationCenter> vaccinationCenter = vaccineSchedule.GetVaccinationCenterList();
        List<String> optionsVCName = vaccinationCenterName(vaccinationCenter);
        int optionVCName = Utils.showAndSelectIndex(optionsVCName, "Vaccination Center: ");

        do {
            if (optionVaccine > optionsVaccine.size()) {
                System.out.println("Please select a valid option");
                optionVCName = Utils.showAndSelectIndex(optionsVCName, "Enter vaccination center");
            }
        } while (optionVCName > optionsVCName.size());

        for (int i = 0; i < vaccinationCenter.size(); i++) {
            if (optionVCName == i) {
                vaccinationCenterName = vaccinationCenter.get(i).getName();
                vCNumber = i;
            }
        }

        String date = Utils.readLineFromConsole("Day (DD-MM-YYYY): ");
        System.out.println();

        String hour = null;
        boolean validHour = false;
        String openingHour = vaccinationCenter.get(vCNumber).getCenterSchedule().getOpeningHour(); //Problem
        String closingHour = vaccinationCenter.get(vCNumber).getCenterSchedule().getClosingHour(); //Problem
        String[] partsOpening = openingHour.split(":");
        String[] partsClosing = closingHour.split(":");
        int openingHourValue = Integer.parseInt(partsOpening[0]);
        int closingHourValue = Integer.parseInt(partsClosing[0]);
        System.out.println("Hour (00:00): ");
        do {
            hour = ler.nextLine();
            String[] partsHour = hour.split(":");
            int hourValue = Integer.parseInt(partsHour[0]);
            if (hourValue >= openingHourValue && hourValue < closingHourValue) {
                validHour = true;
            } else {
                System.out.println("Enter a valid hour (between " + openingHourValue + " and " + closingHourValue + ": ");
            }
        } while (!validHour);

        String snsUserNumber = Utils.readLineFromConsole("SNS User Number (10 digits): ");
        boolean validSnsUserNumber = false;
        do {
            if (snsUserNumber == null) {
                validSnsUserNumber = false;
            } else if (snsUserNumber.length() != 10) {
                validSnsUserNumber = false;
                System.out.println("Invalid SNS User Number");
                snsUserNumber = Utils.readLineFromConsole("Enter a valid SNS User Number (10 digits): ");
            } else {
                validSnsUserNumber = true;
            }
        } while (!validSnsUserNumber);

        boolean cont;
        cont = Utils.confirm("The following vaccine schedule was created do you want to save? \n----> Yes or No? <----\n");

        if (cont) {
            vaccineSchedule.createVaccineSchedule(vaccineName, date, hour, vaccinationCenterName, snsUserNumber);
            vaccineSchedule.saveVaccineSchedule();
            System.out.println("Success");

        } else if (!cont) {
            new RequestVaccineUI().run();
        }
    }

    public List<String> vaccinationCenterName(List<ComunityMassVaccinationCenter> vaccinationCenter) {
        List<String> vaccinationCenterName = new ArrayList<>();
        for(ComunityMassVaccinationCenter vc : vaccinationCenter) {
            vaccinationCenterName.add(vc.getName());
        }
        return vaccinationCenterName;
    }

    public List<String> vaccineName(List<Vaccine> vaccine) {
        List<String> vaccineName = new ArrayList<>();
        for(Vaccine v : vaccine){
            vaccineName.add(v.get_disease());
        }
        return vaccineName;
    }


}


