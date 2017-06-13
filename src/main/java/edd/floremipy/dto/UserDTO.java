package edd.floremipy.dto;

import java.io.Serializable;

import edd.floremipy.model.UserRole;

public class UserDTO implements Serializable {
	String identifiant;
	String email;
	UserRole role;
	public UserDTO() {
		super();
	}
	
	public UserDTO(String identifiant, String email, UserRole role) {
		super();
		this.identifiant = identifiant;
		this.email = email;
		this.role = role;
	}

	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	

}
