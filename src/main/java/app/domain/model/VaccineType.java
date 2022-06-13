package app.domain.model;

import app.domain.shared.Constants;
import org.apache.commons.lang3.StringUtils;

public class VaccineType {
    /**
     * Class that represents a Vaccine Type
     *
     * @author Gonçalo Carneiro <1210809@isep.ipp.pt>
     */
    private String code;
    private String type;
    private String tech;

    /**
     * Constructor of the VaccineType, it calls methods in order to validate the parameters
     *
     * @param code represents the VaccineType code
     * @param type represents the VaccineType Name
     * @param tech represents the VaccineType tech
     */

    public VaccineType(String code, String type, String tech) {
        check_CodeRules(code);
        this.code = code;
        this.type = type;
        this.tech = tech;
    }
    public String getCode(){return this.code;}
    public String getType(){return this.type;}

    /**
     * This method checks if the code provided meets the requirements, if not it throws an exception making the execution to stop
     *
     * @param code Vaccine Type Code
     */
    public void check_CodeRules(String code) {
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Vaccine Type Code cannot have null (blank) value.");
        if (code.length() != Constants.MAX_CODE)
            throw new IllegalArgumentException("Vaccine Type Code must have a minimum of 5 numbers.");
    }


    /**
     * @return A string with the format Vaccine Type: Code= code, Type= type, Tech = tech
     */
    @Override
    public String toString() {
        return "Vaccine Type: \n" +
                "Code = " + this.code +
                "\nTech = " + this.tech +
                "\nType = " + this.type;
    }
}
