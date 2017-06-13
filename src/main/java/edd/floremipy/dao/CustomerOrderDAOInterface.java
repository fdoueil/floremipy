package edd.floremipy.dao;

import java.util.Date;

public interface CustomerOrderDAOInterface {
	// Retourne un numero de commande
	public long add( Date customerOrderDate, long idCustomer, long idAdress );
	
	
}
