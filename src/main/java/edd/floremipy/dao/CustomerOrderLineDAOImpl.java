package edd.floremipy.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("commandeLineDAO")
@Scope("singleton")
public class CustomerOrderLineDAOImpl implements CustomerOrderLineDAOInterface {

	@Override
	public long ajouteLigneCommande(long idCustomerOrder, long idArticle, int quantity, int deliveryQuantity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
