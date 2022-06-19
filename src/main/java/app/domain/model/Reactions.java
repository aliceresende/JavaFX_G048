package app.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
public class Reactions implements Serializable{
    String snsnumber;
    String sns_name;
    String allergy;
    String Vaccine_reaction;
    String anaphylactic_reaction;
    String blood_clotting_disorders;
    String immunodeficiency;
    String chemo;
    String this_vaccine;


    public Reactions(String snsnumber,String sns_name,String allergy,String Vaccine_reaction,String anaphylactic_reaction,String blood_clotting_disorders,
                     String immunodeficiency, String chemo, String this_vaccine){
        this.allergy=allergy;
        this.Vaccine_reaction=Vaccine_reaction;
        this.anaphylactic_reaction=anaphylactic_reaction;
        this.blood_clotting_disorders=blood_clotting_disorders;
        this.immunodeficiency=immunodeficiency;
        this.chemo=chemo;
        this.this_vaccine=this_vaccine;
        this.snsnumber=snsnumber;
        this.sns_name=sns_name;

    }

    @Override
    public String toString() {
        return "Reactions{" +
                "snsnumber='" + snsnumber + '\'' +
                ", sns_name='" + sns_name + '\'' +
                ", allergy='" + allergy + '\'' +
                ", Vaccine_reaction='" + Vaccine_reaction + '\'' +
                ", anaphylactic_reaction='" + anaphylactic_reaction + '\'' +
                ", blood_clotting_disorders='" + blood_clotting_disorders + '\'' +
                ", immunodeficiency='" + immunodeficiency + '\'' +
                ", chemo='" + chemo + '\'' +
                ", Any adverse reaction to the vaccine about to be administered =>'" + this_vaccine + '\'' +
                '}';
    }


    public String getAllergy() {
        return allergy;
    }

    public String getVaccine_reaction() {
        return Vaccine_reaction;
    }

    public String getAnaphylactic_reaction() {
        return anaphylactic_reaction;
    }

    public String getBlood_clotting_disorders() {
        return blood_clotting_disorders;
    }

    public String getSnsnumber() {
        return snsnumber;
    }

    public String getSns_name() {
        return sns_name;
    }

    public String getImmunodeficiency() {
        return immunodeficiency;
    }

    public String getChemo() {
        return chemo;
    }

    public String getThis_vaccine() {
        return this_vaccine;
    }
    public void checkRules(List<SNSUser> user){
        boolean res;
        int count=0;
        for (SNSUser U : user){
            res=snsnumber.equals(U.getSnsUserNumber());
            if (res==true){
                count++;
            }
        }
        if(count==0){
            throw new IllegalArgumentException("SNS User does not exist in the data base");
        }
    }
}
