package edd.floremipy.service;

import java.util.ArrayList;
import java.util.Date;

import edd.floremipy.dao.CustomerOrderDAOInterface;
import edd.floremipy.dao.CustomerOrderLineDAOInterface;
import edd.floremipy.dto.ArticlePrixListDTO;
import edd.floremipy.model.TypeModeLivraison;

public class CreerCommandeImplementation implements CreerCommandeInterface {
	
	private CustomerOrderDAOInterface unCustomerOrderDAO;
	private CustomerOrderLineDAOInterface unCustomerOrderLineDAO;
	private long dernierIdCommande;

	public CreerCommandeImplementation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creeCommande(ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut) {
		Date uneDate = null;
		long idCustomer=10; // A recevoir en paramétre, lié au idCustomer du User connecté
		long idAdress=0;  // A 0 , quand on livre a l'adresse du client
		long numeroCommande = unCustomerOrderDAO.add(uneDate, idCustomer, idAdress);
		for (int iArticle=0; iArticle < articlePrixDTOListeHaut.size(); iArticle++)  {
			ArticlePrixListDTO unArticle = articlePrixDTOListeHaut.get(iArticle);
			int qteCommandee = unArticle.getQuantityOrder();
			int qteLivree = qteCommandee; // pour l'instant pas de livraison partielle TODO
			long idLine = unCustomerOrderLineDAO.add(numeroCommande,unArticle.getId(), qteCommandee,qteLivree);
			
		}
		dernierIdCommande = numeroCommande; // Provisoirement car le no de commande sera stocké dans la couche supérieure
		

	}

	@Override
	public void selectModeLivraison(TypeModeLivraison typeModeLivraison) {
		// TODO Auto-generated method stub

	}


}
