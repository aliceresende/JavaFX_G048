package app.domain.model;

public class VaccinationCenter {

    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String faxNumber;
    private String websiteAddress;
    private Schedule centerSchedule;
    private String slotDuration;
    private String maxNumVaxPerSlot;

    /**
     * builds the center with it's information
     * @param name name of the center
     * @param address of the center
     * @param phoneNumber phone number of the SNS User
     * @param email email of the SNS User
     * @param faxNumber fax number of the center
     * @param websiteAddress website address of the center
     * @param centerSchedule center's schedule
     * @param slotDuration vaccine slots on the center
     * @param maxNumVaxPerSlot maximum number of vaccines that can be given per slot
     */

    public VaccinationCenter(String id,String name, String address, String phoneNumber, String email, String faxNumber, String websiteAddress, Schedule centerSchedule, String slotDuration, String maxNumVaxPerSlot) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.faxNumber = faxNumber;
        this.websiteAddress = websiteAddress;
        this.centerSchedule = new Schedule(centerSchedule);
        this.slotDuration = slotDuration;
        this.maxNumVaxPerSlot = maxNumVaxPerSlot;
    }

    /**
     * Returns the id from the vaccination center
     * @return the id from the vaccination center
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name from the vaccination center
     * @return the name from the vaccination center
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the phone number of the vaccination center
     * @return the phone number of the vaccination center
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the email from the vaccination center
     * @return the email from the vaccination center
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the fax number from the vaccination center
     * @return the fax number from the vaccination center
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Returns the website from the vaccination center
     * @return the website from the vaccination center
     */
    public String getWebsiteAddress() {
        return websiteAddress;
    }

    /**
     * Returns the center schedule from the vaccination center
     * @return the center schedule from the vaccination center
     */
    public Schedule getCenterSchedule() {
        return centerSchedule;
    }

    /**
     * Returns the slot duration from the vaccination center
     * @return the slot duration from the vaccination center
     */
    public String getSlotDuration() {
        return slotDuration;
    }

    /**
     * Returns the max number of vaccines per slot from the vaccination center
     * @return the max number of vaccines per slot from the vaccination center
     */
    public String getMaxNumVaxPerSlot() {
        return maxNumVaxPerSlot;
    }

    /**
     * Returns the address from the vaccination center
     * @return
     */
    public String getAddress() {
        return address;
    }
}
