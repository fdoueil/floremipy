package edd.floremipy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edd.floremipy.dao.CatalogueDAOInterface;
import edd.floremipy.dto.CatalogueLineDTO;

@Service("catalogueService")
public class CatalogueServiceImpl implements CatalogueServiceInterface {
	
	@Autowired
	CatalogueDAOInterface dao;
	
	
	@Override
	public String catalogLinesToJson() {
		
		List<CatalogueLineDTO> myCatalogLines = dao.findCatalogue();
		
		Gson gson = new GsonBuilder().create();
		StringBuffer sbLignesCatalogue = new StringBuffer();
		
		if (!(myCatalogLines.isEmpty())){
			for (CatalogueLineDTO catalogueLineDTO : myCatalogLines) {
				//convertir au format String JSON(P) chaque ligne du catalogue reçu
				//( "id/ref - ArticleName - Category - Price - QtyStock")
				sbLignesCatalogue.append(catalogueLineDTO.lineToJson());
				System.out.println("Ligne de catalogue : " + catalogueLineDTO.lineToJson());
			}			
		}
		System.out.println(sbLignesCatalogue.toString());
		return sbLignesCatalogue.toString();
	}
}
