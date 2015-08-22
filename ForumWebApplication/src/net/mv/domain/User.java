package net.mv.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="User_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUserIDKey")
	@SequenceGenerator(name = "seqUserIDKey", sequenceName = "SEQ_USERID_KEY", allocationSize = 1)
	private int u_id;
	
	@Column(unique=true)
	private String username;
	
	@Column
	private String password;
	
	@Column
	private int age;
	
	@Column
	private String email;
	
	@OneToMany(mappedBy="user", targetEntity=Forum.class)
	private Set<Forum> forums;
	
	@OneToMany(mappedBy="user", targetEntity=Reply.class)
	private Set<Reply> replies;
	
	
	public User() {}

	public User(int u_id, String username, String password, int age,
			String email) {
		super();
		this.u_id = u_id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
	}

	public int getu_id() {
		return u_id;
	}

	public void setu_id(int u_id) {
		this.u_id = u_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Set<Forum> getForums() {
		return forums;
	}

	public void setForums(Set<Forum> forums) {
		this.forums = forums;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", username=" + username + ", password="
				+ password + ", age=" + age + ", email=" + email + "]";
	}
	

	
}
