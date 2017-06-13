package edd.floremipy.dto;

import java.io.Serializable;

import edd.floremipy.model.UserRole;

public class UserDTO implements Serializable {
	String identifiant;
	String email;
	UserRole role;
	Long idCustomer;
	public UserDTO() {
		super();
		idCustomer=0L;
	}
	
	public UserDTO(String identifiant, String email, UserRole role, Long idCustomer ) {
		super();
		this.identifiant = identifiant;
		this.email = email;
		this.role = role;
		this.idCustomer = idCustomer;
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

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	

}
