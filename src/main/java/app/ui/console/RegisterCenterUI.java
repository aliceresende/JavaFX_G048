package app.ui.console;

import app.controller.RegisterCenterController;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.io.IOException;

/**
 * The type Register center ui.
 */
public class RegisterCenterUI implements Runnable {

    private RegisterCenterController centerC = new RegisterCenterController();

    /**
     * Asks the information of the center and reads it
     */

    public void run() {

        System.out.print("Enter the required information:\n");

        String id = Utils.readLineFromConsole("Center ID: ");

        //center name
        String name = Utils.readLineFromConsole("Center name:");

        //center adress
        String adress = Utils.readLineFromConsole("Center adress:");

        //center phone number
        String phoneNumber = Utils.readLineFromConsole("Center phone number:");

        boolean validPhoneNumber;
        do {
            if (phoneNumber.length() != 9 || !phoneNumber.startsWith("9")) {
                validPhoneNumber = false;
                System.out.println("Invalid phone number");
                phoneNumber = Utils.readLineFromConsole("Enter a valid phone Number:");
            } else {
                validPhoneNumber = true;
            }
        } while (!validPhoneNumber);

        //center e-mail adress
        String email = Utils.readLineFromConsole("Center e-mail adress:");
        boolean validEmail;
        do {
            if (!email.contains("@") ) {
                validEmail = false;
                System.out.println("Invalid email");
                email = Utils.readLineFromConsole("Enter a valid email:");
            } else {
                validEmail = true;
            }
        } while (!validEmail);


        //center fax number
        String faxNumber = Utils.readLineFromConsole("Center fax number (10 digits):");
        boolean validFaxNumber;
        do {
            if (faxNumber.length() != 10) {
                validFaxNumber = false;
                System.out.println("Invalid phone number");
                faxNumber = Utils.readLineFromConsole("Enter a valid fax number:");
            } else {
                validFaxNumber = true;
            }
        } while (!validFaxNumber);

        //center website adress
        String websiteAdress = Utils.readLineFromConsole("Center website adress:");
        boolean validWebsiteAdress;
        do {
            if (!websiteAdress.contains("www.")) {
                validWebsiteAdress = false;
                System.out.println("Invalid phone number");
                websiteAdress= Utils.readLineFromConsole("Enter a valid website adress:");
            } else {
                validWebsiteAdress = true;
            }
        } while (!validWebsiteAdress);

        //center opening hour
        String openingHour = Utils.readLineFromConsole("Center opening hours (hh:mm):");
        boolean validOpeningHour;
        do {
            if (!openingHour.contains(":") || openingHour.length() != 5) {
                validOpeningHour = false;
                System.out.println("Invalid opening hour");
                openingHour = Utils.readLineFromConsole("Enter a valid opening hour:");
            } else {
                validOpeningHour = true;
            }
        } while (!validOpeningHour);

        //center closing hour
        String closingHour = Utils.readLineFromConsole("Center closing hours:");
        boolean validClosingHour;
        do {
            if (!closingHour.contains(":") || closingHour.length() != 5) {
                validClosingHour = false;
                System.out.println("Invalid closing hour");
                closingHour = Utils.readLineFromConsole("Enter a valid closing hour:");
            } else {
                validClosingHour = true;
            }
        } while (!validClosingHour);

        //center slot duration
        String slotDuration = Utils.readLineFromConsole("Center slot duration:");


        //maximum number of vaccies that can be given per slot
        String maxNumVaxPerSlot = Utils.readLineFromConsole("Maximum number of vaccines that can be given per slot");

        try {
            System.out.print("Can you confirm the data entered?");
            System.out.print("[1] (Yes)\n[2] (No)");
            String answer = Constants.sc.next();
            Constants.sc.nextLine();

            Confirmation(answer,id,name,adress,phoneNumber,email,faxNumber,websiteAdress,openingHour,closingHour,slotDuration,maxNumVaxPerSlot);

        } catch (Exception e) {
            System.out.print("\nError:");
            System.out.print(e.getMessage());

        }

    }

    /**
     * Confirms if the information of the center right
     * @param answer answer of the confirmation
     * @param name name of the center
     * @param adress of the center
     * @param phoneNumber phone number of the SNS User
     * @param email email of the SNS User
     * @param faxNumber fax number of the center
     * @param websiteAdress website addres of the center
     * @param openingHour opening hour of the center
     * @param closingHour closing hour of the center
     * @param slotDuration vaccine slots on the center
     * @param maxNumVaxPerSlot maximum number of vaccines that can be given per slot
     * @throws IllegalArgumentException if is selected an invalid option
     */

    private void Confirmation(String answer ,String id, String name, String adress, String phoneNumber, String email, String faxNumber, String websiteAdress, String openingHour,String closingHour, String slotDuration, String maxNumVaxPerSlot){
        if (answer.equals("1")) {
            centerC.RegisterCenterD(id, name,adress,phoneNumber,email,faxNumber,websiteAdress,openingHour,closingHour,slotDuration,maxNumVaxPerSlot);
            try {
                centerC.SaveCenter();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        if (answer.equals("2")){
            run();
        }
        else if (!answer.equals("1") && !answer.equals("2")) {
            throw new IllegalArgumentException("Enter a valid option (1 or 2)");
        }
    }


}
