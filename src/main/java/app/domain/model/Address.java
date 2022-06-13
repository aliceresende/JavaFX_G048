package app.domain.model;

public class Address {

    private String street;

    private String doorNumber;

    private String postCode;

    private String city;

    public Address(String street, String doorNumber, String postCode, String city) {
        this.street = street;
        this.doorNumber = doorNumber;
        this.postCode = postCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("\nStreet: %s\nDoor number: %s\nPost Code: %s\nCity: %s",
                street,doorNumber,postCode,city);
    }
}
