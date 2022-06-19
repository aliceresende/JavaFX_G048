package app.mappers.dto;

import app.domain.model.AdministrationProcess;

import java.util.ArrayList;

public class VaccineDTO {

    private String code;
    private String designation;
    private String VaccineType;
    private ArrayList<String> AgeGroup = new ArrayList<String>();
    private String intv;
    private String description;
    private String disease;
    private ArrayList<AdministrationProcess> administration = new ArrayList<AdministrationProcess>();

    public VaccineDTO( String code, String designation, String VaccineType, ArrayList<String> AgeGroup, String intv, String disease,
                    String description, ArrayList<AdministrationProcess> administration){
        this.code = code;
        this.designation = designation;
        this.VaccineType = VaccineType;
        this.intv=intv;
        this.description = description;
        this.disease = disease;
        this.AgeGroup = AgeGroup;
        this.administration = administration;
    }

    public VaccineDTO(ArrayList<AdministrationProcess> administration, String disease,String designation) {
        this.administration = administration;
        this.disease = disease;
        this.designation = designation;
    }

    public ArrayList<String> getAgeGroup() {
        return AgeGroup;
    }
    public ArrayList<AdministrationProcess> getAdministration() {
        return administration;
    }
    public String get_designation(){
        return this.designation;
    }
    public String get_type(){
        return this.VaccineType;
    }
    public String get_code(){return this.code;}
    public String get_description(){return this.description;}

    public String get_disease(){return this.disease;}

    @Override
    public String toString() {
        return "VaccineDTO{" +
                "designation='" + designation + '\'' +
                '}';
    }
}
