package app.mappers.dto;

import app.domain.model.Schedule;

public class VaccinationCenterDTO {
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
     * Builds an instance of the Vaccination Center DTO receiving the id, name, address, phone number, email, fax, website, center schedule, slot duration and max of vaccines per slot
     * @param id the id of the Vaccination center DTO
     * @param name the name of the Vaccination center DTO
     * @param address the address of the Vaccination center DTO
     * @param phoneNumber the phone number of the Vaccination center DTO
     * @param email the email of the Vaccination center DTO
     * @param faxNumber the fax number of the Vaccination center DTO
     * @param websiteAddress the website address of the Vaccination center DTO
     * @param centerSchedule the center schedule of the Vaccination center DTO
     * @param slotDuration the slot duration of the Vaccination center DTO
     * @param maxNumVaxPerSlot the max number of vaccines per slot of the Vaccination center DTO
     */
    public VaccinationCenterDTO(String id, String name, String address, String phoneNumber, String email, String faxNumber, String websiteAddress, Schedule centerSchedule, String slotDuration, String maxNumVaxPerSlot) {
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
     * Returns the id of the vaccination center DTO
     * @return the id of the vaccination center DTO
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the vaccination center DTO
     * @return the name of the vaccination center DTO
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the address of the vaccination center DTO
     * @return the address of the vaccination center DTO
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the phone number of the vaccination center DTO
     * @return the phone number of the vaccination center DTO
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the email of the vaccination center DTO
     * @return the email of the vaccination center DTO
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the fax number of the vaccination center DTO
     * @return the fax number of the vaccination center DTO
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Returns the website address of the vaccination center DTO
     * @return the website of the vaccination center DTO
     */
    public String getWebsiteAddress() {
        return websiteAddress;
    }

    /**
     * Returns the center schedule of the vaccination center DTO
     * @return the center schedule of the vaccination center DTO
     */
    public Schedule getCenterSchedule() {
        return centerSchedule;
    }

    /**
     * Returns the slot duration of the vaccination center DTO
     * @return the slot duration of the vaccination center DTO
     */
    public String getSlotDuration() {
        return slotDuration;
    }

    /**
     * Returns the max number of vaccines per slot of the vaccination center DTO
     * @return the max number of vaccines per slot of the vaccination center DTO
     */
    public String getMaxNumVaxPerSlot() {
        return maxNumVaxPerSlot;
    }
}
