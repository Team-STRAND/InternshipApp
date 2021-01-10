package endriu.projects.libra.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Comment")
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String text;
	private Date time;
	private String userName;
	@ManyToOne
	private Post post;
	
	public Comment() {
		super();
	}

	public Comment(String text, Date time, String userName, Post post) {
		super();
		this.text = text;
		this.time = time;
		this.userName = userName;
		this.post = post;
	}

	public Comment(int id, String text, Date time, String userName, Post post) {
		super();
		this.id = id;
		this.text = text;
		this.time = time;
		this.userName = userName;
		this.post = post;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
}
