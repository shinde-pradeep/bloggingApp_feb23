
package com.blogging.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="user_info")
public class User {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int uId;
	
	@Column (name = "user_name",length = 255)
	private String uName;
	
	@Column (name = "user_gmail",length = 255)
	private String uMail;
	
	@Column (name = "user_pass",length = 255)
	private String uPass;
	
	@Column (name = "user_info",length = 255)
	private String uAbout;
	
	
}
