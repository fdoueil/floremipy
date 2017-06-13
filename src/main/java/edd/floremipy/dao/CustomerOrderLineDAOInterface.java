package edd.floremipy.dao;

public interface CustomerOrderLineDAOInterface {
	public long ajouteLigneCommande (long idCustomerOrder, long idArticle, int quantity, int deliveryQuantity);
}
