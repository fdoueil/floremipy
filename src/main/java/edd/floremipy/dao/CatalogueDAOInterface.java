package edd.floremipy.dao;

import java.util.List;

import edd.floremipy.dto.CatalogueLineDTO;

public interface CatalogueDAOInterface {

	List<CatalogueLineDTO> findCatalogue();
	
	void setCatalogue(CatalogueLineDTO catalogueLineDTO);
	// si ligne n'existe pas alors ajouter, sinon voir comment traiter (réajuster stock?...)

}