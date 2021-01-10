package endriu.projects.libra.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Post")
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@Enumerated(EnumType.STRING)
	private DomainType domain;
	private String requirements;
	private Integer duration;
	private Integer numberOfApplicants;
	private Boolean paid;
	private String information;
	private String companyEmail;
	@JsonIgnore
	@OneToMany(mappedBy="post")
	private List<Comment> comments;
	@JsonIgnore
	@ManyToOne
	private User creator;
	
	public Post() {
		super();
	}

	public Post(DomainType domain, String requirements, Integer duration, Integer numberOfApplicants,
			Boolean paid, String information, String companyEmail, List<Comment> comments,
			User creator) {
		super();
		this.domain = domain;
		this.requirements = requirements;
		this.duration = duration;
		this.numberOfApplicants = numberOfApplicants;
		this.paid = paid;
		this.information = information;
		this.companyEmail = companyEmail;
		this.comments = comments;
		this.creator = creator;
	}

	public Post(int id, DomainType domain, String requirements, Integer duration, Integer numberOfApplicants,
			Boolean paid, String information, String companyEmail, List<Comment> comments,
			User creator) {
		super();
		this.id = id;
		this.domain = domain;
		this.requirements = requirements;
		this.duration = duration;
		this.numberOfApplicants = numberOfApplicants;
		this.paid = paid;
		this.information = information;
		this.companyEmail = companyEmail;
		this.comments = comments;
		this.creator = creator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DomainType getDomain() {
		return domain;
	}

	public void setDomain(DomainType domain) {
		this.domain = domain;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getNumberOfApplicants() {
		return numberOfApplicants;
	}

	public void setNumberOfApplicants(Integer numberOfApplicants) {
		this.numberOfApplicants = numberOfApplicants;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	public void removeComment(Comment comment) {
		this.comments.remove(comment);
	}
}
