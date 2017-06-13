package edd.floremipy.model;


public class User {
	private Long Id;
	private String identifiant;
	private String email;
	private String pwd;
	private UserRole role;   
	private Long idCustomer;
	
	
	public User(Long id, String identifiant, String email, String pwd, UserRole unRole, Long idCustomer) {
		super();
		Id = id;
		this.identifiant = identifiant;
		this.email = email;
		this.pwd = pwd;
		this.role = unRole;
		this.idCustomer = idCustomer;
	}
	
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
}
