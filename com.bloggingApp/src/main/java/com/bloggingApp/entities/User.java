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
@Table (name="user_information")
public class User {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private long userId;
	
//length---(Optional) The column length. (Applies only if a string-valued column is used.)...default length=225
	
	@Column(name="user_nname", length=225, nullable=false)
	private String userName;
	
	@Column(length=225, nullable=false, unique = true)
	private String userMail;
	
	private String userPassword;
	
	private String userAbout;

	
//.........................................................................
	
  @OneToMany (mappedBy = "user",
		       cascade = CascadeType.ALL,
		         fetch = FetchType.EAGER )	
  private List<Post> posts = new ArrayList<>();	
	
	
	
//NoArgsConstructor.....................................................
		
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
//Getter and Setter......................................................	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAbout() {
		return userAbout;
	}

	public void setUserAbout(String userAbout) {
		this.userAbout = userAbout;
	}


	public List<Post> getPosts() {
		return posts;
	}


	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}



	
	
}
