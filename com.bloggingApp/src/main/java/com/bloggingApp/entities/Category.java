 package com.bloggingApp.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category_info")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	
	@Column (name="category_title",length = 225,nullable = false)
	private String cTitle;
	
	@Column (name="category_description",length = 225,nullable = false)
	private String cDescription;

	
//.........................................................................
@OneToMany (mappedBy="category",
            fetch = FetchType.EAGER,
            cascade=CascadeType.ALL)		
 private List<Post> posts=new ArrayList<>();
 
//......................................................	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

//......................................................


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public String getcDescription() {
		return cDescription;
	}

	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	
	
}
