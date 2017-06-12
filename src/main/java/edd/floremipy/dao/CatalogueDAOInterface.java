package edd.floremipy.dao;

import java.util.List;

import edd.floremipy.dto.CatalogueLineDTO;

public interface CatalogueDAOInterface {

	List<CatalogueLineDTO> findCatalogue();

}