package endriu.projects.libra.model.Responses;

import endriu.projects.libra.model.User;
import endriu.projects.libra.model.UserType;

public class AuthenticationResponse {

    private int id;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private String companyName;
    private UserType type;
    private boolean active;
    private String roles;

    public AuthenticationResponse() {}

    public AuthenticationResponse(User userData) {
        this.id = userData.getId();
        this.email = userData.getUserName();
        this.name = userData.getName();
        this.surname = userData.getSurname();
        this.phoneNumber = userData.getPhoneNumber();
        this.address = userData.getAddress();
        this.companyName = userData.getCompanyName();
        this.type = userData.getType();
        this.active = userData.isActive();
        this.roles = userData.getRoles();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}

