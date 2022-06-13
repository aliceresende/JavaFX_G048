package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Employee {

    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String citizenCardNumber;
    private String role;

    /**
     * Returns the name from the Employee
     * @return the name from the Employee
     */

    public String getName() {
        return name;
    }

    /**
     * Returns the role from the Employee
     * @return the role from the Employee
     */

    public String getRole() {
        return role;
    }

    /**
     * Returns the email from the Employee
     * @return the email from the Employee
     */

    public String getEmail() {
        return email;
    }

    /**
     * Returns the phone number from the Employee
     * @return the phone number from the Employee
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the address from the Employee
     * @return the address from the Employee
     */

    public String getAddress() {
        return address;
    }

    /**
     * Returns the citizen card number from the Employee
     * @return the citizen card number from the Employee
     */

    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /**
     * Builds an instance of the Employee receiving the name, phone number, email, address, citizen card number and role
     * @param name the name of the Employee
     * @param phoneNumber the phone number of the Employee
     * @param email the email of the Employee
     * @param address the address of the Employee
     * @param citizenCardNumber the citizen card number of the Employee
     * @param role the role of the SNS user
     */

    public Employee(String name, String phoneNumber, String email, String address, String citizenCardNumber, String role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.citizenCardNumber = citizenCardNumber;
        this.role = role;
    }

    /**
     * Returns the textual description of the Employee
     * @return Employee features
     */

    @Override
    public String toString(){
        return String.format("Employee Info: \nName: %s\nPhone Number: %s\nEmail: %s\nAdress: %s\nCitizen Card Number: %s\nRole: %s\n",
                name, phoneNumber, email,address, citizenCardNumber,role);
    }

    /**
     * Checks if the citizen card number is valid
     */

    public void checkCitizenCardNumber(String citizenCardNumber) {
        if (StringUtils.isBlank(citizenCardNumber)) {
            throw new IllegalArgumentException("You must enter a valid Citizen Card Number");
        }
        if (String.valueOf(citizenCardNumber).length() != 8) {
            throw new IllegalArgumentException("Invalid Citizen Card Number, it must contain 8 digits");
        }
    }

    /**
     * Checks if the phone number is valid
     * @param phoneNumber
     */

    public void checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 9) {
            throw new IllegalArgumentException("Invalid Phone Number! Must have 9 digits");
        }
        if (!phoneNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
    }

    /**
     * Checks if the email is valid
     * @param email
     */

    public void checkEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (!pat.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid Email");
        }
    }

    /**
     * Checks if the address is valid
     * @param address
     */

    public void checkAddress(String address) {
        if (StringUtils.isBlank(address)) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
    }

    /**
     * Checks if the name is valid
     * @param name
     */

    public void checkName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    /**
     * Checks if the role is valid
     */

    public void checkRole(String role) {
        List<String> roleList = new ArrayList<String>();
        roleList.add("Receptionist");
        roleList.add("Nurse");
        roleList.add("Center Coordinator");
        if (!roleList.contains(role)) {
            throw new IllegalArgumentException("You must select a valid Role [Receptionist/Nurse/Center Coordinator]");
        }
    }

    /**
     * Modify the name from the Employee
     * @param name
     */

    public void setName(String name) {
        checkName(name);
        this.name = name;
    }

    /**
     * Modify the phone number from the Employee
     * @param phoneNumber
     */

    public void setPhoneNumber(String phoneNumber) {
        checkPhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Modify the email from the Employee
     * @param email
     */

    public void setEmail(String email) {
        checkEmail(email);
        this.email = email;
    }

    /**
     * Modify the address from the Employee
     * @param address
     */

    public void setAddress(String address) {
        checkAddress(address);
        this.address = address;
    }

    /**
     * Modify the role from the Employee
     * @param role
     */

    public void setRole(String role) {
        checkRole(role);
        this.role = role;
    }

    /**
     * Modify the email from the SNS user
     * @param citizenCardNumber
     */

    public void setCitizenCardNumber(String citizenCardNumber) {
        checkCitizenCardNumber(citizenCardNumber);
        this.citizenCardNumber = citizenCardNumber;
    }
}
