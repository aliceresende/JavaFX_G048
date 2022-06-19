package app.domain.model;
import java.io.Serializable;
public class Nurse extends Employee implements Serializable{
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
    public Nurse(String name, String phoneNumber, String email, String address, String citizenCardNumber, String role) {
        super(name, phoneNumber, email, address, citizenCardNumber, role);
    }

}
