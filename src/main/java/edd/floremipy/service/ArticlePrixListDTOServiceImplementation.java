package edd.floremipy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edd.floremipy.dao.CatalogueDAOInterface;
import edd.floremipy.dto.ArticlePrixListDTO;
import edd.floremipy.dto.CatalogueLineDTO;

@Service
public class ArticlePrixListDTOServiceImplementation implements ArticlePrixListDTOServiceInterface {
	private  ArrayList<ArticlePrixListDTO> listeInitHaut = new  ArrayList<ArticlePrixListDTO>();
	private  ArrayList<ArticlePrixListDTO> listeInitBas = new  ArrayList<ArticlePrixListDTO>();

	@Autowired
	private CatalogueDAOInterface catalogueDAO ;
	
	public ArticlePrixListDTOServiceImplementation() {
		// TODO Auto-generated constructor stub

	}
	@Override
	public ArrayList<ArticlePrixListDTO> initListeArticleHaut(){		
		//this.fillWithMockedValue(articlePrixListDTO);
		//articlePrixListDTO.setName(articlePrixListDTO.getName() + " - Haut");
		List<CatalogueLineDTO> maListe = catalogueDAO.findCatalogue();
		for (CatalogueLineDTO catalogueLineDTO : maListe) {
			ArticlePrixListDTO articlePrixListDTO = new ArticlePrixListDTO();
			transformCatalogueListToArticlePrixListeDTO(catalogueLineDTO,articlePrixListDTO);
			this.listeInitHaut.add(articlePrixListDTO);
		}
		
		return this.listeInitHaut;
	}

	private void transformCatalogueListToArticlePrixListeDTO(CatalogueLineDTO catalogueLineDTO,
			ArticlePrixListDTO articlePrixListDTO) {
		articlePrixListDTO.setId(catalogueLineDTO.getId());
		articlePrixListDTO.setName(catalogueLineDTO.getName());
		articlePrixListDTO.setPriceValue((float)catalogueLineDTO.getPrice());
		articlePrixListDTO.setQuantityInStock(catalogueLineDTO.getStock());		
	}
	
	@Override
	public ArrayList<ArticlePrixListDTO> initListeArticleBas(){
		ArticlePrixListDTO articlePrixListDTO = new ArticlePrixListDTO();
		this.fillWithMockedValue(articlePrixListDTO);
		articlePrixListDTO.setName(articlePrixListDTO.getName() + " - Bas");
		articlePrixListDTO.setId(articlePrixListDTO.getId() + 10);
		this.listeInitBas.add(articlePrixListDTO);
		return this.listeInitBas;
	}

	@Override
	public void deplaceDuHautVersLeBas(ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut,
			ArrayList<ArticlePrixListDTO> articlePrixDTOListeBas, int idArticlePrixToAdd) {
		ArticlePrixListDTO articlePrixListDTO=null;
		for (ArticlePrixListDTO current : articlePrixDTOListeHaut) {
			if(current.getId()== idArticlePrixToAdd) {
				articlePrixListDTO=current;
				break;
			}
		}
		if(articlePrixListDTO!=null){
			articlePrixDTOListeBas.add(articlePrixListDTO);
			articlePrixDTOListeHaut.remove(articlePrixListDTO);
		}
		
	}

	@Override
	public void deplaceDuBasVersLeHaut(ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut,
			ArrayList<ArticlePrixListDTO> articlePrixDTOListeBas, int idArticlePrixToDel) {
		ArticlePrixListDTO articlePrixListDTO=null;
		for (ArticlePrixListDTO current : articlePrixDTOListeBas) {
			if(current.getId()== idArticlePrixToDel) {
				articlePrixListDTO=current;
				break;
			}
		}	
		if(articlePrixListDTO!=null){
			articlePrixDTOListeHaut.add(articlePrixListDTO);
			articlePrixDTOListeBas.remove(articlePrixListDTO);
		}
	}

	protected void fillWithMockedValue(ArticlePrixListDTO item){
		item.setName("Article Test");
		item.setDescription("Article cr�� automatiquement");
		item.setPriceValue(10.26F);
		item.setQuantityInStock(12);
		item.setQuantityOrder(0);
		item.setId(-9999);
		item.setImg("Olivier.jpg");
	}
}
