package edd.floremipy.dao;

import edd.floremipy.model.Customerorder;
@FunctionalInterface
public interface CustomerOrderDAOInterface {
	// Retourne un numero de commande
	public long ajouteCommande( Customerorder uneCommande );


}
