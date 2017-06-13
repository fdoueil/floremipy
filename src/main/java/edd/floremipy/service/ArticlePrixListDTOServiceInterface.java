package edd.floremipy.service;

import java.util.ArrayList;

import edd.floremipy.dto.ArticlePrixListDTO;

public interface ArticlePrixListDTOServiceInterface {

	public ArrayList<ArticlePrixListDTO> initListeArticleHaut();
	public ArrayList<ArticlePrixListDTO> initListeArticleBas();
	public void deplaceDuHautVersLeBas(ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut, ArrayList<ArticlePrixListDTO> articlePrixDTOListeBas, int idArticlePrixToAdd);
	public void deplaceDuBasVersLeHaut(ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut, ArrayList<ArticlePrixListDTO> articlePrixDTOListeBas, int idArticlePrixToDel);

}
