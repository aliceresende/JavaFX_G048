package app.domain.store;


import app.domain.model.CSV.CSV;
import app.domain.model.PasswordGenerator;
import app.domain.model.SNSUser;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * The type Sns user store.
 */
public class SNSUserStore extends PasswordGenerator {
    private ArrayList<SNSUser> knows = new ArrayList<>();
    private AuthFacade auth;
    private PasswordGenerator pwd;

    /**
     * Instantiates a new Sns user store.
     *
     * @param knows the knows
     * @param auth  the auth
     * @param pwd   the pwd
     */
    public SNSUserStore(ArrayList<SNSUser> knows, AuthFacade auth, PasswordGenerator pwd) {
        this.knows = knows;
        this.auth = auth;
        this.pwd = pwd;
    }

    /**
     * Creates an SNS User with name, birthdate, phone number, email, address, sex and citizen card number
     *
     * @param name              the name of the SNS user
     * @param birthdate         the birthdate of the SNS user
     * @param SNSUserNumber     the SNS user number of the SNS user
     * @param phoneNumber       the phone number of the SNS user
     * @param email             the email of the SNS user
     * @param street            the street
     * @param doornumber        the doornumber
     * @param postCode          the post code
     * @param city              the city
     * @param sex               the sex of the SNS user
     * @param citizenCardNumber the citizen card number of the SNS user
     * @return the SNS user information
     * @throws ParseException the parse exception
     */
    public SNSUser createSNSUser(String name, Date birthdate, String SNSUserNumber, String phoneNumber, String email, String street, String doornumber ,String postCode, String city , String sex, String citizenCardNumber) throws ParseException {
        return new SNSUser(name, birthdate, SNSUserNumber, phoneNumber, email, street, doornumber, postCode, city,sex, citizenCardNumber);

    }

    /**
     * Creates an SNS User with name, birthdate, phone number, email, address and citizen card number
     *
     * @param name              the name of the SNS user
     * @param birthdate         the birthdate of the SNS user
     * @param SNSUserNumber     the SNS user number of the SNS user
     * @param phoneNumber       the phone number of the SNS user
     * @param email             the email of the SNS user
     * @param street            the street
     * @param doornumber        the doornumber
     * @param postCode          the post code
     * @param city              the city
     * @param citizenCardNumber the citizen card number of the SNS user
     * @return the SNS user information
     */
    public SNSUser createSNSUser(String name, Date birthdate, String SNSUserNumber, String phoneNumber, String email, String street, String doornumber ,String postCode, String city, String citizenCardNumber) {
        return new SNSUser(name, birthdate, SNSUserNumber, phoneNumber, email, street, doornumber, postCode, city, citizenCardNumber);
    }

    /**
     * Validates the SNS user data and increments an SNS User.
     *
     * @param snsuser the SNS user data of the SNS user
     * @return true if the SNS user data is valid and false otherwise
     * @throws IllegalArgumentException if the SNS user already exists
     */
    public boolean validateSNSUser(SNSUser snsuser) {
        if (snsuser == null)
            return false;
        int i = 0;
        for (SNSUser snsU : knows) {
            if (snsuser.getEmail().equals(knows.get(i).getEmail())) {
                System.out.println("SNS User " + snsU.getName() + " already exists");
                break;
            }
            i++;
        }
        return !this.knows.contains(snsuser);
    }

    /**
     * Validate sns users boolean.
     *
     * @param listUsers the list users
     * @return the boolean
     */
    public boolean validateSNSUsers(List<SNSUser> listUsers){
        boolean validation = false;
        for(SNSUser user: listUsers){
            validation = validateSNSUser(user);
        }
        return validation;
    }

    /**
     * Constructs a SNSUserStore instance, initializing the list of SNS Users
     */
    public SNSUserStore() {
    }

    /**
     * Gets sns user list.
     *
     * @return the sns user list
     */
    public List<SNSUser> getSnsUserList() {
        return knows;
    }

    /**
     * Saves an SNS user
     *
     * @param snsuser the SNS user data of the SNS user
     */
    public void saveSNSUser(SNSUser snsuser) {
        addSNSUser(snsuser);
    }

    /**
     * Generate password string.
     *
     * @return the string
     */
//Extends PasswordGenerator Polimorfism
    public static String generatePassword() {

        return PasswordGenerator.generatePassword();
    }

