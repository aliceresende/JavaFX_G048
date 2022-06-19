package app.store;
import app.domain.model.AdministrationProcess;
import app.domain.model.Vaccine;
import app.ui.Persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewVaccineStore {
    List<Vaccine> array1;
    ArrayList<String> age;
    ArrayList<AdministrationProcess> adm;
    Vaccine v;

    public NewVaccineStore() {
        this.array1 = new ArrayList<Vaccine>();
        this.age = new ArrayList<String>();
        try{
            array1 = (List<Vaccine>) Persistence.readObjectFromFile("Vaccine.bin");
        }catch (Exception e){
            //System.out.println("The clientStore was not loaded :)");
        }
       /* age.add("child");
        age.add("teenager");
        age.add("adult");
        age.add("old");
        this.adm = new ArrayList<AdministrationProcess>();
        adm.add(new AdministrationProcess("123", "varicela", 2, "child", 30, "cheiro"));

        array1.add(new Vaccine ("VAC-1234", "varicela (chickenpox) vaccine","12345", age, "6", "varicela", "The vaccine is given as 2 separate injections, usually into the upper arm, 4 to 8 weeks apart.", adm));
        //array1.add(new Vaccine ("VAC-1254", "influenza vaccine","Influenza Viruses", "12346", 6, 80, 4,"14 days", "Standard-dose quadrivalent influenza shots that are manufactured using virus grown in eggs. mal"));
        array1.add(new Vaccine ("VAC-1345", "hepatitis B", "12347", age, "4", "Hepatitis B","Immunization against hepatitis B disease is recommended for all newborn babies, infants, children, and adolescents up to 19 years of age.", adm));
        array1.add(new Vaccine ("VAC-1345", "hepatitis B a", "12347", age, "4", "Hepatitis B","Immunization against hepatitis B disease is recommended for all newborn babies, infants, children, and adolescents up to 19 years of age.", adm));
        //array1.add(new Vaccine ("VAC-1235", "Tetanus vaccine","Tetanus", "12348", 6, 80, 5, "14 days", "Doctors give this vaccine in a 5-shot series to babies and children 6 weeks through 6 years old."));
        array1.add(new Vaccine ("VAC-1252", "Johnson&Johnson ", "12349", age, "4", "COVID-19", "Administer a booster dose at least 2 months after the primary series dose (1st dose) or additional primary dose (2nd dose) for those who are moderately or severely immunocompromised.", adm));
        array1.add(new Vaccine ("VAC-2312", "ebola vaccine", "12349", age, "4", "Ebola", "prevention of disease caused by Zaire ebolavirus in individuals 18 years of age and older as a single dose administration", adm));
        //for (Vaccine v:array1){
        //    System.out.println(v);
       // }
        System.out.println("\n-----------------------I WAS HERE-----------------");*/
    }

    public Vaccine createVaccine(String code, String designation, String VaccineType, ArrayList<String> AgeGroup, String intv, String disease,
                                 String description, ArrayList<AdministrationProcess> administration) {
        this.v = new Vaccine(code, designation, VaccineType, AgeGroup, intv, disease,  description, administration);
        return this.v;
    }

    public List<Vaccine> ArrayList(){
        return this.array1;
    }

    private boolean contains(Vaccine v) {
        if (this.array1.contains(v)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidateVaccine(Vaccine v) {
        if (v == null || contains(v)) {
            return false;
        }
        return true;
    }

    public boolean saveVaccine() {
        if (ValidateVaccine(this.v)) {
            add(v);
            return true;
        } else {
            return false;
        }
    }

    public boolean add(Vaccine v) {
        array1.add(v);
        return true;
    }

    public Vaccine getV() {
        return v;
    }

    public void setV(Vaccine v) {
        this.v = v;
    }


   public String toString() {
        StringBuilder listString = new StringBuilder();

        for (Vaccine s : array1) {
            listString.append(s.toString()).append(" \n");
            System.out.println(""+s);
        }

        return String.valueOf(listString);
    }
    /** This method searchs for a type name in NewVaccineType Store that equals to @param type*/
    public String findType(String type, NewVaccineTypeStore st_type){
        String res=("\nno type found");
        for (int i=0; i<st_type.array.size(); i++){

            if (type==st_type.array.get(i).getCode()){

                res = st_type.array.get(i).getType();
            };
        }
        return res;
    }
    /**This method sorts the arraylist of vaccines using the ordering method in Vaccine.order*/
    public void sort_ArrayList(){Collections.sort(array1, Vaccine.order);}

    /**This method Lists all the vaccines registered in the system divided by type
     *
     * @param st_type represents a object of the class NewVaccineTypeStore
     *
     */
    public void ListAll(NewVaccineTypeStore st_type){
        Vaccine Vtype;
        String type;
        String result;
        sort_ArrayList();
        for (int i=0; i<array1.size(); i++){
            Vtype=array1.get(i);
            type=array1.get(i).get_type();
            if(i==0||Vtype.get_type() != array1.get(i-1).get_type()){
                type = findType(type, st_type);
                System.out.println("\n------>Vaccine type List:" + type + "<------\n");
            }
            result=Vtype.toString();
            System.out.println(result);


        }
    }

    public List<Vaccine> getArray1(){
        return array1;
    }


    //---------------valid vaccine name-----------------------------------

    public boolean validPDVaccine(List<List<String>> csvInfo) {
        boolean val= true;
        for(List<String> lineInfo: csvInfo){
            val = vaccineNameExists(lineInfo);
            if(!val){
                return false;
            }
        }
        return true;
    }

    private boolean onlyLetters (String name){
        boolean letter = false;
        String[] numbers = name.split("");
        for (int i = 0; i < name.length(); i++) {
            if(numbers[i].matches("[a-zA-Z]")) { // verifica a existência de letras
                letter = true;
            }else{
                letter = false;
            }
        }
        return letter;
    }
    public boolean vaccineNameExists(List<String> lineInfo){
        boolean exists = false;
        String vaccineName = lineInfo.get(1);
        if (onlyLetters(vaccineName)){
            for (Vaccine vac : array1) {
                if (vaccineName.equals(vac.get_designation())) {  //exist name
                    exists = true;
                }
            }
        }
        return exists;
    }

    public List<Vaccine> getVaccineList() {
        return array1;
    }
}