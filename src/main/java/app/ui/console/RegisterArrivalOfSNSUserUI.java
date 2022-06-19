package app.ui.console;


import app.controller.RegisterArrivalOfSNSUserController;
import app.controller.SelectVaccinationCenterController;
import app.mappers.ArrivalOfSNSUserMapper;
import app.mappers.dto.VaccinationCenterDTO;
import app.ui.console.utils.Utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RegisterArrivalOfSNSUserUI implements Runnable{
    static Scanner read = new Scanner(System.in);
    private final RegisterArrivalOfSNSUserController arrivalUserC = new RegisterArrivalOfSNSUserController();
    private final SelectVaccinationCenterController selectCenterController = new SelectVaccinationCenterController();
    private ArrivalOfSNSUserMapper arrivalMapper;

    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register the arrival of a SNS User", new ShowTextUI("You have chosen to register the arrival of a SNS User")));
        String SNSUserNumber = Utils.readLineFromConsole("SNS User Number (10 digits): ");
        boolean validSnsNumber;
        do {
            if (SNSUserNumber.length() != 10) {
                validSnsNumber = false;
                System.out.println("Invalid SNS Number");
                SNSUserNumber = Utils.readLineFromConsole("Enter a valid SNS Number (10 digits):");
            } else {
                try {
                    Long.parseLong(SNSUserNumber);
                    validSnsNumber = true;
                } catch (Exception e) {
                    System.out.println("Invalid SNS Number");
                    validSnsNumber = false;
                    SNSUserNumber = Utils.readLineFromConsole("Enter a valid SNS Number (10 digits):");
                }
            }
        } while (!validSnsNumber);
        VaccinationCenterDTO vCenterDTO = selectCenterController.getCurrentCenter();
        arrivalUserC.getVaccineScheduleBySNSUserNumber(SNSUserNumber);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime localTime = LocalDateTime.now();
        System.out.println("Current time: "+dtf.format(localTime));
        try {
            System.out.println("");
            System.out.print("Do you confirm the vaccine schedule?\n");
            System.out.print("[1] (Yes)\n[2] (No)\n");
            String answer = read.next();
            read.nextLine();
            confirmation(answer,SNSUserNumber,dtf.format(localTime),vCenterDTO.getName());

        }
        catch (Exception e){
            System.out.print("\nError:");
            System.out.print(e.getMessage());
        }
        arrivalUserC.show();
    }

    /**
     * This method confirms the arrival of the SNS user and verify the data
     * @param answer
     * @param SNSUserNumber
     * @param timeOfArrival
     * @param vCenterDTO
     */
    private void confirmation(String answer, String SNSUserNumber, String timeOfArrival, String vCenterDTO){
        if (answer.equals("1")) {
            arrivalUserC.registerArrivalUser(SNSUserNumber, timeOfArrival,vCenterDTO);
            try {
                arrivalUserC.saveArrival(SNSUserNumber,arrivalUserC.getVaccinationCenterName(SNSUserNumber).getVaccinationCenterName());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (answer.equals("2")){
            new RegisterArrivalOfSNSUserUI().run();
        }
        else if (!answer.equals("1") && !answer.equals("2")) {
            throw new IllegalArgumentException("Enter a valid option (1 or 2)");
        }
    }


}
