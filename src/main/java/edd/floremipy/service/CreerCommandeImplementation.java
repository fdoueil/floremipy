package edd.floremipy.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edd.floremipy.dao.CustomerOrderDAOInterface;
import edd.floremipy.dao.CustomerOrderLineDAOInterface;
import edd.floremipy.dto.ArticlePrixListDTO;
import edd.floremipy.dto.CommandListDTO;
import edd.floremipy.dto.CustomerOrderDTO;
import edd.floremipy.dto.CustomerOrderLineDTO;
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
	public CustomerOrderDTO creeCommande(long idCustomerLogge, ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut) {
		Date uneDate = null;
		CustomerOrderDTO retour=new CustomerOrderDTO();
		
		// Pour la creation de commande , l'adresse n'est pas connue,pas plus que la date
		// par contre on doit gérer l'id du customer (passé par l'appelant et correspond a l'user loggé)
		

		
		long idAdress=0;
		ArrayList<CustomerOrderLineDTO> lignesCommande= new ArrayList<CustomerOrderLineDTO>();

		retour.setIdAdress(idAdress);
		retour.setIdCustomer(idCustomerLogge);
		
		retour.setId(unCustomerOrderDAO.ajouteCommande(uneDate, idCustomerLogge, idAdress));
		
		System.out.println("idcommande retourné:" + retour.getId());
		for (int iArticle=0; iArticle < articlePrixDTOListeHaut.size(); iArticle++)  {
			ArticlePrixListDTO unArticle = articlePrixDTOListeHaut.get(iArticle);
			int qteCommandee = unArticle.getQuantityOrder();
			
			int qteLivree = qteCommandee; // pour l'instant pas de livraison partielle TODO
			System.out.println("Parametres:" + retour.getId() + "/" + unArticle.getId()+"/" + qteCommandee + "/" + qteLivree);
			long idLine = unCustomerOrderLineDAO.ajouteLigneCommande(retour.getId(),unArticle.getId(), qteCommandee,qteLivree);
			System.out.println("Ligne commande ajoutée:" + idLine);
			lignesCommande.add( new CustomerOrderLineDTO(unArticle.getId(), qteCommandee, qteLivree));
		}
		retour.setLignesCommande(lignesCommande);
		
		
		// Fabriquer en parallele le DTO de retour (id_client, et liste de customerOrderLineDTO)
		return retour;

	}

	@Override
	public void selectModeLivraison(TypeModeLivraison typeModeLivraison) {
		// TODO Auto-generated method stub

	}


}
