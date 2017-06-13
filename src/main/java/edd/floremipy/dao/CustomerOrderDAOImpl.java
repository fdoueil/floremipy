package edd.floremipy.dao;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edd.floremipy.dto.CommandListDTO;

@Repository("commandeDAO")
@Scope("singleton")
public class CustomerOrderDAOImpl implements CustomerOrderDAOInterface {

	

	@Override
	public long ajouteCommande(Date customerOrderDate, long idCustomer, long idAdress) {
		// TODO Auto-generated method stub
		return 0;
	}

}
