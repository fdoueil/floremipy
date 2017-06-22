package edd.floremipy.dao;

import java.util.Date;

import edd.floremipy.dto.CommandListDTO;
import edd.floremipy.model.Customerorder;

public interface CustomerOrderDAOInterface {
	// Retourne un numero de commande
	public long ajouteCommande( Customerorder uneCommande );
	
	
}
