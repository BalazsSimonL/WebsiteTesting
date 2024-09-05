package websiteBase;


import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class DTO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String date;
    private String phoneNumber;
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String stateOfProvince;
    private String postalCode;
    private String country;

    static Faker faker = new Faker();


    public static DTO createCustomerDTO() {
        DTO customerDTO = new DTO();
        customerDTO.setFirstName(faker.name().firstName());
        customerDTO.setLastName(faker.name().lastName());
        customerDTO.setPassword(faker.internet().password());
        customerDTO.setEmail(faker.internet().emailAddress());
        customerDTO.setDate(new SimpleDateFormat("yyyy-MM-dd").format(faker.date().birthday()));
        customerDTO.setPhoneNumber(faker.numerify("###########"));
        customerDTO.setStreetAddress1(faker.address().streetAddress());
        customerDTO.setStreetAddress2(faker.address().streetAddress());
        customerDTO.setCity(faker.address().city());
        customerDTO.setStateOfProvince(faker.address().state());
        customerDTO.setPostalCode(faker.address().zipCode());
        customerDTO.setCountry(faker.address().country());
        return customerDTO;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOfProvince() {
        return stateOfProvince;
    }

    public void setStateOfProvince(String stateOfProvince) {
        this.stateOfProvince = stateOfProvince;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
