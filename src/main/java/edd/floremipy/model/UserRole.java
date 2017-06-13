package edd.floremipy.model;

public enum UserRole {
	CLIENT,DIRECTEUR,JARDINIER,MAGASINIER,VENDEUR;
	
	public String toString()
	{
		return super.toString().toUpperCase();
	}

}
