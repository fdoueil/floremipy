package edd.floremipy.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edd.floremipy.dto.ArticleDTO;
import edd.floremipy.dto.CatalogueLineDTO;
import edd.floremipy.model.Article;

@Repository("unArticleDAO")
@Scope("singleton")
public class ArticleDAOImplementation extends AbstractDAO implements ArticleDAOInterface {

	@Override
	public Article findById(int parmId) {
		Article retour=null;
		EntityManager em = getEntityManager();
		
		// EN JPA, mais marche mal
		String q= "SELECT a FROM Article a where a.id = :parmId";
//		Query reqInnerJoin = em.createQuery(q);
//		reqInnerJoin.setParameter("id", id);
		//log.info("Create query yahoo");
//		retour = (Article) reqInnerJoin.getSingleResult();
//		retour = (Article)em.find(Article.class, id);
		
		// En SQL pur
		String sqlPur = "SELECT article.id, article.category, article.description,article.imgsrc,article.name,article.quantityinstock FROM article WHERE article.id = " + parmId;
		System.out.println(sqlPur);
		Query reqInnerJoin = em.createNativeQuery(sqlPur);
		List<Object[]> results = reqInnerJoin.getResultList();
		System.out.println("nb result = " + results.size());
		for (Object[] current : results) {
			int id = ((Integer)current[0]).intValue();	
			String category= (String)current[1];
			String description =(String)current[2];
			String imgsrc =(String)current[3];
			String name = (String)current[4];
			int stock = ((Integer)current[5]).intValue();
			
			System.out.println("article nom=" + name);

			retour = new Article();
			retour.setId(id);
			retour.setCategory(category);
			retour.setDescription(description);
			retour.setImgsrc(imgsrc);
			retour.setName(name);
			retour.setQuantityInStock(stock);
			//log.info(""+cl);
			
		}

		

				
		return retour;
	}

}
