package edd.floremipy.service;

import edd.floremipy.dto.AdresseDTO;

public interface CreerAdresseInterface {
	public AdresseDTO getAdresseByUser(int idClient);
	public void majAdresse(int idAdresseLivraison, String location,String zipCode, String city);
	public AdresseDTO creerAdresse(String location,String zipCode, String city);
}
