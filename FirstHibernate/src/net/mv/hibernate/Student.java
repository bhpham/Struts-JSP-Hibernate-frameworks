package net.mv.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	private int s_id;
	
	@Column
	private String name;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="STUDENT_COURSE",
				joinColumns={@JoinColumn(name="S_ID")},
				inverseJoinColumns={@JoinColumn(name="C_ID")})
	private Set<Course> courses = new HashSet<Course>();

	public Student() {}

	public Student(int s_id, String name) {
		super();
		this.s_id = s_id;
		this.name = name;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", name=" + name + ", courses="
				+ courses + "]";
	}


	
	


}
