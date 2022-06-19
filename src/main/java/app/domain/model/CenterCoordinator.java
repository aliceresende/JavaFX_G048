package app.domain.model;

import app.mappers.dto.VaccinationCenterDTO;

import java.io.Serializable;

public class CenterCoordinator extends Employee implements Serializable {

    private VaccinationCenterDTO center;

    /**
     * Builds an instance of the Employee receiving the name, phone number, email, address, citizen card number and role
     *
     * @param name              the name of the Employee
     * @param phoneNumber       the phone number of the Employee
     * @param email             the email of the Employee
     * @param address           the address of the Employee
     * @param citizenCardNumber the citizen card number of the Employee
     * @param role              the role of the SNS user
     */
    public CenterCoordinator(String name, String phoneNumber, String email, String address, String citizenCardNumber, String role, VaccinationCenterDTO center) {
        super(name, phoneNumber, email, address, citizenCardNumber, role);
        this.center=center;
    }

    public VaccinationCenterDTO getCenter() {
        return center;
    }

    @Override
    public String toString() {
        return "\"Employee Info: \nName:" + this.getName() + "\nPhone Number: " + this.getPhoneNumber() +
                "\nEmail: " + this.getEmail() + "\nAdress: " + this.getAddress() + "\nCitizen Card Number: " +
                this.getCitizenCardNumber() + "\nRole: " + this.getRole() + "\ncenter {" + center.getName() +
                '}';
    }
}