package edd.floremipy.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@Transactional
public class AbstractDAO  {


	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager(){
		return this.entityManager;
	}
}
