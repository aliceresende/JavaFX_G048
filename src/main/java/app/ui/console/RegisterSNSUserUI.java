package app.ui.console;

import app.controller.RegisterSNSUserController;
import app.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * The type Register sns user ui.
 */
public class RegisterSNSUserUI implements Runnable{
    /**
     * The Read.
     */
    static Scanner read = new Scanner(System.in);
    private final RegisterSNSUserController snsUserC = new RegisterSNSUserController();

    /**
     * Asks the information of the SNS user and reads it
     * @throws Exception if the information enter is not valid
     */
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register a new SNS User", new ShowTextUI("You have chosen to register a new SNS User.")));

        System.out.print("Enter the required information:\n");

        String name = Utils.readLineFromConsole("Name: ");

        String street = Utils.readLineFromConsole("Street: ");

        String doornumber = Utils.readLineFromConsole("Door Number: ");

        String postCode = Utils.readLineFromConsole("Post Code: ");


        while(!validPostCode(postCode)){
            System.out.println("Invalid Post Code!");
            postCode = Utils.readLineFromConsole("Enter a valid Post Code: ");
        }

        String city = Utils.readLineFromConsole("City: ");

        String phoneNumber;
        boolean validPhoneNumber;
        phoneNumber = Utils.readLineFromConsole("Phone Number (9 digits): ");
        do {
            if (phoneNumber.length() != 9 || !phoneNumber.startsWith("9")) {
                validPhoneNumber = false;
                System.out.println("Invalid phone number");
                phoneNumber = Utils.readLineFromConsole("Enter a valid phone Number:");
            } else {
                validPhoneNumber = true;
            }
        } while (!validPhoneNumber);


        String email = null;
        boolean validEmail;
        Email e1;
        do {
            validEmail = true;
            try {
                email = Utils.readLineFromConsole("Email:");
                e1 = new Email(email);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                validEmail = false;
            }
        } while (!validEmail);


        Date birthDate = Utils.readDateFromConsole("Birth day (dd-mm-yyyy): ");


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


        String citizenCardNumber = Utils.readLineFromConsole("Citizen Card Number (8 digits): ");
        boolean validCitizenCardNumber;
        do {
            if (citizenCardNumber.length() != 8) {
                validCitizenCardNumber = false;
                System.out.println("Invalid Citizen Card Number");
                citizenCardNumber = Utils.readLineFromConsole("Enter a valid number of citizen card (8 digits):");
            } else {
                try {
                    Long.parseLong(citizenCardNumber);
                    validCitizenCardNumber = true;

                } catch (Exception e) {
                    System.out.println("Invalid Citizen Card Number");
                    validCitizenCardNumber = false;
                    citizenCardNumber = Utils.readLineFromConsole("Enter a valid number of citizen card (16 digits): ");
                }
            }
        } while (!validCitizenCardNumber);


