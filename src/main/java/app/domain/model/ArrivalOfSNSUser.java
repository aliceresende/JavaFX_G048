package app.domain.model;

/**
 * The type Arrival of sns user.
 */
public class ArrivalOfSNSUser {
    private String SNSUserNumber;
    private String timeOfArrival;
    private String vCenterName;


    /**
     * Builds an instance of the SNS user arrival receiving the SNS user number,the time of arrival and the vaccination center
     *
     * @param SNSUserNumber the SNS user number of the SNS User arriving
     * @param timeOfArrival the time of arrival of the SNS User to the vaccination center
     * @param vCenterName   the vaccination center where the user is currently in
     */
    public ArrivalOfSNSUser(String SNSUserNumber, String timeOfArrival, String vCenterName) {
        this.SNSUserNumber = SNSUserNumber;
        this.timeOfArrival = timeOfArrival;
        this.vCenterName = vCenterName;
    }

    /**
     * Returns the SNS user number from the SNS User arrival
     *
     * @return the SNS user number from the SNS User arrival
     */
    public String getSNSUserNumber() {
        return SNSUserNumber;
    }

    /**
     * Returns the time of arrival from the SNS User arrival
     *
     * @return the time of arrival from the SNS User arrival
     */
    public String getTimeOfArrival() {
        return timeOfArrival;
    }

    /**
     * Returns the vaccination center from the SNS User arrival
     *
     * @return the vaccination center from the SNS User arrival
     */
    public String getvCenterName() {
        return vCenterName;
    }

    /**
     * Returns the textual description of the SNS user arrival
     * @return SNS User arrival features
     */
    @Override
    public String toString() {
        return "\nArrival Of SNS User\n" +
                "SNS User Number = " + SNSUserNumber +
                "\nTime Of Arrival = " + timeOfArrival +
                "\nVaccination center = " + vCenterName +"\n";
    }
}
