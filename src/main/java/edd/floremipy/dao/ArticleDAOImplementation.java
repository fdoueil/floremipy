package edd.floremipy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edd.floremipy.dto.ArticleDTO;
import edd.floremipy.dto.CatalogueLineDTO;
import edd.floremipy.model.Article;

@Repository("ArticleDAORepository")
@Scope("singleton")
public class ArticleDAOImplementation extends AbstractDAO implements ArticleDAOInterface {

	@Override
	public Article findById(int id) {
		Article retour=null;
		EntityManager em = getEntityManager();
		String q= "SELECT NEW edd.floremipy.dto.ArticleDTO(a.id, a.category, a.description, a.imgsrc, a.name, a.quantityInStock) "+
		" FROM Article a where a.id = " + id;
		Query reqInnerJoin = em.createQuery(q);
		//log.info("Create query yahoo");
		
		retour = (Article) reqInnerJoin.getSingleResult();
				
		return retour;
	}

}
