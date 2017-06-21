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

// ici catalogueDAO est le nom de la variable qui sera en autowired
// on peut ne rien mettre en paramètre, et Spring prendra la 1ere classe qui implemente l'interface catalogueDAOInterface
// Si on met un nom c'est pour s'assurer qu'il la prendra pour telle variable
// (ici on aurait du mettre dao car c'est le nom de la variable dans catalogueServiceImpl

// @repository  et @service seront tous les deux cherchés par spring pour l'injection de dépendance
//  mais ils ont des initialisation différente (par exemple ici avec @service on aurait probablement pas eu accés a l'entity manager)

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

		String sqlPur = "SELECT p.IdArticle,a.name,a.category,a.quantityInStock,p.value, a.description, a.imgsrc FROM Article a, Price p"
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
			String description =(String)current[5];
			String imgsrc =(String)current[6];
			
			CatalogueLineDTO cl=new CatalogueLineDTO(id , name, category, price, stock, description, imgsrc );
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
		
		
//		String q = "SELECT NEW edd.floremipy.dto.CatalogueLineDTO(a.id,a.name,a.category, 10.10,a.quantityInStock) "+
//		" FROM Article a";
		
		String q= "SELECT NEW edd.floremipy.dto.CatalogueLineDTO(a.id,a.name,a.category, 10.10,a.quantityInStock) "+
		" FROM Article a, price t  order by a.id, t.Date desc";
		Query reqInnerJoin = em.createQuery(q);
		log.info("Create query yahoo");
		
		List<CatalogueLineDTO> retour = new ArrayList<CatalogueLineDTO>();
		int dernierIdAjoute = 0;
		List<CatalogueLineDTO> resultatIntermediaire = (List<CatalogueLineDTO>)reqInnerJoin.getResultList();
		for (CatalogueLineDTO unLineDTO : resultatIntermediaire) {
			if (unLineDTO.getId()==dernierIdAjoute) continue;
			dernierIdAjoute = unLineDTO.getId();
			retour.add(unLineDTO);
			
		}
		
		// Faire une jointure complete prix,article en JPA mais sans faire de new (car on ne veut pas tous les objets
		// Garder que le premier objet de chaque article dans le dto retourné
		
		// Version 1, on fait quand meme les new, (de toute facon on ne les persist pas)
		
		
		
		for (CatalogueLineDTO catalogueLineDTO : retour) {
			log.info("Current res="+catalogueLineDTO);
		}
		
		return retour;
	}

	@Override
	public void setCatalogue(CatalogueLineDTO catalogueLineDTO) {
		// TODO Auto-generated method stub
		
	}
}
