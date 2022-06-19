package app.mappers.dto;

import app.domain.model.VaccinationCenter;

public class ArrivalOfSNSUserDTO {
    private String SNSUserNumber;
    private String timeOfArrival;
    private String vCenterName;


    /**
     * Builds an instance of the SNS user arrival DTO receiving the SNS user number, the time of arrival and the vaccination center
     * @param SNSUserNumber the SNS user number of the SNS User arrival DTO
     * @param timeOfArrival the time of arrival of the SNS User arrival DTO
     * @param vCenterName the vaccination center of the SNS User arrival DTO
     */
    public ArrivalOfSNSUserDTO(String SNSUserNumber, String timeOfArrival, String vCenterName) {
        this.SNSUserNumber = SNSUserNumber;
        this.timeOfArrival = timeOfArrival;
        this.vCenterName = vCenterName;
    }

    /**
     * Returns the SNS User number of the SNS User arrival DTO
     * @return the SNS User number of the SNS User arrival DTO
     */
    public String getSNSUserNumber() {
        return SNSUserNumber;
    }

    /**
     * Returns the time of arrival of the SNS User arrival DTO
     * @return the time of arrival of the SNS User arrival DTO
     */
    public String getTimeOfArrival() {
        return timeOfArrival;
    }

    /**
     * Returns the vaccination center DTO of the SNS USer arrival
     * @return the vaccination center DTO of the SNS USer arrival
     */
    public String getvCenterDTO() {
        return vCenterName;
    }


    @Override
    public String toString() {
        return   "SNSUserNumber: " + SNSUserNumber  + ", timeOfArrival: " + timeOfArrival  + ", vCenterName: " + vCenterName + "\n";

    }

    public String getvCenterName() {
        return vCenterName;
    }

    public void setvCenterName(String vCenterName) {
        this.vCenterName = vCenterName;
    }
}
