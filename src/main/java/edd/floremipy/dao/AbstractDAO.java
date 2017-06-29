package edd.floremipy.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@Transactional
public class AbstractDAO implements Serializable {

	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager(){
		return this.entityManager;
	}
}
