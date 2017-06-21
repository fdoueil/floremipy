package edd.floremipy.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import edd.floremipy.dao.ArticleDAOInterface;
import edd.floremipy.dao.CatalogueDAOInterface;
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

@RunWith(MockitoJUnitRunner.class)
public class CreerCommandeImplementationTest {
	//CustomerOrderDAOInterface myCustomerOrderDAOMock = Mockito.mock(CustomerOrderDAOInterface.class);
	ArticleDAOInterface myArticleDAOMock = Mockito.mock(ArticleDAOInterface.class);
	CustomerDAOInterface myCustomerDAOMock = Mockito.mock(CustomerDAOInterface.class);
	
	@InjectMocks
	CreerCommandeImplementation myCreerCommandeService = new CreerCommandeImplementation();
	// On fait vraiment le new du service, mais le systeme s'arrangera a remplacer les autowired
	// par les mock s'il en a (et donc ici par les mocks déclarés ci dessus)
	
	ArrayList<ArticlePrixListDTO> uneListe;
	Article article1;
	Article article2;
	Adress adresse1;
	Customer client1;
	
	CommandListDTO myCommandListDTO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		uneListe = new ArrayList<ArticlePrixListDTO>();
	
		uneListe.add( new ArticlePrixListDTO("olivier", "olivier_desc", 100, 10, 2, 123, ""));
		uneListe.add(new ArticlePrixListDTO("rosier", "rosier_desc", 5, 50, 3, 456, ""));
	
		article1 = new Article();
		article1.setId(123);
		article1.setName("olivier");
		
		article2 = new Article();
		article2.setId(456);
		article2.setName("rosier");
		
		adresse1 = new Adress();
		adresse1.setId(50);
		adresse1.setCity("Villeneuve sur lot");
		adresse1.setLocation("11 rue marechal Joffre");
		adresse1.setZipCode("47300");
		
		client1 = new Customer();
		client1.setName("DEFLANDRE");
		client1.setAdress(adresse1);
		client1.setFirstName("Eric");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreerCommande() {
		Date uneDate=null;
		long idCustomer=155;
		long idAdress=0;
		

		
		
		// En fait le service crée, la commande pas besoin de mockito
		// pour créer la commande, par contre il en faut un pour s'affranchir
		// de la lecture du customer ou de l'adresse ou de l'article

		//Mockito.when(myCustomerOrderDAOMock.ajouteCommande(uneDate, idCustomer, idAdress)).thenReturn(idCommande);	

		
		Mockito.when(myArticleDAOMock.findById(123)).thenReturn(article1);	
		Mockito.when(myArticleDAOMock.findById(456)).thenReturn(article2);
		
		Mockito.when(myCustomerDAOMock.findById(idCustomer)).thenReturn(client1);
		
		// Cyril, si l'entitymanager est dans le service faut il le mocker aussi?????
		
		
		Customerorder laCommande = myCreerCommandeService.creeCommande(idCustomer, uneListe);
		// 1er partie les caracteristique de la commande
		assertEquals("DEFLANDRE",laCommande.getCustomer().getName());
		assertEquals("11 rue marechal Joffre", laCommande.getCustomer().getAdress().getLocation());
		
		
		// 2eme partie, le detail des lignes		
		ArrayList<Customerorderline> lignesCommande = (ArrayList<Customerorderline>) laCommande.getCustomerorderlines();
		
		assertEquals(2, lignesCommande.size());
		Article premierArticle=lignesCommande.get(0).getArticle();
		assertEquals(123, premierArticle.getId());
		assertEquals("olivier", premierArticle.getName());
		assertEquals(2, lignesCommande.get(0).getQuantity());
	
		Article deuxiemeArticle=lignesCommande.get(1).getArticle();
		assertEquals(456, deuxiemeArticle.getId());
		assertEquals("rosier", deuxiemeArticle.getName());
		assertEquals(3, lignesCommande.get(1).getQuantity());
		
//		// Qte délivrée n'est pas testée ici, car elle n'est pas géré a la création de commande

		
	}

}
