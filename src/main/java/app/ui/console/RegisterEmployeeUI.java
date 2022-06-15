package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.shared.Constants;

import java.io.IOException;
import java.util.Scanner;

/**
 * The type Register employee ui.
 */
public class RegisterEmployeeUI implements Runnable{
    /**
     * The Read.
     */
    static Scanner read = new Scanner(System.in);
    private final RegisterEmployeeController employeeC = new RegisterEmployeeController();

    /**
     * Asks the information of the employee and reads it
     * @throws Exception if the information enter is not valid
     */

    public void run() {
        System.out.print("Enter the required information:\n");
        //Employee name
        System.out.print("Name: ");
        String name = read.nextLine();
        //Employee phoneNumber
        System.out.print("Phone Number: ");
        //read.nextLine();
        String phoneNumber = read.nextLine();
        try{
            Double.parseDouble(phoneNumber);

        }catch (Exception e){
            System.out.print("The phone number must have only numbers.");
        }
        //Employee email
        System.out.print("Email: ");
        String email = read.nextLine();
        //Employee address
        System.out.print("Address: ");
        String address = read.nextLine();
        //Employee citizen card number
        System.out.print("Citizen Card Number: ");
        String citizenCardNumber = read.nextLine();
        try{
            Double.parseDouble(citizenCardNumber);

        }catch (Exception e){
            System.out.print("The citizen card number must have only numbers.");
        }
        //Employee Role
        System.out.print("Role: ");
        System.out.println("\n[1] Receptionist\n[2] Nurse\n[3] Center Coordinator");
        String role = "";
        try {
            int option;
            option = read.nextInt();
            if (option == 1) {
                role = Constants.ROLE_RECEPT;
            } if (option == 2) {
                role = Constants.ROLE_NURSE;
            } if (option == 3) {
                role = Constants.ROLE_CENTER_COORDINATOR;
            }
        }
        catch (Exception e){
            System.out.print("Select a valid option (1, 2 or 3)");
        }

        try {
            System.out.println("Can you confirm the data entered?");
            System.out.println("[1] (Yes)\n[2] (No)");
            String answer = read.next();
            read.nextLine();

            confirmation(answer,name,phoneNumber,email,address,citizenCardNumber,role);
        }
        catch (Exception e){
            System.out.print("\nError:");
            System.out.print(e.getMessage());
        }
    }

    /**
     * Confirms if the information of the Employee is right
     * @param answer answer of the confirmation
     * @param name name of the Employee
     * @param phoneNumber phone number of the Employee
     * @param email email of the Employee
     * @param address address of the Employee
     * @param citizenCardNumber citizen card number of the Employee
     * @param role role of the Employee
     * @throws IllegalArgumentException if is selected an invalid option
     */

    private void confirmation(String answer, String name, String phoneNumber, String email, String address, String citizenCardNumber, String role){
        if (answer.equals("1")) {
            employeeC.createEmployee(name,phoneNumber,email,address,citizenCardNumber,role);
            try {
                employeeC.saveEmployee();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("Success!");
        }
        if (answer.equals("2")){
            new RegisterEmployeeUI().run();
        }
        else if (!answer.equals("1") && !answer.equals("2")) {
            throw new IllegalArgumentException("Enter a valid option (1 or 2)");
        }
    }
}
