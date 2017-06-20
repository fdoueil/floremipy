package edd.floremipy.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import edd.floremipy.dao.CatalogueDAOImpl;
import edd.floremipy.dao.CatalogueDAOInterface;
import edd.floremipy.dto.CatalogueLineDTO;

@RunWith(MockitoJUnitRunner.class)
public class CatalogueServiceImplTest {
	
	CatalogueDAOInterface myCatalogMock = Mockito.mock(CatalogueDAOInterface.class);
	
	@InjectMocks
	CatalogueServiceImpl myCatalogService = new CatalogueServiceImpl();

	CatalogueLineDTO catalogueLineDTO1; 
	CatalogueLineDTO catalogueLineDTO2;
	
	ArrayList<CatalogueLineDTO> myListCatalogueLinesDTO = new ArrayList<CatalogueLineDTO>();
	 
	
	 @Before
	 public void init() throws Throwable {
		 //creation d'un article ref "123"
		 catalogueLineDTO1 = new CatalogueLineDTO(123, "olivier", "arbre", 100, 10);
		 
		 //creation d'un 2nd article ref "234"
		 catalogueLineDTO2 = new CatalogueLineDTO(234, "rosier", "arbuste", 15, 30);
		 
		 //alimentation myListCatalogueLinesDTO
		 myListCatalogueLinesDTO.add(catalogueLineDTO1);
		 myListCatalogueLinesDTO.add(catalogueLineDTO2);				 
	 }
	
	 @Test
	 public void testCatalogue_linesToJson() {
		 String expected = "{\"id\":123,\"name\":\"olivier\",\"category\":\"arbre\",\"price\":100.0,\"stock\":10}{\"id\":234,\"name\":\"rosier\",\"category\":\"arbuste\",\"price\":15.0,\"stock\":30}";
		 
		 Mockito.when(myCatalogMock.findCatalogue()).thenReturn(myListCatalogueLinesDTO);	 
		 String result = myCatalogService.catalogLinesToJson();
		 
		 assertEquals(expected,result);		
	 }
}
