package app.domain.shared;

import java.util.Scanner;

/**
 * The type Constants.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Constants {
    /**
     * The constant ROLE_ADMIN.
     */
    public static final String ROLE_ADMIN = "ADMINISTRATOR";
    /**
     * The constant ROLE_RECEPT.
     */
    public static final String ROLE_RECEPT = "RECEPTIONIST";
    /**
     * The constant ROLE_CENTER_COORDINATOR.
     */
    public static final String ROLE_CENTER_COORDINATOR = "CENTER COORDINATOR";
    /**
     * The constant ROLE_SNSUSER.
     */
    public static final String ROLE_SNSUSER = "SNS USER";
    /**
     * The constant ROLE_NURSE.
     */
    public static final String ROLE_NURSE = "NURSE";
    /**
     * The constant SEX_OMISSION.
     */
    public static final String SEX_OMISSION = "Undefined";
    /**
     * The constant sc.
     */
    public static final Scanner sc = new Scanner(System.in);
    /**
     * The constant AGEGROUP_CHILD.
     */
    public static final String AGEGROUP_CHILD="child";
    /**
     * The constant AGEGROUP_TEENAGER.
     */
    public static final String AGEGROUP_TEENAGER="teenager";
    /**
     * The constant AGEGROUP_ADULT.
     */
    public static final String AGEGROUP_ADULT="adult";
    /**
     * The constant AGEGROUP_OLD.
     */
    public static final String AGEGROUP_OLD="old";

    /**
     * The constant PARAMS_FILENAME.
     */
    public static final String PARAMS_FILENAME = "config.properties";
    /**
     * The constant PARAMS_COMPANY_DESIGNATION.
     */
    public static final String PARAMS_COMPANY_DESIGNATION = "Company.Designation";

    /**
     * The constant TOTAL_MINUTES.
     */
    public static int TOTAL_MINUTES=720;
    /**
     * The constant OPEN_HOUR.
     */
    public static String OPEN_HOUR="8:00";


    /**
     * The constant TECH_1.
     */
    public static final String TECH_1 = "Live-attenuated vaccines";
    /**
     * The constant TECH_1_TYPE.
     */
    public static final String TECH_1_TYPE = "Live-attenuated vaccines contain live pathogens from either\n" +
            "a bacteria or a virus that have been \"attenuated,\" or weakened. According to Dr. Scully, live-attenuated vaccines\n" +
            " are produced by selecting strains of a bacteria or virus that\n " +
            "still produce a robust enough immune response but that does not cause disease. \n";
    /**
     * The constant TECH_2.
     */
    public static final String TECH_2 = "Inactivated vaccines";
    /**
     * The constant TECH_2_TYPE.
     */
    public static final String TECH_2_TYPE = "Inactivated vaccines take a live pathogen and inactivate or \n" +
            "kill it. When the vaccine is then introduced to a human through a shot, for example, the inactivated \n" +
            "pathogen is strong enough to create an \n" +
            "immune response, however, is incapable of causing disease. Multiple doses are often needed in order to\n" +
            " build up immunity and offer full protection.";
    /**
     * The constant TECH_3.
     */
    public static final String TECH_3 = "Subunit vaccines";
    /**
     * The constant TECH_3_TYPE.
     */
    public static final String TECH_3_TYPE = "Subunit vaccines are made from a piece of a pathogen,\n" +
            " not the whole organism, so they do not contain any live pathogens. Some important subunit \n" +
            "vaccines are polysaccharide vaccines, conjugate vaccines, and protein-based vaccines.";
    /**
     * The constant TECH_4.
     */
    public static final String TECH_4 = "Toxoid vaccines";
    /**
     * The constant TECH_4_TYPE.
     */
    public static final String TECH_4_TYPE = "Toxoid vaccines use inactivated toxins to target the toxic activity created by the bacteria, \n" +
            "rather than targeting the bacteria itself.";
    /**
     * The constant TECH_5.
     */
    public static final String TECH_5 = "Viral vector vaccines";
    /**
     * The constant TECH_5_TYPE.
     */
    public static final String TECH_5_TYPE = "Viral vector vaccines use a harmless virus to deliver to the hosts\n" +
            " cells the genetic code of the antigen you want the immune system to fight";
    /**
     * The constant TECH_6.
     */
    public static final String TECH_6 = "Messenger RNA (mRNA) vaccines";
    /**
     * The constant TECH_6_TYPE.
     */
    public static final String TECH_6_TYPE = "When an mRNA vaccine is delivered, the RNA material\n" +
            " teaches our body how to make a specific type of protein that is unique to the virus, but\n" +
            " does not make the person sick. The protein triggers an immune response, which includes the generation\n " +
            "of antibodies that recognize the protein. That way, if a person is ever exposed to that virus in the future,\n " +
            "the body would like have the tools (antibodies) to fight against it.4";

    /**
     * The constant MAX_CODE.
     */
    public static final int MAX_CODE = 5;
    /**
     * The constant DOSES_VACCINE_TYPE_1.
     */
    public static final int DOSES_VACCINE_TYPE_1 = 3;
    /**
     * The constant DOSES_VACCINE_TYPE_2.
     */
    public static final int DOSES_VACCINE_TYPE_2 = 3;
    /**
     * The constant DOSES_VACCINE_TYPE_3.
     */
    public static final int DOSES_VACCINE_TYPE_3 = 3;
    /**
     * The constant TIME_BETWEEN_FIRST_DOSE_AND_SECOND.
     */
    public static final int TIME_BETWEEN_FIRST_DOSE_AND_SECOND = 21;
    /**
     * The constant TIME_BETWEEN_SECOND_DOSE_AND_THIRD.
     */
    public static final int TIME_BETWEEN_SECOND_DOSE_AND_THIRD = 180;


    /**
     * The constant VACCINE_1.
     */
    public static final String VACCINE_1 = "Covid- 19 Vaccine";
    /**
     * The constant VACCINE_TYPE_1.
     */
    public static final String VACCINE_TYPE_1 = "Pfizer vaccine";
    /**
     * The constant VACCINE_TYPE_2.
     */
    public static final String VACCINE_TYPE_2 = "Moderna vaccine";
    /**
     * The constant VACCINE_TYPE_3.
     */
    public static final String VACCINE_TYPE_3 = "Astra Zeneca vaccine";
    /**
     * The constant VACCINE_2.
     */
    public static final String VACCINE_2 = "Denge Vaccine";
    /**
     * The constant VACCINE_3.
     */
    public static final String VACCINE_3 = "Tetanus Vaccine";
    /**
     * The constant VACCINE_4.
     */
    public static final String VACCINE_4 = "Smallpox Vaccine";


}
