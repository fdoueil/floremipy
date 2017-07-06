package edd.floremipy.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

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
		Query reqInnerJoin = em.createQuery(q);
		reqInnerJoin.setParameter("parmId", parmId);
		retour = (Article) reqInnerJoin.getSingleResult();
		
		return retour;
	}

}
