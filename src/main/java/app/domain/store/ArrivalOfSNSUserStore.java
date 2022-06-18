package app.domain.store;

import app.domain.model.ArrivalOfSNSUser;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Arrival of sns user store.
 */
public class ArrivalOfSNSUserStore {
    private ArrayList<ArrivalOfSNSUser> knows = new ArrayList<>();

    /**
     * Instantiates a new Arrival of sns user store.
     */
    public ArrivalOfSNSUserStore() {}

    /**
     * Lists the arrivals of the SNS Users
     *
     * @param knows the knows
     */
    public ArrivalOfSNSUserStore(ArrayList<ArrivalOfSNSUser> knows) {
        this.knows = knows;
    }

    /**
     * This method creates the arrival of the SNS user with the SNS User number, time of arrival and vaccination center
     *
     * @param SNSUserNumber the SNS User number of the SNS User arrival
     * @param timeOfArrival the time of arrival of the SNS User arrival
     * @param vCenterDTO    the vaccination center of the SNS User arrival
     * @return the SNS User arrival information
     */
    public ArrivalOfSNSUser createArrivalOfSNSUser(String SNSUserNumber, String timeOfArrival, String vCenterDTO) {
          return new ArrivalOfSNSUser(SNSUserNumber,timeOfArrival, vCenterDTO);

    }
    /**
     * Adds a new SNS User arrival to the list
     * @param arrivalU the SNS User arrival data
     */
    private void addArrivalOfSNSUser(ArrivalOfSNSUser arrivalU) { knows.add(arrivalU); }

    /**
     * Checks the existence of duplicate entries
     *
     * @param arrival the arrival of the SNS User Arrival
     * @return true and warn that are duplicate entries, otherwise return false
     */
    public boolean checksDuplicatesEntries(ArrivalOfSNSUser arrival){
        for(ArrivalOfSNSUser arrivalU: knows){
            if(arrivalU.getSNSUserNumber().equals(arrival.getSNSUserNumber())){
                System.out.println("-----WARNING-----");
                System.out.println("Duplicate entries!");
                return true;
            }

        }
        return false;
    }

    /**
     * Checks if the SNS User is in the right center
     *
     * @param vCenterNameSchedule the vaccination center name of the schedule
     * @param arrival             the arrival of the SNS user
     * @return true if the SNS user isn't in the schedule vaccination center, otherwise return false
     */
    public boolean validateArrivalOfSNSUser(String vCenterNameSchedule, ArrivalOfSNSUser arrival){
        if(!arrival.getvCenterName().equals(vCenterNameSchedule)){
            System.out.println("-----WARNING-----");
            System.out.println("The SNS user is in the wrong vaccination center!");
            return true;
        }
        return false;
    }

    /**
     * Saves the SNS User arrival if there are no duplicate entries
     * and if the user is in the right vaccination center
     *
     * @param arrival               the arrival of the SNS User Arrival
     * @param vaccinationCenterName the vaccination center of the SNS User arrival
     */
    public void saveArrivalOfSNSUser(ArrivalOfSNSUser arrival, String vaccinationCenterName){
        if(!validateArrivalOfSNSUser(vaccinationCenterName,arrival) && !checksDuplicatesEntries(arrival)){
            checksDuplicatesEntries(arrival);
            addArrivalOfSNSUser(arrival);
            System.out.println(arrival.toString());
            System.out.println("The arrival of the SNS user was registered with success!");
        }

    }

    /**
     * This method returns the list of SNSUsers that have arrived
     *
     * @return the ArrayList containing the SNSUsers that have arrived
     */
    public ArrayList<ArrivalOfSNSUser> GetArrivalOfSNSUsers(){
        return knows;
    }

}
