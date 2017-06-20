package edd.floremipy.service;

import java.util.ArrayList;
import java.util.List;

import edd.floremipy.dto.CatalogueLineDTO;

public interface CatalogueServiceInterface {

	String catalogLinesToJson();

	//sert à CatalogueServiceImpl pour
	//retourner au format JSON 
	//la liste de LigneDeCatalogue (id/ref - ArticleName - Category - Price - QtyStock)

}
