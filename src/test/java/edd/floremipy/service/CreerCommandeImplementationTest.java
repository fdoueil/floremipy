package edd.floremipy.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edd.floremipy.dto.ArticlePrixListDTO;

public class CreerCommandeImplementationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreerCommande() {
		ArrayList<ArticlePrixListDTO> uneListe = new ArrayList<ArticlePrixListDTO>();
		//uneListe.add( new ArticlePrixListDTO());
		//uneListe.add(new ArticlePrixListDTO());
		CreerCommandeInterface uneCreationCommande = new CreerCommandeImplementation();
		uneCreationCommande.creeCommande(uneListe);
		fail("Not yet implemented");
	}

}
