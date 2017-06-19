package edd.floremipy.service;

import java.util.ArrayList;

import edd.floremipy.dto.ArticlePrixListDTO;
import edd.floremipy.dto.CommandListDTO;
import edd.floremipy.dto.CustomerOrderDTO;
import edd.floremipy.model.TypeModeLivraison;

public interface CreerCommandeInterface {
	// A terme retourner un Long identifiant la commande et ce long sera fourni a nouveau en parametre par selectModeLivraison
	// Actuellement on considere que selectModeLivraison travaille sur la derniere commande en cours...
	
	public CustomerOrderDTO creeCommande(long idCustomerLogge, ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut);
	public void selectModeLivraison(TypeModeLivraison typeModeLivraison);
}
