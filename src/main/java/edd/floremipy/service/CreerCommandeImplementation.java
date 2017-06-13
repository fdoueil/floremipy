package edd.floremipy.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edd.floremipy.dao.CustomerOrderDAOInterface;
import edd.floremipy.dao.CustomerOrderLineDAOInterface;
import edd.floremipy.dto.ArticlePrixListDTO;
import edd.floremipy.dto.CommandListDTO;
import edd.floremipy.model.TypeModeLivraison;

@Service("commandeService")
public class CreerCommandeImplementation implements CreerCommandeInterface {
	
	@Autowired
	private CustomerOrderDAOInterface unCustomerOrderDAO;
	@Autowired
	private CustomerOrderLineDAOInterface unCustomerOrderLineDAO;
	

	public CreerCommandeImplementation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CommandListDTO creeCommande(ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut) {
		Date uneDate = null;
		CommandListDTO retour=new CommandListDTO();
//		long idCustomer=10; // A recevoir en paramétre, lié au idCustomer du User connecté
//		long idAdress=0;  // A 0 , quand on livre a l'adresse du client
		long idCustomer=155;
		long idAdress=0;
		long idCommande = unCustomerOrderDAO.ajouteCommande(uneDate, idCustomer, idAdress);
		System.out.println("idcommande retourné:" + idCommande);
		for (int iArticle=0; iArticle < articlePrixDTOListeHaut.size(); iArticle++)  {
			ArticlePrixListDTO unArticle = articlePrixDTOListeHaut.get(iArticle);
			int qteCommandee = unArticle.getQuantityOrder();
			int qteLivree = qteCommandee; // pour l'instant pas de livraison partielle TODO
			long idLine = unCustomerOrderLineDAO.ajouteLigneCommande(idCommande,unArticle.getId(), qteCommandee,qteLivree);
			System.out.println("Ligne commande ajoutée:" + idLine);
		}
		retour.setId(idCommande);
		return retour;

	}

	@Override
	public void selectModeLivraison(TypeModeLivraison typeModeLivraison) {
		// TODO Auto-generated method stub

	}


}
