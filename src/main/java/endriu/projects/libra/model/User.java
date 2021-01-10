package endriu.projects.libra.model;

import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private String companyName;
    @Enumerated(EnumType.STRING)
    private UserType type;
    private boolean active;
    private String roles;
    private String resumepath;
    @OneToMany(mappedBy="creator")
    private List<Post> postsCreated;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Students_Internships", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "post_id") }
    )
    private List<Post> internships;

    public User(int id, String userName, String password, String name, String surname, String phoneNumber, String address, String companyName, UserType type, boolean active, String roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.companyName = companyName;
        this.type = type;
        this.active = active;
        this.roles = roles;
        this.resumepath = "";
        this.postsCreated = new ArrayList<Post>();
        this.internships = new ArrayList<Post>();
    }

    public User(String userName, String password, String name, String surname, String phoneNumber, String address, String companyName, UserType type, boolean active, String roles) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.companyName = companyName;
        this.type = type;
        this.active = active;
        this.roles = roles;
        this.resumepath = "";
        this.postsCreated = new ArrayList<Post>();
        this.internships = new ArrayList<Post>();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public User setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public UserType getType() {
        return type;
    }

    public User setType(UserType type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setActive(boolean active) {
        this.active = active;
        return this;
    }

    public User setRoles(String roles) {
        this.roles = roles;
        return this;
    }

    public String getResumepath() {
        return resumepath;
    }

    public void setResumepath(String resumepath) {
        this.resumepath = resumepath;
    }
    
    public void addInternship(Post post) {
    	this.internships.add(post);
    }
    
    public void removeInternship(Post post) {
    	this.internships.remove(post);
    }
    
    public void addPostCreated(Post post) {
    	this.postsCreated.add(post);
    }
    
    public void removePostCreated(Post post) {
    	this.postsCreated.remove(post);
    }

	public List<Post> getPostsCreated() {
		return postsCreated;
	}

	public void setPostsCreated(List<Post> postsCreated) {
		this.postsCreated = postsCreated;
	}

	public List<Post> getInternships() {
		return internships;
	}

	public void setInternships(List<Post> internships) {
		this.internships = internships;
	}
}