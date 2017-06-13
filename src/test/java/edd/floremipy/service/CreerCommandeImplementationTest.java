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

import edd.floremipy.dao.CatalogueDAOInterface;
import edd.floremipy.dao.CustomerOrderDAOInterface;
import edd.floremipy.dao.CustomerOrderLineDAOInterface;
import edd.floremipy.dto.ArticlePrixListDTO;
import edd.floremipy.dto.CommandListDTO;

@RunWith(MockitoJUnitRunner.class)
public class CreerCommandeImplementationTest {
	CustomerOrderDAOInterface myCustomerOrderDAOMock = Mockito.mock(CustomerOrderDAOInterface.class);
	CustomerOrderLineDAOInterface myCustomerOrderLineDAOMock = Mockito.mock(CustomerOrderLineDAOInterface.class);
	
	
	@InjectMocks
	CreerCommandeImplementation myCreerCommandeService = new CreerCommandeImplementation();
	// On fait vraiment le new du service, mais le systeme s'arrangera a remplacer les autowired
	// par les mock s'il en a (et donc ici par les mocks déclarés ci dessus)
	
	ArrayList<ArticlePrixListDTO> uneListe;
	
	CommandListDTO myCommandListDTO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		uneListe = new ArrayList<ArticlePrixListDTO>();
	
		uneListe.add( new ArticlePrixListDTO("olivier", "olivier_desc", 100, 10, 2, 123, ""));
		uneListe.add(new ArticlePrixListDTO("rosier", "rosier_desc", 5, 50, 3, 456, ""));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreerCommande() {
		Date uneDate=null;
		long idCustomer=155;
		long idAdress=0;
		
		//CommandListDTO uneCommande=null;
		long idCommande = 2001;
		long idLineCommande = 12001;
		
		Mockito.when(myCustomerOrderDAOMock.ajouteCommande(uneDate, idCustomer, idAdress)).thenReturn(idCommande);	
		Mockito.when(myCustomerOrderLineDAOMock.ajouteLigneCommande(idCommande, 123, 10, 2)).thenReturn(idLineCommande);	
		Mockito.when(myCustomerOrderLineDAOMock.ajouteLigneCommande(idCommande, 456, 50, 3)).thenReturn(idLineCommande+1);	
		
		
		CommandListDTO laCommande = myCreerCommandeService.creeCommande(uneListe);
		
		System.out.println(laCommande.getId());
		
		// On regarde laCommande pour verifier qu'elle est bien formée
		//fail("Not yet implemented");
	}

}
