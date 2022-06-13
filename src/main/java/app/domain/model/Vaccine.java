package app.domain.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Vaccine {

    private String code;
    private String designation;
    private String VaccineType;
    private ArrayList<String> AgeGroup = new ArrayList<String>();
    private String intv;
    private String description;
    private String disease;
    private ArrayList<AdministrationProcess> administration = new ArrayList<AdministrationProcess>();
    public Vaccine( String code, String designation, String VaccineType, ArrayList<String> AgeGroup, String intv, String disease,
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

    public String get_designation(){
        return this.designation;
    }
    public String get_type(){
        return this.VaccineType;
    }
    public String get_code(){return this.code;}
    public String get_description(){return this.description;}

    public String get_disease(){return this.disease;}

    /**Method to print Objects atributes*/
    public String toString() {
        return "\nVaccine : \n" + "Code = " + this.code + "\ndesignation = " + this.designation + "\nVaccineType = " + this.VaccineType
                + "\nAgeGroup:  " + this.AgeGroup + "\ninterval between:" +
                this.intv + "\ndescription = " + this.description +"\n\n--->" + this.administration + "\n";
    }
    /** Method that will sort the arraylist objetcs of NewVaccineStore*/
    public static Comparator<Vaccine> order = new Comparator<Vaccine>() {
        @Override
        public int compare(Vaccine o1, Vaccine o2) {
            int comp=0;
            String code1=o1.VaccineType;
            String code2=o2.VaccineType;
            comp=code1.compareTo(code2);
            if(comp==0){

                comp=o1.designation.toUpperCase().compareTo(o2.designation.toUpperCase());
            }

            return comp;

        }
    };
}
