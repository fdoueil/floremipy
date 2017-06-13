package edd.floremipy.dao;

import java.util.Date;

import edd.floremipy.dto.CommandListDTO;

public interface CustomerOrderDAOInterface {
	// Retourne un numero de commande
	public long ajouteCommande( Date customerOrderDate, long idCustomer, long idAdress );
	
	
}