        String sex = null;
        boolean validSexOption = false;
        List<String> optionsSex = new ArrayList<>();
        optionsSex.add("Female");
        optionsSex.add("Male");
        optionsSex.add("Do not refer");
        int optionSex = Utils.showAndSelectIndex(optionsSex, "Sex: ");
        do {
            if (optionSex == 0) {
                sex = "Female";
                validSexOption = true;
                try {
                    System.out.print("Can you confirm the data entered?");
                    System.out.print("[1] (Yes)\n[2] (No)\n");
                    String answer = read.next();
                    read.nextLine();
                    confirmation(answer,name,birthDate,SNSUserNumber,phoneNumber,email,street, doornumber, postCode, city,sex,citizenCardNumber);
                }
                catch (Exception e){
                    System.out.print("\nError:");
                    System.out.print(e.getMessage());
               }
            } else if (optionSex == 1) {
                sex = "Male";
                validSexOption = true;
                try {
                    System.out.print("Can you confirm the data entered?");
                    System.out.print("[1] (Yes)\n[2] (No)\n");
                    String answer = read.next();
                    read.nextLine();
                    confirmation(answer,name,birthDate,SNSUserNumber,phoneNumber,email,street, doornumber, postCode, city,sex,citizenCardNumber);
                }
                catch (Exception e){
                    System.out.print("\nError:");
                    System.out.print(e.getMessage());
                }
            } else if (optionSex == 2) {
                validSexOption = true;
                try {
                    System.out.print("Can you confirm the data entered?");
                    System.out.print("[1] (Yes)\n[2] (No)\n");
                    String answer = read.next();
                    read.nextLine();
                    confirmation(answer,name,birthDate,SNSUserNumber,phoneNumber,email,street, doornumber, postCode, city,citizenCardNumber);
                }
                catch (Exception e){
                    System.out.print("\nError:");
                    System.out.print(e.getMessage());
                }
            } else {
                System.out.println("ERROR: Please select a valid option");
                optionSex = Utils.showAndSelectIndex(optionsSex, "Enter sex: ");
            }
        } while (!validSexOption);


    }

    /**
     * Confirms if the information of the SNS user is right
     * @param answer answer of the confirmation
     * @param name name of the SNS User
     * @param birthdate birthdate of the SNS User
     * @param snsUserNumber SNS user number of the SNS User
     * @param phoneNumber phone number of the SNS User
     * @param email email of the SNS User
     * @param
     * @param sex sex of the SNS User
     * @param citizenCardNumber citizen card number of the SNS User
     * @throws IllegalArgumentException if is selected an invalid option
     */
    private void confirmation(String answer, String name, Date birthdate, String snsUserNumber, String phoneNumber, String email,  String street, String doornumber ,String postCode, String city, String sex, String citizenCardNumber) throws ParseException {
        if (answer.equals("1")) {
            snsUserC.createSNSUser(name, birthdate, snsUserNumber,phoneNumber,email,street, doornumber, postCode, city,sex,citizenCardNumber);
            try {
                snsUserC.saveSNSUser();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (answer.equals("2")){
            new RegisterSNSUserUI().run();
        }
        else if (!answer.equals("1") && !answer.equals("2")) {
            throw new IllegalArgumentException("Enter a valid option (1 or 2)");
        }
    }
    /**
     * Confirms if the information of the SNS user is right
     * @param answer answer of the confirmation
     * @param name name of the SNS User
     * @param birthdate birthdate of the SNS User
     * @param snsUserNumber SNS user number of the SNS User
     * @param phoneNumber phone number of the SNS User
     * @param email email of the SNS User
     * @param
     * @param citizenCardNumber citizen card number of the SNS User
     * @throws IllegalArgumentException if is selected an invalid option
     */
    private void confirmation(String answer, String name, Date birthdate, String snsUserNumber, String phoneNumber, String email,  String street, String doornumber ,String postCode, String city, String citizenCardNumber){
        if (answer.equals("1")) {
            snsUserC.createSNSUser(name, birthdate, snsUserNumber,phoneNumber,email, street, doornumber, postCode, city,citizenCardNumber);
            try {
                snsUserC.saveSNSUser();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("Success!");
        }
        if (answer.equals("2")){
            new RegisterSNSUserUI().run();
        }
        else if (!answer.equals("1") && !answer.equals("2")) {
            throw new IllegalArgumentException("Enter a valid option (1 or 2)");
        }
    }

    // validations post code

    private boolean validPostCode (String postCode) {
        if(validPostCodeHas8Digits(postCode) && validPostCodeHasHifen(postCode) && validPostCodeOnlyNumbers(postCode)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validPostCodeHasHifen (String postCode){
        if(postCode.charAt(4) == '-')
            return true;
        else{
            return false;
        }
    }

    private boolean validPostCodeOnlyNumbers (String postCode){
        String[] numbers = postCode.split("-");
        int[] numb = new int[2];
        try{
            numb[0] = Integer.parseInt(numbers[0]);
            numb[1] = Integer.parseInt(numbers[1]);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    private boolean validPostCodeHas8Digits (String postCode){
        if(postCode.length() != 8){
            return false;
        }else{
            return  true;
        }

    }
}
