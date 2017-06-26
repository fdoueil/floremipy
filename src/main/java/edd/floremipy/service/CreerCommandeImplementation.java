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
// Si on veut que le service fasse les différentes opérations sur les différentes tables de la base dans une transaction
// il faut une annotation @transaction
@Service("creerCommandeImplementation")
public class CreerCommandeImplementation implements CreerCommandeInterface {

	@Autowired
	private ArticleDAOInterface unArticleDAO;
	
	@Autowired
	private CustomerDAOInterface unCustomerDAO;
	
	@Autowired
	private CustomerOrderDAOInterface unCustomerOrderDAO;
	
	

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
		
		
		System.out.println("dans creer commande" + idCustomerLogge + " " + listeArticles.size());
		
		
		
		entiteCommande.setCustomerorderlines(new ArrayList<Customerorderline>());
		
		//on recupere le customer correspond a l'id
		System.out.println("client id = " + idCustomerLogge);
		
		clientCourant= unCustomerDAO.findById(idCustomerLogge);
	
		entiteCommande.setCustomer(clientCourant);	
		// TODO findById sur AdressDAO
		entiteCommande.setAdress(adresseLivraison);
		
		// On transforme le tableau recu de l'IHM
		// en une liste de customerOrderLine pour pouvoir l'ajouter 
		// a la nouvelle entite commande en cours de construction		
		for (ArticlePrixListDTO unArticlePrix : listeArticles) {
			int qteCommandee = unArticlePrix.getQuantityOrder();			
			int qteLivree = qteCommandee; // pour l'instant pas de livraison partielle TODO
			if (unArticlePrix.getId() < 0 ) unArticlePrix.setId(3);  // on recoit un ID bidon, on fige sur l'article 3   TODO
			System.out.println("Parametres:" + "/" + unArticlePrix.getId()+"/" + qteCommandee + "/" + qteLivree);
			Customerorderline uneLigne = new Customerorderline();
			Article unArticle = unArticleDAO.findById(unArticlePrix.getId());
			System.out.println("apres dao article");
			uneLigne.setArticle(unArticle);
			uneLigne.setQuantity(qteCommandee);
			uneLigne.setDelivredQuantity(qteLivree);
			
			entiteCommande.addCustomerorderline(uneLigne);
			
		}
		
			
		// 3) l'objet est persisté en base
		unCustomerOrderDAO.ajouteCommande(entiteCommande);
		
		
		// On pourra ici commencer et finir une transaction
		// si ce service modifiait plusieurs tables
		

		
		return entiteCommande;


	}

	@Override
	public void selectModeLivraison(TypeModeLivraison typeModeLivraison) {
		// TODO Auto-generated method stub

	}


}