    /**
     * Adds a new SNS user to the list
     *
     * @param snsuser the SNS user data of the SNS user
     * @return true and adds a new SNS user if the SNS user is fulfilled, otherwise returns false
     */
    public boolean addSNSUser(SNSUser snsuser) {
        int i = 0;
        boolean check = true;
        if (snsuser != null) {
            for (SNSUser snsU : knows) {
                if (knows.equals(snsuser)) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                knows.add(snsuser);
                return check;
            }
        }
        return false;
    }

    /**
     * Show the authentication data of the SNS User
     *
     * @param snsUser the sns user
     * @param pwd     the pwd
     * @return string
     */
    public String showAuthenticationData(SNSUser snsUser, String pwd) {
        return String.format("\n\nSNS USER AUTHENTICATION DATA\n\nName: %s\nEmail: %s\nPassword: %s\n",
                snsUser.getName(), snsUser.getEmail(), pwd);
    }

//==================== CSV FILE ================================================

    /**
     * Register csv users list.
     *
     * @param listcsvInfo the listcsv info
     * @return the list
     * @throws ParseException the parse exception
     */
    public List<SNSUser> registerCSVUsers(List<List<String>> listcsvInfo) throws ParseException {
        List<SNSUser> listSNSUsers = new ArrayList<SNSUser>();
        for (List<String> user : listcsvInfo) {
            if (user.get(1).isBlank()) { //sex is undefined
                listSNSUsers.add(new SNSUser(user.get(0), user.get(2), user.get(3), user.get(4), user.get(5), user.get(6), user.get(7), user.get(8), user.get(9), user.get(10)));
            } else { //sex is defined
                listSNSUsers.add(new SNSUser(user.get(0), user.get(1), user.get(2), user.get(3), user.get(4), user.get(5), user.get(6), user.get(7), user.get(8), user.get(9), user.get(10)));
            }
        }
        return listSNSUsers;
    }


    /**
     * File treatment users list.
     *
     * @param filePath the file path
     * @param csv      the csv
     * @return the list
     * @throws IOException               the io exception
     * @throws ClassNotFoundException    the class not found exception
     * @throws InvocationTargetException the invocation target exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws ParseException            the parse exception
     */
    public List<SNSUser> fileTreatmentUsers(String filePath, CSV csv) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParseException {
        List<List<String>> listcsvInfo = new ArrayList<>();
        List<SNSUser> listSNSUsers = new ArrayList<>();
        listcsvInfo = csv.readFile(filePath,listcsvInfo); // read file
        listSNSUsers = registerCSVUsers(listcsvInfo); // info -> snsusers
        if(validateCSVUsers(listSNSUsers) == true){
            return listSNSUsers;
        }else{
            return null;
        }
    }


    /**
     * Validate csv users boolean.
     *
     * @param listSNSUsers the list sns users
     * @return the boolean
     * @throws ParseException the parse exception
     */
    public boolean validateCSVUsers(List<SNSUser> listSNSUsers) throws ParseException {
        boolean valid = true;
        for (SNSUser u : listSNSUsers)
            if ( u.getName() == null || u.getDate() == null || u.getAddress() == null || u.getPhoneNumber() == null || u.getEmail() == null || u.getSnsUserNumber() == null || u.getCitizenCardNumber() == null) {
                return valid = false;
            }else if( validName(u.getName())== false || validDate(u.getDate())== false ||validPostCode(u.getAddress().getPostCode()) == false ||validPhoneNumber(u.getPhoneNumber()) == false || validEmail(u.getEmail()) == false|| validSNSUserNumber(u.getSnsUserNumber()) == false || validCitizenCardNumber(u.getCitizenCardNumber()) == false) {
                return valid = false;
            }else{
                return valid = true;
            }
        return valid;
    }
    //========= Validations =========================================
    private boolean onlyLetters (String name){
        boolean letter = false;
        String[] numbers = name.split("");
        for (int i = 0; i < name.length(); i++) {
            if(numbers[i].matches("[a-zA-Z]")) { // verifica a existÃªncia de letras
                letter = true;
            }else{
                letter = false;
            }
        }
        return letter;
    }

