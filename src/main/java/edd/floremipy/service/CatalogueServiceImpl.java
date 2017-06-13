package edd.floremipy.service;

import java.util.ArrayList;
import edd.floremipy.dto.CatalogueLineDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CatalogueServiceImpl implements CatalogueService {

	@Override
	public String catalogLinesToJson(ArrayList<CatalogueLineDTO> myCatalogLines) {
		
		Gson gson = new GsonBuilder().create();
		StringBuffer sbLignesCatalogue = new StringBuffer();
		
		if (!(myCatalogLines.isEmpty())){

			for (CatalogueLineDTO catalogueLineDTO : myCatalogLines) {
				//convertir au format String JSON(P) chaque ligne du catalogue reçu
				//( "id/ref - ArticleName - Category - Price - QtyStock")
				sbLignesCatalogue.append(catalogueLineDTO.toString());
				System.out.println("Ligne de catalogue : " + catalogueLineDTO.toString());
			}			
		}
		return gson.toJson(sbLignesCatalogue);
	}
}
