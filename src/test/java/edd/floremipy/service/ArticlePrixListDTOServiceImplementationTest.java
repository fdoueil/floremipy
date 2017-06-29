package edd.floremipy.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import edd.floremipy.dao.CatalogueDAOInterface;
import edd.floremipy.dto.ArticlePrixListDTO;
import edd.floremipy.dto.CatalogueLineDTO;

@RunWith(MockitoJUnitRunner.class)
public class ArticlePrixListDTOServiceImplementationTest {
	
	CatalogueDAOInterface myCatalogMock = Mockito.mock(CatalogueDAOInterface.class);
	
	CatalogueLineDTO article1;
	CatalogueLineDTO article2;
	CatalogueLineDTO article3;
	
	ArrayList<ArticlePrixListDTO> articlePrixListe;
	ArticlePrixListDTO articlePrix2;
	ArticlePrixListDTO articlePrix3;
	
	@InjectMocks
	ArticlePrixListDTOServiceImplementation myListDTOServiceImplementation = new ArticlePrixListDTOServiceImplementation();
	
	ArrayList<CatalogueLineDTO> listeArticles = new ArrayList<CatalogueLineDTO>();
	
	ArrayList<ArticlePrixListDTO> listeHautTest = new ArrayList<ArticlePrixListDTO>();
	ArrayList<ArticlePrixListDTO> listeBasTest = new ArrayList<ArticlePrixListDTO>();
	
	@Before
	 public void init() throws Throwable {
		 //creation d'un article ref "1"
		 article1 = new CatalogueLineDTO(1,"olivier","arbre",100.0f,10,"ceci est un olivier","olivier.jpg");
		 
		 //creation d'un 2nd article ref "2"
		 article2 = new CatalogueLineDTO(2,"rosier", "arbre",15.0f, 10, "ceci est un rosier","rosier.jpg");
		 
		 //creation d'un 3ème article ref "3"
		 article3 = new CatalogueLineDTO(3,"pommier", "arbre",115.0f, 10,"ceci est un pommier","pommier.jpg");
		 
		 //alimentation listeHautTest
		 listeArticles.add(article1);
		 listeArticles.add(article2);	
		 listeArticles.add(article3);	
		 
		 //Mise en place du Mock sur la liste des articles
		 Mockito.when(myCatalogMock.findCatalogue()).thenReturn(listeArticles);
		 
		 //initialisation des listes d'article haut et bas
		 listeHautTest=myListDTOServiceImplementation.initListeArticleHaut();
		 listeBasTest=myListDTOServiceImplementation.initListeArticleBas();		 
	 }
	
	
	 @Test
	 public void initListeArticleHautTest() {
		 assertEquals(3,listeHautTest.size());
	 }
	 
	 @Test
	 public void initListeArticleBasTest() {
		 assertEquals(0,listeBasTest.size());
	 }
	 
	 @Test
	 public void deplaceDuHautVersLeBasTest() {
		 myListDTOServiceImplementation.deplaceDuHautVersLeBas(listeHautTest, listeBasTest, 3);
		 assertEquals(2,listeHautTest.size());
		 assertEquals(1,listeBasTest.size());
		 
	 }
	 
	 @Test
	 public void deplaceDuBasVersLeHautTest() {
		 myListDTOServiceImplementation.deplaceDuHautVersLeBas(listeHautTest, listeBasTest, 3);
		 myListDTOServiceImplementation.deplaceDuHautVersLeBas(listeHautTest, listeBasTest, 2);
		 myListDTOServiceImplementation.deplaceDuBasVersLeHaut(listeHautTest, listeBasTest, 3);
		 assertEquals(2,listeHautTest.size());
		 assertEquals(1,listeBasTest.size());
	 }

}
