package endriu.projects.libra.model.Requests;

import endriu.projects.libra.model.UserType;

public class UpdateUserInfoRequest {

    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private String companyName;

    public UpdateUserInfoRequest() {}

    public UpdateUserInfoRequest(String name, String surname, String phoneNumber, String address, String companyName) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
