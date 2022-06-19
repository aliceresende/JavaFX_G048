package app.store;


import app.domain.model.*;
import app.domain.shared.Constants;

import app.domain.model.ComunityMassVaccinationCenter;
import app.domain.model.Schedule;
import app.ui.Persistence;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VaccinationCenterStore {

    private static ComunityMassVaccinationCenter currentCenter;
    private static List<ComunityMassVaccinationCenter> knows = new ArrayList<ComunityMassVaccinationCenter>();

    public VaccinationCenterStore() {
        try{
            knows = (List<ComunityMassVaccinationCenter>) Persistence.readObjectFromFile("VaccinationCenter.bin");
        }catch (Exception e){
            //System.out.println("The clientStore was not loaded :)");
        }

    }

    public List<ComunityMassVaccinationCenter> getKnows() {
        return knows;
    }

    /**
     * Creates center and schedule
     * @param name name of the center
     * @param address of the center
     * @param phoneNumber phone number of the SNS User
     * @param email email of the SNS User
     * @param faxNumber fax number of the center
     * @param websiteAdress website addres of the center
     * @param openingHour opening hour of the center
     * @param closingHour closing hour of the center
     * @param slotDuration vaccine slots on the center
     * @param maxNumVaxPerSlot maximum number of vaccines that can be given per slot
     */
    public  ComunityMassVaccinationCenter RegistersCenter(String id,String name, String address, String phoneNumber, String email, String faxNumber, String websiteAdress, String openingHour, String closingHour, String slotDuration, String maxNumVaxPerSlot){

        Schedule sche = new Schedule(openingHour,closingHour);
        ComunityMassVaccinationCenter center = new ComunityMassVaccinationCenter(id,name,address,phoneNumber,email,faxNumber,websiteAdress,sche,slotDuration,maxNumVaxPerSlot);

        return center;
    }

    /**
     * Validates the center data and increments a center.
     * @param center the center data of the center
     * @return true if the center data is valid and false otherwise
     */

    public  boolean ValidateCenter(ComunityMassVaccinationCenter center){
        boolean verification= true;
        if (center == null)
            return false;

        int i = 0;
        for (ComunityMassVaccinationCenter cen : knows) {
            if (center.getAddress().equals(knows.get(i).getAddress())) {
                verification = false;
                break;
            }
            i++;
        }
        if ( verification == false){
            System.out.println("falso");
        }



        return verification;

    }

    /**
     * Saves a center
     * @param center the center data
     */

    public  void SaveCenter(ComunityMassVaccinationCenter center){
        if (ValidateCenter(center)) {
            knows.add(center);
            System.out.print("Success!");
        }else {
            System.out.println("This center is already registered");
        }
    }


    //necessario para testagem do modulo SaveCenter().

    public List<ComunityMassVaccinationCenter> ArrayListGetter(){
        return knows;
    }
/*
   public static void Show(){
        int i = 0;
        for(ComunityMassVaccinationCenter cen : knows){
            System.out.println(knows.get(i));
            i++;
        }
    }
*/

    /**
     * Returns the vaccination center selected by the name
     * @param centerName
     * @return the vaccination center selected by the name
     */
    public ComunityMassVaccinationCenter getVaccinationCenter(String centerName) {
        for(ComunityMassVaccinationCenter vC: knows){
            if(vC.getName().equals(centerName)){
                return vC;
            }
        }
        return null;
    }

    /**
     * Returns the current vaccination center
     * @return the current vaccination center
     */
    public ComunityMassVaccinationCenter getCurrentCenter() { return currentCenter;}

    /**
     * Modified the current center
     * @param currentCenter
     */
    public void setCurrentCenter(ComunityMassVaccinationCenter currentCenter) {
        this.currentCenter = currentCenter;
    }


    public int[] countArrivalsByInterval(int interval, List<ArrivalOfSNSUser> list) {
        int nOfArrivals, index=0, position;
        int[] arrivals = new int[Constants.TOTAL_MINUTES/interval];
        for(int i = 0; i < arrivals.length; i++){
            position = convertToMinutes(Constants.OPEN_HOUR) + (i+1)*interval;
            nOfArrivals=0;
            while(index < list.size() && convertToMinutes(splitDateFromTime(list.get(index).getTimeOfArrival())) < position){ //length -1
                nOfArrivals++;
                index++;
            }
            arrivals[i] = nOfArrivals;

        }
        return arrivals;
    }

    public int[] countExitsByInterval(int interval, List<Administration> list) {
        int nOfExits, index=0, position;
        int[] exits = new int[Constants.TOTAL_MINUTES/interval];
        for(int i = 0; i < exits.length; i++){
            position = convertToMinutes(Constants.OPEN_HOUR) + (i+1)*interval;
            nOfExits=0;
            while(index < list.size() && convertToMinutes(splitDateFromTime(list.get(index).getExitTime())) < position){ //length -1
                nOfExits++;
                index++;
            }
            exits[i] = nOfExits;

        }
        return exits;
    }
    public int convertToMinutes(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[HH][H]:mm");
        LocalTime time = LocalTime.parse(timeString, formatter);
        return time.getHour()*60 + time.getMinute();
    }

    public String splitDateFromTime(String str){
        String time=str.split("\\s")[1];
        return time;
    }
    public int[] inputtedList(int interval, List<ArrivalOfSNSUser> listA, List<Administration> listL){
        int[] differenceForInterval = new int[Constants.TOTAL_MINUTES/interval];
        int[] arrivalForInterval = countArrivalsByInterval(interval, listA);
        int[] exitForInterval = countExitsByInterval(interval, listL);
        for (int i = 0; i < arrivalForInterval.length; i++) {
            differenceForInterval[i] = arrivalForInterval[i] - exitForInterval[i];
        }
        return differenceForInterval;
    }



}
