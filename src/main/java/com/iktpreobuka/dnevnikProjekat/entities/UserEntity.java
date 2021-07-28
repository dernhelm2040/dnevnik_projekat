package com.iktpreobuka.dnevnikProjekat.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity {
			
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		protected Integer id;
		
		@Column(name = "username", nullable = false)
		protected String userName;
		
		@Column(name = "password", nullable = false)
		protected String password;
		
		@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
		@JoinColumn(name = "role")
		private RoleEntity role;
		
		
		public UserEntity() {
			super();
			
		}
		
		
		public RoleEntity getRole() {
			return role;
		}



		public void setRole(RoleEntity role) {
			this.role = role;
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
