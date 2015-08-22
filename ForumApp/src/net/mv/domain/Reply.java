package net.mv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReplyIDKey")
	@SequenceGenerator(name = "seqReplyIDKey", sequenceName = "SEQ_REPLYID_KEY", allocationSize = 1)
	private int r_id;
	
	@Column
	private String r_desc;
	
	@ManyToOne
	@Cascade({CascadeType.ALL})
    @JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@Cascade({CascadeType.ALL})
    @JoinColumn(name="forum_id")
	private Forum forum;

	public Reply() {}

	public Reply(int r_id, String r_desc, User user, Forum forum) {
		super();
		this.r_id = r_id;
		this.r_desc = r_desc;
		this.user = user;
		this.forum = forum;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_desc() {
		return r_desc;
	}

	public void setR_desc(String r_desc) {
		this.r_desc = r_desc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	
	@Override
	public String toString() {
		return "Reply [r_id=" + r_id + ", r_desc=" + r_desc + ", user=" + user
				+ ", forum=" + forum + "]";
	}

	
}
