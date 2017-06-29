package edd.floremipy.dao;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edd.floremipy.dto.CommandListDTO;
import edd.floremipy.model.Customerorder;

@Repository("commandeDAO")
@Scope("singleton")
public class CustomerOrderDAOImpl  extends AbstractDAO implements CustomerOrderDAOInterface {

	

	@Override
	public long ajouteCommande(Customerorder uneCommande) {
		System.out.println("Ajout d'un commande de " + uneCommande.getCustomerorderlines().size() + "lignes");
		System.out.println("Pour le client " + uneCommande.getCustomer());
		System.out.println("Pour le client no " + uneCommande.getCustomer().getId());
		
		//this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(uneCommande);
		//this.getEntityManager().getTransaction().commit();
		return 0;
	}

}