    private boolean onlyNumbers (String number){
        try{
            int numb = Integer.parseInt(number);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }


    // ----------- valid name-------------------------------------
    private boolean validName (String name){
        if(!onlyLetters(name) || name.length() !=  35){
            return false;
        }else {
            return  true;
        }
    }


    // ----------- valid birth date-------------------------------------
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private boolean validDate (String date) throws ParseException {
        Calendar cal = new GregorianCalendar(); //calendar

        Calendar calData = Calendar.getInstance(); //date received to calendar
        calData.setTime(dateFormat.parse(date));

        if(calData.compareTo(cal) == 0){
            return true;
        }else {
            return false;
        }
    }




    // ----------- valid address-------------------------------------
    private boolean validPostCode (String postCode) {
        if(!validPostCodeHas6to8Digits(postCode) || !validPostCodeHasHifen(postCode) || !validPostCodeOnlyNumbers(postCode)) {
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

    private boolean validPostCodeHas6to8Digits (String postCode){
        if( !onlyNumbers(postCode) || postCode.length() < 6 || postCode.length() > 8 ){
            return false;
        }else{
            return  true;
        }

    }

    // ----------- valid phone number-------------------------------------
    /**
     *
     * @param phoneNumber
     * @return true if valid (9 digits)
     */
    private boolean validPhoneNumber(String phoneNumber) {
        try{
            if ( !onlyNumbers(phoneNumber) || phoneNumber.length() != 9){
                return true;
            }else{
                return false;
            }
        }catch (NumberFormatException e){
            return false;
        }
    }

    // ----------- valid email-------------------------------------
    /**
     * this method checks if the email is valid
     *
     * @param
     * @return true if the email is valid (11 digits and regular expression)
     */

    private boolean validEmail(String email) {
        if(!validEmailHasArroba(email) || !validEmailOnly1Arroba(email) || !validEmailHasDotAfterArroba(email)  || !validEmailHasNotSpaceBetweenDotsAndArroba(email)) {
            return false;
        }else{
            return true;
        }
    }

    /**
     * this method checks if email has a regular expression
     *
     * @param email
     * @return true if email has not space between dots ans arroba
     */
    private boolean validEmailHasNotSpaceBetweenDotsAndArroba(String email) {
        String[] dividedEmail= email.split("@");
        String afterArroba= dividedEmail[1];
        boolean dotFound=false;
        for (int i = 1; i < afterArroba.length()-1; i++) {
            if(afterArroba.charAt(i)=='.') {
                dotFound = true;

                if (dotFound && (afterArroba.charAt(i - 1) == '.' || afterArroba.charAt(i + 1) == '.')) {
                    return false;
                }

            }else{
                dotFound = false;
            }
        }
        return true;
    }

    /**
     * this method checks if email has a regular expression
     *
     * @param email
     * @return true if email
     */

    private boolean validEmailOnly1Arroba(String email) {
        boolean arrobaFound = false;
        for(int x=0; x<email.length();x++){
            if(arrobaFound){
                if(email.charAt(x)=='@')
                    return false;
            }
            if(email.charAt(x)=='@')
                arrobaFound=true;
        }
        return true;
    }

    /**
     *
     * @param email
     * @return
     */

    private boolean validEmailHasDotAfterArroba(String email) {
        boolean arrobaFound = false;
        for(int x=0; x<email.length();x++){
            if(email.charAt(x)== '@')
                arrobaFound=true;
            if(arrobaFound){
                if(email.charAt(x)== '.')
                    return true;
            }
        }
        return false;
    }

    /**
     *
     * @param email
     * @return
     */

    private boolean validEmailHasArroba(String email) {
        for(int x=0; x< email.length();x++){
            if(email.charAt(x) == '@')
                return true;
        }
        return false;
    }

    // ----------- valid snsuser number-------------------------------------
    /**
     *
     * @param snsUserNumber
     * @return true if valid (9 digits)
     */

    private boolean validSNSUserNumber(String snsUserNumber){
        if(!onlyNumbers(snsUserNumber) || snsUserNumber.length() != 9 ){
            return false;
        }else{
            return true;
        }
    }

    // ----------- valid cc number-------------------------------------
    /**
     *
     * @param citizenCardNumber
     * @return true if valid (8 digits)
     */

    private boolean validCitizenCardNumber(String citizenCardNumber) {
        if(!onlyNumbers(citizenCardNumber) || citizenCardNumber.length() != 8) {
            return false;
        }else{
            return true;
        }
    }

    //--------------------valid snsuser per number----------------------

    public List<List<String>> validPDUser(List<List<String>> csvInfo) {
        boolean val;
        for (List<String> lineInfo : csvInfo) {
            val = snsUserNumberExists(lineInfo);
            if (!val) {
                csvInfo.remove(lineInfo);
            }
        }
        return csvInfo;
    }

    public boolean snsUserNumberExists(List<String> lineInfo){
        boolean exists = false;
        String snsUserNumber = lineInfo.get(0);
        if (validSNSUserNumber(snsUserNumber)){
            for (SNSUser snsU : knows) {
                if (snsUserNumber.equals(snsU.getSnsUserNumber())) {  //exist
                    exists = true;
                }
            }
        }
        return exists;
    }


}
