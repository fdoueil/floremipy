package edd.floremipy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edd.floremipy.dao.ArticleDAOInterface;
import edd.floremipy.dao.CustomerDAOInterface;
import edd.floremipy.dao.CustomerOrderDAOInterface;
import edd.floremipy.dao.CustomerOrderLineDAOInterface;
import edd.floremipy.dto.ArticlePrixListDTO;
import edd.floremipy.dto.CommandListDTO;
import edd.floremipy.dto.CustomerOrderDTO;
import edd.floremipy.dto.CustomerOrderLineDTO;
import edd.floremipy.model.Adress;
import edd.floremipy.model.Article;
import edd.floremipy.model.Customer;
import edd.floremipy.model.Customerorder;
import edd.floremipy.model.Customerorderline;
import edd.floremipy.model.TypeModeLivraison;

@Service("commandeService")
public class CreerCommandeImplementation implements CreerCommandeInterface {
	

	
	@Autowired
	private ArticleDAOInterface unArticleDAO;
	
	@Autowired
	private CustomerDAOInterface unCustomerDAO;
	
	@PersistenceContext
	EntityManager entityManager;
	
	

	public CreerCommandeImplementation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customerorder creeCommande(long idCustomerLogge, ArrayList<ArticlePrixListDTO> listeArticles) {
		Date uneDate = null;
		
		Customerorder entiteCommande=new Customerorder();
		
		if (unArticleDAO==null) return entiteCommande;
		if (unCustomerDAO==null) return entiteCommande;
		
		Customer clientCourant=null;
		Adress adresseLivraison=null;
		
		
		entiteCommande.setCustomerorderlines(new ArrayList<Customerorderline>());
		
		//on recupere le customer correspond a l'id
		clientCourant= unCustomerDAO.findById(idCustomerLogge);
		
		// A la place on peut faire, mais comment mocker   CYRIL???
		//entityManager.find(Customer.class, idCustomerLogge);
		entiteCommande.setCustomer(clientCourant);	
		// TODO findById sur AdressDAO
		entiteCommande.setAdress(adresseLivraison);
		
		// On transforme le tableau recu de l'IHM
		// en une liste de customerOrderLine pour pouvoir l'ajouter 
		// a la nouvelle entite commande en cours de construction		
		for (ArticlePrixListDTO unArticlePrix : listeArticles) {
			int qteCommandee = unArticlePrix.getQuantityOrder();			
			int qteLivree = qteCommandee; // pour l'instant pas de livraison partielle TODO
			System.out.println("Parametres:" + "/" + unArticlePrix.getId()+"/" + qteCommandee + "/" + qteLivree);
			Customerorderline uneLigne = new Customerorderline();
			Article unArticle = unArticleDAO.findById(unArticlePrix.getId());
			uneLigne.setArticle(unArticle);
			uneLigne.setQuantity(qteCommandee);
			uneLigne.setDelivredQuantity(qteLivree);
			
			entiteCommande.addCustomerorderline(uneLigne);		
		}
		
			
		// 3) l'objet est persisté en base
		if (entityManager!=null) {
			entityManager.getTransaction().begin();
			entityManager.persist(entiteCommande);//,  l'entite manager le poussera en base
			entityManager.getTransaction().commit();
		}
		
		// On pourra ici commencer et finir une transaction
		// si ce service modifiait plusieurs tables
		
		// Cyril , on a pas l'id de la commande, comment la redemander pour lire
		// les commandes faites
		
		
	
		
		return entiteCommande;
		

	
		
		
		
		
		// Pour la creation de commande , l'adresse n'est pas connue,pas plus que la date
		// par contre on doit gérer l'id du customer (passé par l'appelant et correspond a l'user loggé)
	
//		long idAdress=0;
//
//		retour.setIdAdress(idAdress);
//		retour.setIdCustomer(idCustomerLogge);
//		
//		retour.setId(unCustomerOrderDAO.ajouteCommande(uneDate, idCustomerLogge, idAdress));
//		
//		System.out.println("idcommande retourné:" + retour.getId());
//		for (int iArticle=0; iArticle < listeArticles.size(); iArticle++)  {
//			ArticlePrixListDTO unArticle = listeArticles.get(iArticle);
//			int qteCommandee = unArticle.getQuantityOrder();
//			
//			int qteLivree = qteCommandee; // pour l'instant pas de livraison partielle TODO
//			System.out.println("Parametres:" + retour.getId() + "/" + unArticle.getId()+"/" + qteCommandee + "/" + qteLivree);
//			long idLine = unCustomerOrderLineDAO.ajouteLigneCommande(retour.getId(),unArticle.getId(), qteCommandee,qteLivree);
//			System.out.println("Ligne commande ajoutée:" + idLine);
//			lignesCommande.add( new CustomerOrderLineDTO(unArticle.getId(), qteCommandee, qteLivree));
//		}
//		retour.setLignesCommande(lignesCommande);
//		
//		
//		// Fabriquer en parallele le DTO de retour (id_client, et liste de customerOrderLineDTO)
//		return retour;

	}

	@Override
	public void selectModeLivraison(TypeModeLivraison typeModeLivraison) {
		// TODO Auto-generated method stub

	}


}
