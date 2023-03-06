package com.bloggingApp.entitiesDtos;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public class PostDto {


		
		private int pId;
		
		@NotBlank
		@Length(min=3, max= 225, message = "post title length must be min-3 & max-225")
		private String pTitle;
        
		@NotNull
		@Length(min=5, max= 225, message = "post content length must be min-5 & max-225")
		private String pContent;

		private String pImageName;
		
		private Date pAddedDate;

		
		private UserDto user;
		
		private CategoryDto category;
//........................................................
		
		public PostDto() {
			super();
			// TODO Auto-generated constructor stub
		}

//.........................................................
		
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
		
		
		
		
	

		public UserDto getUser() {
			return user;
		}

		public void setUser(UserDto user) {
			this.user = user;
		}

		public CategoryDto getCategory() {
			return category;
		}

		public void setCat(CategoryDto category) {
			this.category = category;
		}

		

}
