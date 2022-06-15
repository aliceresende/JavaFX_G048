package app.domain.model;

/**
 * The type Comunity mass vaccination center.
 */
public class ComunityMassVaccinationCenter extends VaccinationCenter {


    /**
     * builds the center with it's information
     *
     * @param id               the id
     * @param name             name of the center
     * @param address          of the center
     * @param phoneNumber      phone number of the SNS User
     * @param email            email of the SNS User
     * @param faxNumber        fax number of the center
     * @param websiteAddress   website addres of the center
     * @param centerSchedule   center's schedule
     * @param slotDuration     vaccine slots on the center
     * @param maxNumVaxPerSlot maximum number of vaccines that can be given per slot
     */
    public ComunityMassVaccinationCenter(String id, String name, String address, String phoneNumber, String email, String faxNumber, String websiteAddress, Schedule centerSchedule, String slotDuration, String maxNumVaxPerSlot) {
        super(id, name, address, phoneNumber, email, faxNumber, websiteAddress, centerSchedule, slotDuration, maxNumVaxPerSlot);
    }



}
