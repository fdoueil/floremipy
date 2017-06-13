package edd.floremipy.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edd.floremipy.dto.CatalogueLineDTO;

@Repository("catalogueDAO")
@Scope("singleton")
public class CatalogueDAOImpl extends AbstractDAO implements CatalogueDAOInterface {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see edd.floremipy.dao.CatalogueDAOInterface#findCatalogue()
	 */
	@Override
	public List<CatalogueLineDTO> findCatalogue() {
		String vlsql;
		EntityManager em;

		em = getEntityManager();

		String sqlPur = "SELECT p.IdArticle,a.name,a.category,a.quantityInStock,p.value FROM Article a, Price p"
				+ " WHERE a.id = p.IdArticle and p.date = "
				+ "(SELECT MAX(date) from Price pr WHERE pr.IdArticle = p.IdArticle)";

		Query reqInnerJoin = em.createNativeQuery(sqlPur);

		log.info("Create query yahoo");
		
		List<Object[]> results = reqInnerJoin.getResultList();
		
		List<CatalogueLineDTO> res=new ArrayList<CatalogueLineDTO>(results.size());
		
		for (Object[] current : results) {
			int id = ((Integer)current[0]).intValue();			
			String name = (String)current[1];
			String category= (String)current[2];
			double price= ((BigDecimal)current[4]).doubleValue();
			int stock = ((Integer)current[3]).intValue();
			CatalogueLineDTO cl=new CatalogueLineDTO(id , name, category, price, stock);
			log.info(""+cl);
			res.add(cl);
		}
		return res;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see edd.floremipy.dao.CatalogueDAOInterface#findCatalogue()
	 */
	public List<CatalogueLineDTO> findCatalogueJPA() {
		String vlsql;
		EntityManager em;

		em = getEntityManager();

//		String q = "SELECT NEW edd.floremipy.dto.CatalogueLineDTO(a.id,a.name,a.category,p.value,a.quantityInStock) "+
//		" FROM Article a JOIN a.prices p ORDER BY p.date";

//		String q = "SELECT NEW edd.floremipy.dto.CatalogueLineDTO(a.id,a.name,a.category,p.value,a.quantityInStock) "+
//		" FROM Article a JOIN a.prices p";
		String q = "SELECT NEW edd.floremipy.dto.CatalogueLineDTO(a.id,a.name,a.category, 10.10,a.quantityInStock) "+
		" FROM Article a";
		Query reqInnerJoin = em.createQuery(q);
		log.info("Create query yahoo");
		

		List<CatalogueLineDTO> res = (List<CatalogueLineDTO>)reqInnerJoin.getResultList();
		
		for (CatalogueLineDTO catalogueLineDTO : res) {
			log.info("Current res="+catalogueLineDTO);
		}
		
		return res;
	}

	@Override
	public void setCatalogue(CatalogueLineDTO catalogueLineDTO) {
		// TODO Auto-generated method stub
		
	}
}
