package net.mv.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Forum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqForumIDKey")
	@SequenceGenerator(name = "seqForumIDKey", sequenceName = "SEQ_FORUMID_KEY", allocationSize = 1)
	private int f_id;
	
	@Column(unique=true)
	private String title;
	
	@Column
	private String f_desc;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="forum", targetEntity=Reply.class)
	private Set<Reply> replies;
	
	public Forum() {}

	public Forum(int f_id, String title, String f_desc, User user) {
		super();
		this.f_id = f_id;
		this.title = title;
		this.f_desc = f_desc;
		this.user = user;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getF_desc() {
		return f_desc;
	}

	public void setF_desc(String f_desc) {
		this.f_desc = f_desc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "Forum [f_id=" + f_id + ", title=" + title + ", f_desc="
				+ f_desc + ", user=" + user + ", replies=" + replies + "]";
	}

		
}
