package app.mappers.dto;

import app.domain.model.Address;

import java.util.Date;

/**
 * The type Sns user dto.
 */
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
     *
     * @param name              the name of the SNS user
     * @param sex               the sex of the SNS user
     * @param birthDate         the birthdate of the SNS user
     * @param address           the address of the SNS user
     * @param phoneNumber       the phone number of the SNS user
     * @param email             the email of the SNS user
     * @param snsUserNumber     the SNS user number of the SNS user
     * @param citizenCardNumber the citizen card number of the SNS user
     */
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


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets sex.
     *
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets sns user number.
     *
     * @return the sns user number
     */
    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    /**
     * Gets citizen card number.
     *
     * @return the citizen card number
     */
    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }


}
