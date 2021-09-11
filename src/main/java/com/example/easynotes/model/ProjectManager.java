/**
 * 
 */
package com.example.easynotes.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author Electem2
 *
 */
@Entity
public class ProjectManager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectManagerId;
	private String name;
	private String emailId;
	private String country;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="projectManagerId")
	private List<Project> projects=new ArrayList<Project>();
	/**
	 * @return the projectManagerId
	 */
	public Integer getProjectManagerId() {
		return projectManagerId;
	}
	/**
	 * @param projectManagerId the projectManagerId to set
	 */
	public void setProjectManagerId(Integer projectManagerId) {
		this.projectManagerId = projectManagerId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return projects;
	}
	/**
	 * @param projects the projects to set
	 */
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
