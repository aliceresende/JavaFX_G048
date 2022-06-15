package app.domain.model;

/**
 * The type Administration process.
 */
public class AdministrationProcess {

    private String Processcode;
    private String vaccine_name;
    private String ageGroup;
    private int doses;
    private int dosage;
    private String description;


    /**
     * Instantiates a new Administration process.
     *
     * @param Processcode  the processcode
     * @param vaccine_name the vaccine name
     * @param doses        the doses
     * @param ageGroup     the age group
     * @param dosage       the dosage
     * @param description  the description
     */
    public AdministrationProcess(String Processcode, String vaccine_name, int doses, String ageGroup, int dosage, String description){
        this.Processcode = Processcode;
        this.vaccine_name = vaccine_name;
        this.ageGroup = ageGroup;
        this.doses = doses;
        this.dosage = dosage;
        this.description = description;


    }
    public String toString() {
        return "Administration Process : \n"
                + "Code = " + this.Processcode +
                "\nVaccine name = " + this.vaccine_name +
                "\nAge group = " + this.ageGroup +
                "\nDoses= " + this.doses + "\nDosage To Be Administered = " + this.dosage + "ml"+
                "\nVaccine description: " + this.description + "\n";
    }
}
