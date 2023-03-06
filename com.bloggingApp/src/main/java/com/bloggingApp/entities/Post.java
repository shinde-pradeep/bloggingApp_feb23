package com.bloggingApp.entities;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="post_details")
public class Post {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
	
	@Column(name="post_title",nullable = false, length = 225)
	private String pTitle;

	private String pContent;

	private String pImageName;
	
	private Date pAddedDate;


	
//.........................................................................
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
	
	
	
//.........................................................................
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}


//.........................................................................

	
	public int getpId() {
		return pId;
	}



	public void setpId(int pId) {
		this.pId = pId;
	}



	public String getpTitle() {
		return pTitle;
	}



	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}



	public String getpContent() {
		return pContent;
	}



	public void setpContent(String pContent) {
		this.pContent = pContent;
	}



	public String getpImageName() {
		return pImageName;
	}



	public void setpImageName(String pImageName) {
		this.pImageName = pImageName;
	}



	public Date getpAddedDate() {
		return pAddedDate;
	}



	public void setpAddedDate(Date pAddedDate) {
		this.pAddedDate = pAddedDate;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	

}
