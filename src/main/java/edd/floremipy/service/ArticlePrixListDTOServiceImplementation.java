package edd.floremipy.service;

import java.util.ArrayList;

import edd.floremipy.dto.ArticlePrixListDTO;

public class ArticlePrixListDTOServiceImplementation implements ArticlePrixListDTOServiceInterface {
	private  ArrayList<ArticlePrixListDTO> listeInitHaut = new  ArrayList<ArticlePrixListDTO>();
	private  ArrayList<ArticlePrixListDTO> listeInitBas = new  ArrayList<ArticlePrixListDTO>();


	public ArticlePrixListDTOServiceImplementation() {
		// TODO Auto-generated constructor stub

	}
	@Override
	public ArrayList<ArticlePrixListDTO> initListeArticleHaut(){
		ArticlePrixListDTO articlePrixListDTO = new ArticlePrixListDTO();
		articlePrixListDTO.setName(articlePrixListDTO.getName() + " - Haut");
		this.listeInitHaut.add(articlePrixListDTO);
		return this.listeInitHaut;
	}

	@Override
	public ArrayList<ArticlePrixListDTO> initListeArticleBas(){
		ArticlePrixListDTO articlePrixListDTO = new ArticlePrixListDTO();
		articlePrixListDTO.setName(articlePrixListDTO.getName() + " - Bas");
		articlePrixListDTO.setId(articlePrixListDTO.getId() + 10);
		this.listeInitBas.add(articlePrixListDTO);
		return this.listeInitBas;
	}

	@Override
	public void deplaceDuHautVersLeBas(ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut,
			ArrayList<ArticlePrixListDTO> articlePrixDTOListeBas, int idArticlePrixToAdd) {
	}

	@Override
	public void deplaceDuBasVersLeHaut(ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut,
			ArrayList<ArticlePrixListDTO> articlePrixDTOListeBas, int idArticlePrixToDel) {
	}
	@Override
	public void creeCommande(ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut) {
		// TODO Auto-generated method stub

	}
}
