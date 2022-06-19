package app.store;

import app.domain.model.Vaccine;
import app.domain.model.VaccineSchedule;
import app.ui.Persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VaccineScheduleStore {
    private ArrayList<VaccineSchedule> knows = new ArrayList<>();

    public VaccineScheduleStore() { //<--(ArrayList<VaccineSchedule> knows)

        try{
            knows = (ArrayList<VaccineSchedule>) Persistence.readObjectFromFile("VaccineShedule.bin");
        }catch (Exception e){
            //System.out.println("The clientStore was not loaded :)");
        }
       /* knows.add(new VaccineSchedule("Covid-19", "14-09-2022 12:00",  "Unilabs Aveiro", "1234567890"));
        knows.add(new VaccineSchedule("Hepatite B", "15-09-2022 13:00","Centro de Vacinação Coimbra","0987654321"));
        knows.add(new VaccineSchedule("Hepatite B", "15-09-2022 13:00","Centro de Vacinação Coimbra","0987854321"));*/



        this.knows = knows;
    }

    /**
     * Create a vaccine schedule with vaccine name, date, hour, vaccination center name and sns user number
     * @param vaccineName the name of the virus the vaccine was made for confronting
     * @param dateAndHour the date and hour scheduled for the vaccine
     * @param vaccinationCenterName the name of the vaccination center
     * @param snsUserNumber the number of the sns user that made the schedule
     * @return the Vaccine Schedule information
     */

    public VaccineSchedule createVaccineSchedule(String vaccineName, String dateAndHour, String vaccinationCenterName, String snsUserNumber) {
        knows.add(new VaccineSchedule(vaccineName, dateAndHour, vaccinationCenterName, snsUserNumber));
        return new VaccineSchedule(vaccineName, dateAndHour, vaccinationCenterName, snsUserNumber);
    }

    /**
     * Validates the vaccine schedule data and increments it
     * @param vaccineSchedule the scheduled vaccine data
     * @return true if the vaccine schedule data is valid false otherwise
     * @throws IllegalArgumentException if the vaccine was already scheduled
     */

    public boolean validateVaccineSchedule(VaccineSchedule vaccineSchedule) {
        if (vaccineSchedule == null) {
            return false;
        }
        for (VaccineSchedule vSchedule : knows) {
            if (vSchedule.equals(vaccineSchedule)) {
                throw new IllegalArgumentException("This vaccine as already been scheduled");
                //System.out.println("This SNS User already scheduled the " + vSchedule.getVaccineName() + " vaccine");
                //return false;
            }
        }
        return true;
    }

    /**
     * returns the vaccine schedule list
     * @return the vaccine schedule list
     */

    public List<VaccineSchedule> getVaccineScheduleList() {
        return knows;
    }

    /**
     * Saves a Vaccine Schedule
     * @param vaccineSchedule the vaccine schedule data
     */

    public void saveVaccineSchedule(VaccineSchedule vaccineSchedule) {
        if (validateVaccineSchedule(vaccineSchedule)) {
            addVaccineSchedule(vaccineSchedule);
        }
    }

    /**
     * Adds a new VaccineSchedule to the list
     * @param vaccineSchedule the vaccine schedule data
     * @return true and adds the vaccine schedule if fulfilled, otherwise returns false
     */

    private boolean addVaccineSchedule(VaccineSchedule vaccineSchedule) {
        int cont = 0;
        boolean check = true;
        if (vaccineSchedule != null) {
            for (VaccineSchedule vSchedule : knows) {
                if (knows.equals(vaccineSchedule)) {
                    check = false;
                    break;
                }
                cont++;
            }
            if (check) {
                knows.add(vaccineSchedule);
                return true;
            }
        }
        return false;
    }

    /**
     * Show the vaccine schedule data to the sns user
     * @param vaccineSchedule the vaccine schedule data
     * @return the data
     */

    public String showAuthenticationData(VaccineSchedule vaccineSchedule) {
        return String.format("\n\nVACCINE SCHEDULE DATA\n\nVaccine: %s\nDay and Hour: %s\nCenter: %s\n",
                vaccineSchedule.getVaccineName(), vaccineSchedule.getDateAndHour(), (vaccineSchedule.getVaccinationCenterName()));
    }

    /**
     * Returns the list of vaccine schedules
     * @return the list of vaccine schedules
     */
    public ArrayList<VaccineSchedule> getKnows() {
        return knows;
    }


    /**
     * Gets the list of the vaccine schedules
     * @param knows
     */
    public VaccineScheduleStore(ArrayList<VaccineSchedule> knows) {
        this.knows = knows;
    }

    /**
     * Returns the schedule of the SNS User by the SNS User number
     * @param SNSUserNumber the SNS user number from the vaccine schedule
     * @return the schedule of the SNS User by the SNS User number
     * @throws IllegalArgumentException if the SNS user doesn't exist
     */
    public String getVaccineScheduleBySNSUserNumber(String SNSUserNumber) {
        for(VaccineSchedule vSchedule : knows) {
            if(vSchedule.getSNSUserNumber().equals(SNSUserNumber)){
                return vSchedule.toString();
            }
        }
        throw new IllegalArgumentException("The SNS user number provided doesn't exist");
    }
    public VaccineSchedule getVaccineSchedule(String SNSUserNumber) {
        for(VaccineSchedule vSchedule : knows) {
            if(vSchedule.getSNSUserNumber().equals(SNSUserNumber)){
                return vSchedule;
            }
        }
        throw new IllegalArgumentException("The SNS user number provided doesn't exist");
    }

    /**
     * Returns the list with -1 element from the list
     * @param SNSUserNumber the SNS user number of the vaccine schedule
     * @return the list with -1 element from the list
     */
   public ArrayList<VaccineSchedule> removeVaccineSchedule(String SNSUserNumber){
        knows.removeAll(Collections.singleton(SNSUserNumber));
        return knows;
   }

    public void show(){
       for (VaccineSchedule vc:knows){
           System.out.println(vc);
       }
    }

    public void removeVaccineScheduleAfterVaccine(String SNSUserNumber){
        knows.removeAll(Collections.singleton(SNSUserNumber));
    }

}
