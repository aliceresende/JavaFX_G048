package app.mappers.dto;

import app.domain.model.Address;

import java.util.Date;

public class SNSUserDTO {
    private String name;
    private String sex;
    private Date birthDate;
    private Address address;
    private String phoneNumber;
    private String email;
    private String snsUserNumber;
    private String citizenCardNumber;



    /**
         * This method creates a SNSUser dto receiving the name, sec, birth date, address, phone number, email, snsUser number, cc number.
     *  @param name the name of the SNS user
     * @param sex the sex of the SNS user
     * @param birthDate the birthdate of the SNS user
     * @param address the address of the SNS user
     * @param phoneNumber the phone number of the SNS user
     * @param email the email of the SNS user
     * @param snsUserNumber the SNS user number of the SNS user
     * @param citizenCardNumber the citizen card number of the SNS user
*       */
    public SNSUserDTO(String name, String sex, Date birthDate, Address address, String phoneNumber, String email, String snsUserNumber, String citizenCardNumber) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.snsUserNumber = snsUserNumber;
        this.citizenCardNumber = citizenCardNumber;


    }


    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }


}
