package app.domain.model;

/**
 * The type Address.
 */
public class Address {

    private String street;

    private String doorNumber;

    private String postCode;

    private String city;

    /**
     * Instantiates a new Address.
     *
     * @param street     the street
     * @param doorNumber the door number
     * @param postCode   the post code
     * @param city       the city
     */
    public Address(String street, String doorNumber, String postCode, String city) {
        this.street = street;
        this.doorNumber = doorNumber;
        this.postCode = postCode;
        this.city = city;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street.
     *
     * @param street the street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets door number.
     *
     * @return the door number
     */
    public String getDoorNumber() {
        return doorNumber;
    }

    /**
     * Sets door number.
     *
     * @param doorNumber the door number
     */
    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    /**
     * Gets post code.
     *
     * @return the post code
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets post code.
     *
     * @param postCode the post code
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("\nStreet: %s\nDoor number: %s\nPost Code: %s\nCity: %s",
                street,doorNumber,postCode,city);
    }
}
