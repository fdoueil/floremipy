# floremipy
FloreMipy project

### Initialisation de la base de données

dans MySQL Workbench

CREATE SCHEMA `floremipy_tu` ;

Puis lancer le script floremipy_tu.sql (src/main/sql/)

### Configuration pour accès base de données dans Eclipse (STS) !

Le fichier application.properties dans src/main/resources permet de configurer l'accès bdd
Il est ignoré par Git et donc est personnalisable pour chaque Dev :)

### Mockito

JUnit Tests avec Mokito

-->cf. CatalogueServiceImplTest.java

1- Dans la classe Service, l'annotation @Service permet de déclarer le nom service :

		@Service("catalogueService")
		public class CatalogueServiceImpl implements CatalogueService {

2- Pour utiliser Mockito, ajouter l'annotation sur la classe de test :

		@RunWith(MockitoJUnitRunner.class)
		public class CatalogueServiceImplTest {...
		
3- Spécifier l'interfaceDAO à 'mocker' pour en permettre son utilisation dans les tests :

		CatalogueDAOInterface myCatalogMock = Mockito.mock(CatalogueDAOInterface.class);
		
4- La classe qui implémente cette interface doit être annotée @Repository pour pouvoir être injectée, et @Scope précise sa portée ("singleton" et "prototype"):

		@Repository("catalogueDAO")
		@Scope("singleton")
		public class CatalogueDAOImpl implements CatalogueDAOInterface {
		   List<CatalogueLineDTO> findCatalogue(){...
		
5- Dans la classe de test, préciser dans quelle classe injecter le mock initié à l'instanciation de celle-ci :

		@InjectMocks
		CatalogueServiceImpl myCatalogService = new CatalogueServiceImpl();
		
6- Dans le test, forcer le résultat attendu à l'appel de la fonction sur la classe 'mockée' :
		
	Mockito.when(myCatalogMock.findCatalogue()).thenReturn(myListCatalogueLinesDTO);
				
Où myListCatalogueLinesDTO est une List<CatalogueLineDTO> que Mokito retournera à l'appel de findCatalogue()
		
Sera ainsi exploité par l'objet de la classe, dont une fonction est à tester, et qui a reçu l'injection (ici 'myCatalogService') :

	String result = myCatalogService.catalogLinesToJson();