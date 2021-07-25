package com.iktpreobuka.dnevnikProjekat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity {
			
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		protected Integer id;
		
		
		protected String userName;
		
	
		protected String password;
		
		
		public UserEntity() {
			super();
			}


		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

}
