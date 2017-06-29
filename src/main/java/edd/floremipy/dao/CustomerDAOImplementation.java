package edd.floremipy.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edd.floremipy.model.Adress;
import edd.floremipy.model.Article;
import edd.floremipy.model.Customer;

@Repository("unCustomerDAO")
@Scope("singleton")

public class CustomerDAOImplementation extends AbstractDAO implements CustomerDAOInterface {

	@Override
	public Customer findById(long id) {
		// TODO Auto-generated method stub
		Customer retour = new Customer();
		retour.setId(7);
		Adress uneAdresse = new Adress();
		uneAdresse.setCity("villeneuve");
		uneAdresse.setZipCode("47300");
		uneAdresse.setLocation("11 rue toto");
		retour.setAdress(uneAdresse);
		return new Customer();
		
		// Un customer bidon en attendant la DAO definitive,
		// car si on retourne null comme proposé par defaut
		// l'enregistrement en base va planter, pour pb de constraint
		// (ne pas peux enregistrer une commande avec un customer a null)
	}

}
