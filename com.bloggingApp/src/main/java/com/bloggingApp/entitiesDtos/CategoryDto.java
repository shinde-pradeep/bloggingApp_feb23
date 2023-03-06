package com.bloggingApp.entitiesDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {


		
		private int cId;
		
		@NotBlank
		@Size (min=4, max=225, message = "category title should contains min-4 & max-225 characters")
		private String cTitle;
		
		@Size (min=4, max=225, message = "category description can have max-225 characters only")
		private String cDescription;

	//..........................................................
		
		public CategoryDto() {
			super();
			// TODO Auto-generated constructor stub
		}

	//...........................................................
		
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

		
		
		
		
		
		
}

