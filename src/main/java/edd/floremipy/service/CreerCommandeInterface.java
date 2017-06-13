package edd.floremipy.service;

import java.util.ArrayList;

import edd.floremipy.dto.ArticlePrixListDTO;
import edd.floremipy.model.TypeModeLivraison;

public interface CreerCommandeInterface {
	public void creeCommande(ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut);
	public void selectModeLivraison(TypeModeLivraison typeModeLivraison);
}
