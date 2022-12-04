package si.fri.rso.samples.firstmicroservice.lib;

public class UserMetadata {

    private Integer id;

    private String firstname;

    private String lastname;

    private String address;

    private String city;

    public Integer id() {
        return id;
    }

    public void setPersonId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
