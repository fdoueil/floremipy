package edd.floremipy.dao;

public interface CustomerOrderLineDAOInterface {
	public long add (long idCustomerOrder, long idArticle, int quantity, int deliveryQuantity);
}
