package edd.floremipy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edd.floremipy.dao.ArticleDAOImplementation;
import edd.floremipy.dao.CatalogueDAOImpl;
import edd.floremipy.model.Article;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleDAOImplementationTest {

	@Autowired
	private ArticleDAOImplementation articleDAOImpl;
	
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
	public void findById() {
		Article unArticle = articleDAOImpl.findById(3);
		assertEquals("Epinette bleue", unArticle.getName());
	
	}

}
