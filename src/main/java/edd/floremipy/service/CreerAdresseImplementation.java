package edd.floremipy.service;

import edd.floremipy.dto.AdresseDTO;

public class CreerAdresseImplementation implements CreerAdresseInterface {

	AdresseDTO adresseDTO = new AdresseDTO();

	public CreerAdresseImplementation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AdresseDTO getAdresseByUser(int idClient) {
		this.fillWithMockedValue(this.adresseDTO);
		return this.adresseDTO;
	}

	@Override
	public void majAdresse(int idAdresseLivraison, String location, String zipCode, String city) {
		this.adresseDTO.setId(idAdresseLivraison);
		this.adresseDTO.setLocation(location);
		this.adresseDTO.setZipCode(zipCode);
		this.adresseDTO.setCity(city);
	}

	@Override
	public AdresseDTO creerAdresse(String location, String zipCode, String city) {
		this.fillWithMockedValue(this.adresseDTO);
		this.adresseDTO.setLocation(location);
		this.adresseDTO.setZipCode(zipCode);
		this.adresseDTO.setCity(city);
		return this.adresseDTO;
	}

	protected void fillWithMockedValue(AdresseDTO item){
		item.setId(-9999);
		item.setLocation("12 Rue Berger Levrault");
		item.setZipCode("31100");
		item.setCity("Toulouse");
	}

}
