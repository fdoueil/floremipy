package edd.floremipy.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edd.floremipy.dto.CatalogueLineDTO;

public class CatalogueServiceImplTest {
	
	//CatalogueLineDTO catalogueLineDTO1 = Mockito.mock(CatalogueLineDTO.class);
	//CatalogueLineDTO catalogueLineDTO2 = Mockito.mock(CatalogueLineDTO.class);
	CatalogueLineDTO catalogueLineDTO1 = new CatalogueLineDTO();
	CatalogueLineDTO catalogueLineDTO2 = new CatalogueLineDTO();
	
	ArrayList<CatalogueLineDTO> myListCatalogueLinesDTO = new ArrayList<CatalogueLineDTO>();
	 
	
	 @Before
	 public void init() throws Throwable {
		 //creation d'un article ref "123"
		 catalogueLineDTO1.setId(123);
		 catalogueLineDTO1.setName("olivier");
		 catalogueLineDTO1.setCategory("arbre");
		 catalogueLineDTO1.setPrice(100);
		 catalogueLineDTO1.setStock(10);
		 
		 //creation d'un 2nd article ref "234"
		 catalogueLineDTO2.setId(234);
		 catalogueLineDTO2.setName("rosier");
		 catalogueLineDTO2.setCategory("arbuste");
		 catalogueLineDTO2.setPrice(15);
		 catalogueLineDTO2.setStock(30);
		 
		 //alimentation myListCatalogueLinesDTO
		 myListCatalogueLinesDTO.add(catalogueLineDTO1);
		 myListCatalogueLinesDTO.add(catalogueLineDTO2);		
	 }
	
	 @Test
	 public void testCatalogue_linesToJson() {
		 String expected = "\"" + "123,olivier,arbre,100.0,10;234,rosier,arbuste,15.0,30;" + "\"" ;		 
		 CatalogueServiceImpl myCatalogService = new CatalogueServiceImpl();
		 String result = myCatalogService.catalogLinesToJson(myListCatalogueLinesDTO);
		 assertEquals(expected,result);		 
	 }
}
