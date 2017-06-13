package edd.floremipy;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edd.floremipy.dao.CatalogueDAOImpl;
import edd.floremipy.dto.CatalogueLineDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class CatalogueDAOImplTest  {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CatalogueDAOImpl catalogueDAOImpl;
	
	
	@Test
	public void testFindCatalogue() {
		List<CatalogueLineDTO> actual=catalogueDAOImpl.findCatalogue();
		assertEquals(11,actual.size());
	}

	@Test
	public void testListCatalogue() {
		log.info("testListCatalogue");
		List<CatalogueLineDTO> actual=catalogueDAOImpl.findCatalogue();
		for (CatalogueLineDTO catalogueLineDTO : actual) {
			log.debug(catalogueLineDTO.getId() +' '+catalogueLineDTO.getName() +' '+catalogueLineDTO.getCategory() +' '+catalogueLineDTO.getStock() +' '+catalogueLineDTO.getId() +' '+catalogueLineDTO.getPrice());
		}
	}
}
