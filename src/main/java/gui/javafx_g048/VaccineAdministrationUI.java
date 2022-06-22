package gui.javafx_g048;

import app.controller.VaccineAdministrationController;
import app.domain.model.Vaccine;
import app.mappers.dto.ArrivalOfSNSUserDTO;
import app.mappers.dto.SNSUserDTO;
import app.mappers.dto.VaccineDTO;
import app.mappers.dto.VaccineScheduleDTO;
import app.ui.console.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VaccineAdministrationUI implements Initializable {


    public ComboBox VaccineSelect;
    public TextField ReadingSNSNumber;
    private ArrayList<VaccineDTO> vaccineOfTheSameType;
    private final VaccineAdministrationController adminController = new VaccineAdministrationController();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
   
    




    /*   public void run() {

           String SNSUserNumber = Utils.readLineFromConsole("Select a user from the waiting room via SNS user number: ");
           SNSUserNumber = ValidateSNSUserNumber(SNSUserNumber);

           // confirms user is in the waiting room

           ArrayList<ArrivalOfSNSUserDTO> waitingRoom = adminController.ToRegisterArraivalOfSNSUserMapper();
           if(ConfirmUserIsInWaitingRoom(SNSUserNumber, waitingRoom)){
               ArrayList<SNSUserDTO> snsUsers = adminController.ToSNSUserMapper();
               // confirms user is registered
               if (SNSUserIsRegistered(snsUsers,SNSUserNumber)){
                   //confirms user has a vaccine scheduled
                   ArrayList<VaccineScheduleDTO> vacSchedules = adminController.ToVaccineScheduleDTO();
                   if (VaccineIsScheduled(vacSchedules,SNSUserNumber)){

                       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                       DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                       ArrayList<VaccineDTO> vaccines = adminController.ToVaccineDTO();

                       String nameOfDisease = getVaccineName(vacSchedules,SNSUserNumber);
                       System.out.println(nameOfDisease);
                       VaccineDTO currentVaccine = selectUsersVaccine(vaccines,nameOfDisease);

                       LocalDateTime localTime = LocalDateTime.now();
                       String administrationTime = dtf.format(localTime);
                       String exitTime = dtf.format(localTime.plusMinutes(2));


                       int numberOfDoses = currentVaccine.getAdministration().get(0).getDoses();
                       int dose = Utils.readIntegerFromConsole("What dose is this?");

                       while (validateDose(dose,numberOfDoses) == false){
                           System.out.printf("this vaccine only has %d",numberOfDoses);
                           dose = Utils.readIntegerFromConsole("");
                       }


                       System.out.println("Has the vaccine been administered?\n Type \"Yes\" when administered ");
                       String confirmation = Utils.readLineFromConsole("");
                       while (!confirmation.equalsIgnoreCase("yes")){
                           System.out.println("Not a valid option, please insert a valid option.");
                           confirmation = Utils.readLineFromConsole("");
                       }

                       // remove user from waiting room
                       adminController.removeUserFromWaitingRoom(SNSUserNumber);
                       //remove schedule
                       adminController.removeScheduleAfterVaccine(SNSUserNumber);


                       System.out.println("Administered Vaccine lot number (example aaaa-00)");
                       String lotNumber = Utils.readLineFromConsole("");
                       while (lotNumberValidation(lotNumber) == false){
                           System.out.println("Invalid lot Number please insert it again");
                           lotNumber = Utils.readLineFromConsole("");
                       }

                       System.out.println("Aditional notes about the vaccine administration");
                       String aditionalNotes = Utils.readLineFromConsole("");
                       adminController.saveAdministration(exitTime,SNSUserNumber,currentVaccine,dose,aditionalNotes,administrationTime,lotNumber);

                   }else{
                       System.out.println("This user does not have a scheduled vaccine today");
                   }
               }else {
                   System.out.println("This user is not yet registered in the system.");
               }
           }else {
               System.out.println("User is not in the waiting room, try another SNS user number, or check if waiting room is empty");
           }


       }

       public SNSUserDTO getSNSUser(String snsUserNumber, ArrayList<SNSUserDTO> users){
           SNSUserDTO currentUser = null;
           for (SNSUserDTO user :users){
               if (user.getSnsUserNumber().equals(snsUserNumber)){
                   currentUser = user;
               }
           }
           return currentUser;
       }

       public boolean validateDose(int curentDose, int numberOfDoses){
           if (curentDose<=numberOfDoses){
               return true;
           }else {
               return false;
           }
       }

       public VaccineDTO selectUsersVaccine(ArrayList<VaccineDTO> vaccines, String vaccineName){
           if (vaccines.isEmpty()) {
               throw new IllegalArgumentException("There are no vaccines");
           }
           ArrayList<VaccineDTO> vaccineOfTheSameType = new ArrayList<>();
           int counter = 1;
           for (VaccineDTO vax : vaccines) {
               if (vax.get_disease().equals(vaccineName)) {
                   System.out.println(counter + " - " + vax.get_designation());
                   counter++;
                   vaccineOfTheSameType.add(vax);
               }
           }
           String option = Utils.readLineFromConsole("Select the vaccine: ");
           try{
               VaccineDTO vCenterDTO = vaccineOfTheSameType.get(Integer.parseInt(option) - 1);
               return vCenterDTO;
           }catch (Exception e){
               System.out.println("Error: " + e.getMessage());
               System.out.println("Please enter the option you want correctly!");
           }
           return null;

       }

       public VaccineScheduleDTO getVaccineSchedule(ArrayList<VaccineScheduleDTO> listOfSchedules, String SNSUserNumber){
           VaccineScheduleDTO vaxName = null;
           for (VaccineScheduleDTO schedule : listOfSchedules){
               if (schedule.getSnsUserNumber().equals(SNSUserNumber)){
                   vaxName = schedule;
               }
           }

           return vaxName;

       }

       public String getVaccineName(ArrayList<VaccineScheduleDTO> listOfSchedules, String SNSUserNumber){
           String vaxName = "";
           for (VaccineScheduleDTO schedule : listOfSchedules){
               if (schedule.getSnsUserNumber().equals(SNSUserNumber)){
                   vaxName = schedule.getVaccineName();
               }
           }

               return vaxName;

       }

       public boolean lotNumberValidation(String lotNumber){
           boolean validLotNumber = false;
           if (lotNumber.charAt(4) == '-'){
               validLotNumber = true;
           }
           return validLotNumber;
       }

       public boolean VaccineIsScheduled(ArrayList<VaccineScheduleDTO> listOfSchedules, String SNSUserNumber){
           boolean vaccineIsScheduled = false;
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           LocalDateTime localTime = LocalDateTime.now();
           String today = dtf.format(localTime);
           for (VaccineScheduleDTO schedule : listOfSchedules){
               String[] dateOfVaccine = schedule.getDateAndHour().split(" ");
               if (SNSUserNumber.equals(schedule.getSnsUserNumber()) && dateOfVaccine[0].equals(today)){
                   vaccineIsScheduled = true;
                   break;
               }
           }
           return vaccineIsScheduled;
       }

       public boolean SNSUserIsRegistered(ArrayList<SNSUserDTO> snsUsers, String SNSUserNumber){
           boolean SNSUserIsRegisterd = false;
           for (SNSUserDTO snsUser : snsUsers){
               if (snsUser.getSnsUserNumber().equals(SNSUserNumber)){
                   SNSUserIsRegisterd = true;
                   break;
               }
           }
           return SNSUserIsRegisterd;
       }

       public boolean ConfirmUserIsInWaitingRoom(String snsUserNumber, ArrayList<ArrivalOfSNSUserDTO> waitngRoom){
           for (ArrivalOfSNSUserDTO userDTO:waitngRoom){
               if (userDTO.getSNSUserNumber().equals(snsUserNumber)){
                   return true;
               }
           }
           return false;
       }

       public String ValidateSNSUserNumber(String snsUserNumber){

           boolean validSnsNumber;
           do {
               if (snsUserNumber.length() != 9) {
                   validSnsNumber = false;
                   System.out.println("Invalid SNS Number");
                   snsUserNumber = Utils.readLineFromConsole("Enter a valid SNS Number (9 digits):");
               } else {
                   try {
                       Long.parseLong(snsUserNumber);
                       validSnsNumber = true;
                   } catch (Exception e) {
                       System.out.println("Invalid SNS Number");
                       validSnsNumber = false;
                       snsUserNumber = Utils.readLineFromConsole("Enter a valid SNS Number (9 digits):");
                   }
               }
           }while (!validSnsNumber);

           return snsUserNumber;
       }
   */
    @FXML
    public void Action(ActionEvent actionEvent) {
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.vaccineOfTheSameType = new ArrayList<>();
        VaccineSelect.setVisible(false);

    }

    public boolean SNSUserIsRegistered(ArrayList<SNSUserDTO> snsUsers, String SNSUserNumber){
        boolean SNSUserIsRegisterd = false;
        for (SNSUserDTO snsUser : snsUsers){
            if (snsUser.getSnsUserNumber().equals(SNSUserNumber)){
                SNSUserIsRegisterd = true;
                break;
            }
        }
        return SNSUserIsRegisterd;
    }

    public boolean VaccineIsScheduled(ArrayList<VaccineScheduleDTO> listOfSchedules, String SNSUserNumber){
        boolean vaccineIsScheduled = false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime localTime = LocalDateTime.now();
        String today = dtf.format(localTime);
        for (VaccineScheduleDTO schedule : listOfSchedules){
            String[] dateOfVaccine = schedule.getDateAndHour().split(" ");
            if (SNSUserNumber.equals(schedule.getSnsUserNumber()) && dateOfVaccine[0].equals(today)){
                vaccineIsScheduled = true;
                break;
            }
        }
        return vaccineIsScheduled;
    }

    public String getVaccineName(ArrayList<VaccineScheduleDTO> listOfSchedules, String SNSUserNumber){
        String vaxName = "";
        for (VaccineScheduleDTO schedule : listOfSchedules){
            if (schedule.getSnsUserNumber().equals(SNSUserNumber)){
                vaxName = schedule.getVaccineName();
            }
        }

        return vaxName;

    }

    public void ConfirmSNSNumber(javafx.event.ActionEvent actionEvent) {

        String SNSUserNumber = String.valueOf(ReadingSNSNumber);
        ArrayList<String> vaxNames = new ArrayList<>();
        VaccineSelect.setVisible(true);
        ArrayList<SNSUserDTO> snsUsers = adminController.ToSNSUserMapper();
        // confirms user is registered
        if (SNSUserIsRegistered(snsUsers, SNSUserNumber)) {
            //confirms user has a vaccine scheduled
            ArrayList<VaccineScheduleDTO> vacSchedules = adminController.ToVaccineScheduleDTO();
            if (VaccineIsScheduled(vacSchedules, SNSUserNumber)) {
                ArrayList<VaccineDTO> vaccines = adminController.ToVaccineDTO();

                String nameOfDisease = getVaccineName(vacSchedules,SNSUserNumber);


                int counter = 1;
                for (VaccineDTO vax : vaccines) {
                    if (vax.get_disease().equals(nameOfDisease)) {
                        System.out.println(counter + " - " + vax.get_designation());
                        counter++;
                        vaccineOfTheSameType.add(vax);
                    }
                }


                for (int i = 0; i < vaccineOfTheSameType.size(); i++) {
                    vaxNames.add(vaccineOfTheSameType.get(i).get_designation());
                }
            }
        }
        VaccineSelect.getItems().addAll(vaxNames);

    }

    public void SelectVaccine(javafx.event.ActionEvent actionEvent) {
        int index = Integer.valueOf(VaccineSelect.getSelectionModel().getSelectedIndex());
        VaccineDTO currentVaccine = vaccineOfTheSameType.get(index);
        int numberOfDoses = currentVaccine.getAdministration().get(0).getDoses();
    }


}
