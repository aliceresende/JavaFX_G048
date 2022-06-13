package app.domain.model;

import app.domain.shared.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class SNSUser {

    private String name;

    private Date birthDate;

    private String snsUserNumber;

    private String phoneNumber;

    private String email;

    private Address address;

    private String sex;

    private String citizenCardNumber;

    private String formattedDate;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    /**
     * Builds an instance of the SNS user (used in the csv file) receiving the name, birthdate, phone number, email, address, sex and citizen card number
     * @param name the name of the SNS user
     * @param sex the sex of the SNS user
     * @param
     * @param
     * @param phoneNumber the phone number of the SNS user
     * @param email the email of the SNS user
     * @param snsUserNumber the SNS user number of the SNS user
     * @param citizenCardNumber the citizen card number of the SNS user
     */
    public SNSUser(String name, String sex, String date, String street, String doornumber ,String postCode, String city ,String phoneNumber, String email, String snsUserNumber, String citizenCardNumber) throws ParseException {
        this.name = name;
        this.sex = sex;
        Date data = dateFormat.parse(date);
        this.formattedDate = dateFormat.format(data);
        this.address = new Address(street,doornumber,postCode,city);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.snsUserNumber = snsUserNumber;
        this.citizenCardNumber = citizenCardNumber;
    }


    public SNSUser(String name, String date, String street, String doornumber , String postCode, String city , String phoneNumber, String email, String snsUserNumber, String citizenCardNumber) throws ParseException {
        this.name = name;
        this.sex= Constants.SEX_OMISSION;
        Date data = dateFormat.parse(date);
        this.formattedDate = dateFormat.format(data);
        this.address = new Address(street,doornumber,postCode,city);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.snsUserNumber = snsUserNumber;
        this.citizenCardNumber = citizenCardNumber;
    }

    /**
     * Returns the name from the SNS user
     * @return the name from the SNS user
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the email from the SNS user
     * @return the email from the SNS user
     */
    public String getEmail() {
        return email;
    }


    /**
     * Builds an instance of the SNS user receiving the name, birthdate, phone number, email, address, sex and citizen card number
     * @param name the name of the SNS user
     * @param birthdate the birthdate of the SNS user
     * @param snsUserNumber the SNS user number of the SNS user
     * @param phoneNumber the phone number of the SNS user
     * @param email the email of the SNS user
     * @param
     * @param sex the sex of the SNS user
     * @param citizenCardNumber the citizen card number of the SNS user
     */
    public SNSUser(String name, Date birthdate, String snsUserNumber, String phoneNumber, String email,  String street, String doornumber ,String postCode, String city , String sex, String citizenCardNumber) {
        this.name = name;
        this.birthDate = birthdate;
        this.formattedDate = dateFormat.format(birthDate);
        this.snsUserNumber = snsUserNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = new Address(street,doornumber,postCode,city);
        this.sex = sex;
        this.citizenCardNumber = citizenCardNumber;
    }

    /**
     * Builds an instance of the SNS user receiving the name, birthdate, phone number, email, address and citizen card number
     * @param name the name of the SNS user
     * @param birthdate the birthdate of the SNS user
     * @param snsUserNumber the SNS user number of the SNS user
     * @param phoneNumber the phone number of the SNS user
     * @param email the email of the SNS user
     * @param citizenCardNumber the citizen card number of the SNS user
     */
    public SNSUser(String name, Date birthdate, String snsUserNumber, String phoneNumber, String email,  String street, String doornumber ,String postCode, String city , String citizenCardNumber) {
        this.name = name;
        this.birthDate = birthdate;
        this.formattedDate = dateFormat.format(birthDate);
        this.snsUserNumber = snsUserNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = new Address(street,doornumber,postCode,city);
        this.sex= Constants.SEX_OMISSION;
        this.citizenCardNumber = citizenCardNumber;
    }

    /**
     * Returns the textual description of the SNS user
     * @return SNS user features
     */
    @Override
    public String toString() {
        return String.format("SNS User Info: \nName: %s\nAddress: %s\nSex: %s\nPhone Number: %s\nEmail: %s\nBirth Date: %s\nSNS User Number: %s\nCitizen Card Number: %s\n",
                name, address, sex, phoneNumber, email, formattedDate, snsUserNumber, citizenCardNumber);
    }


    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    public String getDate() {
        return formattedDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }
}
